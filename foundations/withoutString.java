public String withoutString (String base, String remove) {
    int i = base.toLowerCase().indexOf(remove.toLowerCase());
    if (i == -1) return base;
    return base.substring(0,i) + withoutString(base.substring(i+remove.length()), remove);
}
