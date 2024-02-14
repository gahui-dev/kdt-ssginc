import { Outlet } from 'react-router-dom';
import UsersNavigation from './UsersNavigation.js';

export default function UsersRootLayout() {
  return (
    <div>
      <UsersNavigation />
      <hr />
      <Outlet />
    </div>
  );
}
