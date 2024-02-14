import { useState } from 'react';

function Profile() {
  const [isEditing, setIsEditing] = useState(true);

  function handleEvent() {
    //OLD 버전
    //setIsEditing(!isEditing); //권장 안함
    //New 버전 ( 함수 권장)
    setIsEditing((isEditing) => !isEditing);
  }
  //1. 조건문
  let tag = <span>홍길동</span>;
  if (!isEditing) {
    tag = <input />;
  }
  return (
    <>
      <h1>조건부 랜더링 방법1 - if문 이용</h1>
      {tag}
      <button onClick={handleEvent}>{isEditing ? 'Save' : 'Edit'}</button>

      <h1>조건부 랜더링 방법2 - 3항 연산자 이용</h1>
      {isEditing ? <span>홍길동</span> : <input />}
      <button onClick={handleEvent}>{isEditing ? 'Save' : 'Edit'}</button>

      <h1>조건부 랜더링 방법3 - && 연산자 이용</h1>
      {isEditing && <span>홍길동</span>}
      {!isEditing && <input />}
      <button onClick={handleEvent}>{isEditing ? 'Save' : 'Edit'}</button>
    </>
  );
}

export default Profile;
