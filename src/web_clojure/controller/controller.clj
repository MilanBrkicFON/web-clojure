(ns web-clojure.controller.controller
  (:require
    [clostache.parser :as clostache]
    [web-clojure.model.user :as user]
    [web-clojure.model.city :as city]
    [web-clojure.model.member :as member]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "homepage" {}))

(defn index []
  (render-template "index" {}))

(defn allMembers []
  (render-template "allMembers" {:members (member/getAllMembers)
                                 :cities  (member/getCities)}))
(defn updatingMember [member_id]
  (render-template "updateMember" {:member (member/getMember member_id)
                                   :cities (city/getAll)}))

(defn allCities []
  (render-template "allCities" {:cities (city/getAll)}))
