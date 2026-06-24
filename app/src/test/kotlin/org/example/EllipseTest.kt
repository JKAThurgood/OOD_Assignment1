package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.PI

class EllipseTest {
    @Test
    fun testEllipseCreation() {
        // Checking: Ellipse can be created with center point and two positive radii
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 3.0)
        assertNotNull(ellipse)
    }

    @Test
    fun testEllipseGetCenter() {
        // Checking: getCenter() returns a clone of the center point
        val center = Point(2.0, 3.0)
        val ellipse = Ellipse(center, 5.0, 3.0)
        val retrieved = ellipse.getCenter()
        assertEquals(2.0, retrieved.getX())
        assertEquals(3.0, retrieved.getY())
    }

    @Test
    fun testEllipseGetRadiusX() {
        // Checking: getRadiusX() returns the correct horizontal radius
        val ellipse = Ellipse(Point(0.0, 0.0), 7.5, 3.0)
        assertEquals(7.5, ellipse.getRadiusX())
    }

    @Test
    fun testEllipseGetRadiusY() {
        // Checking: getRadiusY() returns the correct vertical radius
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 4.5)
        assertEquals(4.5, ellipse.getRadiusY())
    }

    @Test
    fun testEllipseArea() {
        // Checking: getArea() calculates PI * radiusX * radiusY
        val ellipse = Ellipse(Point(0.0, 0.0), 4.0, 3.0)
        assertEquals(12 * PI, ellipse.getArea(), 0.0001)
    }

    @Test
    fun testEllipseAreaCircular() {
        // Checking: getArea() for ellipse with equal radii (circular case)
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 5.0)
        assertEquals(25 * PI, ellipse.getArea(), 0.0001)
    }

    @Test
    fun testEllipseMove() {
        // Checking: move() translates ellipse center by delta values
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 3.0)
        ellipse.move(2.0, 4.0)
        val newCenter = ellipse.getCenter()
        assertEquals(2.0, newCenter.getX())
        assertEquals(4.0, newCenter.getY())
    }

    @Test
    fun testEllipseMovePreservesRadii() {
        // Checking: move() preserves radii
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 3.0)
        ellipse.move(10.0, -5.0)
        assertEquals(5.0, ellipse.getRadiusX())
        assertEquals(3.0, ellipse.getRadiusY())
    }

    @Test
    fun testEllipseMoveNegative() {
        // Checking: move() handles negative deltas
        val ellipse = Ellipse(Point(5.0, 5.0), 2.0, 2.0)
        ellipse.move(-3.0, -2.0)
        val newCenter = ellipse.getCenter()
        assertEquals(2.0, newCenter.getX())
        assertEquals(3.0, newCenter.getY())
    }

    @Test
    fun testEllipseZeroRadiusXThrowsException() {
        // Checking: Ellipse with zero or negative radiusX throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 0.0, 3.0)
        }
    }

    @Test
    fun testEllipseNegativeRadiusXThrowsException() {
        // Checking: Ellipse with negative radiusX throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), -5.0, 3.0)
        }
    }

    @Test
    fun testEllipseZeroRadiusYThrowsException() {
        // Checking: Ellipse with zero or negative radiusY throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 5.0, 0.0)
        }
    }

    @Test
    fun testEllipseNegativeRadiusYThrowsException() {
        // Checking: Ellipse with negative radiusY throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 5.0, -3.0)
        }
    }

    @Test
    fun testEllipseCenterCloneIsIndependent() {
        // Checking: Retrieved center is independent clone
        val ellipse = Ellipse(Point(0.0, 0.0), 5.0, 3.0)
        val center = ellipse.getCenter()
        center.move(10.0, 10.0)
        val centerAgain = ellipse.getCenter()
        assertEquals(0.0, centerAgain.getX())
        assertEquals(0.0, centerAgain.getY())
    }

    @Test
    fun testEllipseNegativeCenterCoordinates() {
        // Checking: Ellipse can have center with negative coordinates
        val ellipse = Ellipse(Point(-5.0, -3.0), 2.0, 2.0)
        val center = ellipse.getCenter()
        assertEquals(-5.0, center.getX())
        assertEquals(-3.0, center.getY())
    }
}
