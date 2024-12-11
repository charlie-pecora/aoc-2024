(ns charlie-pecora.aoc-2024
  (:gen-class)
  (:require [charlie-pecora.aoc-2024.day1 :as day1])
  (:require [charlie-pecora.aoc-2024.day2 :as day2])
  (:require [charlie-pecora.aoc-2024.day3 :as day3])
  (:require [charlie-pecora.aoc-2024.day4 :as day4]))

(defn -main
  "I don't do a whole lot ... yet."
  [day]
  (println "AOC 2024 -- learning clojure")
  (case day
    "day1" (day1/main)
    "day2" (day2/main)
    "day3" (day3/main)
    "day4" (day4/main)
    (println day "not found")))

