import { useState, useReducer } from 'react';
import Greeting from './Greeting';

import { UserContext } from '../score/user-context.js';

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

  function handleChange(event) {
    setItem(event.target.value);
  }

  console.log('Profile 생성');
  return (
    <UserContext.Provider value={[dispatch, item]}>
      <>
        <input
          type='text'
          value={item}
          onChange={handleChange}
        />
        <br />
        <Greeting />
        <br />
        <br />
        {itemList}
      </>
    </UserContext.Provider>
  );
}

export default Profile;
