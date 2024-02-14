import { useState } from 'react';

function Profile() {
  // 주제는 input태그에 입력한 값을 state에 저장해서 관리하자.
  const [inputs, setInputs] = useState({ email: '', passwd: '' });

  // 유효성 체크용
  const [isEdit, setIsEdit] = useState({ email: false, passwd: false });

  // 유효성 조건지정
  const emailIsInvalid = isEdit.email && !inputs.email.includes('@'); // @ 반드시 포함
  const passwdIsInvalid = isEdit.passwd && !(inputs.passwd.length > 6); // 6 글자이상

  function handleChange(event) {
    // setInputs({...inputs, [event.target.name]:event.target.value});
    setInputs((prev) => ({ ...prev, [event.target.name]: event.target.value }));

    setIsEdit((prev) => ({ ...prev, [event.target.name]: false }));
  }

  function handleEventBlur(x) {
    // email|passwd
    setIsEdit((prev) => ({ ...prev, [x]: true }));
  }
  function handleSubmit(event) {
    event.preventDefault();
    console.log(inputs);
  }
  return (
    <>
      <form onSubmit={handleSubmit}>
        email:
        <input
          type='text'
          name='email'
          value={inputs.email}
          onChange={handleChange}
          onBlur={() => {
            handleEventBlur('email');
          }}
        />
        <span>{emailIsInvalid && <p>email @ 필수입니다.</p>}</span>
        <br />
        비밀번호:
        <input
          type='text'
          name='passwd'
          value={inputs.passwd}
          onChange={handleChange}
          onBlur={() => {
            handleEventBlur('passwd');
          }}
        />
        <span>{passwdIsInvalid && <p>passwd 7글자 이상입니다.</p>}</span>
        <br />
        <button>로그인</button>
      </form>
    </>
  );
}

export default Profile;
