import { useEffect, useState } from 'react';

function Profile() {
  const [num, setNum] = useState(0);
  const [num2, setNum2] = useState(0);

  useEffect(() => {
    console.log('useEffect');
  }, [num]);

  function handleUp() {
    setNum(num + 1);
  }
  function handleDown() {
    setNum2(num2 - 1);
  }
  console.log('Profile');
  return (
    <>
      <h2>Profile</h2>
      <button onClick={handleUp}>+</button>
      <button onClick={handleDown}>-</button>
    </>
  );
}

export default Profile;
