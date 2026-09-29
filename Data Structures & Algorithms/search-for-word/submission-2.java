class Solution {
    Set<Integer> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (temp(board, word, r, c)) return true;
            }
        }

        return false;
    }

    private boolean temp(char[][] board, String sufix, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        
        int position = (row * board[0].length) + col;
        if (visited.contains(position)){
            return false;
        }
        
        if (board[row][col] != sufix.charAt(0)) return false;
        if (sufix.length() == 1) return true;

        visited.add(position);

        if (temp(board, sufix.substring(1), row + 1, col)) return true;
        if (temp(board, sufix.substring(1), row - 1, col)) return true;
        if (temp(board, sufix.substring(1), row, col + 1)) return true;
        if (temp(board, sufix.substring(1), row, col - 1)) return true;

        visited.remove(position);

        return false;
    }
}
