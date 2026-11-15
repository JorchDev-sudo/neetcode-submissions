class Solution {

    private boolean[][] pacific;
    private boolean[][] atlantic;

    private int[][] directions = {
        {-1, 0}, // Up
        {1, 0},  // Down
        {0, -1}, // Left
        {0, 1}   // Right
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        // Pacific DFS
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
        }

        // Atlantic DFS
        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]);
        }

        // Find intersection
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(
        int[][] heights,
        int r,
        int c,
        boolean[][] visited,
        int prevHeight
    ) {

        if (r < 0 || r >= heights.length ||
            c < 0 || c >= heights[0].length) {
            return;
        }

        if (visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        for (int[] direction : directions) {

            int newR = r + direction[0];
            int newC = c + direction[1];

            dfs(
                heights,
                newR,
                newC,
                visited,
                heights[r][c]
            );
        }
    }
}