import Profile from './components/Profile.js';
import logo from './logo.svg';
function App() {
  //이벤트 처리 함수
  function handleEvent(n) {
    console.log('handleEvent', n);
  }

  return (
    <div>
      <Profile onMyClick={handleEvent} />
    </div>
  );
}

export default App;
