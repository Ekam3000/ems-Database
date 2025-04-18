import axios from "axios";// in order to make Rest APIs
// calls in a react application we have to use third party
// library. we are using xios for this

const REST_API_BASE_URL = import.meta.env.VITE_API_BASE_URL;
console.log('VITE_API_BASE_URL:', import.meta.env.VITE_API_BASE_URL);

export const listEmployees = () => axios.get(REST_API_BASE_URL);// called from ListEmployeeComponent

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL,employee); // called from EmployeeComponent

export const getEmployee = (employeeId) => axios.get(`${REST_API_BASE_URL}/${employeeId}`); // called from EmployeeComponent

export const updateEmployee = (employeeId,employee) => axios.put(`${REST_API_BASE_URL}/${employeeId}`, employee); // called from EmployeeComponent

export const deleteEmployee = (employeeId) => axios.delete(`${REST_API_BASE_URL}/${employeeId}`); // called from ListEmployeeComponent
