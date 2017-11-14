/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * Accepted.
 */
class SetMatrixZeroes {

    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return

        val row = HashSet<Int>(matrix.size)
        val column = HashSet<Int>(matrix[0].size)
        matrix.indices.forEach { i ->
            (0 until matrix[0].size).forEach {
                if (matrix[i][it] == 0) {
                    row.add(i)
                    column.add(it)
                }
            }
        }

        row.forEach { i -> (0 until matrix[0].size).forEach { matrix[i][it] = 0 } }

        column.forEach { i -> (0 until matrix.size).forEach { matrix[it][i] = 0 } }

        print("{")
        for (group in matrix) {
            println()
            group.forEach { print("$it ") }
        }
        println("\n}")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val smz = SetMatrixZeroes()

            smz.setZeroes(arrayOf())
            // The matrix:
            // {
            //  {0, 0}
            // }
            smz.setZeroes(arrayOf(intArrayOf(0, 1)))
            // The matrix:
            // {
            //  {0, 0, 0},
            //  {3, 0, 5},
            //  {6, 0, 8}
            // }
            smz.setZeroes(arrayOf(intArrayOf(1, 0, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8)))
            // The matrix:
            // {
            //  {0, 0, 0},
            //  {0, 0, 0},
            //  {0, 0, 0},
            // }
            smz.setZeroes(arrayOf(intArrayOf(0, 1, 1), intArrayOf(2, 0, 2), intArrayOf(3, 3, 0)))
            // The matrix:
            // {
            //  {0, 0, 0, 0},
            //  {0, 0, 0, 4},
            //  {0, 0, 0, 0},
            //  {0, 0, 0, 3},
            //  {0, 0, 0, 0}
            // }
            smz.setZeroes(arrayOf(intArrayOf(0, 0, 0, 5), intArrayOf(4, 3, 1, 4), intArrayOf(0, 1, 1, 4), intArrayOf(1, 2, 1, 3), intArrayOf(0, 0, 1, 1)))
        }
    }
}