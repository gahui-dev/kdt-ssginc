import { useRouteError } from 'react-router-dom';
import MainNavigation from '../pages/MainNavigation';

function ErrorPage() {
  const error = useRouteError();
  console.log('error:', error);
  // App.js에서 다양한 예외가 발생되어 전달될 것이다.
  /// 따라서 status로 비교해서 적절한 예외메시지 츨력한다.
  let title = '예외입니다';
  let message = '예외입니다';
  if (error.status == 500) {
    message = '500 예외입니다';
  }
  if (error.status == 404) {
    message = '404 예외입니다';
  }
  return (
    <div>
      <MainNavigation />
      <hr />
      <h1>{title}</h1>
      <p>{error.data.message}</p>
    </div>
  );
}

export default ErrorPage;
