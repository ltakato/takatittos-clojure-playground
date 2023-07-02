(ns curso.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
;; (println (precos 17))
;; nao da excpetion de index out of bounds
(println (get precos 17))

(println "valor padrao nil" (get precos 17))
(println "valor padrao 0" (get precos 17 0))
(println "valor padrao 0, mas existe" (get precos 2 0))

(println (conj precos 5))
;; precos se mantem intacto sem o 5
(println precos)

(println (+ 5 1))
(println (inc 5))
;; atualiza indice passado aplicando a função inc que passei
(println (update precos 0 inc))
;; preservando vetor original
(println precos)

(defn soma-1
  [valor]
  (println "estou somando um em" valor)
  (+ valor 1))

(println (update precos 0 soma-1))

(defn soma-3
  [valor]
  (println "estou somando tres em" valor)
  (+ valor 3))

(println (update precos 0 soma-3))