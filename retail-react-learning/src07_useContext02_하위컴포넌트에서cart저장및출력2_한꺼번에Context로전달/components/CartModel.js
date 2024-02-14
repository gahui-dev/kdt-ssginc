import Cart from './Cart';
import { useRef, useContext } from 'react';
import { UserContext } from '../store/user-context.js';
function CartModel() {
  const x = useRef();
  const { addCart } = useContext(UserContext);

  return (
    <>
      값:
      <input ref={x} />
      <button onClick={() => addCart(x.current.value)}>cart저장</button>
      <Cart />
    </>
  );
}

export default CartModel;
