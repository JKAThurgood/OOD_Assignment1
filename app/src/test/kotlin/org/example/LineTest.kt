package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.abs

class LineTest {
    @Test
    fun testLineCreation() {
        // Checking: Line should be created with two distinct points
        val start = Point(0.0, 0.0)
        val end = Point(3.0, 4.0)
        val line = Line(start, end)
        assertEquals(0.0, line.getStartPoint().getX())
        assertEquals(0.0, line.getStartPoint().getY())
    }

    @Test
    fun testLineGetStartPoint() {
        // Checking: getStartPoint() returns a clone of the start point with correct coordinates
        val start = Point(1.0, 2.0)
        val end = Point(4.0, 6.0)
        val line = Line(start, end)
        val retrievedStart = line.getStartPoint()
        assertEquals(1.0, retrievedStart.getX())
        assertEquals(2.0, retrievedStart.getY())
    }

    @Test
    fun testLineGetEndPoint() {
        // Checking: getEndPoint() returns a clone of the end point with correct coordinates
        val start = Point(0.0, 0.0)
        val end = Point(5.0, 12.0)
        val line = Line(start, end)
        val retrievedEnd = line.getEndPoint()
        assertEquals(5.0, retrievedEnd.getX())
        assertEquals(12.0, retrievedEnd.getY())
    }

    @Test
    fun testLinePointsAreCloned() {
        // Checking: Line stores clones of points (modifying original points doesn't affect line)
        val start = Point(0.0, 0.0)
        val end = Point(3.0, 4.0)
        val line = Line(start, end)
        start.move(10.0, 10.0)
        assertEquals(0.0, line.getStartPoint().getX())
        assertEquals(0.0, line.getStartPoint().getY())
    }

    @Test
    fun testLineLength() {
        // Checking: getLength() calculates correct distance between endpoints (3-4-5 triangle)
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        assertEquals(5.0, line.getLength(), 0.0001)
    }

    @Test
    fun testLineHorizontalLength() {
        // Checking: getLength() works for horizontal lines
        val line = Line(Point(0.0, 5.0), Point(10.0, 5.0))
        assertEquals(10.0, line.getLength(), 0.0001)
    }

    @Test
    fun testLineVerticalLength() {
        // Checking: getLength() works for vertical lines
        val line = Line(Point(3.0, 0.0), Point(3.0, 7.0))
        assertEquals(7.0, line.getLength(), 0.0001)
    }

    @Test
    fun testLineSlope() {
        // Checking: getSlope() calculates correct slope (rise/run = 1 for 45 degrees)
        val line = Line(Point(0.0, 0.0), Point(3.0, 3.0))
        assertEquals(1.0, line.getSlope(), 0.0001)
    }

    @Test
    fun testLineSlopeNegative() {
        // Checking: getSlope() handles negative slopes correctly
        val line = Line(Point(0.0, 5.0), Point(5.0, 0.0))
        assertEquals(-1.0, line.getSlope(), 0.0001)
    }

    @Test
    fun testLineHorizontalSlope() {
        // Checking: getSlope() returns 0 for horizontal lines
        val line = Line(Point(0.0, 3.0), Point(5.0, 3.0))
        assertEquals(0.0, line.getSlope())
    }

    @Test
    fun testLineVerticalSlope() {
        // Checking: getSlope() returns POSITIVE_INFINITY for vertical lines
        val line = Line(Point(3.0, 0.0), Point(3.0, 5.0))
        assertEquals(Double.POSITIVE_INFINITY, line.getSlope())
    }

    @Test
    fun testLineMove() {
        // Checking: move() translates both endpoints by the specified deltas
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        line.move(2.0, 3.0)
        assertEquals(2.0, line.getStartPoint().getX())
        assertEquals(3.0, line.getStartPoint().getY())
        assertEquals(5.0, line.getEndPoint().getX())
        assertEquals(7.0, line.getEndPoint().getY())
    }

    @Test
    fun testLineMoveLengthUnchanged() {
        // Checking: move() preserves line length after translation
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        val originalLength = line.getLength()
        line.move(10.0, -5.0)
        assertEquals(originalLength, line.getLength(), 0.0001)
    }

    @Test
    fun testLineZeroLengthThrowsException() {
        // Checking: Line with same start and end points throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Line(Point(5.0, 5.0), Point(5.0, 5.0))
        }
    }

    @Test
    fun testLineNegativeCoordinates() {
        // Checking: Line can be created with negative coordinates
        val line = Line(Point(-5.0, -3.0), Point(-1.0, 2.0))
        assertEquals(-5.0, line.getStartPoint().getX())
        assertEquals(2.0, line.getEndPoint().getY())
    }
}
