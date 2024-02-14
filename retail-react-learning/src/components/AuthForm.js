import {
  Form,
  Link,
  useSearchParams,
  useActionData,
  useNavigation,
} from 'react-router-dom';


function AuthForm() {
  const navigation = useNavigation();

  const [searchParams] = useSearchParams();
  const isLogin = searchParams.get('mode') === 'login';
  const isSubmitting = navigation.state === 'submitting';

  return (
    <>
      <Form method="post" >
        <h1>{isLogin ? 'Log in' : 'Create a new user'}</h1>
        {! isLogin ? null: <>
          <p>
            <label htmlFor="email">email</label>
            <input id="email" type="email" name="email" required />
          </p>
          <p>
            <label htmlFor="pwd">pwd</label>
            <input id="pwd" type="password" name="password" required />
          </p>
          </>
        }  
        {isLogin ? null: <>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div>
                <input type="text" name="name" placeholder="Name"/>
            </div>
            <div>
                <input type="text" name="username" placeholder="*Username"/>
            </div>
            <div>
                <input type="text" name="email" placeholder="*Email"/>
            </div>
            <div>
                <input type="password" name="password" placeholder="Password"/>
            </div>
            <div>
                <input type="text" name="address" placeholder="Address"/>
            </div>
            <div>
                <input type="text" name="phone" placeholder="Phone"/>
            </div>
            <div>
                <input type="text" name="website" placeholder="Website"/>
            </div>
            <div>
                <input type="text" name="company" placeholder="Company"/>
            </div>
            <div>
            <select name="role">
              <option>URER_ROLE</option>
              <option>URER_ADMIN</option>
            </select>
            </div>
        </>
       }
        
        
        <div>
          <Link to={`?mode=${isLogin ? 'signup' : 'login'}`}>
            {isLogin ? 'Create new user' : 'Login'}
          </Link>
          <button disabled={isSubmitting}>
            {isSubmitting ? 'Submitting...' : 'Save'}
          </button>
        </div>
      </Form>
    </>
  );
}

export default AuthForm;
