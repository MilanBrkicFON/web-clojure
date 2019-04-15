(ns web-clojure.controller.controller
  (:require
    [clostache.parser :as clostache]
    [web-clojure.model.city :as city]
    [web-clojure.model.property :as property]
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

(defn allProperties []
  (render-template "allProperties" {:properties (property/getAllProperties)
                                 :cities  (city/getAll)}))

(defn searchProperties [postal_code]
  (render-template "search" {:properties (property/getPropertyInCity postal_code)
                                 :cities  (city/getAll)}))

(defn updatingMember [member_id]
  (render-template "updateMember" {:member (member/getMember member_id)
                                   :cities (city/getAll)}))

(defn getProperty [property_id]
  (render-template "property" {:property (property/getProperty property_id)}))

(defn updatingCity [postal_code]
  (render-template "updateCity" {:city (city/get postal_code)}))

(defn allCities []
  (render-template "allCities" {:cities (city/getAll)}))
