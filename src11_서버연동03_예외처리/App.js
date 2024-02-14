
import {useEffect, useState} from 'react';
import { fetchUserList } from './http/http';
import UserList from './components/UserList';
import ErrorPage from './components/ErrorPage';

function App() {

  // useState
  const [userList, setUserList] = useState([]);
  // 로딩 페이지
  const [isFetching, setIsFetching] = useState(false);

  // 에러
  const [error, setError] = useState();

  //useEffect
  useEffect(()=>{
    async function xxx(){
      setIsFetching(true);
      try{
        const list = await fetchUserList();
        setUserList(list);
      }catch(err){
        console.log("err:" , err.message);
        setError({message: err.message});

      }
      setIsFetching(false);
     }
     xxx();
  }, []);

  return (
    <div>
      <h1>user 목록</h1>
      {error && <ErrorPage title="User목록예외" message={error.message}/>}
      {!error && (<UserList userList={userList} 
                  isFetching={isFetching}/>)}
    </div>
  );
}

export default App;
