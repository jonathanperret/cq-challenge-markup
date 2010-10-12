(ns markup)

(defn header-tag [level]
  (keyword (str "h" level)))

(defn process-text-block [block]
  (let [replaced (. block replace "\n" " ")]
    (if-let [prefix (re-find #"\*+ " block)]
      (let [prefix-length (count prefix)
            tag (header-tag (dec prefix-length))]
        [tag (. replaced substring prefix-length)])
      [:p replaced])))

(defn split-into-text-blocks [s]
  (. s split "\n\n"))

(defn markup [data]
  `(:body
    ~@(if (not (= "" data))
	(map process-text-block
	     (split-into-text-blocks data)))))
