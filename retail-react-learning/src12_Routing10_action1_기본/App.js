import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';
import Products from './components/Products';
import RootLayout from './pages/Root';
import ErrorPage from './components/ErrorPage';
import ProductDetail from './components/ProductDetail';
import UsersPage, { loader as UsersLoader } from './components/UsersPage';
import UsersRootLayout from './pages/UsersRoot';
import NewUserPage, { action as NewUserAction } from './components/NewUserPage';

//라우팅 기능
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    id: 'root',
    loader: async function () {
      console.log('UsersPage.loader');
      const response = await fetch(' https://reqres.in/api/users?page=1');
      const resData = await response.json();
      return resData.data;
    },
    errorElement: <ErrorPage />,
    children: [
      { path: '', element: <Home /> },
      { path: 'products', element: <Products /> },
      { path: 'products/:prod_id', element: <ProductDetail /> },

      {
        path: 'users',
        element: <UsersRootLayout />,
        children: [
          { path: 'all_user', element: <UsersPage />, loader: UsersLoader },
          { path: 'new_user', element: <NewUserPage />, action: NewUserAction },
        ],
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
