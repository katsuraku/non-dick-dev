(ns non-dick-dev.routes.home
  (:require [non-dick-dev.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn addProject-page []
  (layout/render "addProject.html"))

(defn projects-page []
  (layout/render "projects.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/projects" [] (projects-page))
  (GET "/addProject" [] (addProject-page))
  (POST "/testPosts" {testPosts :params} (str testPosts)))
