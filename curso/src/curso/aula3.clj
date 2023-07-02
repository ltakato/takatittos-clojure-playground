(ns curso.aula3)

;; (defn aplica-desconto?
;;   [valor-bruto]
;;   (if (> valor-bruto 100)
;;     true
;;     false))

; when
;; (defn aplica-desconto?
;;   [valor-bruto]
;;   ((> valor-bruto 100)
;;    true))

; simplificado
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

;; (defn valor-descontado
;;   "Retorna o valor com desconto de 10%"
;;   [valor-bruto]
;;   (if (aplica-desconto? valor-bruto)
;;     (let [taxa-de-desconto (/ 10 100)
;;           desconto (* valor-bruto taxa-de-desconto)]
;;       (- valor-bruto desconto))
;;     valor-bruto))
;; (valor-descontado 1000)

;; refatorado: função como parametro (high order functions)
(defn valor-descontado
  "Retorna o valor com desconto de 10%, se deve aplicar desconto com a função passada"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))

;; CHECKPOINT: CONCEITOS
;; high order functions
;; imutabilidade

;; with anonymous function
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))
;; como tem só um argumento, nem precisa de 1
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

;; definir simbolo para uma anonymous function
;; não estou DEFININDO UMA FUNÇÃO! só dando nome para uma existente
(def mais-caro-que-100-simb? #(> % 100))

(println (mais-caro-que-100-simb? 1000))
(println (mais-caro-que-100-simb? 100))
