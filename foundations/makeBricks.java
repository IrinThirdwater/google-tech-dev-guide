public boolean makeBricks (int small, int big, int goal) {
    return 5*Math.min(big,goal/5) + small >= goal;
}
