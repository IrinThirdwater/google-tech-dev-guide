public Map<String,Integer> wordCount (String[] strings) {
    Map<String,Integer> map = new HashMap<String,Integer>();
    for (String s: strings) {
        if (!map.containsKey(s)) map.put(s,1);
        else map.put(s,map.get(s)+1);
    }
    return map;
}
