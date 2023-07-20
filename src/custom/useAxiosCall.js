import axios from "axios";
import { useEffect, useState } from "react";

const useAxiosCall = (url, method, headers) => {
  const [response, setResponse] = useState(null);
  const [isError, setIsError] = useState(true);
  const [isLoading, setIsLoading] = useState(false);
};
