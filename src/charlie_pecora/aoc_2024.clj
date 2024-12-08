(ns charlie-pecora.aoc-2024
  (:gen-class)
  (:require [charlie-pecora.aoc-2024.day1 :as day1])
  (:require [charlie-pecora.aoc-2024.day2 :as day2])
)

(defn -main
  "I don't do a whole lot ... yet."
  [day]
  (println "AOC 2024 -- learning clojure")
  (case day
    "day1" (day1/main)
    "day2" (day2/main)
    (println day "not found")
  )
)

