import { json, redirect, Form } from 'react-router-dom';

function SignupPage() {
    return 
    <>
       <h1>SignupPage</h1>;
    </>
  }
  
  export default SignupPage;
  
  export async function action({ request }) {
    console.log("SignupPage.action");
   
    return redirect('/');
  }