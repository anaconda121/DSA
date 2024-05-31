class DesignUndergroundSystem {

    static class Customer {
        int id = 0;
        String checkInStation = "";
        int checkInTime = 0;

        public Customer(int i, String cIS, int cIT) {
            id = i;
            checkInStation = cIS;
            checkInTime = cIT;
        }
    }

    HashMap<Integer, Customer> railway;
    HashMap<String, ArrayList<Integer>> tripTimes;

    public UndergroundSystem() {
        railway = new HashMap<>();
        tripTimes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        // if (!railway.containsKey(id)) {
            railway.put(id, new Customer(id, stationName, t));
        // }
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer c = railway.get(id);
        ArrayList<Integer> currTimes = tripTimes.getOrDefault(c.checkInStation + ":" + stationName, new ArrayList<>());
        currTimes.add(t - c.checkInTime);
        tripTimes.put(c.checkInStation + ":" + stationName, currTimes);        
        railway.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        ArrayList<Integer> trips = tripTimes.get(startStation + ":" + endStation);
        double tot = 0.0; double cnt = 0.0;
        for (Integer i : trips) {
            tot += (double) i; cnt++;
        }
        return tot / cnt;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
