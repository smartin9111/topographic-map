import java.util.*;

public class TrailFinder {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private final TopographicMap map;

    public TrailFinder(TopographicMap map) {
        this.map = map;
    }

    public int calculateTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {
                if (map.getValue(i, j) == 0) {
                    totalScore += bfs(i, j);
                }
            }
        }
        return totalScore;
    }

    private int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> foundNines = new HashSet<>();

        queue.add(new Node(startX, startY, 0));
        visited.add(startX + "," + startY);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && nx < map.getRows() && ny >= 0 && ny < map.getCols()) {
                    int expectedHeight = current.height + 1;
                    int nextHeight = map.getValue(nx, ny);
                    String key = nx + "," + ny;

                    if (nextHeight == expectedHeight && !visited.contains(key)) {
                        if (nextHeight == 9) {
                            foundNines.add(key);
                        }
                        queue.add(new Node(nx, ny, nextHeight));
                        visited.add(key);
                    }
                }
            }
        }

        return foundNines.size();
    }
}
