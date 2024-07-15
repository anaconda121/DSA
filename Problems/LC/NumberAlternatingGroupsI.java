class NumberAlternatingGroupsI {
    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        for (int i = 2; i < colors.length; i++) {
            int s = colors[i - 2];
            int m = colors[i - 1];
            int e = colors[i];
            if (s == e && s != m) { res++; }
        }

        int s = colors[colors.length - 2];
        int m = colors[colors.length - 1];
        int e = colors[0];
        if (s == e && s != m) { res++; }

        s = colors[colors.length - 1];
        m = colors[0];
        e = colors[1];
        if (s == e && s != m) { res++; }

        return res;
    }
}
