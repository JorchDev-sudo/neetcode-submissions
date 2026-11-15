class Solution {

    private boolean[][] visited;
    private boolean[] oceans;
    private List<List<Integer>> result;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        result = new ArrayList<>();
        visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                oceans = new boolean[2];

                dfs(heights, r, c, heights[r][c]);

                if (oceans[0] && oceans[1]) {
                    result.add(List.of(r, c));
                }

                visited = new boolean[rows][cols];
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight) {

        if (r < 0 || r >= heights.length ||
            c < 0 || c >= heights[0].length) {
            return;
        }

        if (visited[r][c] || heights[r][c] > prevHeight) {
            return;
        }

        visited[r][c] = true;

        // Pacific Ocean
        if (r == 0 || c == 0) {
            oceans[0] = true;
        }

        // Atlantic Ocean
        if (r == heights.length - 1 ||
            c == heights[0].length - 1) {
            oceans[1] = true;
        }

        // Both oceans found
        if (oceans[0] && oceans[1]) {
            return;
        }

        int currentHeight = heights[r][c];

        dfs(heights, r, c - 1, currentHeight);
        dfs(heights, r, c + 1, currentHeight);
        dfs(heights, r - 1, c, currentHeight);
        dfs(heights, r + 1, c, currentHeight);
    }
}