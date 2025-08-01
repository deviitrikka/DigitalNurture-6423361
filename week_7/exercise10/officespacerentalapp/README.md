### ✨ JSX (JavaScript XML)
JSX is a syntax extension for JavaScript used in React. It lets you write HTML-like code in JavaScript, making your UI code easier to read and write.

#### 🧾 Example:
```jsx
const element = <h1>Hello World!</h1>;
```
This looks like HTML but is actually JavaScript. Behind the scenes, this gets converted into a `React.createElement()` call.

---

### 📜 ECMAScript
ECMAScript (often called ES) is the standard on which JavaScript is based. Think of it as the blueprint that defines how JavaScript should work. Different versions like ES6, ES7, etc., bring new features.

#### 🧾 Example (ES6 feature: arrow function)
```js
const greet = name => `Hello, ${name}!`;
console.log(greet("Alice")); // Output: Hello, Alice!
```

---

### ⚙️ React.createElement()
This function is used by React to create virtual DOM elements. It’s the behind-the-scenes version of JSX.

#### 🧾 Example (same as JSX but without JSX syntax):
```js
const element = React.createElement("h1", null, "Hello World!");
```
This does exactly the same as `<h1>Hello World!</h1>`, but written the long way.

### 🧩 Create React Nodes with JSX
In React, a "node" is basically an element in the virtual DOM. You can create it using JSX just like writing HTML inside your JavaScript.

#### 🧾 Example:
```jsx
const element = <h2>Welcome to React!</h2>;
```
This creates a React node—a virtual `<h2>` element—with the text “Welcome to React!”

---

### 🌐 Render JSX to the DOM
To make your JSX appear on the actual web page (the real DOM), React uses a method called `ReactDOM.render()`.

#### 🧾 Example:
```jsx
const element = <h2>Hello World!</h2>;
ReactDOM.render(element, document.getElementById("root"));
```
Here, `element` is rendered to the HTML element with the ID `"root"`. You'll usually see a `<div id="root"></div>` in your HTML file.

---

### 🔁 Use JavaScript Expressions in JSX
You can include JavaScript logic inside JSX by wrapping it with curly braces `{}`. This keeps your UI dynamic!

#### 🧾 Example:
```jsx
const name = "Sam";
const element = <p>Hello, {name}!</p>;
```
This will show: `Hello, Sam!` on the screen.

You can also use math or function calls:
```jsx
const element = <p>2 + 2 = {2 + 2}</p>;
```

---

### 🎨 Use Inline CSS in JSX
React allows inline styling using a special syntax: styles are written as objects with camelCased properties.

#### 🧾 Example:
```jsx
const element = <h3 style={{ color: "blue", fontSize: "20px" }}>Styled Text</h3>;
```
This sets the text color to blue and font size to 20px.
