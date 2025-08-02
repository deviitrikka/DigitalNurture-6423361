// src/components/UserProfile.js
import React, { useState } from 'react';

const UserProfile = () => {
  const [selectedFlight, setSelectedFlight] = useState('');
  const [bookingStatus, setBookingStatus] = useState('');

  const handleBooking = (e) => {
    e.preventDefault();
    if (selectedFlight) {
      setBookingStatus(`Successfully booked flight ID: ${selectedFlight}`);
    } else {
      setBookingStatus('Please select a flight to book.');
    }
  };

  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>Select a flight to book:</p>
      <form onSubmit={handleBooking}>
        <select
          value={selectedFlight}
          onChange={(e) => setSelectedFlight(e.target.value)}
        >
          <option value="">-- Select Flight --</option>
          <option value="1">New Delhi → Mumbai</option>
          <option value="2">Bangalore → Chennai</option>
          <option value="3">Kolkata → Hyderabad</option>
        </select>
        <button type="submit">Book Ticket</button>
      </form>
      {bookingStatus && <p>{bookingStatus}</p>}
    </div>
  );
};

export default UserProfile;
