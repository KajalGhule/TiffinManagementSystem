import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
const NavAdmin = () => {
  const navigate = useNavigate()
  const Logout = () => {
    sessionStorage['id'] = null
    console.log(sessionStorage['id'])
    sessionStorage['loginStatus'] = null
    navigate('/signin')
  }
  return (
    <div>
      <nav
        className='navbar navbar-expand-lg navbar-light bg-grey'
        style={{ backgroundColor: '#4caf95' }}>
        <Link className='nav-link' to='/Admin'>
          <h2 style={{fontFamily:'cursive',color:'black'}}>
            Admin Panel
          </h2>
        </Link>

        <button
          className='navbar-toggler'
          type='button'
          data-bs-toggle='collapse'
          data-bs-target='#navbarNav'
          aria-controls='navbarNav'
          aria-expanded='false'
          aria-label='Toggle navigation'>
          <span className='navbar-toggler-icon'></span>
        </button>
        <ul>{''}</ul>
        <div className='collapse navbar-collapse' id='navbarNav'>
          <ul class='navbar-nav'>
            <li className='nav-item'>
              <Link
                className='nav-link'
                to='/DeliveryBoyManagement'
                style={{ color: 'wheat' }}>
                Delivery boy management
              </Link>
            </li>
            <li className='nav-item'>
              <Link
                className='nav-link'
                to='/CustomerListAdmin'
                style={{ color: 'wheat' }}>
                Customers List
              </Link>
            </li>
            <li className='nav-item'>
              <Link
                className='nav-link '
                to='/AdminTiffin'
                style={{ color: 'wheat' }}>
                Tiffin Management
              </Link>
            </li>
            <li className='nav-item'>
              <Link
                className='nav-link '
                to='/AdminDeliveryAddrees'
                style={{ color: 'wheat' }}>
                Delivery Address Management
              </Link>
            </li>
          </ul>
        </div>

        <ul>
          <button
            type='submit'
            style={{ width: 100 }}
            onClick={Logout}
            className='btn btn-danger'>
            Logout
          </button>
        </ul>
        <ul>{''}</ul>
      </nav>
    </div>
  )
}

export default NavAdmin
