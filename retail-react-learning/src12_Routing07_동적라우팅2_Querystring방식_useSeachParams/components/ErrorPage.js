import MainNavigation from '../pages/MainNavigation';

function ErrorPage() {
  return (
    <div>
      <MainNavigation />
      <hr />
      <h2>예외발생</h2>
      <p>존재하지 않는 페이지입니다.</p>
    </div>
  );
}

export default ErrorPage;
