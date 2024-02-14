// http/http.js

export async function fetchUserList() {
  const response = await fetch(' https://reqres.in/api/users?page=2');
  console.log('response:', response);
  const resData = await response.json();
  console.log('resData:', resData);

  return resData.data;
}
