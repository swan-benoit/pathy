package courses

import graph.GraphSingleton
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class BreadthFirstTest {

    @Test
    fun testCourse() {
        assertEquals("[10, 6, 7, 3, 4, 14, 1, 5, 12, 2, 9, 8, 11, 13]", BreadthFirst(GraphSingleton.getInstance()).course(10, 13))
    }
}
