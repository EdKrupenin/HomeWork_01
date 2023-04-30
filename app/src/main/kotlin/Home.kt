fun removeOdd(_listInput: MutableList<Int>) {
    val itemIterator = _listInput.iterator()
    while (itemIterator.hasNext()){
        val number = itemIterator.next()
        if (number % 2 != 0)
            itemIterator.remove()
    }
}

fun slice(_listInput: MutableList<Int>, from:Int, to:Int) : IntArray {
    if (to < from || _listInput.size-1 < to)
        throw IllegalArgumentException()
    val answer = IntArray(to-from + 1)
    (0 until _listInput.size).forEach { i ->
        if (i in from..to)
            answer[i-from] = _listInput[i]
    }
    return answer
}

fun main() {
    var i = 0
    val homeWorkList = MutableList(99) { i++ }
    homeWorkList.forEach { println(it) }
    println("Удаляет из цепочки все нечетные числа")
    removeOdd(homeWorkList)
    homeWorkList.forEach { println(it) }
    println("Берет слайс с 10 по 20 элементы")
    val homeSlice = slice(homeWorkList, 10,20)
    homeSlice.forEach { println(it) }
    println("Добавляет к каждому элементу 1")
    (homeSlice.indices).forEach { index -> homeSlice[index]++ }
    homeSlice.forEach { println(it) }
    println("Суммирует все оставшиеся числа и возвращает сумму")
    val sumOfSlice = homeSlice.sum();
    println(sumOfSlice)
}