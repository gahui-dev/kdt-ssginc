import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';
import Products from './components/Products';
import RootLayout from './pages/Root';
import ErrorPage from './components/ErrorPage';
import ProductDetail from './components/ProductDetail';
import UsersPage from './components/UsersPage';

//라우팅 기능
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { path: '', element: <Home /> },
      { path: 'products', element: <Products /> },
      { path: 'products/:prod_id', element: <ProductDetail /> },

      {
        path: 'users',
        element: <UsersPage />,
        loader: async function () {
          console.log('UsersPage.loader');

          const response = await fetch(' https://reqres.in/api/users?page=2');
          const resData = await response.json();

          return resData.data;
        },
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
