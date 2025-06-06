import { Link } from 'react-router-dom'
const Navbar = () => {
  return (
    <nav
      className='navbar navbar-expand-lg navbar-light bg-grey'
      style={{ backgroundColor: '#4caf95' }}>
      <ul></ul>
      <Link
        className='navbar-brand'
        to={'/'}
        style={{ fontWeight: 'bold', height: 50, color: 'white' }}>
        <h2>Annapurna</h2>
      </Link>
      <i className='fas fa-utensils fa-2x' style={{ padding: 5 }}></i>

      <ul>{''}</ul>
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
      <div className='collapse navbar-collapse' id='navbarNav'>
        <ul className='navbar-nav me-right mb-2 mb-lg-0'>
          <li className='nav-item'>
            <Link className='nav-link' to='/Signin' style={{ color: 'wheat' }}>
              Signin
            </Link>
          </li>
        </ul>
      </div>

      <ul className='navbar-nav me-right mb-2 mb-lg-0'>
        <li>
          <Link className='nav-link' to='/signup' style={{ color: 'wheat' }}>
            <i class='bi bi-solid bi-person-circle'></i> Register Here
          </Link>
        </li>

        <ul>{''}</ul>
      </ul>
    </nav>
  )
}

export default Navbar
