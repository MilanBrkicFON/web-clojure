(ns web-clojure.model.member
    (:refer-clojure :exclude [get])
    (:require [clojure.java.jdbc :as jdbc]
      [clojure.java.jdbc.sql :as sql]))

(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/pssunce"
               :user "root"
               :password ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(defn getAllMembers []
      (jdbc/query mysql-db ["SELECT * FROM osoba JOIN clan USING(idOsoba) JOIN mesto WHERE mesto.ptt = osoba.mesto"]))

(defn getAllTrainers []
      (jdbc/query mysql-db ["SELECT * FROM osoba JOIN trener USING(idOsoba)"]))

(defn get [id]
      (first (jdbc/query mysql-db
                         ["SELECT * FROM member WHERE idOsoba = ?" id])))