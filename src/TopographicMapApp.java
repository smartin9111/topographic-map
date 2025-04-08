public class TopographicMapApp {
    public static void main(String[] args) {
        try {
            TopographicMap map = new TopographicMap("input.txt");
            TrailFinder finder = new TrailFinder(map);
            int totalRating = finder.calculateTotalRating();
            System.out.println("Total trailhead rating: " + totalRating);
        } catch (Exception e) {
            System.err.println("Hiba történt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
