public class TestPoints {
    public boolean check(double x, double y, double r) {
        if (x <= 0 && y >= 0 && y <= 2 * x + r) {
            return true;
        }

        if (x <= 0 && y <= 0 && ((x * x) + (y * y)) <= r * r) {
            return true;
        }

        if (x >= 0 && y <= 0 && x < r && y > -r) {
            return true;
        }
        return false;
    }
}
