// Practice 3, analyse the following code with your own words

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

val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
listEvens(l)
listEvens(l2)

//3 7 afortunado
//Este código esta creando una función llamada "afortunado", la cual recibe como parametro
//  una lista de tipo Int, y retorna un entero, lo que hace es recorrer la lista con un 
//  ciclo for y cuando encuentra un 7 suma a una vaviable (res) el contenido de la variable
//  más 14, si no es un 7 el número entonces solo suma el valor del número
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
//En el caso de la lista (1, 7, 7) nos debe de dar el resultado de 29 (1 + 14 + 14)
val af= List(1,7,7)
println(afortunado(af))

//Esta funcion recibe una lista de enteros y retorna un booleano, se crean dos varibles primera y
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

//Esta funcion lo que hace es recibir un string y retornar un booleano, si la cadena ingrasada
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