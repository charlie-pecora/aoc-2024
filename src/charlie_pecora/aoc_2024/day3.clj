(ns charlie-pecora.aoc-2024.day3
  (:require [clojure.java.io])
  (:require [clojure.string :as str]))

(def part1-sample-inputs (slurp "inputs/day3-sample.txt"))
(def part2-sample-inputs "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")
(def real-inputs (slurp "inputs/day3.txt"))

(defn part1 [input]
  (->> input
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)")
       (map (fn [v]
              (* (Integer/parseInt (get v 1)) (Integer/parseInt (get v 2)))))

       (reduce +)))

(defn part2 [input]
  (def dont-splits (str/split input #"don't\(\)"))
  (def do-blocks (str/join (concat
                             ;; keep the first element, which is all blocks before the first "don't()"
                            (take 1 dont-splits)
                            (map
                              ;; in each following block (after a "don't()") check if there's a "do()"
                              ;; limit the check for one split (limit 2 blocks)
                              ;; then get the second element, which is all code after the "do()"
                             (fn [s] (get
                                      (str/split s #"do\(\)" 2)
                                      1))
                             (drop 1 dont-splits)))))

  (->> do-blocks
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)")
       (map (fn [v]
              (* (Integer/parseInt (get v 1)) (Integer/parseInt (get v 2)))))

       (reduce +)))

(defn main []
  (println "Day 3!")

  (println "Part 1!")
  (println "Sample run")
  (println "  sample answer:" (part1 part1-sample-inputs))
  (println "Real run")
  (println "  real answer:" (part1 real-inputs))

  (println)

  (println "Part 2!")
  (println "Sample run")
  (println "  sample answer:" (part2 part2-sample-inputs))
  (println "Real run")
  (println "  real answer:" (part2 real-inputs)))

