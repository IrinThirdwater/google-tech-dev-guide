public Map<String, String> pairs (String[] strings) {
    Map<String, String> map = new HashMap<String, String>();
    for (String s: strings) {
        // Will just use the last occurence (e.g. {"ma","mb"} returns a map with "m":"b")
        map.put(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(s.length()-1)));
    }
    return map;
}
