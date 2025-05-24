
import { useState } from "react";
import config from '../../config'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { toast } from 'react-toastify'
import { textAlign } from "@mui/system";
const ForgetPass=()=>{
    const [email, setEmail] = useState('')
    const navigate = useNavigate()
    const onsubmit=()=>{
        console.log(email)
        const body = {
            email
          }
        const url = config.serverURL + `/sendotp`
        axios.post(url, body).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {   
            sessionStorage.setItem("otp", result['otp']);
            sessionStorage.setItem("email", email);
              navigate('/verifyOTP')
              toast.info('OTP send successfully')
            } else {
              toast.error(result.error)
            }
          })
    }
    
    console.log("inside forget");
    return(
        <div style={style.container}>
                <center style={{ color: 'white' , fontFamily:'cursive' }}><h1>Forget Password</h1>
                <br/>
                
                <table table-border={0} style={{width:700}}>
                   <tr>
                    <td><h1 style={{ color: 'white' }}>Email  :</h1></td>
                    <td><input type={"email"} onChange={(e) => {
                setEmail(e.target.value)
              }}></input></td>
                   </tr>
                   <tr>
                    <td colSpan={2}  style={{textAlign:"center"}}><button style={{width:100}} className="btn btn-info" onClick={onsubmit}>submit</button></td>
                   </tr>
                </table>
                </center>
        </div>
    )
}
const style = {
    container: {
      width: 700,
      height: 350,
      padding: 2,
      position: 'relative',
      top: 150,
      left: 0,
      right: 0,
      bottom: 0,
      margin: 'auto',
      borderRadius: 10,
      border: 1,
      borderColor: '#171511',
      boxShadow: '1px 1px 30px 10px #FFEEB8',
},
submit: {
    position: 'relative',
    width: '100%',
    height: 50,
    color: 'white',
    borderRadius: 10,
    border: 'none',
    marginTop: 10,
    textAlign: 'center',
  },

}
export default ForgetPass;