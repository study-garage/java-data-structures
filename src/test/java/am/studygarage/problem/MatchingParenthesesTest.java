package am.studygarage.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MatchingParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"()", "{}", "[]", "({[]})", "{{{}}}"})
    public void givenSimple_Match_AssertTrue(String expression) {
        MatchingParentheses matchingParentheses = new MatchingParentheses();

        assertTrue(matchingParentheses.isMatching(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(", "((", "{{})", "({[])}"})
    public void givenSimple_Match_AssertFalse(String expression) {
        MatchingParentheses matchingParentheses = new MatchingParentheses();

        assertFalse(matchingParentheses.isMatching(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"( )(( )){([( )])}", "((( )(( )){([( )])}))"})
    public void givenExpression_Match_AssertTrue(String expression) {
        MatchingParentheses matchingParentheses = new MatchingParentheses();

        assertTrue(matchingParentheses.isMatching(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {")(()){([()])}"})
    public void givenExpression_Match_AssertFalse(String expression) {
        MatchingParentheses matchingParentheses = new MatchingParentheses();

        assertFalse(matchingParentheses.isMatching(expression));
    }
}
