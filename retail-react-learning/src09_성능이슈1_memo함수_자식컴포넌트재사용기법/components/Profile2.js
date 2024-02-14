import { memo } from 'react';

const Profile2 = memo(({ xxx }) => {
  console.log('Profile2');
  return <>Profile2값:{xxx}</>;
});
const Profile3 = memo(function ({ xxx }) {
  console.log('Profile2');
  return <>Profile2값:{xxx}</>;
});

export default Profile2;
