import { UserContext } from '../store/user-context.js';
import { useContext } from 'react';
function Cart() {
  const cartList = useContext(UserContext);

  return (
    <>
      {cartList.map((row, idx) => (
        <div key={idx}>{row}</div>
      ))}
    </>
  );
}

export default Cart;
