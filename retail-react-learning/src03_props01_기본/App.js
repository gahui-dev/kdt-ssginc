import Profile from './components/Profile.js';

function App() {
  const addr = '제주';
  const user = { name: '이순신', age: 30, address: '대구' };
  return (
    <div>
      프로필1:{' '}
      <Profile
        name='홍길동'
        age={20}
        address='부산'
      />
      프로필2:{' '}
      <Profile
        name='홍길동2'
        age={20}
      />
      프로필3:{' '}
      <Profile
        name='홍길동2'
        age={20}
        address={addr}
      />
      프로필4: <Profile {...user} />
    </div>
  );
}

export default App;
