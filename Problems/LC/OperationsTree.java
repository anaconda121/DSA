class OperationsTree {

    HashMap<Integer, ArrayList<Integer>> descendants;
    int[] parents;
    int[] locks;
    boolean[] visited;

    public LockingTree(int[] parent) {
        descendants = new HashMap<>();
        parents = new int[parent.length];
        locks = new int[parent.length];
        visited = new boolean[parent.length];
        Arrays.fill(locks, -1);
        for (int i = 0; i < parent.length; i++) {
            ArrayList<Integer> curr = descendants.getOrDefault(parent[i], new ArrayList<>());
            curr.add(i);
            descendants.put(parent[i], curr);
            parents[i] = parent[i];
        }
    }
    
    public boolean lock(int num, int user) {
        if (locks[num] == -1) {
            locks[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (locks[num] == user) {
            locks[num] = -1;
            return true;
        }
        return false;
    }

    void unlockDescendants(int num) {
        if (visited[num]) return;
        visited[num] = true;
        ArrayList<Integer> d = descendants.get(num);
        if (d != null) {
            for (int i : d) {
                locks[i] = -1;
                unlockDescendants(i);
            }
        }
    }
    
    boolean searchDescendants(int num) {
        if (visited[num]) return false;
        ArrayList<Integer> d = descendants.get(num);
        visited[num] = true;
        if (d != null) {
            for (int i : d) {
                if (locks[i] != -1) { return true; }
                if (searchDescendants(i)) { return true; }
            }
        }
        return false;
    }

    boolean searchAncestors(int num) {
        if (num == -1) return false;
        if (locks[num] != -1) return true;
        return searchAncestors(parents[num]);
    }
    
    public boolean upgrade(int num, int user) {
        if (locks[num] != -1 || searchAncestors(parents[num])) return false;

        Arrays.fill(visited, false);
        if (!searchDescendants(num)) return false;
        
        Arrays.fill(visited, false);
        unlockDescendants(num);
        locks[num] = user;
        
        return true;
    }
}
