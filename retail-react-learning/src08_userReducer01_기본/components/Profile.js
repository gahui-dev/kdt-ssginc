import { useReducer } from 'react';

function Profile() {
  //reducer 선언
  const reducer = (state, action) => {
    switch (action.type) {
      case 'INCREMENT':
        return state + 1;
      case 'DECREMENT':
        return state - 1;
      default:
        return state;
    }
  };

  // reducer 사용
  const [num, dispatch] = useReducer(reducer, 0);

  function handleUp() {
    dispatch({ type: 'INCREMENT' });
  }
  function handleDown() {
    dispatch({ type: 'DECREMENT' });
  }
  console.log('Profile 생성');
  return (
    <>
      num:{num}
      <br />
      <button onClick={handleUp}>+</button>
      <button onClick={handleDown}>-</button>
    </>
  );
}

export default Profile;
