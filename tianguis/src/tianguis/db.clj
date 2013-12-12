(ns tianguis.db
  (:use korma.db )
  (:use korma.core)
  (:require [clojure.string :as str]))

(defdb db (sqlite3 (:db "resources/db/tianguis.sqlite")))

(declare vendimia oferta producto pedido)

(defentity producto
  (entity-fields :nombre :descripcion :unidad))

(defentity vendimia
  (entity-fields :fecha-cierre :fecha-entrega-inicio :fecha-entrega_fin :publicada)
  (has-many oferta))

(defentity oferta
  (entity-fields :precio :descuento :comentario)
  (has-one producto))

(defentity pedido
  (entity-fields :entregado :cantidad)
  (has-one vendimia)
  (has-one producto))


;; (let [vendimia {:fecha-cierre '2013-12-1'
;;                 :publicada nil
;;                 :fecha-entrega-inicial '2013-12-2 13:00'
;;                 :fecha-entrega-final '2013-12-2 19:00'
;;                 :ofertas [
;;                           {:producto "tomate"
;;                            :unidad "kg"
;;                            :precio 23.2}
;;                           {:producto "ghee"
;;                            :precio 23
;;                            :unidad "lt"}
;;                           {:producto "acelga"
;;                            :precio 11
;;                            :unidad "ramo"}]
;;                 :pedidos [
;;                           { :producto "jitomate"
;;                            :precio 22
;;                            :unidad "kg"
;;                            :cantidad 3
;;                            :status "pedido"
;;                            :cliente "absorto@sdf.org"}
;;                           {:producto "arroz"
;;                            :precio 40
;;                            :unidad "kg"
;;                            :cantidad 2
;;                            :status "entregado"
;;                            :cliente "alguien@example.com"}]}]
;;   )
