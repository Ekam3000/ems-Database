import axios from "axios";// in order to make Rest APIs
// calls in a react application we have to use third party
// library. we are using xios for this

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => axios.get(REST_API_BASE_URL);// called from ListEmployeeComponent

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL,employee); // called from EmployeeComponent

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + '/' + employeeId); // called from EmployeeComponent

export const updateEmployee = (employeeId,employee) => axios.put(REST_API_BASE_URL + '/' + employeeId, employee); // called from EmployeeComponent

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/' + employeeId); // called from ListEmployeeComponent
