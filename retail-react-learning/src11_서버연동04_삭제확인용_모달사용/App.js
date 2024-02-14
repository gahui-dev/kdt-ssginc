import { useEffect, useState } from 'react';
import { fetchUserList } from './http/http';
import UserList from './components/UserList';
import ErrorPage from './components/ErrorPage';
import Box from './components/Box';

function App() {
  // useState
  const [userList, setUserList] = useState([]);
  // 로딩 페이지
  const [isFetching, setIsFetching] = useState(false);

  // 에러
  const [error, setError] = useState();

  //모달 open 여부
  const [modalIsOpen, setModalIsOpen] = useState(false);

  //삭제할 user
  const [user, setUser] = useState('');

  //useEffect
  useEffect(() => {
    async function xxx() {
      setIsFetching(true);
      try {
        const list = await fetchUserList();
        setUserList(list);
      } catch (err) {
        console.log('err:', err.message);
        setError({ message: err.message });
      }
      setIsFetching(false);
    }
    xxx();
  }, []);

  //삭제 확인(Confirm)
  function handleRemoveConfirm() {
    //원래는 서버 연동
    setModalIsOpen(false);
    setUserList((prev) => prev.filter((x) => x.id !== user));
  }

  //진짜 삭제
  function handleRemove(id) {
    console.log('>>>', id);
    setUser(id);
    setModalIsOpen(true);
  }

  return (
    <div>
      <Box open={modalIsOpen}>
        <h2>삭제 확인</h2>
        <p>진짜 삭제합니까?</p>
        <button onClick={() => setModalIsOpen(false)}>NO</button>
        <button onClick={handleRemoveConfirm}>YES</button>
      </Box>

      <h1>user 목록</h1>
      {error && (
        <ErrorPage
          title='User목록예외'
          message={error.message}
        />
      )}
      {!error && (
        <UserList
          userList={userList}
          isFetching={isFetching}
          onRemove={handleRemove}
        />
      )}
    </div>
  );
}

export default App;
