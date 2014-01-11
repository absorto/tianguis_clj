(ns tianguis.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [tianguis.views :as views]))

(defroutes app-routes
  (GET "/"
       [vendimia-id]
       (views/una-vendimia vendimia-id))
  (GET "/vendimias/"
       []
       (views/vendimias))
  (GET "/vendimias/crear/"
       []
       (views/vendimias-crear))
  (POST "/vendimias/crear/"
       {params :params}
       (views/vendimias-crear-resultado params))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
