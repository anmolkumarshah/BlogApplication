import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { login } from "../store/slices/userSlice";
import { Spinner } from "react-bootstrap";

const Login = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const dispatch = useDispatch();

    const handleLogin = (e) => {
        e.preventDefault();
        const authObj = { email, password };
        dispatch(login(authObj));
    }

    const loginState = useSelector(state => state.user)

    return (
        <div className="container d-flex justify-content-center align-items-center p-4 ">
            <div className="card w-50">
                <div className="card-body">
                    <h5 className="card-title">Welcome Back</h5>
                    <form>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input onChange={(e) => { setEmail(e.target.value) }} value={email} type="email" className="form-control" id="email" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input onChange={(e) => { setPassword(e.target.value) }} value={password} type="password" className="form-control" id="password" />
                        </div>
                        <button onClick={handleLogin} type="submit" className="btn btn-success mt-1">
                            {loginState.auth.isLoading ? <Spinner /> : "Login"}
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Login;