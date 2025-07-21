
✨ **Need**: It helps developers manage how a component behaves during creation, updates, and removal.

🔄 **Initialization**: When a component is created (e.g. showing a login form), its setup begins—like setting default states.

🧠 **Update**: Whenever data changes (like typing in the form), the component responds and may re-render.

🧹 **Unmounting**: When the component is no longer needed (e.g. user logs in and sees a dashboard), it gets cleaned up to save memory.

💡 **Benefits**: Improves performance, avoids memory leaks, and ensures smooth user interactions.


**React’s life cycle hook methods** 

🟢 **Mounting Phase** (component is created and added to the DOM):
- `constructor()` → Sets initial state.  
  *Example: Set `this.state = { count: 0 }`.*
- `componentDidMount()` → Runs once after the component appears.  
  *Example: Fetch user data from API here.*

🔁 **Updating Phase** (component re-renders due to props/state changes):
- `shouldComponentUpdate()` → Decides if re-render is needed.  
  *Example: Only re-render when a user clicks a button.*
- `componentDidUpdate()` → Runs after updates.  
  *Example: Scroll to bottom after chat message appears.*

❌ **Unmounting Phase** (component is removed from DOM):
- `componentWillUnmount()` → Cleanup work like stopping timers or unsubscribing.  
  *Example: Clear interval or detach event listeners.*

✨ **Hooks Alternative (Functional Components)**:
- `useEffect()` → Can mimic `componentDidMount`, `componentDidUpdate`, and `componentWillUnmount`.  
  *Example: `useEffect(() => { fetchData(); return () => cleanup(); }, [props])`*

The sequence of steps involved when **React renders a class component**:

🔧 **1. Constructor** – Initializes state and binds methods.  
*Example: `this.state = { name: '' };`*

🖼️ **2. Render** – Returns the JSX to describe what the UI should look like.  
*Example: `<input value={this.state.name} />`*

🗂️ **3. componentDidMount** – Executes once after the component is added to the DOM.  
*Example: Ideal spot to fetch initial data.*

♻️ **4. componentDidUpdate** – Runs after re-rendering due to props/state changes.  
*Example: Sync with external systems if needed.*

🧹 **5. componentWillUnmount** – Called before removing the component.  
*Example: Cleanup like clearing timers.*

And if you're using functional components, the **`useEffect`** hook can handle steps 3–5 depending on how it's used.

