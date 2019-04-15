(ns web-clojure.model.property
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

(defn getAllProperties []
  (jdbc/query mysql-db ["SELECT * FROM property AS p INNER JOIN member ON p.owner = member.member_id INNER JOIN city ON p.city = city.postal_code"]))

(defn getProperty [property_id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM property WHERE property_id = ?" property_id])))

(defn getPropertyInCity [postal_code]
  (jdbc/query mysql-db
              ["SELECT * FROM property AS p INNER JOIN member ON p.owner = member.member_id INNER JOIN city ON p.city = city.postal_code WHERE p.city = ?" postal_code]))

(defn book [property_id]
  (jdbc/execute! mysql-db
              ["UPDATE property SET property.booked = true WHERE property_id = ?" property_id]))

(defn removeProperty [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM property WHERE property_id = ?" id]))