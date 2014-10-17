(ns joker.style)

(defn em [x] (str x "em"))

(defn box [nm]
  {:padded {:display "block"
            :padding (em 1)}})

(defn color [nm]
  (nm {:normal  {:background "white" :color "#333"}
       :scale   {:background "#333" :color "white"}
       :inverse {:background "black" :color "white"}}))

(defn text [sz]
  (sz {:large  {:font-size (em 1.5)}
       :normal {:font-size (em 1)}
       :small  {:font-size (em 0.7)}}))

(def textarea
  {:min-height (em 10)
   :width "100%"
   :display "block"})

(defn message [w]
  [:div.message
   [:b {:width (em w)
        :float "left"}]
   [:div.res {:margin-left (em w)}
    [:pre (merge (color :inverse)
                 (box :padded)
                 {:color "#ddd"
                  :overflow "hidden"})]]])

(def main-style
  [:body
   (merge (box :padded)
          (color :scale))
   (message 5)
   [:textarea#inp
    (merge textarea
           (color :inverse)
           (text  :large))]])

(println main-style)
