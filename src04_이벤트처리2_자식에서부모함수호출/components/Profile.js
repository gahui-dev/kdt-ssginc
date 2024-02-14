function Profile({ onMyClick }) {
  return (
    <>
      <button onClick={onMyClick}>click1</button>
      <br />
      <button
        onClick={() => {
          onMyClick();
        }}
      >
        click2
      </button>
      <br />
      <button
        onClick={() => {
          onMyClick(100);
        }}
      >
        click3
      </button>
      <br />
    </>
  );
}

export default Profile;
