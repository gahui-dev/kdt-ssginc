import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';
import Products from './components/Products';
import RootLayout from './pages/Root';

//라우팅 기능
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      { path: '', element: <Home /> },
      { path: 'products', element: <Products /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
