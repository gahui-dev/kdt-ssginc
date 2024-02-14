import { useState } from 'react';

function Profile() {
  const [username, setUsername] = useState('');
  const [submitted, setSubmitted] = useState(false); // 저장 버튼 클릭 여부 확인

  function handleChange(event) {
    setUsername(event.target.value);
    setSubmitted(false);
  }
  function handleClick(event) {
    setSubmitted(true);
  }
  console.log('Profile');
  return (
    <>
      <h2>환영합니다. {submitted ? username : ''} </h2>
      <input
        type='text'
        value={username}
        onChange={handleChange}
      />
      <button onClick={handleClick}>저장</button>
    </>
  );
}

export default Profile;
