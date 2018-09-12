(ns web-clojure.controller.controller
  (:require
    [clostache.parser :as clostache]
    [web-clojure.model.user :as user]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "homepage" {}))

(defn index []
  (render-template "index" {}))
