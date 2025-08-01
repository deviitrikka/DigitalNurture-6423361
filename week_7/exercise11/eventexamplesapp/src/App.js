import { useState } from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [val, setVal] = useState(0)
  const sayHello = () => {
    window.alert("Hello! Welcome to EventExamplesApp");
  };

  const onIncreament = () =>{
    setVal(prev => prev+1)
    sayHello()
  }
  const onDecreament = ()=>{
    setVal(prev => prev-1)
  }

    const sayMessage = (msg) => {
    window.alert(msg);
  };

  const onSayWelcome = () => {
    sayMessage("welcome");
  };
  const handleClick = (event) => {
    window.alert("I was clicked");
  };
  return (
    <div className="App">
      <h1>{val}</h1>
      <button onClick={onIncreament}>Increment</button>
      <button onClick={onDecreament}>Decrement</button>
      <button onClick={onSayWelcome}>Say Welcome</button>
       <button onClick={handleClick}>Click Me</button>
       <CurrencyConvertor/>
    </div>
  );
}

export default App;
