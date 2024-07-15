class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0; 
        int numberEmpty = 0;

        while (numBottles + (numberEmpty / numExchange) > 0) {
            res += numBottles;
            numberEmpty += numBottles;
            numBottles = numberEmpty / numExchange;
            numberEmpty = numberEmpty - (numBottles * numExchange);
        }

        return res;
    }
}
