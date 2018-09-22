(ns web-clojure.model.sport
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {
               :subprotocol           "mysql"
               :subname               "//localhost:3306/clojure_app"
               :user                  "root"
               :password              ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM sport WHERE sport_id = ?" id])))

(defn insertSport
  [params]
  (jdbc/insert! mysql-db :sport params))

(defn removeSport [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM sport WHERE sport_id = ?" id]))