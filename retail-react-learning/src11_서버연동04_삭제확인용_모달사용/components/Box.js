import { useRef, useEffect } from 'react';

export default function Box({ open, children }) {
  const dialog = useRef();

  useEffect(() => {
    if (open) {
      dialog.current.showModal();
    } else {
      dialog.current.close();
    }
  }, [open]);

  return <dialog ref={dialog}>{open ? children : null}</dialog>;
}
