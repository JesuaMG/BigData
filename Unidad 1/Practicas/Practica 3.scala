// Practice 3, analyse the following code with your own words

// Number #1

// In this code, first a function called "listEvens" is created where it will receive as parameters
// the values ​​of a list that will be of type Int and will return the integer value, it is initialized
// with a for loop where the variable n is where the list values ​​will be inserted, it is created
// a conditional where it is checked in each iteration if the control variable n is even or not
// checking if the remainder of the division by 2 is 0 or not and the message is printed, to finish
// returns "Done" given as finished
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}


// The variables "l" and "l2" are declared where they will be listed where the values to be compared will be saved
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)

// The values of the lists are sent to the function "listEvens"
listEvens(l)
listEvens(l2)


// Number #2

// This code is creating a function called "lucky", which receives as a parameter
// a list of type Int, and returns an integer, what it does is traverse the list with a
// for loop and when it finds a 7 it adds to a variable (res) the content of the variable
// plus 14, if the number is not a 7 then just add the value of the number
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

// In the case of the list (1, 7, 7) it should give us the result of 29 (1 + 14 + 14)
val to f = List (1,7,7)
println(afortunado(af))


// Number #3
//  Esta funcion recibe una lista de enteros y retorna un booleano, se crean dos varibles primera y
//  segunda, a la varible segunda se le asigna la suma de todos los terminnos en la lista, se itera
//  la lista por medio de un ciclo for, en cada iteracion a la variable primera se le agraga (suma) el 
//  valor de la posicion (i) de la lista y a la variable segunda se le resta este mismo valor, luego se 
//  hace una comparacion para determinar si las varibles (primera y segunda) tienen el mismo valor, si es asi
//  se devolveria el valor true, pero en caso de recorrer toda la lista y las varialbles nunca fueron 
//  iguales retornaria un false
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}

val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)



// Number #4
//  Esta funcion lo que hace es recibir un string y retornar un booleano, si la cadena ingrasada
//  es igual a la palabra pero con el orden invertido entonces devolvera un true, en caso contrario
//  devuelve un false
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))