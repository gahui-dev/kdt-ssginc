import { useLoaderData, useRouteLoaderData } from 'react-router-dom';
export default function UserList() {
  const userList = useLoaderData();
  // const userList = useRouteLoaderData("root");
  console.log(userList);
  return (
    <>
      <table border='1'>
        <thead>
          <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>사진</th>
          </tr>
        </thead>
        <tbody>
          {userList.map((row, idx) => {
            return (
              <tr key={idx}>
                <td>{row.id}</td>
                <td>{row.first_name}</td>
                <td>
                  <img
                    src={row.avatar}
                    width={50}
                    height={50}
                  />
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </>
  );
}
