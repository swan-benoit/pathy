package graph

interface IGraph {
    val vertexes: MutableMap<Int, MutableSet<Vertex>>
    fun getDegree(index: Int): Int?
    fun breadthFirstSearch(start: Int): List<Vertex>
    fun depthFirstSearch(
        start: Int,
        result: MutableList<Vertex> = mutableListOf(),
        visited: MutableList<Boolean> = vertexes.map { false }.toMutableList()
    ): MutableList<Vertex>

    fun getAdjencyMatrix(): Matrix
    fun nodeList(): Map<String, Int>
}
