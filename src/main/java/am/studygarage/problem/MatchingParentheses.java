package am.studygarage.problem;

import am.studygarage.datastructures.stack.LinkedStack;
import am.studygarage.datastructures.stack.Stack;

public class MatchingParentheses {
    /**
     * opening delimiters
     */
    private final String opening = "({[";
    /**
     * respective closing delimiters
     */
    private final String closing = ")}]";

    public static void main(String[] args) {

    }

    /**
     * Each time we encounter an opening symbol, we push that symbol onto the stack, and each time
     * we encounter a closing symbol, we pop a symbol from the stack (assuming it is not empty) and
     * check that these two symbols form a valid pair. If we reach the end of the expression and the
     * stack is empty, then the original expression was properly matched. Otherwise, there must be an
     * opening delimiter on the stack without a matching symbol. If the length of the original
     * expression is n, the algorithm will make at most n calls to push and n calls to pop.
     */
    public boolean isMatching(String expression) {
        Stack<Character> buffer = new LinkedStack<>();

        for (Character character : expression.toCharArray()) {
            if (opening.indexOf(character) != -1) { // left delimiter
                // opening symbol, push to stack
                buffer.push(character);
            } else if (closing.indexOf(character) != -1) { // closing(right) delimiter
                if (buffer.isEmpty()) {
                    // No left delimiter, nothing to match
                    return false;
                }

                // match with potential valid left delimiter
                if (closing.indexOf(character) != opening.indexOf(buffer.pop())) {
                    // closing and opening delimiters doesnt match
                    return false;
                }
            }
        }

        // all opening delimiters were matched
        return buffer.isEmpty();
    }
}
