export default function UserList({ userList, isFetching }) {
  return (
    <>
      {isFetching && <p>loading 중입니다</p>}
      {!isFetching && (
        <table border='1'>
          <thead>
            <tr>
              <th>아이디</th>
              <th>이름</th>
              <th>사진</th>
            </tr>
          </thead>
          <tbody>
            {userList.map((row, idx) => (
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
            ))}
          </tbody>
        </table>
      )}
    </>
  );
}
