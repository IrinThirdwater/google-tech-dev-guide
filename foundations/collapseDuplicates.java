public String collapseDuplicates (String a) {
    int i = 0;
    String result = "";

    while (i < a.length()) {
        char ch = a.charAt(i);
        result += ch;
        // The problem is the index i+1 eventually going out of bound
        while (i < a.length() - 1 && a.charAt(i + 1) == ch) {
            i++;
        }
        i++;
    }

    return result;
}
