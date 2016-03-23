package examples

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo as eq

class Examples {

    // --------------------------------------------------

    @Test
    fun destructuring() {

        data class Result(val result: Int, val status: String)

        fun function(): Result {
            // ...
            return Result(3, "foo")
        }

        // Now, to use this function:
        val (result, status) = function()

        assertThat(result, `is`(3))
        assertThat(status, eq("foo"))

    }

    // --------------------------------------------------

    sealed class ChildrenType { // change to 'open'
        class Eeny: ChildrenType()
        class Meeny(val meeny: Int): ChildrenType()
        class Miny(val miny: String): ChildrenType()
        class Moe(val moe: Int): ChildrenType()
    }

    @Test
    fun caseMatching() {

        fun function(type: ChildrenType): Int = when (type) {
            is ChildrenType.Eeny -> 1
            is ChildrenType.Meeny -> { type.meeny * 2 }
            is ChildrenType.Miny -> { type.miny.length }
            is ChildrenType.Moe -> { type.moe }
        }

        assertThat(function(ChildrenType.Meeny(42)), eq(84))
        assertThat(function(ChildrenType.Miny("some text")), eq(9))

    }

    // --------------------------------------------------


    @Test
    fun extensionFunctions() {
        fun <E> List<E>.random(): Int {
            return 1; // some random index
        }

        val a = listOf(1,2,3)

        assertThat(a.random(), eq(1));
    }


    // --------------------------------------------------

    @Test
    fun inspiredByDotDotDot() {
        val a: Any = 3;
        val b = { i: Int -> i + 1 }
        val c: (Int) -> Unit = { i -> i + 1 }

        assertThat(b(2), `is`(3)) // call c

        // Collection types are immutable by default
        val d: List<String> = listOf("Foo") // try mutableListOf()
        assertThat(d.first(), eq("Foo"))
    }

    class FooClass()
    object FooObject


    // --------------------------------------------------

    // The Kotlin SDK library is < 700kb and the runtime lib is about 210 kb.

}
