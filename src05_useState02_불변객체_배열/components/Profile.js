import { useState } from 'react';

function Profile() {
  const [num, setNum] = useState([10]);

  function handleUp() {
    const new_num = [...num, 100];
    console.log(new_num, num, new_num === num); // new_num(200번지), num(100번지)
    setNum(new_num);
  }
  function handleDown() {}
  console.log('Profile 생성');
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
