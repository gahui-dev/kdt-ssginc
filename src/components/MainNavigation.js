
import { Form, NavLink, useRouteLoaderData } from "react-router-dom";

import classes from './MainNavigation.module.css'

export default function MainNavigation(){
  const token = useRouteLoaderData('tokenRoot');
  console.log("MainNavigation.token", token);
    return (
        <>
          <NavLink to="/" 
           className={({isActive})=>
            isActive? classes.menu: undefined
          }
          >Home</NavLink><br/>
       

          {!token && <NavLink 
          to="/auth?mode=login"
          className={({isActive})=>
            isActive? classes.menu: undefined
          }
          >auth</NavLink> }
          
          {token &&  <Form action="/logout" method="post">
                <button>Logout</button>
              </Form> }
          {token &&  <NavLink 
                    to="/update"
                    className={({isActive})=>
                      isActive? classes.menu: undefined
                    }
                    >update</NavLink> }
          {token &&  <NavLink 
                    to="/userList"
                    className={({isActive})=>
                      isActive? classes.menu: undefined
                    }
                    >userList</NavLink> }
        </>
    )
}
