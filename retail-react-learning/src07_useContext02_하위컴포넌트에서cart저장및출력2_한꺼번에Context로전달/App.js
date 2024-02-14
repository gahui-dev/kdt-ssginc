import CartModel from './components/CartModel.js';
import { useState } from 'react';
import { UserContext } from './store/user-context.js';

function App() {
  const [shoppingCart, setShoppingCart] = useState([]);

  function handleAdd(v) {
    setShoppingCart([...shoppingCart, v]);
  }

  //한번에 [] 와 handleAdd를 Context로 전달
  const ctxValue = {
    cartList: shoppingCart,
    addCart: handleAdd,
  };

  return (
    <>
      <UserContext.Provider value={ctxValue}>
        <CartModel />
      </UserContext.Provider>
    </>
  );
}

export default App;
