import { useState } from 'react';

function Profile() {
  // 주제는 input태그에 입력한 값을 state에 저장해서 관리하자.
  const [inputs, setInputs] = useState({ userid: '', passwd: '' });

  function handleChange(event) {
    // setInputs({...inputs, [event.target.name]:event.target.value});
    setInputs((prev) => ({ ...prev, [event.target.name]: event.target.value }));
  }
  function handleSubmit(event) {
    event.preventDefault();
    console.log(inputs);
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
          onChange={handleChange}
        />
        <br />
        비밀번호:
        <input
          type='text'
          name='passwd'
          value={inputs.passwd}
          onChange={handleChange}
        />
        <br />
        <button>로그인</button>
      </form>
    </>
  );
}

export default Profile;
