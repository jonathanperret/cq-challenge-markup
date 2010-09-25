(ns markup)

(defn markup [data]
  `(:body
    ~@(if (not (= "" data))
       `([:p ~data]))))
