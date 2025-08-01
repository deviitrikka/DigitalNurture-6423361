import React from 'react';
import './App.css';


function App() {
  const element = "Office Space";
  const jsxatt = <img src="/sr.jpg" alt='office'></img>
  // Single office object
  const office = {
    name: 'Sunshine Workspace',
    rent: 55000,
    address: '123 Business St, Cityville',
  };

  // List of office spaces
  const officeList = [
    {
      name: 'Downtown Hub',
      rent: 45000,
      address: '1 Main Ave, Downtown',
    },
    {
      name: 'Elite Corporate',
      rent: 65000,
      address: '99 Elite Blvd, Metropolis',
    },
    {
      name: 'Skyline Tower',
      rent: 75000,
      address: '200 Sky St, Uptown',
    }
  ];

  return (
    <div className="App">
      <h1>{element}, at affordable range</h1>

      <div className="office-card">
        <h2>{office.name}</h2>
        {jsxatt}
        <p style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
          Rent: ₹{office.rent}
        </p>
        <p>Address: {office.address}</p>
      </div>

      <h2>More Office Listings</h2>
      <div className="office-list">
        {officeList.map((item, index) => (
          <div key={index} className="office-card">
            <h3>{item.name}</h3>
            <p style={{ color: item.rent > 60000 ? 'green' : 'red' }}>
              Rent: ₹{item.rent}
            </p>
            <p>Address: {item.address}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
