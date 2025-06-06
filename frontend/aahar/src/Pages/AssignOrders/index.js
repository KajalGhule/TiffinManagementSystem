import axios from 'axios'
import { useEffect, useState } from 'react'
import config from '../../config'
import OrderDetails from '../../Components/OrderDetails'
import NavAdmin from '../../Components/navAdmin'

const AssignOrders = () => {
  const [Orders, setdayWiseorder] = useState([])

  const Assignorders = () => {
    const url = config.serverURL+`/daywiseOrder/ListOfPendingOrders`

    axios
      .post(url,{}, {
        headers: { Authorization: `Bearer ${localStorage['jwt']}` },
      })
      .then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          // navigate('/home')
            console.log(result['data'])
          setdayWiseorder(result['data'])
        } else {
          alert(result.error)
        }
      })
  }

  useEffect(() => {
    Assignorders()
  }, [])

  return (
    <div>
      <NavAdmin />
      <br />
      <h1 style={{ textAlign: 'center', color: 'white' }}>Orders List</h1>
      <br />
      <br />
      <div class='row'>
        <div class='col'></div>
        <div class='col-10'>
          <table class='table  table-dark table-striped'>
            <thead
              class='table-primary'
              style={{ background: 'grey', color: 'white' }}>
              <th>userName</th>
              <th>user_address</th>
              <th>Area</th>
              <th>City</th>
              <th>Pincode</th>
              <th>OrderId</th>
              <th>Assign Delivery Boy</th>
            </thead>
            <tbody>
              {Orders.map((order) => {
                return <OrderDetails order={order} />
              })}
            </tbody>
          </table>
        </div>
        <div class='col'></div>
      </div>
    </div>
  )
}
export default AssignOrders
