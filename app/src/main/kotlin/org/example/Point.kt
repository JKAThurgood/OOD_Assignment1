package org.example

class Point(private var x: Double, private var y: Double) : Shape {

    fun getX(): Double = x
    fun getY(): Double = y

    fun clone(): Point = Point(x, y)

    override fun move(deltaX: Double, deltaY: Double) {
        x += deltaX
        y += deltaY
    }
}
