public class ABBA {

    public String canObtain(String initial, String target) {
        return canObtainBoolean(initial, target) ? "Possible" : "Impossible";
    }

    public boolean canObtainBoolean(String initial, String target) {
        if (initial.length() == target.length()) {
            return initial.equals(target);
        }

        int sizeIndex = target.length() - 1;
        char lastChar = target.charAt(sizeIndex);
        String previousText;

        if (lastChar == 'A') {
            previousText = target.substring(0, sizeIndex);
        } else {
            previousText = new StringBuilder(target).reverse().toString();
        }

        return canObtainBoolean(initial, previousText);
    }
}
