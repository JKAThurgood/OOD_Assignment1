package org.example

import kotlin.math.PI

open class Ellipse @Throws(IllegalArgumentException::class) constructor(
    center: Point,
    radiusX: Double,
    radiusY: Double
) : Shape {
    private val center: Point
    private val radiusX: Double
    private val radiusY: Double

    init {
        if (radiusX <= 0.0 || radiusY <= 0.0) {
            throw IllegalArgumentException("An ellipse cannot have an area of zero")
        }
        this.center = center.clone()
        this.radiusX = radiusX
        this.radiusY = radiusY
    }

    fun getCenter(): Point = center.clone()
    fun getRadiusX(): Double = radiusX
    fun getRadiusY(): Double = radiusY

    fun getArea(): Double {
        return PI * radiusX * radiusY
    }

    override fun move(deltaX: Double, deltaY: Double) {
        center.move(deltaX, deltaY)
    }

}
