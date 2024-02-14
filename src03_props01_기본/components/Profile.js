// 객체분해할당
function Profile({ name, age, address = '서울' }) {
  return (
    <>
      <p>Profile</p>
      이름:{name}
      <br />
      나이:{age}
      <br />
      주소:{address}
      <br />
    </>
  );
}
function Profile2(props) {
  console.log(props);
  const { name, age, address } = props;
  return (
    <>
      <p>Profile</p>
      이름:{name}
      <br />
      나이:{age}
      <br />
      주소:{address}
      <br />
    </>
  );
}

export default Profile;
