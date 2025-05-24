import { color } from '@mui/system'

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faYoutube,
  faFacebook,
  faTwitter,
  faInstagram
} from "@fortawesome/free-brands-svg-icons";


const Footer = () => {
  return (
    <div className='container-fluid' style={sty.footer}>
      <footer className='page-footer font-small blue pt-4'>
     
        <div className='container-fluid text-center text-md-left'>
          <div className='row'>
            <div className='col-md-6 mt-md-0 mt-3'>
              <h5 className='text-uppercase'>Annapurna</h5>
              <p>
                One cannot think well, love well, sleep well, if one has not
                dined well.
              </p>
            </div>

            <hr className='clearfix w-100 d-md-none pb-3' />

            <div className='col-md-3 mb-md-0 mb-3'></div>
            <div className='col-md-3 mb-md-0 mb-3'>
              {/* <h5 className='text-uppercase'>Social Media</h5> */}
             

              <ul className='list-unstyled'>
                        <li>
                        <a href="https://www.youtube.com"
                className="youtube social">
                <FontAwesomeIcon icon={faYoutube} size="2x" />
              </a>
                        </li>
                        <li>
                        <a href="https://www.facebook.com"
                className="facebook social">
                <FontAwesomeIcon icon={faFacebook} size="2x" />
              </a>
                        </li>
                        <li>
                        <a href="https://www.twitter.com" className="twitter social">
                <FontAwesomeIcon icon={faTwitter} size="2x" />
              </a>
                        </li>
                        <li>
                        <a href="https://www.instagram.com"
                className="instagram social">
                <FontAwesomeIcon icon={faInstagram} size="2x" />
              </a>
                        </li>
                      </ul>
                    </div>
          </div>
        </div>
      </footer>
   
      </div>
  )
}

const sty = {
  footer: {
    position: 'relative',
    color: 'white',
    backgroundColor: '#4caf95',
    bottom: 0,
    right: 0,
    textAlign: 'center',
    width: '100%',
  },
}
export default Footer
