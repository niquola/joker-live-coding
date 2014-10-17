(ns joker.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))
(comment
  (require '[vinyasa.pull :as vp]))

(comment
  (defroutes app-routes
    (GET "/" [] "Hello World")
    (route/resources "/")
    (route/not-found "Not Found"))

  (def app
    (handler/site app-routes)))
