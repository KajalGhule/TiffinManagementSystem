import './App.css'
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom'
import Signin from './Pages/Signin'
import Home from './Pages/Home/home'
import Signup from './Pages/signup'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import ForgetPass from './Pages/ForgotPassword'
import VerifyOtp  from './Pages/ForgotPassword/verifyOTP'
import AdminHome from './Pages/AdminHome/index'
import ResetPass from './Pages/ForgotPassword/ResetPass'
import DeliveryBoy from './Pages/Deliveryboy/deliveryboy'
import AssignOrders from './Pages/AssignOrders/index'
import ShowTiffins from './Pages/Tiffin/tiffindetails/ShowTiffin'
import CustomerListAdmin from './Pages/CustomerListAdmin/CustomerList'
import DeliveryBoyManagement from './Pages/DeliveryBoyManagement/index' 
import AddDeliveryBoy from './Pages/AddDeliveryBoy'
import AdminTiffin from './Pages/AdminTiffin'
import AddTiffin from './Pages/AddTiffin'
import TiffinDetailsData from './Pages/Tiffin/EditTiffin/TiffinDetailsData'
import EditTiffin from './Pages/Tiffin/EditTiffin/editTiffin'
import DeliveredOrders from './Pages/DeliveredOrdersAdmin/index'
import DispatchedOrders from './Pages/dispatchedOrdersAdmin/index'
import AdminDeliveryManagement from './Pages/AdminDeliveryAddrees/index'
import DeliveryAddresses from './Pages/AdminDeliveryAddrees/DeliveryAddressList'
import Address from './Pages/Tiffin/tiffindetails/address'
import Order from './Pages/Tiffin/tiffindetails/order'
import UserProfile from './Pages/Tiffin/user profile/userProfile'
import EditUser from './Pages/Tiffin/edit user/editUser'
import SetPayment from './Pages/Tiffin/userPayment/payment'
import DeliveryBoyProfile from './Pages/Tiffin/user profile/DeliveryBoyProfile'
import EditDeliveryBoy from './Pages/Tiffin/edit user/editDeliveryBoy'



function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/home' element={<Home />} />
          <Route path='/Signin' element={<Signin />} />
          <Route path='/Signup' element={<Signup />} />
          <Route path='/ForgotPassword' element={<ForgetPass />} />
          <Route path='/verifyOtp' element={<VerifyOtp />} />
          <Route path='/ResetPass' element={<ResetPass/>} />
          <Route path='/Admin' element={<AdminHome/>} />
          <Route path='/Delivery' element={<DeliveryBoy/>} />
          <Route path='/ShowTiffin' element={<ShowTiffins/>} />
          <Route path='/AssignOrders' element={<AssignOrders />} />
          <Route path='/CustomerListAdmin' element={<CustomerListAdmin />} />
          <Route path='/DeliveryBoyManagement' element={<DeliveryBoyManagement/>} />
          <Route path='/AddDeliveryBoy' element={<AddDeliveryBoy/>}></Route>
          <Route path='/AdminTiffin'element={<AdminTiffin/>}></Route>
          <Route path='/addtiffin' element={<AddTiffin/>}></Route>
          <Route path='/tiffinDetailsData' element={<TiffinDetailsData/>}></Route>
          <Route path='/editTiffin' element={<EditTiffin />}></Route>
          <Route path='/DeliveredOrders' element={<DeliveredOrders />}></Route>
          <Route path='/DispatchedOrders' element={<DispatchedOrders />}></Route>
          <Route path='/userProfile' element={<UserProfile />}></Route>
          <Route path='/payment' element={<SetPayment />}></Route>
          <Route path='/DeliveryBoyProfile' element={<DeliveryBoyProfile />}></Route>
          <Route
            path='/AdminDeliveryAddrees'
            element={<AdminDeliveryManagement />}
          />


          <Route path='/AddressList' element={<DeliveryAddresses/>}/>
          <Route path='/address' element={<Address/>}></Route>
          
          <Route path='/order' element={<Order />}></Route>
          <Route path='/editUser' element={<EditUser />}></Route>
          <Route path='/editDeliveryBoy' element={<EditDeliveryBoy />}></Route>

        </Routes>
        
              </BrowserRouter>
      <ToastContainer position='top-right' theme='colored' />
      
    </div>
  )
}

export default App
