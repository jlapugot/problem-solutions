package topcoder;

public class ABBADiv1 {

    public boolean canObtainBoolean(String initial, String target) {
        if (initial.length() == target.length()) {
            return initial.equals(target);
        }

        int sizeIndex = target.length() - 1;
        char firstChar = target.charAt(0);
        char lastChar = target.charAt(sizeIndex);
        String previousText;
        boolean canObtain;

        if (lastChar == 'A') {
            previousText = target.substring(0, sizeIndex);
            canObtain = canObtainBoolean(initial, previousText);

            if (firstChar == 'B') {
                previousText = new StringBuilder(target.substring(1, target.length())).reverse().toString();
                canObtain = canObtain || canObtainBoolean(initial, previousText);
            }
        } else {
            previousText = new StringBuilder(target.substring(1, target.length())).reverse().toString();
            canObtain = canObtainBoolean(initial, previousText);
        }

        return canObtain;
    }

    public String canObtain(String initial, String target) {
        return canObtainBoolean(initial, target) ? "Possible" : "Impossible";
    }
}
