import { Link } from 'react-router-dom';
// 상품목록
const PRODUCTS = [
  { id: 'p1', title: 'TV1' },
  { id: 'p2', title: 'TV2' },
  { id: 'p3', title: 'TV3' },
];

export default function Products() {
  return (
    <div>
      <h2>Products 화면</h2>
      {PRODUCTS.map((row, idx) => (
        <Link
          key={idx}
          to={`/products/${row.id}`}
        >
          {row.title}
        </Link>
      ))}
    </div>
  );
}
