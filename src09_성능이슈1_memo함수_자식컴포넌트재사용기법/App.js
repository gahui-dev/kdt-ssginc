import Profile from './components/Profile.js';
import Profile2 from './components/Profile2.js';
import { useState } from 'react';
function App() {
  const [num, setNum] = useState(0);

  function handleEvent() {
    setNum(num + 1);
  }

  console.log('App');
  return (
    <div>
      <Profile xxx={num} />
      <br />
      <Profile2 xxx={10} />
      <hr />

      <button onClick={handleEvent}>+</button>
    </div>
  );
}

export default App;
