package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SquareTest {
    @Test
    fun testSquareCreation() {
        // Checking: Square can be created with equal width and height
        val square = Square(Point(0.0, 5.0), Point(5.0, 0.0))
        assertNotNull(square)
    }

    @Test
    fun testSquareArea() {
        // Checking: getArea() calculates area as side * side
        val square = Square(Point(0.0, 4.0), Point(4.0, 0.0))
        assertEquals(16.0, square.getArea())
    }

    @Test
    fun testSquareGetTopLeft() {
        // Checking: getTopLeft() returns top-left corner
        val square = Square(Point(0.0, 5.0), Point(5.0, 0.0))
        val topLeft = square.getTopLeft()
        assertEquals(0.0, topLeft.getX())
        assertEquals(5.0, topLeft.getY())
    }

    @Test
    fun testSquareGetBottomRight() {
        // Checking: getBottomRight() returns bottom-right corner
        val square = Square(Point(0.0, 5.0), Point(5.0, 0.0))
        val bottomRight = square.getBottomRight()
        assertEquals(5.0, bottomRight.getX())
        assertEquals(0.0, bottomRight.getY())
    }

    @Test
    fun testSquareMove() {
        // Checking: move() translates square by delta values
        val square = Square(Point(0.0, 4.0), Point(4.0, 0.0))
        square.move(2.0, 3.0)
        val topLeft = square.getTopLeft()
        assertEquals(2.0, topLeft.getX())
        assertEquals(7.0, topLeft.getY())
    }

    @Test
    fun testSquareMovePreservesArea() {
        // Checking: move() preserves square area
        val square = Square(Point(0.0, 3.0), Point(3.0, 0.0))
        val originalArea = square.getArea()
        square.move(5.0, -5.0)
        assertEquals(originalArea, square.getArea())
    }

    @Test
    fun testSquareUnequalDimensionsThrowsException() {
        // Checking: Square with unequal width and height throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Square(Point(0.0, 5.0), Point(4.0, 0.0))
        }
    }

    @Test
    fun testSquareZeroDimensionThrowsException() {
        // Checking: Square with zero dimensions throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Square(Point(3.0, 5.0), Point(3.0, 5.0))
        }
    }

    @Test
    fun testSquareNegativeCoordinates() {
        // Checking: Square can be created with negative coordinates
        val square = Square(Point(-3.0, 2.0), Point(2.0, -3.0))
        assertEquals(25.0, square.getArea())  // 5x5 square
    }

    @Test
    fun testSquareNormalizePoints() {
        // Checking: Square normalizes points correctly regardless of input order
        val square1 = Square(Point(0.0, 5.0), Point(5.0, 0.0))
        val square2 = Square(Point(5.0, 0.0), Point(0.0, 5.0))
        assertEquals(square1.getArea(), square2.getArea())
    }

    @Test
    fun testSquareAllCornersCorrect() {
        // Checking: All four corners have correct coordinates
        val square = Square(Point(1.0, 6.0), Point(6.0, 1.0))
        val topLeft = square.getTopLeft()
        val topRight = square.getTopRight()
        val bottomLeft = square.getBottomLeft()
        val bottomRight = square.getBottomRight()

        assertEquals(1.0, topLeft.getX())
        assertEquals(6.0, topLeft.getY())
        assertEquals(6.0, topRight.getX())
        assertEquals(6.0, topRight.getY())
        assertEquals(1.0, bottomLeft.getX())
        assertEquals(1.0, bottomLeft.getY())
        assertEquals(6.0, bottomRight.getX())
        assertEquals(1.0, bottomRight.getY())
    }
}
