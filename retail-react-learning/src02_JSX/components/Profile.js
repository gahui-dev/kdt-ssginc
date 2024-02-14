import './Profile.css';
import daumImg from '../assets/daum.png';

//변수
let title = 'hello';
let names = ['홍길동', '이순신', '유관순'];
let attr = { href: 'http://www.daum.net', target: '_blank' };

function Profile() {
  //일반함수
  function handleEvent() {
    console.log('handleEvent');
  }

  return (
    <div>
      <h1>기본 JSX1</h1>
      숫자:{10}
      <br />
      문자:hello
      <br />
      연산:{10 + 1},{10 > 4},{10 > 4 ? 'true' : 'false'}
      <h1>기본 JSX2</h1>
      title:{title}
      <br />
      names:{names},{names[0]}
      <br />
      attr:JSON 사용불가
      <br />
      <a {...attr}>다음</a>
      <br />
      반복1:
      {names.map(function (row, idx) {
        return <span key={idx}>{row}</span>;
      })}
      <br />
      반복2(arrow 함수):
      {names.map((row, idx) => (
        <span key={idx}>{row}</span>
      ))}
      <h1>기본 JSX3</h1>
      이벤트:<button onClick={handleEvent}>click</button>
      style:<p style={{ fontSize: '30px', backgroundColor: 'yellow' }}>Hello</p>
      className 속성:<p className='profile'>Hello2</p>
      조건부 랜더링: {title === 'hello' && <p>HEllo 입니다.</p>}
      이미지:
      <img
        src={daumImg}
        width={100}
        height={100}
      />
      <br />
      주석문: {/* 주석문  */}
    </div>
  );
}

export default Profile;
