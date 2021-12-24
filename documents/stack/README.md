# Contents

- [Stack](#stack)
- [Stack ADT](#stack-adt)
- [Array based implementation of Stack](#array-based-implementation-of-stack)
- [Linked List based implementation of Stack](#linked-list-based-implementation-of-stack)
- [Efficiency of Implementations](#efficiency-of-implementations)

# Stack
A stack is a collection of objects that are inserted and removed according to the **last-in, first-out
(LIFO)** principle. A user may insert objects into a stack at any time, but may only access or 
remove the most recently inserted object that remains (at the so-called “top” of the stack).

## Use cases examples
- Internet Web browsers store the addresses of recently visited sites on a stack. 
Each time a user visits a new site, that site’s address is “pushed” onto the stack of addresses. 
The browser then allows the user to “pop” back to previously visited sites using the “back” button.
- Text editors usually provide an “undo” mechanism that cancels recent editing operations and reverts
to former states of a document. This undo operation can be accomplished by keeping text changes in a stack.

In fact, the current Java documentation for the Stack class recommends that it not be used, 
as LIFO functionality (and more) is provided by a more general data structure known as a double-ended queue.

# Stack ADT

| methods          | description                                                                                |
|------------------|--------------------------------------------------------------------------------------------|
| ```size()```     | Returns the number of elements in the stack.                                               |
| ```isEmpty()```  | Returns a boolean indicating whether the stack is empty.                                   |
| ```push(e)```    | Adds element e to the top of the stack.                                                    |
| ```pop()```      | Removes and returns the top element from the stack (or null if the stack is empty).        |
| ```top()```      | Returns the top element of the stack, without removing it (or null if the stack is empty). |

# Array based implementation of Stack
The array implementation of a stack is simple and efficient. Nevertheless, this implementation has 
one negative aspect it relies on a fixed-capacity array, which limits the ultimate size of the stack.
If the application needs much less space than the reserved capacity, memory is wasted.

[Java class](../../src/main/java/am/studygarage/datastructures/stack/ArrayStack.java)

# Linked List based implementation of Stack
Stack interface can be easily implemented using a singly linked list for storage.
We use adapter design pattern approach here.
The **adapter design** pattern applies to any context where we effectively want to modify an
existing class so that its methods match those of a related, but different, class or interface.
One general way to apply the adapter pattern is to define a new class in such a way that it
contains an instance of the existing class as a hidden field, and then to implement each
method of the new class using methods of this hidden instance variable.
By applying the adapter pattern in this way, we have created a new class that performs some
of the same functions as an existing class, but repackaged in a more convenient way.

[Java class](../../src/main/java/am/studygarage/datastructures/stack/LinkedStack.java)

# Efficiency of Implementations
Also, although all methods execute in constant time for both implementations, it seems clear that
the operations involving linked lists have a large number of primitive operations per call.
For example, adding an element to an array-based queue consists primarily of calculating an index
with modular arithmetic, storing the element in the array cell, and incrementing the size counter.
For a linked list, an insertion includes the instantiation and initialization of a new node,
relinking an existing node to the new node, and incrementing the size counter.
In practice, this makes the linked-list method more expensive than the array-based method.