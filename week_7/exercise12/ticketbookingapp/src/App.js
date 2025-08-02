import './App.css';
import { useState } from 'react';
import UserProfile from './UserProfile';
import GuestProfile from './GuestProfile';
import Flights from './Flights';

function App() {
  const [isLoggedIn, setisLoggedIn] = useState(false)
  const handleLogin = () => setisLoggedIn(true)
  const handleLogout = () => setisLoggedIn(false)
  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      <div>
        {isLoggedIn? 
        <button onClick={handleLogout}>Log Out</button>
        : <button onClick={handleLogin}>Log In</button>} 
      </div>
      <main>
        {isLoggedIn ? <UserProfile/> : <GuestProfile/>}
      </main>
      <Flights/>
    </div>
  );
}

export default App;
