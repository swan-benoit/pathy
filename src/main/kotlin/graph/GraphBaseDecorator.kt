package graph

open class GraphBaseDecorator(private val graph: IGraph) : IGraph {
    override val vertexes: MutableMap<Int, MutableSet<Vertex>>
        get() = graph.vertexes

    override fun getDegree(index: Int): Int? {
        return graph.getDegree(index)
    }

    override fun breadthFirstSearch(start: Int): List<Vertex> {
        return graph.breadthFirstSearch(start)
    }

    override fun depthFirstSearch(
        start: Int,
        result: MutableList<Vertex>,
        visited: MutableList<Boolean>
    ): MutableList<Vertex> {
        return graph.depthFirstSearch(start,result,visited)
    }

    override fun getAdjencyMatrix(): Matrix {
        return graph.getAdjencyMatrix();
    }

    override fun nodeList(): Map<String, Int> {
        return graph.nodeList()
    }

}
