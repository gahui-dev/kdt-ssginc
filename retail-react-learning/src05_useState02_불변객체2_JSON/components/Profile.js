import { useState } from 'react';

function Profile() {
  const [num, setNum] = useState({ n: 0 });

  function handleUp() {
    const new_num = { ...num, n: num.n + 1 }; // {n:0, n:1} ==> {n:1}
    console.log(new_num, num, new_num === num); //new_num과 num은 다른 객체
    setNum(new_num);
  }
  function handleDown() {
    setNum({ ...num, n: num.n - 1 });
  }
  console.log('Profile 생성');
  return (
    <>
      num:{num.n}
      <br />
      <button onClick={handleUp}>+</button>
      <button onClick={handleDown}>-</button>
    </>
  );
}

export default Profile;
