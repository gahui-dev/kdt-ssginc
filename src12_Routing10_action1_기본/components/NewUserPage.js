import { Form, redirect } from 'react-router-dom';

export default function NewUserPage() {
  return (
    <div>
      <Form method='post'>
        id:
        <input
          type='text'
          name='id'
        />
        <br />
        email:
        <input
          type='text'
          name='email'
        />
        <br />
        first_name:
        <input
          type='text'
          name='first_name'
        />
        <br />
        last_name:
        <input
          type='text'
          name='last_name'
        />
        <br />
        <button>저장</button>
      </Form>
    </div>
  );
}
export async function action({ request }) {
  //https://reqres.in/api/users + post

  const form_data = await request.formData();

  const id = form_data.get('id');
  const email = form_data.get('email');
  const first_name = form_data.get('first_name');
  const last_name = form_data.get('last_name');
  console.log(id, email, first_name, last_name);

  const json_data = {
    id: id,
    email: email,
    first_name: first_name,
    last_name: last_name,
  };

  const response = await fetch('https://reqres.in/api/users', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(json_data),
  });

  //예외처리

  // 실제 서버에는 저장안되지만 서버연동 확인
  const resData = await response.json();
  console.log('resData', resData);

  return redirect('/users');
}
