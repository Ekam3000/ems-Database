import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import Footer from './components/Footer'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
function App() {
  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
    {/* when https://localhost:3000 hits */}
    <Route path='/' element={<ListEmployeeComponent/>}></Route>
    {/*  https://localhost:3000/employees */}
    <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
    {/*  https://localhost:3000/add-employee */}
    <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
     {/*  https://localhost:3000/edit-employee/1 */}
     <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
    </Routes>
    <Footer/>
    </BrowserRouter>
    </>
  )
}

export default App
