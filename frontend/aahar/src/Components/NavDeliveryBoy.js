import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
const NavDeliveryBoy = () => {
  const navigate = useNavigate()
  const Logout = () => {
    sessionStorage['id'] = null
    console.log(sessionStorage['id'])
    sessionStorage['loginStatus'] = null
    navigate('/signin')
  }
  return (
    <nav
      className='navbar navbar-expand-lg navbar-light bg-grey'
      style={{ backgroundColor: '#4caf95' }}>
      <a
        className='navbar-brand'
        href='/Delivery'
        style={{ fontWeight: 'bold', color: 'white' }}>
        {' '}
        <h2>Annapurna</h2>
      </a>
      <button
        className='navbar-toggler'
        type='button'
        data-bs-toggle='collapse'
        data-bs-target='#navbarSupportedContent'
        aria-controls='navbarSupportedContent'
        aria-expanded='false'
        aria-label='Toggle navigation'>
        <span className='navbar-toggler-icon'></span>
      </button>

      <div className='collapse navbar-collapse' id='navbarSupportedContent'>
        <ul className='navbar-nav mr-auto'>
          <li className='nav-item active'>
            <Link
              className='nav-link '
              to={'/DeliveryBoyProfile'}
              style={{ color: 'wheat' }}>
              Edit Profile
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
  )
}

export default NavDeliveryBoy
