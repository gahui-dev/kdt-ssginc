import { json, useLoaderData} from 'react-router-dom';
import { getAuthToken } from '../util/auth';

// axios import 
import axios from 'axios';


function UserListPage(){
  const users = useLoaderData();
  console.log("UserListPage,users>>>>>>>>>>>>.",users)
    return (
        <>
         <h1>회원 목록</h1>
         <table border="1">
           <thead> 
                <tr>
                    <th>id</th>
                    <th>email</th>
                    <th>username</th>
                    <th>role</th>
                </tr>
            </thead>
            <tbody> 
              {
                users.map((user,idx)=>
                <tr key={user.id}>
                    <td>{user.id}</td>
                    <td>{user.email}</td>
                    <td>{user.username}</td>
                    <td>{user.role}</td>
                </tr>  )

              }
    
            </tbody>
          </table>
        </>
    )
 
}
export default UserListPage;

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// axios 버전
export async function loader({ request }) {
  console.log("UserListPage,loader>>>>>>>>>>>>.",request)
  const token = getAuthToken();
  const email = localStorage.getItem("email");
  console.log("token:", token);
  console.log("email:" , email);
 
  const response = await axios({
     method:"GET",
     url:"http://localhost:8090/userList/", 
      headers: {
        'Content-Type': 'application/json',
        'jwtauthtoken': token
      }
    });
   
    console.log("UserListPage.response >>>>>>>>>>>..", response );

    if (response.status !== 200) {
      throw json({ message: 'Could not save event.' }, { status: 500 });
    }
    
  const resData = response.data;
  console.log("resData", resData);
  return resData;
}


//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// fetch 기반
export async function loader2 ({ request }) {
    console.log("MyPagePage,loader>>>>>>>>>>>>.",request)
    const token = getAuthToken();
    const email = localStorage.getItem("email");
    console.log("token:", token);
    console.log("email:" , email);
    const authData = {
      email: email
    }
    const response = await fetch("http://localhost:8090/api/mypage/", {
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
          'jwtAuthToken': token
        },
        body: JSON.stringify(authData),
      });
     

      if (!response.ok) {
        throw json({ message: 'Could not save event.' }, { status: 500 });
      }
      
    const resData = await response.data;
    console.log("resData", resData);
    return resData;
  }
  