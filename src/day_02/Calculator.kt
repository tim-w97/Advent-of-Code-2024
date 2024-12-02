package day_02

import java.io.File
import kotlin.math.abs

fun readLevels(onComplete: (lines: List<List<Int>>) -> Unit) {
    onComplete(
        File("src/day_02/input.txt").readLines().map { line ->
            line.split(" ").let { row ->
                row.map { level ->
                    level.toInt()
                }
            }
        }
    )
}

fun isSafe(levels: List<Int>): Boolean {
    var lastWasPositive: Boolean? = null

    repeat(levels.size - 1) { index ->
        val diff = levels[index] - levels[index + 1]

        when {
            lastWasPositive == true && diff < 0 ->
                return false

            lastWasPositive == false && diff > 0 ->
                return false

            abs(diff) !in (1..3) ->
                return false
        }

        lastWasPositive = diff > 0
    }

    return true
}

fun main() {
    var safeReports = 0

    readLevels { lines ->
        lines.forEach { levels ->
            var isSafe = isSafe(levels)

            repeat(levels.size) { index ->
                val levelsWithoutOne = levels.run {
                    subList(0, index) + subList(index + 1, size)
                }

                if (isSafe(levelsWithoutOne)) {
                    isSafe = true
                }
            }

            if (isSafe) {
                safeReports++
            }
        }
    }

    println(safeReports)
}