(ns tianguis.views
  (:require [tianguis.db :as db]
            [clojure.string :as str]
            [hiccup.page :as hic-p]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]
   (hic-p/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/add-location"} "Add a Location"]
   " | "
   [:a {:href "/all-locations"} "View All Locations"]
   " ]"])

(defn una-vendimia
  []
  (let [vendimia {:fecha-cierre  "2013-12-1"
                  :publicada nil
                  :fecha-entrega-inicial "2013-12-2 13:00"
                  :fecha-entrega-final "2013-12-2 19:00"
                  :ofertas [
                            {:producto "tomate"
                             :unidad "kg"
                             :precio 23.2}
                            {:producto "ghee"
                             :precio 23
                             :unidad "lt"}
                            {:producto "acelga"
                             :precio 11
                             :unidad "ramo"}]
                  :pedidos [
                            { :producto "jitomate"
                             :precio 22
                             :unidad "kg"
                             :cantidad 3
                             :status "pedido"
                             :cliente "absorto@sdf.org"}
                            {:producto "arroz"
                             :precio 40
                             :unidad "kg"
                             :cantidad 2
                             :status "entregado"
                             :cliente "alguien@example.com"}]}]
    (hic-p/html5
     (gen-page-head "Una vendimia")
     header-links
     [:h1 "Una vendimia"]
     [:p "fecha de cierre"  ((vendimia :ofertas) 0)])))

