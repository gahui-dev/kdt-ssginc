import { Link } from 'react-router-dom';

export default function MainNavigation() {
  return (
    <div>
      <Link to='/'>Home</Link>
      <br />
      <Link to='/products'>products</Link>
    </div>
  );
}
