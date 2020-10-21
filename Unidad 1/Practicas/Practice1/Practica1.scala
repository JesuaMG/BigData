// Assessment 1/Practica 1

//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
var radio: Double = 0;

def radioPerimetro (perimetro:Double): Unit = {
    radio = perimetro / (2 * 3.1416);
    println(f"El radio de un circulo de perimetro: $perimetro%1.2f es $radio%1.3f");
}

def radioArea (area:Double): Unit = {
    radio = math.sqrt(area * 3.1416);
    println(f"El radio de un circulo de area: $area%1.2f es $radio%1.3f");
}

//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
def isPrime(i :Int) : Boolean = {
     if (i <= 1)
       false
     else if (i == 2)
       true
     else
       !(2 to (i-1)).exists(x => i % x == 0)
   }

(1 to 100).foreach(i => if (isPrime(i)) println("%d es numero primo.".format(i)))

//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"
var bird :String = "tweet";
println(f"Estoy escribiendo un $bird%s");

//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"
val mensaje = ("Hola Luke yo soy tu padre!")
mensaje.slilce(5,9)

//5. Cual es la diferencia entre value y una variable en scala?
//  val (vlaue) son constantes lo qeu significa que no podemos modificar el valor de esta,
//  mintras var (variable) si podemos modificar su valor a lo largo del programa
val constante : Int = 5;
var variable : Int = 5;

constante = 6; //error: reassignment to val
variable = 6; 

//6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416 
val tupla1 = (2,4,5,1,2,3,3.1416,23)
tupla1._7

mutmap.values
mutmap.keys
mutmap 