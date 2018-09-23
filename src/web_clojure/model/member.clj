(ns web-clojure.model.member
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

(defn getAllMembers []
  (jdbc/query mysql-db ["SELECT * FROM member JOIN city WHERE city.postal_code = member.city"]))

(defn getCities []
  (jdbc/query mysql-db
              ["SELECT * FROM city"]))

(defn getMember [member_id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM member WHERE member_id = ?" member_id])))

(defn insertMember
  [params]
  (jdbc/insert! mysql-db :member params))

(defn updateMember [member_id params]
  (jdbc/update! mysql-db :member params (sql/where {:member_id member_id})))

(defn removeMeber [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM member WHERE member_id = ?" id]))