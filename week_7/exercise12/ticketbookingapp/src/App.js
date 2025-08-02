import './App.css';
import { useState } from 'react';
import GuestProfile from './components/GuestProfile';
import UserProfile from './components/UserProfile';
import FlightList from './components/FlightList';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>

      {/* Login/Logout Button */}
      <div>
        {isLoggedIn ? (
          <button onClick={handleLogout}>Log Out</button>
        ) : (
          <button onClick={handleLogin}>Log In</button>
        )}
      </div>
      {isLoggedIn ? <UserProfile /> : <GuestProfile />}

      <FlightList />
    </div>
  );
}

export default App;
