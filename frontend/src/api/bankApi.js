import axios from 'axios';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080';
const API_URL = `${API_BASE_URL}/api/customers`;

export const bankApi = {
  register: async (customerData) => {
    const response = await axios.post(`${API_URL}/register`, customerData);
    return response.data;
  },
  
  login: async (email, pin) => {
    const response = await axios.post(`${API_URL}/login`, null, {
      params: { email, pin }
    });
    return response.data;
  },

  getBalance: async (accountNumber) => {
    const response = await axios.get(`${API_URL}/${accountNumber}/balance`);
    return response.data;
  },

  getStatement: async (accountNumber) => {
    const response = await axios.get(`${API_URL}/${accountNumber}/statement`);
    return response.data;
  },

  credit: async (accountNumber, amount) => {
    const response = await axios.post(`${API_URL}/${accountNumber}/credit`, null, {
      params: { amount }
    });
    return response.data;
  },

  debit: async (accountNumber, amount) => {
    const response = await axios.post(`${API_URL}/${accountNumber}/debit`, null, {
      params: { amount }
    });
    return response.data;
  },

  transfer: async (accountNumber, toAccount, amount) => {
    const response = await axios.post(`${API_URL}/${accountNumber}/transfer`, null, {
      params: { toAccount, amount }
    });
    return response.data;
  }
};
