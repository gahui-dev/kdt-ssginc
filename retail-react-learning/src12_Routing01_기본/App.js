import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';

//라우팅 기능
const router = createBrowserRouter([{ path: '/', element: <Home /> }]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
