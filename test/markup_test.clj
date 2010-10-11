(ns markup-tests
  (:use clojure.test)
  (:use midje.sweet)
  (:use markup :reload-all))

(deftest an-empty-string-gives-empty-body
  (fact (markup "") =>
        [:body]))

(deftest a-simple-paragraph
  (fact (markup "a simple paragraph") =>
        [:body [:p "a simple paragraph"]]))

(deftest another-simple-paragraph
  (fact (markup "another simple paragraph") =>
        [:body [:p "another simple paragraph"]]))

(deftest a-multiline-paragraph
  (fact (markup "a multiline\nparagraph") =>
        [:body [:p "a multiline paragraph"]]))

(deftest two-paragraphs
  (fact (markup "one paragraph\n\ntwo paragraph") =>
	[:body [:p "one paragraph"]
	 [:p "two paragraph"]]))
