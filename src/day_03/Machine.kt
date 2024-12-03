package day_03

import java.io.File

fun part1() {
    val instructions = File("src/day_03/input.txt").readText()

    val mulRegex = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)")
    val numsRegex = Regex("[0-9]{1,3}")

    val result = mulRegex.findAll(instructions)
        .map { instruction ->
            numsRegex.findAll(instruction.value)
                .map { number -> number.value.toInt() }
                .reduce { a, b -> a * b}
        }
        .reduce { a, b -> a + b}

    println(result)
}

fun part2() {
    val instructions = File("src/day_03/input.txt").readText()

    val operationsRegex = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)")
    val numsRegex = Regex("[0-9]{1,3}")
    var enabled = true
    var sum = 0

    operationsRegex.findAll(instructions).forEach { operation ->
        when {
            operation.value == "do()" ->
                enabled = true
            operation.value == "don't()" ->
                enabled = false
            enabled ->
                sum += numsRegex.findAll(operation.value)
                    .map { number -> number.value.toInt() }
                    .reduce { a, b -> a * b}
        }
    }

    println(sum)
}

fun main() {
    part2()
}