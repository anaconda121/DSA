class CompareVersionNumbers {
    int parseVersionPart(String str) {
        return Integer.parseInt(str.replaceFirst("^0+(?!$)", ""));
    }

    int compareVersions(ArrayList<String> list1, ArrayList<String> list2) {
        for (int i = 0; i < list1.size(); i++) {
            int v1 = parseVersionPart(list1.get(i));
            int v2 = parseVersionPart(list2.get(i));
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(versions1));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(versions2));

        if (list1.size() > list2.size()) {
            while (list2.size() < list1.size()) { list2.add("0"); }
        } else if (list2.size() > list1.size()) {
            while (list1.size() < list2.size()) { list1.add("0"); }
        }

        int comparisonResult = compareVersions(list1, list2);
        return comparisonResult;
    }
}
