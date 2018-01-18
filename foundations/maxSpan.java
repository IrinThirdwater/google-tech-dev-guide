public int maxSpan (int[] nums) {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
        if (!map.containsKey(i)) {
            for (int j = nums.length-1; j >= i; j--) {
                if (nums[j] == nums[i]) {
                    int span = j-i+1;
                    map.put(i,span);
                    if (span > max) max = span;
                    break;
                }
            }
        }
    }

    return max;
}
