package org.example

class Line @Throws(IllegalArgumentException::class) constructor(startPoint: Point, endPoint: Point) : Shape {
    private val startPoint: Point = startPoint.clone()
    private val endPoint: Point = endPoint.clone()

    init {
        validateLength()
    }

    fun getStartPoint(): Point = startPoint.clone()
    fun getEndPoint(): Point = endPoint.clone()

    fun getSlope(): Double {
        val deltaX = endPoint.getX() - startPoint.getX()
        val deltaY = endPoint.getY() - startPoint.getY()
        return if (deltaX == 0.0) {
            if (deltaY == 0.0) Double.NaN else Double.POSITIVE_INFINITY
        } else {
            deltaY / deltaX
        }
    }

    fun getLength(): Double {
        val dx = endPoint.getX() - startPoint.getX()
        val dy = endPoint.getY() - startPoint.getY()
        return kotlin.math.hypot(dx, dy)
    }

    override fun move(deltaX: Double, deltaY: Double) {
        startPoint.move(deltaX, deltaY)
        endPoint.move(deltaX, deltaY)
    }

    private fun validateLength() {
        if (getLength() == 0.0) {
            throw IllegalArgumentException("A line cannot have zero length")
        }
    }
}
