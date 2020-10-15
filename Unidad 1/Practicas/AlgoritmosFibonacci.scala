//Fibonacci sequence algorithms
//Algorithm 1

//Algorithm 2
//Version with explicit formula

def fib2(n:Int): Double = {
    if(n < 2){
        return n
    }
    else{
        var fi = ((1 + math.sqrt(5)) / 2)
        var j = ((math.pow(fi, n) - (math.pow((1 - fi), n))) / (math.sqrt(5)))
        return j
    }
}

//Algorithm 3

//Algorithm 4
//Iterative version 2 variables
def fib4(n:Int): Int = {
    var a = 0
    var b = 1
    for (k <-1 to n){
        b = b + a
        a = b - a
    }
    return a
}

//Algorithm 5
