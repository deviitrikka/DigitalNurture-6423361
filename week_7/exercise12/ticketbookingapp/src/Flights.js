import React from 'react'

const Flights = () => {
    const flights = [
    { id: 1, from: 'New Delhi', to: 'Mumbai', price: 5500 },
    { id: 2, from: 'Bangalore', to: 'Chennai', price: 3200 },
    { id: 3, from: 'Kolkata', to: 'Hyderabad', price: 4800 }
    ];
  return (
    <div>
        <h5>Available Flights</h5>
        
        {flights.map((flight)=>(
            <li key={flight.id}>
            {flight.from} → {flight.to} - ₹{flight.price}
            </li>
        ))}
        
    </div>
  )
}

export default Flights