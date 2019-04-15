(ns web-clojure.model.user
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

(defn getByUsername [username]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM user WHERE username = ?" username])))

(defn getUserByPassword [password]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM user WHERE password = ?" password])))
