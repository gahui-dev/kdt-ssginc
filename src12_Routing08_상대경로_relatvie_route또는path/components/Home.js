import { Link, useNavigate } from 'react-router-dom';

function Home() {
  const navigate = useNavigate();

  function handleEvent() {
    navigate('/products');
  }

  return (
    <div>
      <h2>Home 화면</h2>
      <Link to='/products'>products가기1</Link>
      <br />
      <button onClick={handleEvent}>products가기2</button>
    </div>
  );
}

export default Home;
