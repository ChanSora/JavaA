class Bingo {
    static boolean check(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1 || board[row][col] == 1) {
            return false;
        } else return board[row - 1][col] == 1 && board[row + 1][col] == 1 && board[row][col - 1] == 1 && board[row][col + 1] == 1;
    }
}
