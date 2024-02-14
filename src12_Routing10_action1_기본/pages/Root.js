import { Outlet, useNavigation } from 'react-router-dom';
import MainNavigation from './MainNavigation';

export default function RootLayout() {
  const navigation = useNavigation();

  return (
    <div>
      <MainNavigation />
      <hr />
      {navigation.state === 'loading' && <p>로딩중입니다....</p>}
      <Outlet />
    </div>
  );
}
