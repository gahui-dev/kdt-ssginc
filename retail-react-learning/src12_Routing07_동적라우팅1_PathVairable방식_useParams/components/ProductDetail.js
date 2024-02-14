import { useParams } from 'react-router-dom';

function ProductDetail() {
  const params = useParams();
  console.log(params);

  return (
    <div>
      <h2>상품상세보기</h2>
      선택상품:{params.prod_id}
    </div>
  );
}

export default ProductDetail;
