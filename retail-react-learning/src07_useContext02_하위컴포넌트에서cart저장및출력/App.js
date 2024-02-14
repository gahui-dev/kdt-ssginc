import CartModel from './components/CartModel.js';
import { useState } from 'react';
import { UserContext } from './store/user-context.js';

function App() {
  const [shoppingCart, setShoppingCart] = useState([]);

  function handleAdd(v) {
    setShoppingCart([...shoppingCart, v]);
  }
  return (
    <>
      <UserContext.Provider value={shoppingCart}>
        <CartModel onCartAdd={handleAdd} />
      </UserContext.Provider>
    </>
  );
}

export default App;
