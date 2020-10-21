# Practice #2

### Exercise 1

Create a list called "list" with the elements "red", "white", "black"

``` scala
val lista = List("rojo","blanco","negro")
lista.toSet
```

### Exercise 2

Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl"

``` scala
val lista_1 = "verde" :: lista
val lista_2 = "amarillo" :: lista_1
var lista_3 = "azul" :: lista_2
var lista_4 = "naranja" :: lista_3
var lista_5 = "perla" :: lista_4
```

### Exercise 3

Bring the items from "list" "green", "yellow", "blue"

``` scala
val resultado = lista_5.slice(2,5) 
print (resultado)
```

### Exercise 4

Create an array of numbers in the range 1-1000 in steps of 5 by 5

``` scala
val array_num = 5 to 1000 by 5
```

### Exercise 5

What are the unique elements of the list List (1,3,3,4,6,7,3,7) use conversion to sets

``` scala
val lista = List (1,3,3,4,6,7,3,7)
lista.toSet
```

### Exercise 6

Create a mutable map named names that contains the following: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"

``` scala
val mapa = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))
```

### Exercise 6.a

Print all keys on the map

``` scala
mapa.keys
```

### Exercise 7.b

Add the following value to the map ("Miguel", 23)

``` scala
mapa += ("Miguel" -> 23)
```


