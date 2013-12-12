(defproject tianguis "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [korma "0.3.0-RC5"]
                 [org.xerial/sqlite-jdbc "3.7.2"]
                 [org.clojure/clojurescript "0.0-2069"]
                 [domina "1.0.3-SNAPSHOT"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler tianguis.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
