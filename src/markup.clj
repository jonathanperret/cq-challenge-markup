(ns markup)

(defn join-paragraph-lines [s] `[:p ~(. s replace "\n" " ")])

(defn split-into-paragraphs [s] (. s split "\n\n"))

(defn markup [data]
  `(:body
    ~@(if (not (= "" data))
	(map join-paragraph-lines
	     (split-into-paragraphs data))
	)))
