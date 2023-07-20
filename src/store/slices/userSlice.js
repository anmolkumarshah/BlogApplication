import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const host = "http://localhost:8080";

export const login = createAsyncThunk("login", async (data) => {
  try {
    const response = await axios.post(
      host + "/auth/login",
      JSON.stringify(data),
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    return response.data;
  } catch (error) {
    return error.response.data;
  }
});

export const signup = createAsyncThunk("signup", async (data) => {
  try {
    const response = await axios.post(host + "/user", JSON.stringify(data), {
      headers: {
        "Content-Type": "application/json",
      },
    });
    return response.data;
  } catch (error) {
    return error.response.data;
  }
});

const userSlice = createSlice({
  name: "user",
  initialState: {
    signup: {
      isError: true,
      response: null,
      isLoading: false,
    },
    auth: {
      isError: true,
      response: null,
      isLoading: false,
    },
    user: {},
  },

  extraReducers: (builder) => {
    builder.addCase(signup.pending, (state, action) => {
      state.signup.isLoading = true;
    });
    builder.addCase(signup.fulfilled, (state, action) => {
      state.signup.isLoading = false;
      state.signup.isError = false;
      state.signup.response = action.payload;
    });
    builder.addCase(signup.rejected, (state, action) => {
      state.signup.isLoading = false;
      state.signup.isError = true;
    });

    //

    builder.addCase(login.pending, (state, action) => {
      state.auth.isLoading = true;
    });
    builder.addCase(login.fulfilled, (state, action) => {
      state.auth.isLoading = false;
      state.auth.isError = false;
      state.auth.response = action.payload;
    });
    builder.addCase(login.rejected, (state, action) => {
      state.auth.isLoading = false;
      state.auth.isError = true;
    });
  },
});

export default userSlice.reducer;
