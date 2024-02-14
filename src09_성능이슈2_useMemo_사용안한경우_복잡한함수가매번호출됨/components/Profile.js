import { useState } from 'react';

function Profile() {
  const [num, setNum] = useState();

  function handleEvent() {
    setNum(num + 1);
  }

  //복잡한 연산식을 가지고 동일한 반환값을 리턴하는 함수
  function complexFun() {
    console.log('complexFun');
    return ((45 * 23) / 3) * 425;
  }

  console.log('Profile');
  return (
    <>
      복잡한결과:{complexFun()}
      <button onClick={handleEvent}>+</button>
    </>
  );
}

export default Profile;
