(ns markup-test
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

(deftest one-header
  (fact (markup "* One header") =>
    [:body [:h1 "One header"]]))

(deftest a-header-with-a-star-in-the-title
  (fact (markup "* One header with a * inside") =>
    [:body [:h1 "One header with a * inside"]]))

(deftest a-level-two-header
  (fact (markup "** A level two header") =>
    [:body [:h2 "A level two header"]]))

(deftest a-multiline-header
  (fact (markup "* A multiline\nheader") =>
    [:body [:h1 "A multiline header"]]))
