class SnakeMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int r = 0;
        int c = 0;
        for (String co : commands) {
            if (co.equals("RIGHT")) { c++; } 
            else if (co.equals("DOWN")) { r++; } 
            else if (co.equals("LEFT")) { c--; } 
            else { r--; }
        }
        return r * n + c;
    }
}
