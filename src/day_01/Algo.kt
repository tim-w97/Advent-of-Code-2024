package day_01

import java.io.File
import kotlin.math.abs

fun readInput(onComplete: (firstList: List<Int>, secondList: List<Int>) -> Unit) {
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    File("src/day_01/input.txt").readLines().forEach { line ->
        line.split("   ").let { pair ->
            firstList.add(pair[0].trim().toInt())
            secondList.add(pair[1].trim().toInt())
        }
    }

    firstList.sort()
    secondList.sort()

    onComplete(firstList, secondList)
}

fun part1() {
    var sum = 0

    readInput { firstList, secondList ->
        repeat(firstList.size) { index ->
            val difference = abs(firstList[index] - secondList[index])
            sum += difference
        }
    }

    println(sum)
}

fun part2() {
    var sum = 0

    readInput { firstList, secondList ->
        firstList.forEach { numberFromFirstList ->
            val count = secondList.count { numberFromSecondList -> numberFromSecondList == numberFromFirstList }
            sum += count * numberFromFirstList
        }
    }

    println(sum)
}

fun main() {
    part2()
}