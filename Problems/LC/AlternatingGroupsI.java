public class AlternatingGroupsI {

    public static int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        for (int i = 2; i < colors.length; i++) {
            int s = colors[i - 2];
            int m = colors[i - 1];
            int e = colors[i];
            if (s == e && s != m) {
                res++;
            }
        }

        // check loop around

        int s = colors[colors.length - 2];
        int m = colors[colors.length - 1];
        int e = colors[0];
        if (s == e && s != m) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0,0, 1}));
    }
}
