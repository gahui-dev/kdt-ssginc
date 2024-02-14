import { useEffect, useState } from 'react';
import { fetchUserList } from './http/http';
import UserList from './components/UserList';

function App() {
  // useState
  const [userList, setUserList] = useState([]);

  //useEffect
  useEffect(() => {
    async function xxx() {
      const list = await fetchUserList();
      setUserList(list);
    }
    xxx();
  }, []);

  return (
    <div>
      <UserList userList={userList} />
    </div>
  );
}

export default App;
