package displayer

import graph.GraphBaseDecorator
import graph.IGraph
import org.graphstream.graph.Graph
import org.graphstream.graph.Node
import org.graphstream.graph.implementations.SingleGraph
import graph.Graph as GraphDatastructure

class GraphDisplayer(graph: IGraph) : GraphBaseDecorator(graph),IGraphDisplayer {

    private var graphDisplayer: Graph

    override fun display() {
        this.graphDisplayer.display();
    }

    init {
        val graph = initGraph()
        initNodes(graph)
        addEdges(graph)
        this.graphDisplayer =  graph;
        System.setProperty("org.graphstream.ui", "swing")
    }

    private fun initGraph() :org.graphstream.graph.Graph{
        val graph = SingleGraph("graph name")
        graph.setAttribute("ui.stylesheet", "node { text-alignment: under;}");
        return graph
    }

    private fun addEdges(graphStream: org.graphstream.graph.Graph) {
        super.vertexes.forEach { row, destination ->
            destination.forEach {
                val edgeId = row.toString() + ":" + it.index.toString()
                graphStream.addEdge(
                    edgeId,
                    row.toString(),
                    it.index.toString(),
                    true
                )
            }
        }
    }

    private fun initNodes(graph: org.graphstream.graph.Graph) {
        super.vertexes.forEach { row, destination ->
            run {
                val node = graph.addNode(row.toString())
                addNodeLabel(node)
            }
        }
    }

    private fun addNodeLabel(node: Node) {
        node.setAttribute("ui.label", "Node " + node.id)
    }

}
