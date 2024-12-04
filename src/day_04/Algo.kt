package day_04

import java.io.File
import java.time.Year

fun main() {
    val lines = File("src/day_04/input.txt").readLines()
    val lineLength = lines[0].length
    val searchWord = "XMAS"
    var count = 0

    // region find horizontal matches
    for (line in lines) {
        repeat(line.length - searchWord.length) { index ->
            line.substring(index, index + searchWord.length).let { possibleWord ->
                if (possibleWord == searchWord || possibleWord == searchWord.reversed()) {
//                    count ++
                }
            }
        }
    }
    // endregion

    // region find vertical matches
    for (lineLengthIndex in lineLength - 1 downTo 0) {
        repeat(lines.size - searchWord.length + 1) { lineIndex ->
            var possibleWord = ""

            repeat(searchWord.length) { wordIndex ->
                possibleWord += lines[wordIndex + lineIndex][lineLengthIndex]
            }

            if (possibleWord == searchWord || possibleWord == searchWord.reversed()) {
//                count ++
            }
        }
    }
    // endregion

    // find diagonal matches

}