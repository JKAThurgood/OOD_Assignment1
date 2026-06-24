package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PointTest {
    @Test
    fun testPointCreation() {
        // Checking: Point should be created with given x and y coordinates
        val point = Point(3.0, 4.0)
        assertEquals(3.0, point.getX())
        assertEquals(4.0, point.getY())
    }

    @Test
    fun testPointGetX() {
        // Checking: getX() returns the correct x coordinate
        val point = Point(5.5, 2.0)
        assertEquals(5.5, point.getX())
    }

    @Test
    fun testPointGetY() {
        // Checking: getY() returns the correct y coordinate
        val point = Point(1.0, 7.3)
        assertEquals(7.3, point.getY())
    }

    @Test
    fun testPointClone() {
        // Checking: clone() creates a new point with identical coordinates
        val original = Point(2.0, 3.0)
        val cloned = original.clone()
        assertEquals(original.getX(), cloned.getX())
        assertEquals(original.getY(), cloned.getY())
    }

    @Test
    fun testPointCloneIsIndependent() {
        // Checking: clone() creates independent copy (modifying clone doesn't affect original)
        val original = Point(1.0, 1.0)
        val cloned = original.clone()
        cloned.move(5.0, 5.0)
        assertEquals(1.0, original.getX())
        assertEquals(1.0, original.getY())
    }

    @Test
    fun testPointMove() {
        // Checking: move() correctly updates point coordinates by delta values
        val point = Point(3.0, 4.0)
        point.move(2.0, 1.0)
        assertEquals(5.0, point.getX())
        assertEquals(5.0, point.getY())
    }

    @Test
    fun testPointMoveNegative() {
        // Checking: move() handles negative delta values correctly
        val point = Point(5.0, 5.0)
        point.move(-2.0, -3.0)
        assertEquals(3.0, point.getX())
        assertEquals(2.0, point.getY())
    }

    @Test
    fun testPointMoveZero() {
        // Checking: move() with zero deltas leaves point unchanged
        val point = Point(2.0, 3.0)
        point.move(0.0, 0.0)
        assertEquals(2.0, point.getX())
        assertEquals(3.0, point.getY())
    }

    @Test
    fun testPointNegativeCoordinates() {
        // Checking: Point can have negative coordinates
        val point = Point(-5.5, -10.3)
        assertEquals(-5.5, point.getX())
        assertEquals(-10.3, point.getY())
    }

    @Test
    fun testPointZeroCoordinates() {
        // Checking: Point can be at origin (0, 0)
        val point = Point(0.0, 0.0)
        assertEquals(0.0, point.getX())
        assertEquals(0.0, point.getY())
    }
}
