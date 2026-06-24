package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RectangleTest {
    @Test
    fun testRectangleCreation() {
        // Checking: Rectangle can be created with two points
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        assertNotNull(rect)
    }

    @Test
    fun testRectangleGetTopLeft() {
        // Checking: getTopLeft() returns the top-left corner point
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val topLeft = rect.getTopLeft()
        assertEquals(0.0, topLeft.getX())
        assertEquals(5.0, topLeft.getY())
    }

    @Test
    fun testRectangleGetBottomRight() {
        // Checking: getBottomRight() returns the bottom-right corner point
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val bottomRight = rect.getBottomRight()
        assertEquals(4.0, bottomRight.getX())
        assertEquals(0.0, bottomRight.getY())
    }

    @Test
    fun testRectangleGetTopRight() {
        // Checking: getTopRight() returns the top-right corner point
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val topRight = rect.getTopRight()
        assertEquals(4.0, topRight.getX())
        assertEquals(5.0, topRight.getY())
    }

    @Test
    fun testRectangleGetBottomLeft() {
        // Checking: getBottomLeft() returns the bottom-left corner point
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val bottomLeft = rect.getBottomLeft()
        assertEquals(0.0, bottomLeft.getX())
        assertEquals(0.0, bottomLeft.getY())
    }

    @Test
    fun testRectangleArea() {
        // Checking: getArea() calculates width * height correctly
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        assertEquals(20.0, rect.getArea())
    }

    @Test
    fun testRectangleAreaLarger() {
        // Checking: getArea() calculates area for larger rectangle
        val rect = Rectangle(Point(1.0, 10.0), Point(6.0, 2.0))
        assertEquals(40.0, rect.getArea())  // width=5, height=8
    }

    @Test
    fun testRectangleNormalizePoints() {
        // Checking: Rectangle normalizes points regardless of input order
        val rect1 = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val rect2 = Rectangle(Point(4.0, 0.0), Point(0.0, 5.0))
        assertEquals(rect1.getArea(), rect2.getArea())
    }

    @Test
    fun testRectangleMovePositive() {
        // Checking: move() translates rectangle by positive deltas
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        rect.move(2.0, 3.0)
        val topLeft = rect.getTopLeft()
        assertEquals(2.0, topLeft.getX())
        assertEquals(8.0, topLeft.getY())
    }

    @Test
    fun testRectangleMoveNegative() {
        // Checking: move() translates rectangle by negative deltas
        val rect = Rectangle(Point(5.0, 5.0), Point(10.0, 0.0))
        rect.move(-3.0, -2.0)
        val bottomLeft = rect.getBottomLeft()
        assertEquals(2.0, bottomLeft.getX())
        assertEquals(-2.0, bottomLeft.getY())
    }

    @Test
    fun testRectangleMovePreservesArea() {
        // Checking: move() preserves rectangle area
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val originalArea = rect.getArea()
        rect.move(10.0, -5.0)
        assertEquals(originalArea, rect.getArea())
    }

    @Test
    fun testRectangleZeroWidthThrowsException() {
        // Checking: Rectangle with zero width throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(3.0, 5.0), Point(3.0, 0.0))
        }
    }

    @Test
    fun testRectangleZeroHeightThrowsException() {
        // Checking: Rectangle with zero height throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(0.0, 3.0), Point(4.0, 3.0))
        }
    }

    @Test
    fun testRectangleNegativeCoordinates() {
        // Checking: Rectangle can be created with negative coordinates
        val rect = Rectangle(Point(-5.0, 2.0), Point(-1.0, -3.0))
        assertEquals(20.0, rect.getArea())  // width=4, height=5
    }

    @Test
    fun testRectanglePointsClonesAreIndependent() {
        // Checking: Retrieved points are independent clones
        val rect = Rectangle(Point(0.0, 5.0), Point(4.0, 0.0))
        val topLeft = rect.getTopLeft()
        topLeft.move(10.0, 10.0)
        val topLeftAgain = rect.getTopLeft()
        assertEquals(0.0, topLeftAgain.getX())
        assertEquals(5.0, topLeftAgain.getY())
    }
}
