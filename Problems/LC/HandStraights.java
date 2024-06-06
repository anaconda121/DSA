class HandStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        boolean[] visited = new boolean[hand.length];

        for (int i = 0; i < hand.length; i++) {
            if (!visited[i]) {
                int membersNeeded = groupSize - 1;
                int latestMember = hand[i];
                for (int j = 0; j < hand.length; j++) {
                    if (i != j && membersNeeded > 0) {
                        if (hand[j] - latestMember == 1 && !visited[j]) {
                            membersNeeded -= 1;
                            latestMember = hand[j];
                            visited[j] = true;
                            // System.out.print("Added: " + hand[j] + " members needed: " + membersNeeded + "; ");
                        }
                    }
                }
                // System.out.println(hand[i] + " " + membersNeeded); 
                if (membersNeeded > 0)  { 
                    return false; 
                } else { visited[i] = true; }
            }
        }
        
        return true;
    }
}
