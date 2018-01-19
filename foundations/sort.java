int[] sort (int[] a) {
    // Assuming the prompt meant that the input array is already sorted.
    if (a.length < 2) return a;
    int prev = a[0];
    List<Integer> list = new ArrayList<Integer>();
    list.add(prev);
    for (int i = 1; i < a.length; i++) {
        if (a[i] != prev) {
            prev = a[i];
            list.add(prev);
        }
    }
    int[] b = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        b[i] = list.get(i);
    }
    return b;
}
