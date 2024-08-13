class KeysRooms {
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    void dfs(int currRoom) {
        if (visited.contains(currRoom)) return;
        visited.add(currRoom);
        for (int unlockable : adj.get(currRoom)) {
            dfs(unlockable);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> r = rooms.get(i);
            adj.put(i, new ArrayList<>(r));
        }

        dfs(0);
        return visited.size() == rooms.size();
    }
}
