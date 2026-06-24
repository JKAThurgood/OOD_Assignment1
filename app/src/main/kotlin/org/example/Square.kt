package org.example

class Square(pointA: Point, pointB: Point) : Rectangle(pointA, pointB) {
    init {
        validateSquare()
    }

    private fun validateSquare() {
        if (width() != height()) {
            throw IllegalArgumentException("A square must have equal width and height")
        }
    }
}
