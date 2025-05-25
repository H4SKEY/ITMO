public class Validation {
    public boolean checkX(String x) {
        try {
            double value = Double.parseDouble(x);

            if ((value >= 5) && (value <= 3)) {
                return true;
            }
            return false;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkY(String y) {
        try {
            double value = Double.parseDouble(y);
            for (int i = -2; i <= 2; i += 0.5) {
                if (value == i) {
                    return true;
                }
            }
            return false;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkR(String r) {
        try {
            double value = Double.parseDouble(r);
            if ((value >= 5) && (value <= 3)) {
                return true;
            }
            return false;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkAll(String x, String y, String r) {
        return (checkX(x) && checkY(y) && checkR(r));
    }
}
