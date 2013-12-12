(ns tianguis.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [tianguis.views :as views]))

(defroutes app-routes
  (GET "/"
       []
       (views/una-vendimia))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
