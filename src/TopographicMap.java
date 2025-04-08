import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TopographicMap {
    private final int[][] map;
    private final int rows, cols;

    public TopographicMap(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        rows = lines.size();
        cols = lines.get(0).length();
        map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < cols; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
    }

    public int getValue(int x, int y) {
        return map[x][y];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
