import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [converted, setConverted] = useState(null);
  const [direction, setDirection] = useState('eur-to-inr'); // default
  const conversionRate = 90; // 1 Euro = 90 INR

  const handleSubmit = (e) => {
    e.preventDefault();

    const value = parseFloat(amount);

    if (isNaN(value)) {
      alert('Please enter a valid number');
      return;
    }

    let result = 0;
    if (direction === 'eur-to-inr') {
      result = value * conversionRate;
      setConverted(`₹ ${result.toFixed(2)}`);
    } else {
      result = value / conversionRate;
      setConverted(`€ ${result.toFixed(2)}`);
    }
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h2>Currency Convertor</h2>

      <select value={direction} onChange={(e) => setDirection(e.target.value)}>
        <option value="eur-to-inr">Euro to Rupees</option>
        <option value="inr-to-eur">Rupees to Euro</option>
      </select>
      <br /><br />

      <input
        type="text"
        placeholder="Enter amount"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />
      <br /><br />

      <button onClick={handleSubmit}>Convert</button>

      {converted && (
        <h3>Converted Amount: {converted}</h3>
      )}
    </div>
  );
}

export default CurrencyConvertor;
