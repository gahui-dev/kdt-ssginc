// 4. null,true,false ==> 랜더링이 안됨
function Profile() {
  return (
    <div>
      1:{null}
      {true}
      {false}
      <br />
      2. {true && <p>Hello</p>}
      <br />
      3. {false && <p>Hello</p>}
      <br />
      4. {null && <p>Hello</p>}
      <br />
    </div>
  );
}

// 3. 배열 반환 가능
function Profile4() {
  return ['A', 'B'];
}

// 2. 일반 데이터 반환 가능
function Profile3() {
  return 'Hello World';
}
// 1. jSX 반환 가능
function Profile2() {
  return <p>Profile</p>;
}
export default Profile;
