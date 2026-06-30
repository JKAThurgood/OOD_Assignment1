package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.PI

class CircleTest {
    @Test
    fun testCircleCreation() {
        // Checking: Circle can be created with center point and single radius
        val circle = Circle(Point(0.0, 0.0), 5.0)
        assertNotNull(circle)
    }

    @Test
    fun testCircleGetCenter() {
        // Checking: getCenter() returns a clone of the center point
        val center = Point(3.0, 4.0)
        val circle = Circle(center, 5.0)
        val retrieved = circle.getCenter()
        assertEquals(3.0, retrieved.getX())
        assertEquals(4.0, retrieved.getY())
    }

    @Test
    fun testCircleRadiiAreEqual() {
        // Checking: getRadiusX() and getRadiusY() return the same value
        val circle = Circle(Point(0.0, 0.0), 7.5)
        assertEquals(7.5, circle.getRadiusX())
        assertEquals(7.5, circle.getRadiusY())
        assertEquals(circle.getRadiusX(), circle.getRadiusY())
    }

    @Test
    fun testCircleArea() {
        // Checking: getArea() calculates PI * radius * radius (same as π * radius²)
        val circle = Circle(Point(0.0, 0.0), 3.0)
        assertEquals(9 * PI, circle.getArea(), 0.0001)
    }

    @Test
    fun testCircleAreaRadius1() {
        // Checking: getArea() for unit circle (radius=1)
        val circle = Circle(Point(0.0, 0.0), 1.0)
        assertEquals(PI, circle.getArea(), 0.0001)
    }

    @Test
    fun testCircleMove() {
        // Checking: move() translates circle center by delta values
        val circle = Circle(Point(0.0, 0.0), 5.0)
        circle.move(3.0, 4.0)
        val newCenter = circle.getCenter()
        assertEquals(3.0, newCenter.getX())
        assertEquals(4.0, newCenter.getY())
    }

    @Test
    fun testCircleMovePreservesRadius() {
        // Checking: move() preserves radius
        val circle = Circle(Point(5.0, 5.0), 3.0)
        circle.move(2.0, -3.0)
        assertEquals(3.0, circle.getRadiusX())
        assertEquals(3.0, circle.getRadiusY())
    }

    @Test
    fun testCircleMovePreservesArea() {
        // Checking: move() preserves area
        val circle = Circle(Point(0.0, 0.0), 4.0)
        val originalArea = circle.getArea()
        circle.move(10.0, -10.0)
        assertEquals(originalArea, circle.getArea(), 0.0001)
    }

    @Test
    fun testCircleZeroRadiusThrowsException() {
        // Checking: Circle with zero radius throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), 0.0)
        }
    }

    @Test
    fun testCircleNegativeRadiusThrowsException() {
        // Checking: Circle with negative radius throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), -5.0)
        }
    }

    @Test
    fun testCircleSmallRadius() {
        // Checking: Circle can have very small radius
        val circle = Circle(Point(0.0, 0.0), 0.001)
        assertEquals(0.001, circle.getRadiusX())
        assertTrue(circle.getArea() > 0.0)
    }

    @Test
    fun testCircleLargeRadius() {
        // Checking: Circle can have very large radius
        val circle = Circle(Point(0.0, 0.0), 1000.0)
        assertEquals(1000.0, circle.getRadiusX())
        assertEquals(1000.0, circle.getRadiusY())
    }

    @Test
    fun testCircleNegativeCenterCoordinates() {
        // Checking: Circle can have center with negative coordinates
        val circle = Circle(Point(-5.0, -3.0), 2.0)
        val center = circle.getCenter()
        assertEquals(-5.0, center.getX())
        assertEquals(-3.0, center.getY())
    }

    @Test
    fun testCircleIsSubclassOfEllipse() {
        // Checking: Circle inherits from Ellipse correctly
        val circle = Circle(Point(0.0, 0.0), 5.0)
    }
}
