(ns charlie-pecora.aoc-2024.day3
  (:require [clojure.java.io])
  (:require [clojure.string :as str]))

(def sample-inputs (slurp "inputs/day3-sample.txt"))
(def real-inputs (slurp "inputs/day3.txt"))

(defn part1 [input]
  (->> input 
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)")
        (map (fn [v] 
               ;(
                (* (Integer/parseInt (get v 1))(Integer/parseInt (get v 2)))
                ;(def l (get v 1))
                ;(def r (get v 2))
                ;r
               ;)
             )
          )
        (reduce +)
      )
 )


(defn part2 [input]
  )
(defn main []
  (println "Day 3!")

  (println "Part 1!")
  (println "Sample run")
  (println "  sample answer:" (part1 sample-inputs))
  (println "Real run")
  (println "  real answer:" (part1 real-inputs))

  (println)

  ;(println "Part 2!")
  ;(println "Sample run")
  ;(println "  sample answer:" (part2 sample-inputs))
  ;(println "Real run")
  ;(println "  real answer:" (part2 real-inputs))
  )

