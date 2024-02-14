import { NavLink } from 'react-router-dom';

import classes from './MainNavigation.module.css';

export default function MainNavigation() {
  return (
    <div>
      <NavLink
        to='/'
        className={({ isActive }) => (isActive ? classes.menu : undefined)}
      >
        Home
      </NavLink>
      <br />
      <NavLink
        to='/products'
        className={({ isActive }) => (isActive ? classes.menu : undefined)}
      >
        products
      </NavLink>
      <br />

      <NavLink
        to='/users'
        className={({ isActive }) => (isActive ? classes.menu : undefined)}
      >
        users
      </NavLink>
    </div>
  );
}
