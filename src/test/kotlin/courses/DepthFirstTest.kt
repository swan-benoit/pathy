package courses

import graph.GraphSingleton
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class DepthFirstTest {

    @Test
    fun testCourse() {
        assertEquals("[10, 6, 3, 4, 1, 2, 8, 11, 13]", DepthFirst(GraphSingleton.getInstance()).course(10, 13))
    }
}
