import axios from 'axios'
import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import config from '../config'

const OrderDetails = (props) => {
  const { order } = props

  const [DeliveryBoys, setDeliveryBoys] = useState([])
  const [deliveryBoyId, setDeliveryBoyId] = useState('A')
  const GetDeliveryBoys = () => {
    const url = config.serverURL + `/admin/deliveryBoys`
    axios
      .get(url, { headers: { Authorization: `Bearer ${localStorage['jwt']}` } })
      .then((response) => {
        const result = response.data
        if (result['status'] == 'success') {
          // navigate('/home')

          setDeliveryBoys(result.data)
        } else {
          alert(result.error)
        }
      })
  }

  const selectDeliveryBoy = () => {
    const url = config.serverURL + `/daywiseOrder/dispatchOrder`
    const userId = deliveryBoyId
    const doId = order.do_id
    console.log('order Id' + doId)
    const body = {
      doId,
      userId
    }

    axios
      .post(url, body, {
        headers: { Authorization: `Bearer ${localStorage['jwt']}` },
      })
      .then((response) => {
        const result = response.data
        console.log(result)
        if (result['status'] == 'success') {
          // navigate('/home')
        } else {
          alert(result.error)
        }
      })
      toast.info("DeliveryBoy assigned successfully")

      setTimeout(function(){ 
        window. location. reload(true); 
      }, 2000);
      
  }

  useEffect(() => {
    GetDeliveryBoys()
  }, [])

  useEffect(() => {
    if (!isNaN(deliveryBoyId)) {
      selectDeliveryBoy()
    }
  }, [deliveryBoyId])

  return (
    <tr>
      <td>{order.userName}</td>
      <td>{order.user_address}</td>
      <td> {order.area}</td>
      <td>{order.city}</td>
      <td>{order.pincode}</td>
      <td> {order.orderId}</td>
      <td>
        <div class='dropdown'>
          <select
            value={deliveryBoyId}
            onChange={(e) => {
              setDeliveryBoyId(e.target.value)
            }}>
            <option selected>Select DeliveryBoy</option>
            {DeliveryBoys.map((boy) => {
              return <option value={boy.userId}>{boy.userName}</option>
            })}
          </select>
        </div>
      </td>
    </tr>
  )
}

export default OrderDetails
