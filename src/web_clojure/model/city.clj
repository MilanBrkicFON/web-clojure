(ns web-clojure.model.city
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {
               :subprotocol           "mysql"
               :subname               "//localhost:3306/clojure_app"
               :user                  "root"
               :password              "root"
               :zeroDateTimeBehaviour "convertToNull"
               })
(defn getAll []
  (jdbc/query mysql-db
              ["SELECT * FROM city"]))

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM city WHERE postal_code = ?" id])))

(defn insertCity
  [params]
  (jdbc/insert! mysql-db :city params))

(defn updateCity [postal_code params]
  (jdbc/update! mysql-db :city params (sql/where {:postal_code postal_code})))

(defn removeCity [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM city WHERE postal_code = ?" id]))