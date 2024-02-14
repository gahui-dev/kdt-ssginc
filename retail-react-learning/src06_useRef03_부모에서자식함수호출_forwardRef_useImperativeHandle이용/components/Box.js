import { forwardRef, useImperativeHandle } from 'react';

const Box = forwardRef((props, ref) => {
  //props와 ref를 따로 받음.

  // open 함수 노출
  useImperativeHandle(ref, () => ({ open })); // ({open}) 필수

  // 부모인 App에서 호출하고자 하는 함수
  function open() {
    console.log('Box.open');
  }

  return <></>;
});

export default Box;
