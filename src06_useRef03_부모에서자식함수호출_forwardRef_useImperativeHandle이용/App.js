import Box from './components/Box.js';
import { useState, useRef } from 'react';
function App() {
  const x = useRef();

  function handleEvent() {
    x.current.open();
  }

  return (
    <div>
      <Box
        ref={x}
        name='box모달'
      />
      <button onClick={handleEvent}>자식open호출</button>
    </div>
  );
}

export default App;
