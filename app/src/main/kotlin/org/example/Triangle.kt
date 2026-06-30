package org.example

class Triangle @Throws(IllegalArgumentException::class) constructor(pointA: Point, pointB: Point, pointC: Point) :
    Shape {
    private val pointA: Point = pointA.clone()
    private val pointB: Point = pointB.clone()
    private val pointC: Point = pointC.clone()

    init {
        validateArea()
    }

    fun getPointA(): Point = pointA.clone()
    fun getPointB(): Point = pointB.clone()
    fun getPointC(): Point = pointC.clone()

    fun getArea(): Double {
        val x1 = pointA.getX()
        val y1 = pointA.getY()
        val x2 = pointB.getX()
        val y2 = pointB.getY()
        val x3 = pointC.getX()
        val y3 = pointC.getY()
        return kotlin.math.abs(
            (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0
        )
    }

    override fun move(deltaX: Double, deltaY: Double) {
        pointA.move(deltaX, deltaY)
        pointB.move(deltaX, deltaY)
        pointC.move(deltaX, deltaY)
    }

    private fun validateArea() {
        if (getArea() == 0.0) {
            throw IllegalArgumentException("A triangle cannot have zero area")
        }
    }
}
