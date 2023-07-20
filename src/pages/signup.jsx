import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { signup } from "../store/slices/userSlice";

const Signup = () => {

    const [email, setEmail] = useState("");
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");

    const dispatch = useDispatch();

    const signupState = useSelector(state => state.user)

    const handleSignup = (e) => {
        e.preventDefault();
        const obj = { email, name, password };
        dispatch(signup(obj));
    }

    return (
        <div className="container d-flex justify-content-center align-items-center p-4 ">
            <div className="card w-50">
                <div className="card-body">
                    <h5 className="card-title">Create New Account</h5>
                    <form>
                        <div className="form-group">
                            <label htmlFor="name">Name</label>
                            <input onChange={(e) => { setName(e.target.value) }} value={name} type="text" className="form-control" id="name" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input onChange={(e) => { setEmail(e.target.value) }} value={email} type="email" className="form-control" id="email" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input onChange={(e) => { setPassword(e.target.value) }} value={password} type="text" className="form-control" id="password" />
                        </div>
                        <button onClick={handleSignup} type="submit" className="btn btn-primary mt-1">Sign Up</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Signup;