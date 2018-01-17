public int sumNumbers (String str) {
    int sum = 0;
    String s = "";

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if ('0' <= c && c <= '9') {
            s += c;
            if (i == str.length() - 1) sum += Integer.valueOf(s);
        } else {
            if (s.length() > 0) sum += Integer.valueOf(s);
            s = "";
        }
    }

    return sum;
}
