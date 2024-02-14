import { useState } from 'react';

function Profile() {
  const [num, setNum] = useState(0);

  function handleUp() {
    setNum(num + 1);
  }
  function handleDown() {
    setNum(num - 1);
  }
  console.log('Profile 생성', num);
  return (
    <>
      num:{num}
      <br />
      <button onClick={handleUp}>+</button>
      <button onClick={handleDown}>-</button>
    </>
  );
}

export default Profile;
