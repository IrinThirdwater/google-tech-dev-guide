public String stringSplosion (String str) {
    if (str.length() == 1) return str;
    return stringSplosion(str.substring(0, str.length() - 1)) + str;
}
