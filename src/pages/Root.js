
import { Outlet } from "react-router-dom";
import MainNavigation from "../components/MainNavigation";

export default function RootLayout(){
    return(
        <div style={{margin:'10px'}}>
          <MainNavigation />
          <hr/>
          <main>
            <Outlet />
          </main>
        </div>
    )
}

