package graph

data class Matrix(val value: List<List<Int>>) {

    fun add( otherMatrix: Matrix) = Matrix(
        otherMatrix.value.mapIndexed { row, list ->
            list.mapIndexed { col, value -> this.value[row][col] + otherMatrix.value[row][col] }
        }
    )

    fun transpose() =
        Matrix(
            this.value.mapIndexed { row, list ->
                list.mapIndexed { col, value -> this.value[col][row] }
                    .map { i -> if (i > 1) 1 else i }
            }
        )

}
