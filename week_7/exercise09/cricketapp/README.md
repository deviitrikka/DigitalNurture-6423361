### 🧠 ES6 Features 

- **Let and Const**
  - `let`: used for variables that can change
    ```javascript
    let score = 10;
    score = 20;
    ```
  - `const`: used for values that stay the same
    ```javascript
    const pi = 3.14;
    ```

- **Arrow Functions**
  - Short way to write functions:
    ```javascript
    const greet = name => `Hello, ${name}!`;
    ```

- **Template Literals**
  - Use backticks and `${}` for easy string formatting:
    ```javascript
    const name = "Amit";
    const msg = `Welcome, ${name}!`;
    ```

- **Default Parameters**
  - Assign default value to function parameter:
    ```javascript
    function sayHi(name = "Guest") {
      console.log(`Hi, ${name}`);
    }
    ```

- **Destructuring**
  - Extract values from objects or arrays:
    ```javascript
    const user = { name: "Rita", age: 25 };
    const { name, age } = user;
    ```

- **Rest and Spread Operators**
  - **Rest (`...`)** gathers values:
    ```javascript
    function sum(...numbers) {
      return numbers.reduce((a, b) => a + b);
    }
    ```
  - **Spread (`...`)** spreads values:
    ```javascript
    const arr1 = [1, 2];
    const arr2 = [...arr1, 3, 4];
    ```

- **Classes**
  - Create reusable object templates:
    ```javascript
    class Animal {
      constructor(name) {
        this.name = name;
      }
      speak() {
        console.log(`${this.name} makes a sound`);
      }
    }
    ```

- **Modules**
  - Use `export` and `import` to share code:
    ```javascript
    // export
    export const greet = () => "Hello";

    // import
    import { greet } from './greetings.js';
    ```

- **Promises**
  - Handle async tasks more easily:
    ```javascript
    const getData = () => {
      return new Promise((resolve, reject) => {
        setTimeout(() => resolve("Data loaded"), 1000);
      });
    };
    ```

- **Enhanced Object Literals**
  - Shorter syntax for defining objects:
    ```javascript
    const name = "Sam";
    const user = {
      name,
      greet() {
        console.log("Hello!");
      }
    };

````javascript
'use strict';

function f() {
    let x = 10;
    x = 20;
    console.log(x);

    if (x > 10) {
        x = 30;
        let y = 10;
        console.log(x);
        console.log(y);
    }

    y = 30; // ❌ ReferenceError in strict mode
    console.log(y);
}
f();
```

### 🔸 `let` in JavaScript
- Used to declare **variables** that can change later
- Has **block scope** (works only inside the `{}` where it's declared)

```javascript
let count = 1;
count = 2; // You can update it
```

Example inside a block:
```javascript
{
  let message = "Hello";
  console.log(message); // works here
}
// console.log(message); // error: message is not defined outside the block
```

---

### 🔍 Difference between `var` and `let`

| Feature              | `var`                        | `let`                          |
|---------------------|------------------------------|--------------------------------|
| Scope               | Function scope               | Block scope                   |
| Redeclaration       | Allowed                      | Not allowed in same block     |
| Hoisting behavior   | Hoisted but initialized as `undefined` | Hoisted but **not** initialized |

Example:
```javascript
function test() {
  if (true) {
    var x = 10;
    let y = 20;
  }
  console.log(x); // ✅ 10
  console.log(y); // ❌ Error: y is not defined
}
```

---

### 🔹 `const` in JavaScript
- Used to declare **constants**
- Value **cannot be changed**
- Has **block scope** just like `let`

```javascript
const pi = 3.14;
// pi = 3.15; // ❌ Error: can't reassign a const
```

For objects or arrays:
```javascript
const user = { name: "Amit" };
user.name = "Rahul"; // ✅ You can change property
```


### 🏗️ ES6 Class Fundamentals
- Classes are blueprints for creating **objects**
- Use `constructor()` to set initial values
- Methods are functions inside the class

```javascript
class Car {
  constructor(brand) {
    this.brand = brand;
  }

  show() {
    console.log(`Car brand is ${this.brand}`);
  }
}

const myCar = new Car("Toyota");
myCar.show(); // Car brand is Toyota
```

---

### 🧬 ES6 Class Inheritance
- One class can inherit from another using `extends`
- `super()` is used to call parent class's constructor

```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    console.log(`${this.name} makes a noise.`);
  }
}

class Dog extends Animal {
  speak() {
    console.log(`${this.name} barks.`);
  }
}

const d = new Dog("Buddy");
d.speak(); // Buddy barks.
```

---

### ➡️ ES6 Arrow Functions
- Shorter syntax for writing functions
- Do not have their own `this`

```javascript
const add = (a, b) => a + b;
console.log(add(2, 3)); // 5
```

Another example:
```javascript
const greet = name => `Hello, ${name}!`;
```

---

### 🗂️ `Set` and `Map` in ES6

#### ✅ `Set`
- Stores **unique values**
- No duplicates allowed

```javascript
const numbers = new Set();
numbers.add(1);
numbers.add(2);
numbers.add(1); // Duplicate ignored

console.log(numbers); // Set { 1, 2 }
```

#### 🗺️ `Map`
- Stores **key-value pairs**
- Keys can be any type (like objects or numbers)

```javascript
const info = new Map();
info.set("name", "Amit");
info.set("age", 25);

console.log(info.get("name")); // Amit
```

