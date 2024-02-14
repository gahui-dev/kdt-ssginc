import { useParams, Link } from 'react-router-dom';

function ProductDetail() {
  const params = useParams();
  console.log(params);

  return (
    <div>
      <h2>상품상세보기</h2>
      선택상품:{params.prod_id}
      <h2>상대경로 실습</h2>
      <Link
        to='..'
        relative='route'
      >
        back(route)
      </Link>
      <br />
      <Link
        to='..'
        relative='path'
      >
        back(path)
      </Link>
    </div>
  );
}

export default ProductDetail;
