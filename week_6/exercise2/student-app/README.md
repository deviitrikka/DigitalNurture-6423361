
### **⚙️ What are React Components?**

* **React components** are the **building blocks** of a React application.
* Each component represents a **part of the user interface** (like buttons, forms, headers).
* They are **reusable**, **independent**, and can have their own **logic and UI**.
* Components can be **nested** inside each other to create complex UIs.

---

### **🔍 Difference Between React Components and JavaScript Functions**

| Feature                   | **React Component**                                 | **JavaScript Function**                |
| ------------------------- | --------------------------------------------------- | -------------------------------------- |
| **Purpose**               | Used to create UI elements in React                 | Used to perform logic or return values |
| **Return**                | Returns **JSX (UI code)**                           | Returns data, not JSX                  |
| **State & Props**         | Can use **state** and **props** to manage UI & data | No built-in support for state or props |
| **Rendering**             | Automatically re-renders when state/props change    | Does not trigger rendering             |
| **Hooks** (like useState) | Can be used in **functional components**            | Cannot use React hooks                 |

---

### **📦 Types of React Components**

1. **Functional Components** ✅

   * **Simpler** and easier to read.
   * Created using a **JavaScript function**.
   * Can use **React Hooks** (like `useState`, `useEffect`).
   * Example:

     ```jsx
     function Welcome(props) {
       return <h1>Hello, {props.name}!</h1>;
     }
     ```

2. **Class Components** 🧱

   * Older way of writing components.
   * Use **`class`** keyword and **`render()`** method.
   * Have built-in support for **state** and **lifecycle methods**.
   * Example:

     ```jsx
     class Welcome extends React.Component {
       render() {
         return <h1>Hello, {this.props.name}!</h1>;
       }
     }
     ```

> ⚠️ Note: Functional components are preferred in modern React due to **hooks** and **simpler syntax**.



### **🏗️ What is a Class Component in React?**

* A **Class Component** is a **React component** written using a **JavaScript class**.
* It extends `React.Component`.
* Used in **older versions of React**, but still supported.
* Can manage **state** and use **lifecycle methods**.

#### ✅ Example:

```jsx
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}!</h1>;
  }
}
```

#### 🔑 Key Points:

* Uses `render()` to return JSX.
* Can use `this.state` and `this.setState()` to manage data.
* Can use lifecycle methods like `componentDidMount()`, `componentDidUpdate()`.

---

### **🔧 What is a Functional Component in React?**

* A **Functional Component** is a **simple JavaScript function** that returns **JSX**.
* Recommended in **modern React** (especially with **Hooks**).
* Easier to write and test.

#### ✅ Example:

```jsx
function Welcome(props) {
  return <h1>Hello, {props.name}!</h1>;
}
```

#### 🔑 Key Points:

* Cannot use `this`.
* Can use **Hooks** like `useState`, `useEffect` to manage state and side effects.
* Clean and concise.

---

### **🛠️ What is a Component Constructor?**

* The **constructor** is a **special method** in **class components**.
* It is used to **initialize state** and **bind methods**.

#### ✅ Example:

```jsx
class Welcome extends React.Component {
  constructor(props) {
    super(props); // Always call super(props) first
    this.state = { message: 'Hello!' };
  }
}
```

#### 🔑 Key Points:

* Called **once** when the component is created.
* `super(props)` is required to access `this.props`.
* Not used in functional components.

---

### **🖼️ What is the render() Function?**

* `render()` is a **required method** in **class components**.
* It **returns JSX** that describes what to show in the UI.

#### ✅ Example:

```jsx
render() {
  return <h1>Hello, React!</h1>;
}
```

#### 🔑 Key Points:

* Called **automatically** during component rendering.
* React **re-runs** it when state or props change.
* Must return a **single JSX element**.
