public class TopographicMapApp {
    public static void main(String[] args) {
        try {
            TopographicMap map = new TopographicMap("input.txt");
            TrailFinder finder = new TrailFinder(map);
            int totalScore = finder.calculateTotalScore();
            System.out.println("Total score: " + totalScore);
        } catch (Exception e) {
            System.err.println("Hiba történt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
