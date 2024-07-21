class TextJustification {
    String allocateLine(List<String> w, int spaces) {
        int[] spaceW = new int[w.size() - 1];
        while (spaces > 0) {
            for (int i = 0; i < spaceW.length; i++) {
                if (spaces > 0) {
                    spaceW[i]++;
                    spaces--;
                }
            }
        }

        String line = w.get(0);
        for (int i = 1; i < w.size(); i++) {
            for (int j = 0; j < spaceW[i - 1]; j++) line += " ";
            line += w.get(i);
        }

        return line;
    }

    String allocateLastLine(List<String> w, int spaces) {
        String line = "";
        for (int i = 0; i < w.size(); i++) {
            if (i < w.size() - 1) { 
                line += w.get(i) + " ";
                spaces--;
            }
            else line += w.get(i);
        }
        
        for (int i = 0; i < spaces; i++) {
            line += " ";
        }

        return line;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();

        int ptr = 0;
        while (ptr < words.length) {
            List<String> w = new ArrayList<>();
            int charCnt = 0;
            int currCnt = 0;
            while (ptr < words.length && currCnt + words[ptr].length() <= maxWidth) {
                w.add(words[ptr]);
                charCnt += words[ptr].length();
                currCnt += words[ptr].length();
                ptr++;
                if (currCnt == maxWidth) break;
                else currCnt += 1;                
            }

            int spaces = maxWidth - charCnt;
            String line = "";
            if (ptr == words.length) { 
                line = allocateLastLine(w, spaces);
            } else if (w.size() > 1) line = allocateLine(w, spaces);
            else {
                line += w.get(0);
                for (int i = 0; i < spaces; i++) line += " ";
            }
            res.add(line);
        }

        return res;
    }
}
