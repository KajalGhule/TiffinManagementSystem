import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import NavUser from '../../../Components/navUser'
import config from '../../../config'

const EditUser = () => {
  const [edit, setEdit] = useState([])
  const [user, setUser] = useState([])

  const [userId, setUserId] = useState('')
  const [userName, setUserName] = useState(user.userName)
  const [email, setEmail] = useState(user.email)
  const [phone, setPhone] = useState(user.phone)
  const [role, setRole] = useState('')
  const [aadharNo, setAadharNo] = useState('user.aadharNo')

  const navigate = useNavigate()
  const id = localStorage['id']
  const loadUser = () => {
    const url = config.serverURL+`/user/${id}`

    axios
      .get(url, {
        headers: { Authorization: `Bearer ${localStorage['jwt']}` },
      })
      .then((response) => {
        const result = response.data
        if (result['status'] === 'success') {
          setUser(result['data'])
          console.log(result['data'])
          setUserId(result.data.userId)
          setUserName(result.data.userName)
          setPhone(result.data.phone)
          setRole(result.data.role)
          setAadharNo(result.data.aadharNo)
          setEmail(result.data.email)
        }
      })
  }

  const editUser = () => {
    const url = config.serverURL+`/user/edit`

    const body = {
      userId,
      userName,
      email,
      phone,
      aadharNo,
    }
    if(phone.length!=10){
      toast.error("please enter 10 digit phone no")
    }else if(aadharNo.length!=12){
      toast.error("please enter 12 digit Aadhar no")
    }else{
    axios
      .put(url, body, {
        headers: { Authorization: `Bearer ${localStorage['jwt']}` },
      })
      .then((response) => {
        const result = response.data
        if (result['status'] === 'success') {
          setEdit(result['data'])
          console.log(result['data'])
          navigate('/userProfile')
        }
      })
    }
  }

  useEffect(() => {
    loadUser()
  }, [])

  return (
    <div>
      <NavUser></NavUser>
      <div class='container'>
        <div class='row'>
          <div class='col'>
            <br />
            <br />
            <br />

            <table
              class='table table-dark table-striped'
              style={{ textAlign: 'center', height: '115%' }}>
              <tbody>
                <tr>
                  <td>User ID</td>
                  <td>
                    {' '}
                    <input
                      type='number'
                      readOnly='readOnly'
                      value={user.userId}></input>
                  </td>
                </tr>
                <tr>
                  <td>Username</td>
                  <td>
                    {' '}
                    <input
                      type='text'
                      onChange={(e) => {
                        setUserName(e.target.value)
                      }}
                      value={userName}></input>
                  </td>
                </tr>
                <tr>
                  <td>Email Address</td>
                  <td>
                    <input
                      type='text'
                      onChange={(e) => {
                        setEmail(e.target.value)
                      }}
                      value={email}></input>
                  </td>
                </tr>
                <tr>
                  <td>Phone</td>
                  <td>
                    <input
                      type='text'
                      maxLength={10}
                      minLength={10}
                      onChange={(e) => {
                        setPhone(e.target.value)
                      }}
                      value={phone}></input>
                  </td>
                </tr>
                <tr>
                  <td>Aadhar Number</td>
                  <td>
                    {' '}
                    <input
                      type='text'
                      maxLength={12}
                      minLength={12}
                      required=''
                      onChange={(e) => {
                        setAadharNo(e.target.value)
                      }}
                      value={aadharNo}></input>
                  </td>
                </tr>
              </tbody>
            </table>
            <div className='mb-3' style={{ textAlign: 'center' }}>
              <button
                onClick={editUser}
                className='btn btn-success float-center'>
                Save
              </button>
              <Link style={{ paddingLeft: 30 }} to='/userProfile'>
                <button className='btn btn-danger float-center'>Back</button>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default EditUser
