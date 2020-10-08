//Practice 2
// 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
val lista = List("rojo","blanco","negro")
lista.toSet
// 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
val lista_1 = "verde" :: lista
val lista_2 = "amarillo" :: lista_1
var lista_3 = "azul" :: lista_2
var lista_4 = "naranja" :: lista_3
var lista_5 = "perla" :: lista_4
// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
val resultado = lista_5.slice(2,5) 
print (resultado)
// 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
val array_num = 5 to 1000 by 5

// 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
val lista = List (1,3,3,4,6,7,3,7)
lista.toSet

// 6. Crea una mapa mutable llamado nombres que contenga los siguiente
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
val mapa = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

// 6 a . Imprime todas la llaves del mapa
mapa.keys

// 7 b . Agrega el siguiente valor al mapa("Miguel", 23)
mapa += ("Miguel" -> 23)
