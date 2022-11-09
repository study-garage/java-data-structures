package am.studygarage.datastructures.tree;

import am.studygarage.datastructures.common.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractTreeTest {

    @Test
    void givenTreeInorderAssertOk() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("Paper");
        var left = tree.addLeft(root, "Title");
        var right = tree.addRight(root, "Abstract");
        left = tree.addLeft(right, "$1");
        tree.addLeft(left, "$1.1");
        tree.addRight(left, "$1.2");

        right = tree.addRight(right, "$2");
        tree.addLeft(right, "$2.1");
        tree.addRight(right, "$2.2");

        StringBuilder stringBuilder = new StringBuilder();
        for (Position<String> node : tree.inorder()) {
            stringBuilder.append(node.getElement());
        }
        assertEquals("TitlePaper$1.1$1$1.2Abstract$2.1$2$2.2", stringBuilder.toString());
    }
}
