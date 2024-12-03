package day_03

import java.io.File

fun main() {
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