function Profile() {
  function handleSubmit(event) {
    event.preventDefault();
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <input
          type='text'
          name='username'
        />
        <button>전송</button>
      </form>
    </>
  );
}

export default Profile;
