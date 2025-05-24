
import NavUser from '../../Components/navUser'

const Customer = () => {
  

    return (
      <div>
        <NavUser></NavUser>
        <h1 style={style.sample}>
          Welcome to Customer page
        </h1>
      </div>
    )
  }
  
  const style={
    sample:{
      color: 'white',
    }
  }
  export default Customer;