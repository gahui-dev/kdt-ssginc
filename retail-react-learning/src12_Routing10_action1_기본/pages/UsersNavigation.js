import { NavLink } from 'react-router-dom';

import classes from './MainNavigation.module.css';

export default function UsersNavigation() {
  return (
    <div>
      <NavLink
        to='/users/all_user'
        className={({ isActive }) => (isActive ? classes.menu : undefined)}
      >
        All users
      </NavLink>
      <br />
      <NavLink
        to='/users/new_user'
        className={({ isActive }) => (isActive ? classes.menu : undefined)}
      >
        new_user
      </NavLink>
      <br />
    </div>
  );
}
