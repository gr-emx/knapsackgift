package com.gaurav.raje.knapsackgift.antipatterns;

public class InputSanitizer {
    /**
     * The given argument pattern is different from the way spring expects. While we could technically adapt to that pattern
     * it is just better if we keep the input to the context as spring expects instead of modifying it.
     * Instead, I am using this adapter class to adapt the given input and change it to what spring expects.
     * Of course, if the arguments are input in the form of --file=X&--name=Y, it can bypass the inputs
     *
     * @param args input arguments separated by a space
     * @return args in the form --key = value
     */
    public String[] sanitizeArguments(String[] args) {
        String[] ret = new String[args.length];
        int i = 0;
        for (String arg : args) {
            if (arg.startsWith("--")) {
                ret[i] = arg;
            } else {
                ret[i] = String.format("--arg%d=%s", i, arg);
            }
            i++;
        }
        return ret;
    }
}
