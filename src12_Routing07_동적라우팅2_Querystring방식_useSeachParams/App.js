import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';
import Products from './components/Products';
import RootLayout from './pages/Root';
import ErrorPage from './components/ErrorPage';
import ProductDetail from './components/ProductDetail';

//라우팅 기능
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      { path: '', element: <Home /> },
      { path: 'products', element: <Products /> },
      { path: 'products2', element: <ProductDetail /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
