package org.example

open class Rectangle @Throws(IllegalArgumentException::class) constructor(a: Point, b: Point) : Shape {

    private val topLeft: Point
    private val bottomRight: Point

    init {
        val normalized = normalizePoints(a, b)
        this.topLeft = normalized.first
        this.bottomRight = normalized.second
        validateDimensions()
    }

    fun getTopLeft(): Point = topLeft.clone()
    fun getBottomRight(): Point = bottomRight.clone()

    fun getTopRight(): Point =
        Point(bottomRight.getX(), topLeft.getY())

    fun getBottomLeft(): Point =
        Point(topLeft.getX(), bottomRight.getY())

    fun getArea(): Double = width() * height()

    override fun move(deltaX: Double, deltaY: Double) {
        topLeft.move(deltaX, deltaY)
        bottomRight.move(deltaX, deltaY)
    }

    protected fun width(): Double =
        kotlin.math.abs(bottomRight.getX() - topLeft.getX())

    protected fun height(): Double =
        kotlin.math.abs(topLeft.getY() - bottomRight.getY())

    private fun validateDimensions() {
        if (width() == 0.0 || height() == 0.0) {
            throw IllegalArgumentException("A rectangle cannot have zero width or height")
        }
    }

    // Normalizes any two points into a consistent bounding box
    private fun normalizePoints(a: Point, b: Point): Pair<Point, Point> {
        val left = minOf(a.getX(), b.getX())
        val right = maxOf(a.getX(), b.getX())
        val top = maxOf(a.getY(), b.getY())
        val bottom = minOf(a.getY(), b.getY())

        return Pair(
            Point(left, top),     // top-left
            Point(right, bottom)  // bottom-right
        )
    }
}
