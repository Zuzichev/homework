import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotSame


class Exercise1KtTest {
    class Rectangle(val width: Int, val height: Int): Figure {
        override fun area(): Int = width * height

        override fun toString(): String {
            return ("Rectangle(${width}x${height})")
        }

        override fun hashCode(): Int {
            var result = width
            result = 31 * result + height
            return result
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Rectangle

            if (width != other.width) return false
            if (height != other.height) return false
            return true
        }
    }

    @Test
    fun rectangleArea() {
        val r = Rectangle(10, 20)
        assertEquals(200, r.area())
        assertEquals(10, r.width)
        assertEquals(20, r.height)
    }
    @Test
    fun rectangleToString() {
        val r = Rectangle(10, 20)
        assertEquals("Rectangle(10x20)", r.toString())
    }
    @Test
    fun rectangleEquals() {
        val a = Rectangle(10, 20)
        val b = Rectangle(10, 20)
        val c = Rectangle(20, 10)
        assertEquals(a, b)
        assertEquals(a.hashCode(), b.hashCode())
        assertNotSame(a, b)
        assertNotEquals(a, c)
    }

    class Square(val x: Int) : Figure {
        override fun area(): Int = x * x
        override fun hashCode(): Int {
            return 31*x
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Square

            if (x != other.x) return false
            return true
        }
    }
    @Test
    fun squareEquals() {
        val a = Square(10)
        val b = Square(10)
        val c = Square(20)
        assertEquals(a.area(), b.area())
        assertEquals(a, b)
        assertEquals(a.hashCode(), b.hashCode())
        assertNotSame(a, b)
        assertNotEquals(a, c)
        println(a)
    }

    interface Figure {
        fun area(): Int
    }
    @Test
    fun figureArea() {
        var f : Figure = Rectangle(10, 20)
        assertEquals(f.area(), 200)

        f = Square(10)
        assertEquals(f.area(), 100)

    }

    @Test
    fun diffArea() {
        val a = Rectangle(10, 20)
        val b = Square(10)
        assertEquals(diffArea(a, b), 100)
    }

    private fun diffArea(a:Figure, b:Figure): Int {
        return a.area() - b.area()
    }
}