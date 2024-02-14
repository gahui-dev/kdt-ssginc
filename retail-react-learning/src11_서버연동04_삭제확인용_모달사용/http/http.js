// http/http.js

export async function fetchUserList() {
  const response = await fetch(' https://reqres.in/api/users?page=2', {
    method: 'GET',
  });
  console.log('response:', response);

  //예외처리
  if (!response.ok) {
    throw new Error('fetchUserList 요청 실패');
  }

  const resData = await response.json();
  console.log('resData:', resData);

  return resData.data;
}
