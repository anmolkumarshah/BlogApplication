import reactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import Login from "./pages/login";
import { RouterProvider, createBrowserRouter } from "react-router-dom";

import Signup from "./pages/signup";
import { Provider } from "react-redux";
import store from "./store/store";

const AppLayout = () => {
  return <h1>AA</h1>;
};

const router = createBrowserRouter([
  { path: "/login", element: <Login /> },
  { path: "/signup", element: <Signup /> },
  { path: "/", element: <AppLayout /> },
]);

const root = reactDOM.createRoot(document.getElementById("root"));
root.render(
  <Provider store={store}>
    <RouterProvider router={router} />
  </Provider>
);
