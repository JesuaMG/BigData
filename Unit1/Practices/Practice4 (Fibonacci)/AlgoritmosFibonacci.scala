//Fibonacci sequence algorithms


// #Algorithm #1
// #Descending recursive version

def fib1(n:Int):Int={
    if(n<2)
    {
        return n
    }
    else
    {
        return (fib1(n-1)+fib1(n-2))
    }
    
}

// #Algorithm #2
// #Version with explicit formula

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

// #Algorithm #3
// #Iterative version

def fib3(n:Int): Int = {
    var a = 0
    var b = 1
    var c = 0
    for (k <-1 to n){
        c = b + a
        a = b 
        b = c
    }
    return a
}
// #Algorithm #4
// #Iterative version 2 variables
def fib4(n:Int): Int = {
    var a = 0
    var b = 1
    for (k <-1 to n){
        b = b + a
        a = b - a
    }
    return a
}


// #Algorithm #5
// #Iterative version vector

def fib5(n :Int):Int={
    if(n<2)
    {
        return n
    }
    else
    {
        var vector = new  Array[Int](n+1)
        vector(0) = 0
        vector(1) = 1

        for (k<- Range(2,n+1))
        {
            vector(k)=vector(k-1)+vector(k-2)
        }
        return vector(n)
    }
    
}