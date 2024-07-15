class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int levels = 0;
        for (String s: logs) {
            if (s.equals("../")) {
                levels -= 1;
            } else if (!s.equals("./")) {
                levels += 1;
            }
            if (levels < 0) levels = 0;
        }
        return (levels < 0) ? 0 : levels;
    }
}
