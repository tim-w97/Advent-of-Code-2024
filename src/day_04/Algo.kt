package day_04

import java.io.File

const val searchWord = "XMAS"

val lines = File("src/day_04/input.txt").readLines()

val width = lines[0].length
val height = lines.size

var count = 0

fun main() {
    repeat(width) { x ->
        val isMatch = findWord(
            x = x,
            y = 0,
            dirX = 1,
            dirY = 0,
            wordIndex = 0
        )

        println(isMatch)
    }
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