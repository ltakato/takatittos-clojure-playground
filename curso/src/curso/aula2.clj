(ns curso.aula2)

(defn imprime-mensagem []
  (println "Bem vindo ao estoque!")
  (println "Bem vindo ao estoque!"))

(imprime-mensagem)

;; diferença de nomenclatura: "aplicar" soa algo "imperativo" com efeito colateral (ex: alterar valor recebido já aplicando desconto)
(defn aplica-desconto [valor-bruto]
  (* valor-bruto 0.9))

(println (aplica-desconto 100))

;; diferença de nomenclatura: nessa versão parece ser mais "declarativo" - idempotente, função pura, executar quantas vezes quiser
(defn valor-descontado
  "Retorna o valor descontado de 90% do valor enviado"
  [valor-bruto]
  (* valor-bruto 0.9))

(valor-descontado 100)

;; praticamente a mesma coisa só que com outro "olhar"
(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.1)))

;; usando simbolo para valor de desconto
;; problema: o simbolo desconto do jeito que está, fica global!
(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (def desconto 0.1)
  (* valor-bruto (- 1 desconto)))

(valor-descontado 100)

;; outra versão com let (simbolos locais)
(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto 0.1]
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto))))

(valor-descontado 100)

;; outra versão ainda com let
(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto))))

(valor-descontado 100) ;; vai dar 90N -> BitInt!

;; reformulando com varios simbolos
(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" desconto)
    (- valor-bruto desconto)))

(valor-descontado 100) ;; vai dar 90N -> BitInt!

;; condicional
(if (> 50 100)
  (println "maior")
  (println "menor ou igual"))

;; valor descontado com condicional
;; (defn valor-descontado
;;   "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100"
;;   [valor-bruto]
;;   (if (> valor-bruto 100)
;;     (let [taxa-de-desconto (/ 10 100)
;;           desconto (* valor-bruto taxa-de-desconto)]
;;       (println "Calculando desconto de" desconto)
;;       (- valor-bruto desconto))
;;     valor-bruto))
