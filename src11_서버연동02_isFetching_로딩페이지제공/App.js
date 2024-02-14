import { useEffect, useState } from 'react';
import { fetchUserList } from './http/http';
import UserList from './components/UserList';

function App() {
  // useState
  const [userList, setUserList] = useState([]);
  // 로딩 페이지
  const [isFetching, setIsFetching] = useState(false);

  //useEffect
  useEffect(() => {
    async function xxx() {
      setIsFetching(true);
      const list = await fetchUserList();
      setUserList(list);
      setIsFetching(false);
    }
    xxx();
  }, []);

  return (
    <div>
      <UserList
        userList={userList}
        isFetching={isFetching}
      />
    </div>
  );
}

export default App;
