package org.example

class Circle @Throws(IllegalArgumentException::class) constructor(center: Point, radius: Double) :
    Ellipse(center, radius, radius) {
}
