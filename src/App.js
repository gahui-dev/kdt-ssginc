import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import HomePage from './pages/Home';
import SignupPage, { action as signupAction } from './pages/SignupPage.js';
import RootLayout from './pages/Root';
import ErrorPage from './pages/Error';
import AuthenticationPage, {
  action as authAction,
} from './pages/Authentication.js';
import { tokenLoader } from './util/auth';
import { action as logoutAction } from './pages/Logout.js';
import UserListPage, {
  loader as userListLoader,
} from './pages/UserListPage.js';
import UpdatePage, { loader as updateLoader } from './pages/UpdatePage.js';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    id: 'tokenRoot',
    loader: tokenLoader,
    children: [
      { index: true, element: <HomePage /> },
      { path: 'signup', element: <SignupPage /> },

      { path: 'auth', element: <AuthenticationPage />, action: authAction },
      { path: 'logout', action: logoutAction },
      { path: 'userList', element: <UserListPage />, loader: userListLoader },
      { path: 'update', element: <UpdatePage />, loader: updateLoader },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
