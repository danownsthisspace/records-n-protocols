(ns records-n-protocols.core)

(defprotocol Display
  (title [this])
  (desciption [this description]))


(defrecord CarModel [make model]
  Display
  (title [this] (str "This is a " make " " model))
  (desciption [this descr] (str "The " make " " model " is " descr)))

(defrecord Product [name])

(def toaster (->Product "Toaster"))

(extend-protocol Display
  Product
  (title [p] (str "This product is a " (:name p)))
  (desciption [p descr] (str "The " (:name p) " is " descr)))

(title toaster)

(desciption toaster " flippin nice")


(def fiat-500 (->CarModel "Fiat" "500"))

(title fiat-500)
(desciption fiat-500 "a super awesome car")

(def ford-focus (map->CarModel {:make "Ford" :model "Focus"}))


