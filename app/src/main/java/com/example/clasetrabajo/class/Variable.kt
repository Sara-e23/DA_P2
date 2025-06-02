//package com.example.clasetrabajo.class

//class clase2 {
//}

fun main(){
    //variables numericas
    val age:Int = 20 //tipo entero
    val long_number:Long = 789123128937 //long para num grandes
    val temperature:Float = 21.14f //float para valor decimal
    val weight:Double = 72.4589 //double decimal para precisión

    //variables tipo string y char
    val gender:Char = 'M' //Char para 1 solo caracter
    val name:String = "Sara Elizabeth" //String para almacenar texto

    //variables booleanas
    val isGreater:Boolean = false //boolean que almacena true o false

    //variables de colección (arreglo de strings)
    val names = arrayOf("Erick", "Sofia", "Javier", "Verónica")

    //Imprimir las variables en consola
    println(age) //imprime edad
    //se concatena
    println("Welcome $name, to your first Kotlin project")
    //imprime mensaje de interpolación de cadenas

    //funciones fuera del main
    println(add()) //llama a funcion add() e imprime
    println(product(5,8)) //llama a funcion product() con parámetros e imprime
    printArray(names) //llama a funcion printArray() imprime nombres de arreglo
    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10) //declara nuevo arreglo de enteros
    isEven(numbers) //funcion isEven() para determinar num pares e impares

    //println(getDay(day : (1))
//    val person = Person(name:"Andreita", age: 6)
//    person.displayInformation()
    //solo imprimir el atributo de name
//    println(person.name)
//    println(person.age)

}//main

fun add(): Int{ //funcion que suma e imprime resultado
    val x = 10
    val y = 5 //Variables enteras
    return (x + y) //retorna la suma de x & y
}

fun product(x: Int, y: Int): Int { //funcion de mult e imprime
    return(x * y) //retorna multip de x por y
}

fun printArray(names: Array<String>){ //funcion de arreglo de nombres
    println(names)
    for(name in names){ //repite sobre cada elemento del arreglo
        println("Hello $name") //imprime un saludo con el nombre
    }
}

fun isEven(numbers: Array<Int>){
    for(number in numbers){
        if(number % 2 == 0){
            println("The number $number is even") //imprime par
        } else{ //si no es par
            println("The number $number is odd") //imprime impar
        }
    }
}

fun getDay(day:Int): String{
    var name = ""
    when(day){//se pueden poner llaves entre el nombre y el numero de día para
        //agrear más cosas
        1 -> name = "Monday"
        2 -> name = "Tuesday"
        3 -> name = "Wednesday"
        4 -> name = "Thursday"
        5 -> name = "Friday"
        6 -> name = "Saturday"
        7 -> name = "Sunday"
        else -> name = "Incorrect value"

    }
    return name
}

class Person (val name:String, val age:Int){
    fun displayInformation(){
        println("Name: $name Age: $age")
    }
}