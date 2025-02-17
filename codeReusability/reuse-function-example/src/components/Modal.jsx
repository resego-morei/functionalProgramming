import { useEffect, useRef } from "react";
import PropTypes from 'prop-types';

function Modal(props) { 
  const ref = useRef(null);

  useEffect(() => {
    props?.isShowing? ref.current?.showModal() : ref.current?.close();
  }, [props.isShowing]);

  return (
    <dialog ref={ref}> {props.children} </dialog>
  );
};
Modal.propTypes = {
  isShowing: PropTypes.bool.isRequired,
  children: PropTypes.node
};

export default Modal;