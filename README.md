# Java Linked List Stack + JUnit Testing – COMPX201 Assignment 3

A custom stack implementation in Java using a linked list (LIFO structure), along with a comprehensive **JUnit test suite**. Developed for **COMPX201 – Data Structures & Algorithms** at the University of Waikato (2024, April).

---

## 🧱 Part One – Stack Implementation

### ✅ Class: `Stack.java`

Implements a basic stack using a singly linked list.

#### Public Methods:
- `push(String x)` – Add item to the top of the stack
- `pop()` – Remove and return the top item
- `peek()` – Return the top item without removing
- `isEmpty()` – Return `true` if stack is empty
- `length()` – Return the number of elements
- `dump()` – Print stack contents from top to bottom

### 🧩 Inner Class: `Node`
Each node holds:
- A string `value`
- A `next` reference to the next node
- A constructor for initialization

---

## 🧪 Part Two – JUnit Test Suite

A JUnit-based test class (`StackTest.java`) that verifies:

### ✔️ Test Coverage:
- Stack creation and initialization
- Push and pop functionality
- Edge cases (empty stack, one item)
- Peek accuracy
- Length tracking
- Behavior on over-popping
- Stack state after multiple operations

### 🗂 Example Test Methods:
```java
@Test
public void pushTestDumpNotEmpty() ... }

@Test
public void popTestNotEmpty(){ ... }

@Test
public void peekTestEmpty(){ ... }

@Test
public void peekTestAfterPushAndPop(){ ... }
```
Each test includes JavaDoc-style comments explaining its purpose and what specific behavior it verifies.

## 📁 Project Structure
```plaintext
linkedlist-stack/
├── Stack.java              # Stack implementation
├── StackTest.java          # JUnit test suite
├── Node.java               # Optional if external Node class
└── README.md
```

## 🛠 Compile & Run
From terminal (Linux/Mac/WSL):
```plaintext
javac -cp junit-platform-console-standalone-1.8.2.jar -d out *.java
java -jar junit-platform-console-standalone-1.8.2.jar -cp out --scan-classpath
```

## 👨‍🎓 Author
```plaintext
Lucas Oda
University of Waikato
COMPX201 – Data Structures & Algorithms
Assignment 3 – Stack & Testing (2024)
```
