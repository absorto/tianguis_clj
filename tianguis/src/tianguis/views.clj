(ns tianguis.views
  (:require [tianguis.db :as db]
            [tianguis.docdb :as docdb]
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
   [:a {:href "/vendimias/crear/"} "Armar vendimia"]
   " | "
   [:a {:href "/vendimias/log/"} "Historial de vendimias"]
   " | "
   [:a {:href "/pedidos/crear/"} "Armar pedidos"]
   " | "
   [:a {:href "/pedidos/log/"} "Historial de pedidos"]
   " ]"])

(defn vendimias-crear
  []
  (hic-p/html5
     (gen-page-head "Creando una Vendimia")
     header-links
     [:h1 "Armar vendimia"]))

(defn vendimias-crear-resultado
  [{:keys [x y]}]
  (hic-p/html5
   (gen-page-head "Vendimia creada")
   header-links
   [:h1 "Vendimia creada"]))

(defn una-vendimia
  [vendimia-id]
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
     (gen-page-head (str"Vendimia " vendimia-id))
     header-links
     [:h1 "Una vendimia"]
     [:p "fecha de cierre"  ((vendimia :ofertas) 0)])))



(defn vendimias
  []
    (hic-p/html5
     (gen-page-head "Vendimias")
     header-links
     [:h1 "Vendimias"]
     [:table
      [:thead
       [:tr
        [:th "aguas"]
        [:th "con"]
        [:th "canem"]]
      [:tbody
       [:tr
        [:td "arf"]
        [:td "arf arf arf"]
        [:td "dge"]]]]
      ]))

;; regresa a vista de la vendimia
(defn vendimia-agrega-producto
  [{:keys [vendimia_id producto_id precio]}]
  )
