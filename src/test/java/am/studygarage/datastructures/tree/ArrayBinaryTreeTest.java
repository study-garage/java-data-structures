package am.studygarage.datastructures.tree;

import am.studygarage.datastructures.tree.ArrayBinaryTree;
import am.studygarage.datastructures.tree.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ArrayBinaryTreeTest {

    @Test void constructArrayBinaryTreeIterateAssertPositionsOk() {
        ArrayBinaryTree<Character> tree = new ArrayBinaryTree<>();
        Position<Character> root = tree.addRoot('/');

        Position<Character> left = tree.addLeft(root, '*');
        Position<Character> right = tree.addRight(root, '+');

        tree.addRight(left, '4');
        left = tree.addLeft(left, '+');

        tree.addLeft(left, '3');
        tree.addRight(left, '1');

        left = tree.addLeft(right, '-');
        right = tree.addRight(right, '2');

        tree.addLeft(left, '9');
        tree.addRight(left, '5');

        assertIterableEquals(new ArrayList<>(
                        Arrays.asList('/', '*', '+', '+', '4', '-', '2', '3', '1', null, null, '9', '5', null, null, null)),
                tree);
    }
}
