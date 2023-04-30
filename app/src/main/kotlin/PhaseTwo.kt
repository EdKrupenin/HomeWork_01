import kotlinx.coroutines.delay
import kotlin.reflect.KSuspendFunction0

data class Person(val name:String, val surname:String, val age:Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return if (this.age > other.age) 1
        else if (this.age == other.age) 0
        else -1
    }
}

fun sortedByName(dataList: List<Person>): List<Person> =
    dataList.sortedWith(compareBy<Person> { it.name}.thenBy { it.surname })

suspend fun functionArg() {
    var i = 0
    while(i < 10){
        delay(500L) // delay a bit
        i++
    }
}

suspend fun stopWatch(_function: KSuspendFunction0<Unit>) {
    val startTime = System.currentTimeMillis()
    _function()
    val stopTime = System.currentTimeMillis() - startTime
    println("function work in $stopTime Ms");
}

suspend fun main(){
    val peter = Person("Peter", "Ivanov",33)
    val tsar = Person("Ivan", "Grozny",546)
    val imperator = Person("Ivan", "Ivanov",30)
    val ivan = Person("Peter", "Great",300)
    val people = mutableListOf(peter, tsar, imperator, ivan)
    val sortedAge = people.sortedDescending()
    println(sortedAge)
    val sortedName = sortedByName(people)
    println(sortedName)
    stopWatch (::functionArg)
}