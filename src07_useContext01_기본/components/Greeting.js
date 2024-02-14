import { UserContext } from '../store/user-context.js';
import { useContext } from 'react';
function Greeting() {
  const username = useContext(UserContext);

  return (
    <>
      <p>{username}</p>
    </>
  );
}

export default Greeting;
