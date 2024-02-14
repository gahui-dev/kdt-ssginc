function Profile() {
  function handleSubmit(event) {
    event.preventDefault();

    // new FormData(event.target)
    const fd = new FormData(event.target);
    const userid = fd.get('userid');
    const passwd = fd.get('passwd');
    const email = fd.getAll('email');
    console.log(userid, passwd, email);
  }
  return (
    <>
      입력값
      <form onSubmit={handleSubmit}>
        아이디:
        <input
          type='text'
          name='userid'
        />
        <br />
        비밀번호:
        <input
          type='text'
          name='passwd'
        />
        <br />
        email1:
        <input
          type='text'
          name='email'
        />
        <br />
        email2:
        <input
          type='text'
          name='email'
        />
        <br />
        <button>로그인</button>
      </form>
    </>
  );
}

export default Profile;
