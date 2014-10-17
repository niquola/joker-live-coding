(ns joker.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [org.httpkit.server :as ohs]
            [hiccup.core :as hc]
            [joker.views :as jv]
            [compojure.route :as route]))


(defn index [req]
  {:body (jv/index req)
   :status 200})

(defroutes app-routes
  (GET "/" [] #'index)
  (GET "/test" [] "test")
  (route/resources "/assets/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(comment
  (stop)
  (def stop
    (ohs/run-server #'app {:port 8080})))


(comment
  (require '[vinyasa.pull :as vp])
  (vp/pull 'http-kit)
  (vp/pull 'hiccup)
  (vp/pull 'garden)
  )

(comment

  )
