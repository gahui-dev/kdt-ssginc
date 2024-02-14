import Profile from './components/Profile.js';
import { UserContext } from './store/user-context.js';
import { useState } from 'react';

function App() {
  const [username, setUsername] = useState('홍길동');

  return (
    <UserContext.Provider value={username}>
      <div>
        <Profile />
      </div>
    </UserContext.Provider>
  );
}

export default App;
