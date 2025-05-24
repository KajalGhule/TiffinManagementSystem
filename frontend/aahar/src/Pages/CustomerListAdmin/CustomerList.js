import axios from "axios"
import { useEffect } from "react"
import { useState } from "react"
import config from "../../config"
import CustomerList from "../../Components/CustomerList"
import NavAdmin from '../../Components/navAdmin'

const CustomerListAdmin=()=>{

    const [users,setUsers]=useState([])
    
    const getAllCustomers=()=>{
        const url=config.serverURL+'/admin/CustomerList'
        axios.get(url,{headers:{Authorization:`Bearer ${localStorage['jwt']}`}})
        .then((response)=>{

            const result=response.data
            if(result['status']=='success'){
                setUsers(result['data'])
            }
        })
    }

    useEffect(()=>{
        if(localStorage['loginStatus']==1){
            getAllCustomers()
        }
    },[])


    return(
        <div>
            <NavAdmin></NavAdmin>
            <h1 style={{textAlign:'center',color:'white',marginTop:'10'}}>
                Customer List
            </h1>
            <br/>
            <br/>
            <div className='row'>
                <div className='col '></div>
                <div className='col-10'>
                    <table className="table table-dark table-striped">
                        <thead className="table-primary"
                        style={{background:'grey',color:'white'}}>
                        <th>UserId</th>
                        <th>UserName</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Adhar</th>
                        <th>Delete</th>
                        </thead>
                        <tbody>
                            {users.map((user)=>{
                                return(
                                    <CustomerList user={user} getAllCustomers={getAllCustomers}/>
                                    )
                            })}
                        </tbody>
                    </table>
                </div>
                <div class='col'></div>
            </div>
            <br/>
            <br/>
            <br/>
        </div>
    )

}

export default CustomerListAdmin