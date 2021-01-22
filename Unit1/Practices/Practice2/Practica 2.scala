//Practice 2

// EXERCISE #1 
// Create a list called "list" with the elements "red", "white", "black"
val lista = List("rojo","blanco","negro")
lista.toSet

// EXERCISE #2
// Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl"
val lista_1 = "verde" :: lista
val lista_2 = "amarillo" :: lista_1
var lista_3 = "azul" :: lista_2
var lista_4 = "naranja" :: lista_3
var lista_5 = "perla" :: lista_4

// EXERCISE #3
//Bring the items from "list" "green", "yellow", "blue"
val resultado = lista_5.slice(2,5) 
print (resultado)

// EXERCISE #4
// Create an array of numbers in the range 1-1000 in steps of 5 by 5
val array_num = 5 to 1000 by 5

// EXERCISE #5
//What are the unique elements of the list List (1,3,3,4,6,7,3,7) use conversion to sets
val lista = List (1,3,3,4,6,7,3,7)
lista.toSet

// EXERCISE #6
// Create a mutable map named names that contains the following: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
val mapa = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

// EXERCISE #6.a
// Print all keys on the map
mapa.keys

// EXERCISE #7.b
// Add the following value to the map ("Miguel", 23)
mapa += ("Miguel" -> 23)
