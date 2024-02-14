function Profile() {
  //이벤트 처리 함수
  function handleEvent() {
    console.log('handleEvent');
  }
  function handleEvent2(event) {
    console.log('handleEvent2', event);
  }
  function handleEvent3(n, event) {
    console.log('handleEvent3', n, event);
  }
  return (
    <>
      <button onClick={handleEvent}>click1</button>
      <br />
      <button
        onClick={() => {
          handleEvent();
        }}
      >
        click2
      </button>
      <br />

      <button onClick={handleEvent2}>click3</button>
      <br />

      <button
        onClick={(e) => {
          handleEvent3(100, e);
        }}
      >
        click4
      </button>
      <br />
    </>
  );
}

export default Profile;
