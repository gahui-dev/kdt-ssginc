import { useState, useReducer } from 'react';

function Profile() {
  //reducer 선언
  const reducer = (state, action) => {
    // [1,2,3] 배열에서 3을 제거하자 [1,2]
    switch (action.type) {
      case 'ADD':
        return [...state, action.xxx];
      case 'DEL':
        return [...state.filter((v, i) => v !== action.xxx)];
      default:
        return state;
    }
  };

  const [item, setItem] = useState('');
  // reducer 사용
  const [itemList, dispatch] = useReducer(reducer, []);

  function handleAdd() {
    dispatch({ type: 'ADD', xxx: item });
  }
  function handleDel() {
    dispatch({ type: 'DEL', xxx: item });
  }

  function handleChange(event) {
    setItem(event.target.value);
  }

  console.log('Profile 생성');
  return (
    <>
      <input
        type='text'
        value={item}
        onChange={handleChange}
      />
      <br />
      <button onClick={handleAdd}>추가</button>
      <button onClick={handleDel}>삭제</button>
      <br />
      {itemList}
    </>
  );
}

export default Profile;
