import { useRef } from 'react';

function Profile() {
  const email = useRef();
  const passwd = useRef();

  function handleSubmit(event) {
    event.preventDefault();
    const email_value = email.current.value;
    const passwd_value = passwd.current.value;
    console.log(email_value, passwd_value);
  }
  return (
    <>
      입력값
      <form onSubmit={handleSubmit}>
        아이디:
        <input
          type='text'
          name='userid'
          ref={email}
        />
        <br />
        비밀번호:
        <input
          type='text'
          name='passwd'
          ref={passwd}
        />
        <br />
        <button>로그인</button>
      </form>
    </>
  );
}

export default Profile;
