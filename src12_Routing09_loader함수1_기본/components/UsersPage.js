import { useLoaderData } from 'react-router-dom';
import UserList from './UserList';

function UsersPage() {
  const xxx = useLoaderData();
  console.log(xxx);

  console.log('UsersPage 생성');
  return (
    <>
      <UserList userList={xxx} />
    </>
  );
}

export default UsersPage;
