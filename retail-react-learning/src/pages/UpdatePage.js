import { json, useLoaderData} from 'react-router-dom';
import { getAuthToken } from '../util/auth';

// axios import 
import axios from 'axios';

function UpdatePage() {
   const user = useLoaderData();

    return (
    <>
         <h1>수정 회원  목록</h1>
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
                <tr>
                    <td>{user.id}</td>
                    <td>{user.email}</td>
                    <td>{user.username}</td>
                    <td>{user.role}</td>
                </tr>  
            </tbody>
          </table>
    </>
    )
  }
  
  export default UpdatePage;
  
  export async function loader({ request }) {
    console.log("UpdatePage.action");
    const token = getAuthToken();
    const email = localStorage.getItem("email");
    console.log("token:", token);
    console.log("email:" , email);
      const response = await axios({
        method:"get",
        url:'http://localhost:8090/update',
        headers: {
          'Content-Type': 'application/json',
          'jwtauthtoken': token
        }
      });
  
      const resData = response.data;
      console.log("resData", resData);

      return resData;
  
  }