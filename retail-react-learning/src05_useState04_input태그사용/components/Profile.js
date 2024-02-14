import { useState } from 'react';

function Profile() {
  // 주제는 input태그에 입력한 값을 state에 저장해서 관리하자.
  const [inputs, setInputs] = useState({ userid: '', passwd: '' });

  function handleEvent(event) {
    //state값 변경
    // const xxx = event.target.name;
    // const yyy = event.target.value
    // console.log(xxx, yyy, {[xxx]:yyy}); // ES 6에 key값을 동적으로 설정 가능
    // const new_inputs = {...inputs, [xxx]:yyy};// {userid:'',passwd:'', }
    // setInputs(new_inputs);
    setInputs({ ...inputs, [event.target.name]: event.target.value });
  }
  function handleSubmit(event) {
    event.preventDefault();
  }

  return (
    <>
      입력값:{inputs.userid},{inputs.passwd}
      <form onSubmit={handleSubmit}>
        아이디:
        <input
          type='text'
          name='userid'
          value={inputs.userid}
          onChange={handleEvent}
        />
        <br />
        비밀번호:
        <input
          type='text'
          name='passwd'
          value={inputs.passwd}
          onChange={handleEvent}
        />
        <br />
        <button>로그인</button>
      </form>
    </>
  );
}

export default Profile;
