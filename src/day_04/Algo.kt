package day_04

import java.io.File

const val searchWord = "XMAS"

val lines = File("src/day_04/input.txt").readLines()

val width = lines[0].length
val height = lines.size

fun main() {
    var xmasWordCount = 0
    var xShapedMasCount = 0

    repeat(height) { y ->
        repeat(width) { x ->
            if (isXShapedMas(x, y)) {
                xShapedMasCount ++
            }

            repeat(3) { dirY ->
                repeat(3) { dirX ->
                    val isXmasWord = findWord(
                        x = x,
                        y = y,
                        dirX = dirX - 1,
                        dirY = dirY - 1,
                        wordIndex = 0
                    )

                    if (isXmasWord) {
                        xmasWordCount++
                    }
                }
            }
        }
    }

    println("XMAS count: $xmasWordCount")
    println("X shaped MAS count: $xShapedMasCount")
}

fun isXShapedMas(x: Int, y: Int): Boolean {
    if (x < 1 || x >= width - 1 || y < 1 || y >= height - 1) {
        return false
    }

    val word1 = StringBuilder()
        .append(getLetter(x - 1, y - 1))
        .append(getLetter(x, y))
        .append(getLetter(x + 1, y + 1))
        .toString()

    val word2 = StringBuilder()
        .append(getLetter(x - 1, y + 1))
        .append(getLetter(x, y))
        .append(getLetter(x + 1, y - 1))
        .toString()

    return (word1 == "MAS" || word1 == "SAM") && (word2 == "MAS" || word2 == "SAM")
}

fun findWord(x: Int, y: Int, dirX: Int, dirY: Int, wordIndex: Int): Boolean {
    // word is XMAS, we have a match!
    if (wordIndex == searchWord.length) {
        return true
    }

    // x or y is out of bounds
    if (x < 0 || x >= width || y < 0 || y >= height) {
        return false
    }

    if (getLetter(x, y) == searchWord[wordIndex]) {
        // Search again in another direction
        return findWord(
            x = x + dirX,
            y = y + dirY,
            dirX = dirX,
            dirY = dirY,
            wordIndex = wordIndex + 1
        )
    }

    // one letter was wrong, we don't have a match :-(
    return false
}

fun getLetter(x: Int, y: Int): Char = lines[y][x]