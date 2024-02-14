import { useState, useReducer, useContext } from 'react';
import { UserContext } from '../score/user-context.js';
function Greeting() {
  const [dispatch, item] = useContext(UserContext);
  return (
    <>
      <button onClick={() => dispatch({ type: 'ADD', xxx: item })}>추가</button>
      <button onClick={() => dispatch({ type: 'DEL', xxx: item })}>삭제</button>
    </>
  );
}

export default Greeting;
