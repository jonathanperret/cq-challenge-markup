(ns markup-tests :reload
  (:use clojure.test)
  (:use midje.sweet)
  (:use markup :reload))

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
  (fact (markup "a! multiline\nparagraph") =>
        [:body [:p "a multiline paragraph"]]))

(run-tests)
