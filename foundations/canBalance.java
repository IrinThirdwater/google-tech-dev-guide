public boolean canBalance (int[] nums) {
    int left = nums[0];
    int right = 0;
    for (int i = 1; i < nums.length; i++) {
        right += nums[i];
    }
    if (left == right) return true;

    for (int i = 1; i < nums.length - 1; i++) {
        left += nums[i];
        right -= nums[i];
        if (left == right) return true;
    }

    return false;
}
