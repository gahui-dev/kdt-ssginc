// 객체분해할당
function Profile({ name, age, children }) {
  return (
    <>
      <p>Profile</p>
      이름:{name}
      <br />
      나이:{age}
      <br />
      children:{children}
    </>
  );
}

export default Profile;
