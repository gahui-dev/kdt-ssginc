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

  return resData.data;
}

export default UsersPage;
