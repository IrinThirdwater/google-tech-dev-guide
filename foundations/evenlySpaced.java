public boolean evenlySpaced (int a, int b, int c) {
    int[] sort = new int[3];
    sort[0] = Math.min(a, Math.min(b, c));
    sort[2] = Math.max(a, Math.max(b, c));
    sort[1] = (a+b+c) - sort[0] - sort[2];
    return sort[1]-sort[0] == sort[2]-sort[1];
}
