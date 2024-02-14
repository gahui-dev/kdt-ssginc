import { useState } from 'react';

function Profile() {
  // 주제는 input태그에 입력한 값을 state에 저장해서 관리하자.
  const [inputs, setInputs] = useState({ username: '', age: '', address: '' });
  const [memberData, setMemberData] = useState([]);
  function handleEvent(event) {
    setInputs({ ...inputs, [event.target.name]: event.target.value });
  }
  function handleSubmit(event) {
    event.preventDefault();
    //입력한 새로운 회원
    var user = {
      username: inputs.username,
      age: inputs.age,
      address: inputs.address,
    };
    setMemberData([...memberData, user]);
  }

  return (
    <>
      {memberData.map((row, idx) => (
        <div>
          {row.username},{row.age},{row.address}
        </div>
      ))}
      <hr />
      <form onSubmit={handleSubmit}>
        이름:
        <input
          type='text'
          name='username'
          value={inputs.username}
          onChange={handleEvent}
        />
        <br />
        나이:
        <input
          type='text'
          name='age'
          value={inputs.age}
          onChange={handleEvent}
        />
        <br />
        주소:
        <input
          type='text'
          name='address'
          value={inputs.address}
          onChange={handleEvent}
        />
        <br />
        <button>저장</button>
      </form>
    </>
  );
}

export default Profile;
