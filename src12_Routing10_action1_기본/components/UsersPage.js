import { json } from 'react-router-dom';
import UserList from './UserList';

function UsersPage() {
  console.log('UsersPage 생성');
  return (
    <>
      <UserList />
    </>
  );
}

export async function loader() {
  console.log('UsersPage.loader');

  const response = await fetch(' https://reqres.in/api/users?page=2');
  const resData = await response.json();

  //예외처리
  if (!response.ok) {
    // 원래는 !response.ok 임
    throw json({ message: 'UsersLoader 요청시 예외발생' }, { status: 500 });
  }

  return resData.data;
}

export default UsersPage;
