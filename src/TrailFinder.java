import java.util.*;

public class TrailFinder {
    private static final int[] dx = {-1, 1, 0, 0}; // fel, le, bal, jobb
    private static final int[] dy = {0, 0, -1, 1};
    private final TopographicMap map;

    public TrailFinder(TopographicMap map) {
        this.map = map;
    }

    public int calculateTotalRating() {
        int totalRating = 0;

        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {
                if (map.getValue(i, j) == 0) {
                    boolean[][] visited = new boolean[map.getRows()][map.getCols()];
                    totalRating += countPaths(i, j, visited);
                }
            }
        }

        return totalRating;
    }

    private int countPaths(int x, int y, boolean[][] visited) {
        int currentHeight = map.getValue(x, y);
        visited[x][y] = true;

        if (currentHeight == 9) {
            visited[x][y] = false;
            return 1;
        }

        int total = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map.inBounds(nx, ny) && !visited[nx][ny]) {
                int nextHeight = map.getValue(nx, ny);
                if (nextHeight == currentHeight + 1) {
                    total += countPaths(nx, ny, visited);
                }
            }
        }

        visited[x][y] = false;
        return total;
    }
}
