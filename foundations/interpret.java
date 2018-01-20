public int interpret (int value, String[] commands, int[] args) {
  // We will assume that commands.length == args.length.
  int result = value;
  for (int i = 0; i < commands.length; i++) {
    switch (commands[i]) {
      case "+":
        result += args[i];
        break;
      case "-":
        result -= args[i];
        break;
      case "*":
        result *= args[i];
        break;
      default:
        // -1 is a valid result (e.g. interpret(1,["-"],[2]))
        // So this is a bad choice, would rather throw an exception
        return -1;
    }
  }
  return result;
}
