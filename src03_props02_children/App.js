import Profile from './components/Profile.js';
import logo from './logo.svg';
function App() {
  const addr = '제주';
  const user = { name: '이순신', age: 30, address: '대구' };
  return (
    <div>
      프로필1:{' '}
      <Profile
        name='홍길동'
        age={20}
      >
        서울
      </Profile>
      프로필2:{' '}
      <Profile
        name='홍길동'
        age={20}
      >
        <span>daum</span>
        <img
          src={logo}
          width={100}
          height={100}
        />
      </Profile>
    </div>
  );
}

export default App;
