# Functional Programming

This is a guide into the world of functional programming.

## What is a Function?
Functions are modular units of code designed to perform specific tasks. They encapsulate a set of instructions, allowing for code reuse and organization.

### Importance of Functions in Programming
Now you might ask, what is the importance of functions in programming?

#### 1. Modularity of Code
Functions help break down a program into smaller, manageable modules. Each function can be developed, tested, and debugged independently, making the overall program more organized and easier to understand.

##### Example:
```cpp
function add(int a, int b){
    int sum = a + b;
    return sum;
}

function run(){
    int result = add(5,7);
    print("Sum: " + result);
}
```
In the example above, the modularity of the code is broken down into two functional components: one that runs the code and one that adds the sum.

#### 2. Abstraction
This refers to the practice of creating reusable functions that encapsulate a specific behavior or calculation. Functions allow programmers to abstract the details of an operation, making code more readable and maintainable.

##### Example:
```cpp
function square(int a){
    int squareValue = a * a;
    return squareValue;
}

function cube(int a){
    int cubedValue = a * a * a;
    return cubedValue;
}

function run(){
    int squaredNumber = square(3);
    int cubedNumber = cube(3);

    print("Result of Square: " + squaredNumber);
    print("Result of Cube: " + cubedNumber);
}
```
##### Output:
```
Result of Square: 9
Result of Cube: 27
```

#### 3. Code Reusability
Functions enable the reuse of code by encapsulating a specific functionality. Once a function is defined, it can be called multiple times, reducing redundancy and improving maintainability.

##### Example:
```cpp
function add(int a, int b){
    int sum = a + b;
    return sum;
}

function run(){
    int result = add(5,7);
    print("Sum: " + result);

    int sum = add(4,2);
    print("Sum: " + sum);
}
```
##### Output:
```
Sum: 12
Sum: 6
```

#### 4. Readability and Maintainability
Well-designed functions enhance code readability by providing a clear structure and isolating specific tasks. This is particularly useful in larger projects where complexity can be a challenge.

#### 5. Testing and Debugging
Functions make testing and debugging easier. Since functions encapsulate specific functionalities, isolating and testing individual units of code simplifies the debugging process.

---

## Function Declaration and Definition

### Function Declaration
A function declaration tells the compiler about a function's name, return type, and parameters. It serves as a prototype for the function, which can be called elsewhere in the program.

### Function Definition
A function definition contains the function declaration along with the body of the function. The body consists of statements that perform the work of the function.

##### Example:
```cpp
// Function declaration
function sum(int a, int b, int c);

function run(){
    int result = sum(2,4,6);
    print("Sum: " + result);
}

// Function definition
function sum(int a, int b, int c){
    int theSum = a + b + c;
    return theSum;
}
```
##### Output:
```
Sum: 12
```

---

## Calling Functions in Programming
Once a function is declared, it can be called by its name. When a function is called, the program jumps to that function, executes its code, and then returns to where the function was called.

##### Example:
```cpp
void function greet(){
    print("Inside Greet\n");
}

function run(){
    print("Inside Run\n");
    greet();
    print("Back to Run");    
}
```
##### Output:
```
Inside Run
Inside Greet
Back to Run
```

---

## Parameters and Return Values
Functions can take parameters, which are values supplied to the function for processing. Functions can also return a value back to the caller.

##### Example:
```cpp
function add(int a, int b){
    int sum = a + b;
    return sum;
}

function run(){
    int result = add(3,4);
    print("Sum: " + result);
}
```
##### Output:
```
Sum: 7
```

---

## Recursion in Functions
Recursion is when a function calls itself to solve a problem. It consists of two main parts:
- **Base case**: The condition that stops the recursion.
- **Recursive call**: The function calling itself, where iteration occurs within the function.

##### Example:
```cpp
// Recursive function to calculate factorial
function factorial(int number){
    if (number == 0)    return 1;
    else    return number * factorial(number - 1);
}

function run(){
    int result = factorial(5);
    print("Result: " + result);
}
```
##### Output:
```
Result: 120
```
---