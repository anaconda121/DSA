class StringIntegerAtoi {
    public int myAtoi(String s) {
        StringBuilder atoiS = new StringBuilder();
        boolean leading = true;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (leading) {
                if (c != '+' && c != '-' && c != ' ' && !Character.isDigit(c)) break;
                else if (Character.isDigit(c) || c == '-') {
                    atoiS.append(c);
                    leading = false;
                } else if (c == '+') { leading = false; }
            } else if (!leading) {
                if (!Character.isDigit(c)) break;
                else atoiS.append(c);
            }
        }
            
        if (atoiS.length() == 0) return 0;
        try {
            long num = Long.parseLong(atoiS.toString());
            if (num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int) num;
        } catch(Exception e) { 
            if (atoiS.length() >= 9) {
                if (atoiS.charAt(0) == '-') return Integer.MIN_VALUE;
                else if (Character.isDigit(atoiS.charAt(0))) return Integer.MAX_VALUE;
            }
            return 0; 
        }
    }
}
