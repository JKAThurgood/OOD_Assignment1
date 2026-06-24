package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TriangleTest {
    @Test
    fun testTriangleCreation() {
        // Checking: Triangle can be created with three non-collinear points
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        assertNotNull(triangle)
    }

    @Test
    fun testTriangleGetPointA() {
        // Checking: getPointA() returns a clone of point A with correct coordinates
        val pointA = Point(0.0, 0.0)
        val triangle = Triangle(pointA, Point(3.0, 0.0), Point(0.0, 4.0))
        val retrieved = triangle.getPointA()
        assertEquals(0.0, retrieved.getX())
        assertEquals(0.0, retrieved.getY())
    }

    @Test
    fun testTriangleGetPointB() {
        // Checking: getPointB() returns a clone of point B with correct coordinates
        val pointB = Point(5.0, 2.0)
        val triangle = Triangle(Point(0.0, 0.0), pointB, Point(1.0, 3.0))
        val retrieved = triangle.getPointB()
        assertEquals(5.0, retrieved.getX())
        assertEquals(2.0, retrieved.getY())
    }

    @Test
    fun testTriangleGetPointC() {
        // Checking: getPointC() returns a clone of point C with correct coordinates
        val pointC = Point(-1.0, -1.0)
        val triangle = Triangle(Point(0.0, 0.0), Point(2.0, 0.0), pointC)
        val retrieved = triangle.getPointC()
        assertEquals(-1.0, retrieved.getX())
        assertEquals(-1.0, retrieved.getY())
    }

    @Test
    fun testTriangleAreaRightTriangle() {
        // Checking: getArea() calculates area for 3-4-5 right triangle correctly
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        assertEquals(6.0, triangle.getArea(), 0.0001)  // (3 * 4) / 2 = 6
    }

    @Test
    fun testTriangleAreaArbitary() {
        // Checking: getArea() calculates area for arbitrary triangle
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(2.0, 3.0))
        assertEquals(6.0, triangle.getArea(), 0.0001)  // (4 * 3) / 2 = 6
    }

    @Test
    fun testTriangleAreaPositive() {
        // Checking: getArea() returns positive value regardless of point order
        val triangle1 = Triangle(Point(0.0, 0.0), Point(1.0, 0.0), Point(0.0, 1.0))
        val triangle2 = Triangle(Point(0.0, 1.0), Point(0.0, 0.0), Point(1.0, 0.0))
        assertEquals(triangle1.getArea(), triangle2.getArea())
    }

    @Test
    fun testTriangleMovePositive() {
        // Checking: move() translates all three vertices by delta values
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        triangle.move(2.0, 3.0)
        val pointA = triangle.getPointA()
        val pointB = triangle.getPointB()
        val pointC = triangle.getPointC()

        assertEquals(2.0, pointA.getX())
        assertEquals(3.0, pointA.getY())
        assertEquals(5.0, pointB.getX())
        assertEquals(3.0, pointB.getY())
        assertEquals(2.0, pointC.getX())
        assertEquals(7.0, pointC.getY())
    }

    @Test
    fun testTriangleMoveNegative() {
        // Checking: move() handles negative delta values
        val triangle = Triangle(Point(5.0, 5.0), Point(8.0, 5.0), Point(5.0, 9.0))
        triangle.move(-2.0, -3.0)
        val pointA = triangle.getPointA()
        assertEquals(3.0, pointA.getX())
        assertEquals(2.0, pointA.getY())
    }

    @Test
    fun testTriangleMovePreservesArea() {
        // Checking: move() preserves triangle area
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        val originalArea = triangle.getArea()
        triangle.move(10.0, -5.0)
        assertEquals(originalArea, triangle.getArea(), 0.0001)
    }

    @Test
    fun testTrianglePointsAreCloned() {
        // Checking: Triangle stores clones of points (modifying original points doesn't affect triangle)
        val pointA = Point(0.0, 0.0)
        val pointB = Point(3.0, 0.0)
        val pointC = Point(0.0, 4.0)
        val triangle = Triangle(pointA, pointB, pointC)

        pointA.move(10.0, 10.0)
        pointB.move(5.0, 5.0)
        pointC.move(-5.0, -5.0)

        val retrievedA = triangle.getPointA()
        assertEquals(0.0, retrievedA.getX())
        assertEquals(0.0, retrievedA.getY())
    }

    @Test
    fun testTriangleCollinearPointsThrowsException() {
        // Checking: Triangle with collinear points (zero area) throws exception
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(Point(0.0, 0.0), Point(1.0, 1.0), Point(2.0, 2.0))
        }
    }

    @Test
    fun testTriangleNegativeCoordinates() {
        // Checking: Triangle can be created with negative coordinates
        val triangle = Triangle(Point(-5.0, -5.0), Point(-2.0, -5.0), Point(-5.0, -1.0))
        assertTrue(triangle.getArea() > 0.0)
    }

    @Test
    fun testTriangleRetrievedPointsAreIndependent() {
        // Checking: Retrieved points are independent clones
        val triangle = Triangle(Point(0.0, 0.0), Point(3.0, 0.0), Point(0.0, 4.0))
        val pointA = triangle.getPointA()
        pointA.move(10.0, 10.0)
        val pointAAgain = triangle.getPointA()
        assertEquals(0.0, pointAAgain.getX())
        assertEquals(0.0, pointAAgain.getY())
    }

    @Test
    fun testTriangleSmallArea() {
        // Checking: Triangle with very small area (but non-zero) can be created
        val triangle = Triangle(Point(0.0, 0.0), Point(0.001, 0.0), Point(0.0, 0.001))
        assertTrue(triangle.getArea() > 0.0)
        assertTrue(triangle.getArea() < 0.0001)
    }
}
