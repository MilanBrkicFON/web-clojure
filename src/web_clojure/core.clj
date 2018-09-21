(ns web-clojure.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [web-clojure.model.user :as user]
            [web-clojure.controller.controller :as controller]))

(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/homepage" [] (controller/home))
           (route/resources "/")
           (GET "/members" [] (controller/allMembers))
           (route/resources "/"))


(defroutes app-routes
           public-routes
           (route/not-found "404 Not Found"))

(def -main
  (handler/site app-routes))