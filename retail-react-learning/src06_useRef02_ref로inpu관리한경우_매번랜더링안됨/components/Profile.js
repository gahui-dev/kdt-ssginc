import { useState, useRef } from 'react';

function Profile() {
  const [username, setUsername] = useState(null);
  const x = useRef();

  function handleClick(event) {
    console.log(x.current.value);
    setUsername(x.current.value);
  }
  console.log('Profile');
  return (
    <>
      <h2>환영합니다. {username ? username : ''} </h2>
      <input
        type='text'
        ref={x}
      />
      <button onClick={handleClick}>저장</button>
    </>
  );
}

export default Profile;
