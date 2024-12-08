(ns charlie-pecora.aoc-2024.day2
  (:require [clojure.java.io])
  (:require [clojure.string :as str]))

(def sample-inputs (slurp "inputs/day2-sample.txt"))
(def real-inputs (slurp "inputs/day2.txt"))

(defn parse-inputs [input]
  (def lines
    (map
     (fn [l] (map (fn [s] (Integer/parseInt s)) l))
     (map
      (fn [s] (str/split s #" "))
      (str/split-lines input))))

  lines)

(defn calc-diffs [line]
  (def diffs (map - (drop 1 line) line))
  (def bounded
    (map
     (fn [d]
       (cond
         (and (<= d 3) (>= d 1)) 1
         (and (>= d -3) (<= d -1)) -1
         :else 0))

     diffs))

  (not= (reduce (fn [l r] (if (= l r) l 0)) bounded) 0))

(defn part1 [input]
  (def lines (parse-inputs input))
  (def res (map
            (fn [line]
              (def out (calc-diffs line))
              out)
            lines))
  (count
   (filter
    (fn [v] (= v true))
    res)))

(defn part2 [input]
  (def lines (parse-inputs input))
  (def res (map
            (fn [line]
              (first
               (filter
                (fn [dropped]
                  (calc-diffs (concat (take (- dropped 1) line) (drop dropped line))))
                (range (+ 1 (count line))))))

            lines))
  (count
   (filter
    (fn [v] (not= v nil))
    res)))

(defn main []
  (println "Day 2!")

  (println "Part 1!")
  (println "Sample run")
  (println "  sample answer:" (part1 sample-inputs))
  (println "Real run")
  (println "  real answer:" (part1 real-inputs))

  (println)

  (println "Part 2!")
  (println "Sample run")
  (println "  sample answer:" (part2 sample-inputs))
  (println "Real run")
  (println "  real answer:" (part2 real-inputs)))

