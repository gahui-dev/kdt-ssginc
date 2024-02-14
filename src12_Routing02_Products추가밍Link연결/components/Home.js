import { Link } from "react-router-dom";

function Home() {
  return (
    <div>
       <h2>Home 화면</h2>
       <Link to="/products">products가기</Link>
    </div>
  );
}

export default Home;
