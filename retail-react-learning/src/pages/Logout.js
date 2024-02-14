import { redirect } from 'react-router-dom';

export function action() {
  localStorage.removeItem('jwtauthtoken');
  localStorage.removeItem('email');
  return redirect('/');
}