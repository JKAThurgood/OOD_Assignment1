package org.example

class Circle(center: Point, radius: Double) : Ellipse(center, radius, radius) {
    init {
        validateCircle()
    }

    private fun validateCircle() {
        if (getRadiusX() != getRadiusY()) {
            throw IllegalArgumentException("A circle must have equal radii")
        }
    }
}
