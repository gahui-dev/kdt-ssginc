import { forwardRef, useImperativeHandle, useRef } from 'react';

const Box = forwardRef((props, ref) => {
  //props와 ref를 따로 받음.

  const modal = useRef();

  // open 함수 노출
  useImperativeHandle(ref, () => ({ open })); // ({open}) 필수

  // 부모인 App에서 호출하고자 하는 함수
  function open() {
    //모달창을 열기 위하여
    modal.current.showModal();
  }

  return (
    <>
      <dialog ref={modal}>
        <form>
          아이디:
          <input />
          <br />
          아이디:
          <input />
          <br />
          <button>close</button>
        </form>
      </dialog>
    </>
  );
});

export default Box;
