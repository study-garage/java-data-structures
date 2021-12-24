# Contents

- [Queue](#queue)
- [Queue ADT](#queue-adt)
- [Array based implementation of Queue](#array-based-implementation-of-queue)
- [Linked List based implementation of Queue](#linked-list-based-implementation-of-queue)
- [Efficiency of Implementations](#efficiency-of-implementations)

# Queue
A **queue** is a collection of objects that are inserted and removed according to the **first-in, first-out (FIFO)** principle. 
That is, elements can be inserted at any time, but only the element that has been in the queue the longest can be next removed.

## Use cases examples
A logical choice for a data structure to handle calls to a customer service center, or a wait-list 
at a restaurant. FIFO queues are also used by many computing devices, such as a networked printer, 
or a Web server responding to a requests, asynchronous messaging systems.

# Queue ADT

| methods          | description                                                                                  |
|------------------|----------------------------------------------------------------------------------------------|
| ```size()```     | Returns the number of elements in the queue.                                                 |
| ```isEmpty()```  | Returns a boolean indicating whether the queue is empty.                                     |
| ```enqueue(e)``` | Adds element e to the back of queue.                                                         |
| ```dequeue()```  | Removes and returns the first element from the queue (or null if the queue is empty).        |
| ```first()```    | Returns the first element of the queue, without removing it (or null if the queue is empty). |

# Array based implementation of Queue
To avoid O(n) running time for the dequeue method and shrinking available size Queue Array implementation is circularly.
In developing a robust queue implementation, we allow both the front and back of the queue to drift 
rightward, with the contents of the queue “wrapping around” the end of an array, as necessary. 
Assuming that the array has fixed length N, new elements are enqueued toward the “end” of the 
current queue, progressing from the front to index N − 1 and continuing at index 0, then 1.

[Java class](../../src/main/java/am/studygarage/datastructures/queue/ArrayQueue.java)

# Linked List based implementation of Queue
Queue interface can be easily implemented using a singly linked list for storage.
We use adapter design pattern approach here.
The **adapter design** pattern applies to any context where we effectively want to modify an
existing class so that its methods match those of a related, but different, class or interface.
One general way to apply the adapter pattern is to define a new class in such a way that it
contains an instance of the existing class as a hidden field, and then to implement each
method of the new class using methods of this hidden instance variable.
By applying the adapter pattern in this way, we have created a new class that performs some
of the same functions as an existing class, but repackaged in a more convenient way.

[Java class](../../src/main/java/am/studygarage/datastructures/queue/LinkedQueue.java)

# Efficiency of Implementations
Also, although all methods execute in constant time for both implementations, it seems clear that 
the operations involving linked lists have a large number of primitive operations per call. 
For example, adding an element to an array-based queue consists primarily of calculating an index 
with modular arithmetic, storing the element in the array cell, and incrementing the size counter. 
For a linked list, an insertion includes the instantiation and initialization of a new node, 
relinking an existing node to the new node, and incrementing the size counter. 
In practice, this makes the linked-list method more expensive than the array-based method.