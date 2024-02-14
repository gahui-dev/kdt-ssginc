import { Form, redirect, useActionData } from 'react-router-dom';

export default function NewUserPage() {
  const actionData = useActionData();

  return (
    <div>
      {actionData && <p>폼데이터 다시 입력하시오.</p>}
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
  if (!response.ok) {
    // 실습방법은 form 태그에 아무것도 입력안하고 전소버튼 클릭;
    return response; // action을 수행하는 컴포넌트(NewUserPage)갑 예외를 처리할 수 있다.
  }

  // 실제 서버에는 저장안되지만 서버연동 확인
  const resData = await response.json();
  console.log('resData', resData);

  return redirect('/users');
}
