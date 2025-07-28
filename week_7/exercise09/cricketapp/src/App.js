import './App.css';
import players from './data/players.js'
import IndianPlayers from './data/IndianPlayers.js';

function App() {
  const flag = true;
  return (
    <div>
    {flag && <div>
      <h2>List of Players</h2>
      {players.map((i)=>(
        <li>
          {i.name}  <span> {i.score}</span>
        </li>
      ))}
      <hr></hr>
      <h2>List of players having score less than 70</h2>
      {players
      .filter(i => i.score<=70)
      .map((i)=>(
        <li>
          {i.name} <span>{i.score}</span>
        </li>
      ))}
    </div>}
    {!flag && <div>      
        <h2>Odd Players</h2>
        {players
        .filter((_,id) => id%2!==0)
        .map((i,_)=>(
          <li>
            {_}<span>{i.name} </span>
          </li>
        ))
        }
        <hr/>
        <h2>Even Players</h2>
        {players
        .filter((_,id) => (id%2===0))
        .map((id,_)=>(
          <li>
            {_} <span>{id.name} </span>
          </li>
        ))
        }
        <hr/>
        <h2>List of Indian Players Merged:</h2>
        {IndianPlayers.map((i) => (
          <li>
            Mr. {i.name}
          </li>
        ))}
      </div>
    }
    </div>
  );
}

export default App;
