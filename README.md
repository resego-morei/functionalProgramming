# functionalProgramming
This is a guide into the world of functional programming


What is a Function?
modular units of code designed to perform specific tasks.
encapsulate a set of instructions, allowing for code reuse and organization.

a. Importance of Funstions in Programming
Now you might ask, what is the importance of functions in programming?
1. Modularity of code:
    Functions in programming help break down a program into smaller, manageable modules.
    Henceforth, each function can be developed, tested, and debugged independently, making the overall
    program more organized and easier to understand.

for example:

function add(int a, int b){
    int sum = a + b;
    return sum;
}

function run(){
    int result = add(5,7);
    print("Sum: " + result);
}

On the example code, the modularity of the code is broken down to two functional functions, the one that runs the code and the one that add the sum. 

2. Abstraction:
In this sense, we refer to the practice of creating reusable functions that encapsulate a specific behavior or calculation.

This is a core concept where a function is treated as a value that can be passed around and manipulated like any other data type, allowing for the creation of generic functions that can operate on different data types.

To drive the concept home, functions in programming allow programmers to abstract the details of a particular operation. 

Instead of dealing with the entire implementation, a programmer can use a function with a clear interface, relying on its functionality without needing to understand the internal complexities.

Functions hide the details of their operations, allowing the programmer to think at a higher level.

For example:

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

Output
Result of Square: 9
Result of Cube: 27

3. Code Reusability:
Functions in programming enables the reuse of code by encapsulating a specific functionality.
Once a function is defined, it can be called multiple times from different parts of the program, reducing redundancy and promoting efficient code maintenance. Functions can be called multiple times, reducing code duplication.

for example:

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

Output:
Sum: 12
Sum: 6

4. Readability and Maintainability:
This falls under the programming language evaluation criteria: Readability, Writability, Reliability and cost. 

Each of the following mean:
Readability :- how easy it is to read and understand code written in a particular language.
Writability :- the ease with which code can be written in a particular language.
Reliability :- the ability of a language to produce consistent and predictable results, even in the presence of errors and unforeseen circumstances.
Cost :- this is the cost of a programming language is indeed a function of various characteristics.
Maintainability :- ease with which code can be modified and updated over time.

Going back to functions, well-designed functions enhance code readability by providing a clear structure and isolating specific tasks. This then makes it easier for programmers to understand and maintain the code, especially in larger projects where complexity can be a challenge.

5. Testing and Debugging:
Functions make testing and debugging much easier than large code blocks.
Since functions encapsulate specific functionalities, it is easier to isolate and test individual units of code. Debugging becomes more focused on a specific function, simplifying the identification and resolution of issues.

b. Functions Declaration and Definition:
Function declaration :- tells compiler about a function's name, return type, and parameters. It provides the basic attributes of a function and serves as a prototype for the function, which can be called elsewhere in the program. It tells the compiler that there is a function with the given name defined somewhere else in the program.

Function Definition :- contains a function declaration and the body of a function. The body is a block of statements that perform the work of the function.

for example:

//the function declaration
function sum(int a, int b, int c);

function run(){
    int result = sum(2,4,6);
    print("Sum: " + result);
}

//the function definition
function sum(int a, int b, int c){
    int theSum = a + b + c;
    return theSum;
}

Output:
Sum: 12

The identifiers declared in this example allocate storage; they are both declarations and definitions.

c. Calling a Functions in Programming:
Once a function is declared, it can be used or "called" by its name.

When a function is called, the control of he program jumps to that function, which then executes its code.
Once function finishes executing, the control returns to teh part of the program that called the function, and the program continues running from there.

for example:

void function greet(){
    print("Inside Greet\n");
}

function run(){
    print("Inside Run\n");
    greet();
    print("Back to Run");    
}

Output
Inside Run
Inside Greet
Back to Run

d. Parameters and Return Values:
Functions in Programming can take parameters, which are values you supply to the function so that the function can do something utilizing those values.

These parameters are placed inside the parentheses in the function declaration.

Functions in Programming can also return a value back to the caller.

The return type is defined in the function declaration. Inside the function, the return statement is used to specify the return value.

for example:
function add(int a, int b){
    int sum = a + b;
    return sum;
}

function run(){
    int result = add(3,4);
    print("Sum: " + result);
}

Output:
Sum: 7

e. Recursion in Functions
We are referring to a function calling itself in order to solve a problem. A recursive function solves a problem by solving smaller instances of the same problem.

This is just a fancy way of iteration. This is were we iterate through a list of names, or solving a problem iteratively. 

Recursion usually has the following stucture:
base case :- condition which stops the program
recursive call :- call ourselves, usually were the iteration occur within a function

for example:
// Recursive function to calculate factorial
function factorial(int number){
    if (number == 0)    return 1;
    else    return number * factorial(number - 1);
}

function run(){
    int result = factorial(5);
    print("Result: " + result);
}