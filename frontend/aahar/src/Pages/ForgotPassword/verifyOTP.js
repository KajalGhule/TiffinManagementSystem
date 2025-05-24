import { useState } from "react";
import { useNavigate } from 'react-router'


const VerifyOtp=()=>{
    const navigate = useNavigate()
    const [otp,setOtp]=useState('')

    const checkOtp=()=>{
    
        console.log("inside checkotp")
        let data = sessionStorage.getItem("otp");
        console.log(data)
        console.log(otp)
        if(otp==data){
            navigate('/ResetPass')
            }

    }

    
    return(<div style={style.sample1}>
        <center>
        <table>
            <tr>
                <td>
                    <h3 style={style.sample}>
                    Enter the OTP :
                    </h3>
                </td>
                <td>
                    <input type={'text'} onChange={(e) => {setOtp(e.target.value)}}></input>
                </td>
            </tr>
            <tr>
                <td colSpan={2} style={style.sample2}>
                    <button className="btn btn-success" onClick={checkOtp}>SendOTP</button>
                </td>
            </tr>
        </table>
        </center>
    </div>)
}

const style={
    sample:{
      color: 'white',
    },
    sample1: {
        position: 'relative',
        width: '100%',
        height: 50,
        color: 'white',
        borderRadius: 5,
        border: 'none',
        marginTop: 300,
        textAlign: 'center',
      },
      sample2:{
        textAlign:'center'
      }
  }
export default VerifyOtp;
