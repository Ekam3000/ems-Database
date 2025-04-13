import React, { useState,useEffect } from "react";
import { createEmployee } from "../services/EmployeeService";
import { useNavigate,useParams } from "react-router-dom";
import { getEmployee, updateEmployee } from '../services/EmployeeService';

const EmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setlastName] = useState("");
  const [email, setEmail] = useState("");
  const [errors, setErrors] = useState({});
  const {id} = useParams();
  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployee(id)
        .then((response) => {
          setFirstName(response.data.firstName);
          setlastName(response.data.lastName);
          setEmail(response.data.email);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function validateForm() {
    const newErrors = {};

    if (!firstName.trim()) {
      newErrors.firstName = "First name is required";
    } else if (!/^[A-Za-z ]+$/.test(firstName)) {
      newErrors.firstName =
        "First name can contain only english alphabets and spaces";
    }

    if (!lastName.trim()) {
      newErrors.lastName = "Last name is required";
    } else if (!/^[A-Za-z ]+$/.test(lastName)) {
      newErrors.lastName =
        "Last name can contain only english alphabets and spaces";
    }

    if (!email.trim()) {
      newErrors.email = "Email is required";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  }

  function saveOrUpdateEmployee(e) {
    e.preventDefault();
    if (!validateForm()) return;

    const employee = { firstName, lastName, email };
    console.log(employee);

    if(id){
      updateEmployee(id,employee).then((response)=>{
        console.log(response.data);
        navigator('/employees');
      }).catch((error) => {
        console.error(error);
      })
    }else{
      createEmployee(employee)
      .then((response) => {
        console.log(response.data);
        navigator("/employees"); // calls App.jsx route
      })
      .catch((error) => {
        console.log(error);
      });
    }
  }

  function pageTitle(){
    if(id){
     return <h2 className="text-center">Update Employee</h2>
    }else{
      return <h2 className="text-center">Add Employee</h2>
    }
  }
  return (
    <div>
      <div className="container">
        <br />
        <br />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {
              pageTitle()
            }
            <div className="card-body">
              <div className="form-body mb-2">
                <label className="form-label">First Name</label>
                <input
                  type="text"
                  placeholder="Enter Employee First Name"
                  name="firstName"
                  value={firstName}
                  className={`form-control ${
                    errors.firstName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setFirstName(e.target.value)}
                />
                {errors.firstName && (
                  <div className="text-danger">{errors.firstName}</div>
                )}
              </div>

              <div className="form-body mb-2">
                <label className="form-label">Last Name</label>
                <input
                  type="text"
                  placeholder="Enter Employee Last Name"
                  name="lastName"
                  value={lastName}
                  className={`form-control ${
                    errors.lastName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setlastName(e.target.value)}
                />
                {errors.lastName && (
                  <div className="text-danger">{errors.lastName}</div>
                )}
              </div>

              <div className="form-body mb-2">
                <label className="form-label">Email Id</label>
                <input
                  type="text"
                  placeholder="Enter Employee Email Id"
                  name="email"
                  value={email}
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {errors.email && (
                  <div className="text-danger">{errors.email}</div>
                )}
              </div>

              <div className="d-flex justify-content-end gap-2 mt-3">
                <button
                  className="btn btn-secondary"
                  onClick={() => navigator("/employees")}
                >
                  Home
                </button>
                <button className="btn btn-success" onClick={saveOrUpdateEmployee}>
                  Submit
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
