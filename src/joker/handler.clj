(ns joker.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [org.httpkit.server :as ohs]
            [hiccup.core :as hc]
            [joker.views :as jv]
            [joker.chat :as jc]
            [compojure.route :as route]))


(defn index [{params :params}]
  {:body (jv/index params)
   :status 200})

(defn chat [{params :params :as req}]
  (ohs/with-channel req ch
    (jc/add-usr ch params)
    (ohs/on-receive ch (fn [msg] (jc/on-msg ch msg)))
    (ohs/on-close ch (fn [st] (jc/rm-usr ch)))))

(defroutes app-routes
  (GET "/" [] #'index)
  (GET "/:name" [] #'index)
  (GET "/chat/:name" [] #'chat)
  (route/resources "/assets/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn start []
  (def stop
    (ohs/run-server #'app {:port 8080})))


(comment
  (require '[vinyasa.pull :as vp])
  (vp/pull 'http-kit)
  (vp/pull 'hiccup)
  (vp/pull 'garden))
