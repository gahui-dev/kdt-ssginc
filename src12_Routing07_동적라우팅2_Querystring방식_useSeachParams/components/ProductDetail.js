import { useSearchParams } from 'react-router-dom';

function ProductDetail() {
  const [params] = useSearchParams();
  console.log(params);
  const prod_id = params.get('prod_id');

  return (
    <div>
      <h2>상품상세보기</h2>
      선택상품:{prod_id}
    </div>
  );
}

export default ProductDetail;
