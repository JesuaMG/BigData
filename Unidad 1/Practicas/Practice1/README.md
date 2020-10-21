# Practice #1

### Exercise 1

Develop a scala algorithm that calculates the radius of a circle

'''
var radio: Double = 0;

def radioPerimetro (perimetro:Double): Unit = {
    radio = perimetro / (2 * 3.1416);
    println(f"El radio de un circulo de perimetro: $perimetro%1.2f es $radio%1.3f");
}

def radioArea (area:Double): Unit = {
    radio = math.sqrt(area * 3.1416);
    println(f"El radio de un circulo de area: $area%1.2f es $radio%1.3f");
}
'''

### Exercise 2

Develop an algorithm in scala that tells me if a number is prime

'''
def isPrime(i :Int) : Boolean = {
     if (i <= 1)
       false
     else if (i == 2)
       true
     else
       !(2 to (i-1)).exists(x => i % x == 0)
   }

(1 to 100).foreach(i => if (isPrime(i)) println("%d es numero primo.".format(i)))
'''

### Exercise 3

Given the variable bird = "tweet", use string interpolation to print "I'm writing a tweet"

'''
var bird :String = "tweet";
println(f"Estoy escribiendo un $bird%s");
'''

### Exercise 4

Given the variable message = "Hello Luke, I am your father!" use slice to extract the sequence "Luke"

'''
val mensaje = ("Hola Luke yo soy tu padre!")
mensaje.slilce(5,9)
'''

### Exercise 5

What is the difference between value and a variable in scala?
> val (value) are constant which means that we cannot modify its value, while var (variable) if we can modify its value throughout the program

## Exercise 6

Given the tuple (2,4,5,1,2,3,3.1416,23) returns the number 3.1416

'''
val tupla1 = (2,4,5,1,2,3,3.1416,23)
tupla1._7

mutmap.values
mutmap.keys
mutmap 
'''