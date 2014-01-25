(ns tianguis.docdb
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]
           [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern])
  (:use [monger.core :only [connect! connect set-db! get-db]]
        [monger.collection :only [insert insert-batch]]))

(mg/connect!)

;; localhost, default port
(connect!)
(set-db! (monger.core/get-db "monger-test"))


(defn add-lennon-to-db
  []
  (let [results (insert "documents"
                        { :_id (ObjectId.)
                          :first_name "John"
                          :last_name "Lennon" })]
    ;; (assert (= (count results) 1))
    ))
    

;; with explicit document id (recommended)
;; multiple documents at once
;; (insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
;;                           { :first_name "Paul" :last_name "McCartney" }])




(defn get-all-docs
  []
  (let [docs (mc/find-maps "documents" {:first_name "John"})]
    docs))


(defn get-vendimia
  [vendimia_id]
  {:fecha-cierre  "2013-12-1"
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
              :cliente "alguien@example.com"}]})
