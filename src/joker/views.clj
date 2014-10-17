(ns joker.views
  (:require
    [garden.core :as gc]
    [joker.style :as jc]
    [hiccup.core :as hc]))

(defn style [g]
  [:style (gc/css g)])

(defn js [pth]
  [:script {:src pth}])

(defn layout [title & cnt]
  (hc/html
    [:html
     [:head
      [:title title]
      (style jc/main-style)]
     [:body
      [:div.container cnt]
      (js "/assets/app.js")]]))

(defn index [data]
  (layout "index"
          [:div#out]
          [:textarea#inp]))

