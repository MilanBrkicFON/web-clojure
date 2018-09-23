(ns web-clojure.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [ring.middleware.basic-authentication :refer :all]
            [web-clojure.model.member :as member]
            [web-clojure.model.city :as city]
            [web-clojure.controller.controller :as controller]))

(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/homepage" [] (controller/home))
           (route/resources "/")
           (GET "/members" [] (controller/allMembers))
           (route/resources "/")
           (GET "/cities" [] (controller/allCities))
           (route/resources "/")


           (GET "/model/member/:id/remove" [id]
             (do (member/removeMeber id)
                 (resp/redirect "/members")))

           (POST "/model/member/insert" [& params]
             (do (member/insertMember params)
                 (resp/redirect "/members")))

           (GET "/model/member/:member_id" [member_id]
             (controller/updatingMember member_id))

           (POST "/model/member/:member_id/update" [& params]
             (do (member/updateMember (:member_id params) params)
                 (resp/redirect "/members")))

           (GET "/model/city/:id/remove" [id]
             (do (city/removeCity id)
                 (resp/redirect "/cities")))

           (POST "/model/city/insert" [& params]
             (do (city/insertCity params)
                 (resp/redirect "/cities")))

           (GET "/model/city/:postal_code" [postal_code]
             (controller/updatingCity postal_code))

           (POST "/model/city/:postal_code/update" [& params]
             (do (city/updateCity (:postal_code params) params)
                 (resp/redirect "/cities"))))




(defroutes app-routes
           public-routes
           (route/not-found "404 Not Found"))

(def -main
  (handler/site app-routes))