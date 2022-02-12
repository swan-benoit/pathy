package courses

import graph.GraphSingleton
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
internal class DijkstraTest {

    @Test
    fun testcourse() {
        assertEquals("[1, 2, 3, 4]", Dijkstra(GraphSingleton.getInstance()).course(1, 4))
    }
}
