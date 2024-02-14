import Cart from './Cart';
import { useRef } from 'react';

function CartModel({ onCartAdd }) {
  const x = useRef();

  return (
    <>
      값:
      <input ref={x} />
      <button onClick={() => onCartAdd(x.current.value)}>cart저장</button>
      <Cart />
    </>
  );
}

export default CartModel;
