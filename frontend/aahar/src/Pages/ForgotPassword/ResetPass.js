import { useState } from "react";
import config from '../../config'
import axios from 'axios'
import { useNavigate } from 'react-router'
import { toast } from 'react-toastify'

const ResetPass=()=>{

    const navigate=useNavigate();
    const [password,setNewPass]=useState('')
    const [reEnterPass,setEnterPass]=useState('')


    const RequestForReset=()=>{
        let email = sessionStorage.getItem("email");
        console.log(password)
        console.log(email)
        const body={
            email,            
            password,
        }

        if(password==reEnterPass){
            console.log(body)
            const url = config.serverURL + `/resetPassword`
            axios.post(url, body).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {   
              navigate('/Signin')
              toast.info('Password changed successfully')
            } else {
              toast.error(result.error)
            }
          })
        }else{
            toast.error('Password mismatch')
        }
    }


    return(
        <div>
            <center>
            <table style={style.sample1} className="login-box h1">
            <tr>
                <td>
                    <h3 style={style.sample}>
                    Enter new Password :
                    </h3>
                </td>
                <td>
                    <input className='form-control' type={'password'}  onChange={(e) => {
                setNewPass(e.target.value)}}></input>
                </td>
            </tr>

            <tr>
                <td>
                <h3 style={style.sample}>
                    Re-enter Password  :
                    </h3>
                </td>
                <td>
                    <input className='form-control' type={'password'} onChange={(e) => {
                setEnterPass(e.target.value)}}></input>
                </td>
            </tr>
            <tr>
                <td style={style.sample2}>
                    <button className="btn btn-success" onClick={RequestForReset}>Reset</button>
                </td>
            </tr>
        </table>
        </center>
        </div>
    ) 
}

const style={
    sample:{
      color: 'white',
    },
    sample1: {
        position: 'relative',
        height: 50,
        color: 'white',
        borderRadius: 5,
        border: 'none',
        marginTop: 250,
        textAlign: 'center',
      },
      sample2:{
        textAlign:'center'
      }
  }
export default ResetPass;