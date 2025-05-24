import axios from 'axios'
import DeliveredOrderList from '../../Components/DeliveredOrderList'
import { useEffect, useState } from 'react'
import NavAdmin from '../../Components/navAdmin'
import config from '../../config'

const DeliveredOrders = () => {
  const [Orders, setdayWiseorder] = useState([])
  const Assignorders = () => {
    const url = config.serverURL+`/daywiseOrder/ListOfDelivered`
    axios
      .post(
        url,
        {},
        {
          headers: { Authorization: `Bearer ${localStorage['jwt']}` },
        }
      )
      .then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          // navigate('/home')
          console.log()
          setdayWiseorder(result['data'])
        } else {
          alert(result.error)
        }
      })
  }

  useEffect(() => {
    Assignorders()
  },[])

  return (
    <div>
      <NavAdmin></NavAdmin>
      <h1 style={{ textAlign: 'center',color:'white' }}>Orders List</h1>
      <br />
      <br />
      <div class='row'>
        <div class='col'></div>
        <div class='col-10'>
          <table class='table  table-dark table-striped' style={{border:10}}>
            <thead class='table-primary'>
              <th>userName</th>
              <th>user_address</th>
              <th>Area</th>
              <th>City</th>
              <th>Pincode</th>
              <th>OrderId</th>
            </thead>
            <tbody>
              {Orders.map((order) => {
                return <DeliveredOrderList order={order} />
              })}
            </tbody>
          </table>
        </div>
        <div class='col'></div>
      </div>
    </div>
  )
}
export default DeliveredOrders
