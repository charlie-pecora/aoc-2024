(ns charlie-pecora.aoc-2024.day1
  (:require [clojure.java.io])
  (:require [clojure.string :as str])
)

(def sample-inputs (slurp "inputs/day1-sample.txt"))
(def real-inputs (slurp "inputs/day1.txt"))

(defn parse-inputs [input]
  (def split-vals (map (fn [s] (str/split s #" +")) (str/split-lines input)))
  (def left
    (reduce
      (fn [l r] (conj l r)) 
      '()
      (map
        (fn [x] (Integer/parseInt (get x 0)))
        split-vals
      )
    )
  )
  (def right
    (reduce
      (fn [l r] (conj l r)) 
      '()
      (map
        (fn [x] (Integer/parseInt (get x 1)))
        split-vals
      )
    )
  )
  [left right]
)

(defn part1 [input]
  (let [left right] (parse-inputs input))
  (reduce
    +
    (map
      (fn [l r] 
        (abs (- l r))
      )
      (sort left)
      (sort right)
    )
  )
)

(defn part2 [input]
  (let [left right] (parse-inputs input))
  (reduce
    +
    (map
      (fn [l] 
        (* l (count (filter (fn [r] (= r l)) right)))
      )
      left
    )
  )
)

(defn main []
  (println "Day 1!")

  (println "Part 1!")
  (println "Sample run")
  (println "  sample answer:" (part1 sample-inputs))
  (println "Real run")
  (println "  real answer:" (part1 real-inputs))

  (println)

  (println "Part 2!")
  (println "Sample run")
  (println "  sample answer:" (part2 sample-inputs))
  (println "  real answer:" (part2 real-inputs))
)

