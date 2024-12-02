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

fun main() {
    readLevels { lines ->
        var safeReports = 0

        lines.forEach { levels ->
            var lastWasPositive: Boolean? = null
            var isSafe = true

            repeat(levels.size - 1) { index ->
                val diff = levels[index] - levels[index + 1]

                when {
                    lastWasPositive == true && diff < 0 ->
                        isSafe = false

                    lastWasPositive == false && diff > 0 ->
                        isSafe = false

                    abs(diff) !in (1..3) ->
                        isSafe = false
                }

                lastWasPositive = diff > 0
            }

            if (isSafe) {
                safeReports++
            }
        }

        println(safeReports)
    }
}