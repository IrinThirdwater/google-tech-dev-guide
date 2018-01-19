public String[] encoder (String[] raw, String[] code_words) {
    // Assumes code_words.length >= raw.length
    Map<String,String> map = new HashMap<String,String>();
    String[] result = new String[raw.length];
    int wordCount = 0;
    
    for (int i = 0; i < raw.length; i++) {
        if (map.containsKey(raw[i])) {
            result[i] = map.get(raw[i]);
        } else {
            result[i] = code_words[wordCount];
            map.put(raw[i], code_words[wordCount]);
            wordCount++;
        }
    }

    return result;
}
