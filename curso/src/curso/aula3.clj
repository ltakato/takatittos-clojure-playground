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

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 1000)
