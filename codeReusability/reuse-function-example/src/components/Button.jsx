import PropTypes from 'prop-types';

function Button(props) {

  const buttonStyle = {
    border: 'none',
    borderRadius: '4px',
    fontSize: '8px',
    color: '#fff',
    backgroundColor: '#54a0ff',
    cursor: 'pointer'
  };

  if (props.size === 'lg') {
    buttonStyle.height = "40px";
    buttonStyle.fontSize = "18px";
  }else if (props.size === 'sm') {
    buttonStyle.height = "16px";
    buttonStyle.fontSize = "10px";
  }

  if (props?.variant === "warning") buttonStyle.backgroundColor = "#ff0000"
  if (props?.variant === "success") buttonStyle.backgroundColor = "#2ecc71"


  return (
    <button type={props.type} onClick={props?.onClick} style={buttonStyle}>
      {props.children}
    </button>
  );
}
Button.propTypes = {
  size: PropTypes.string,
  variant: PropTypes.string,
  type: PropTypes.string,
  onClick: PropTypes.func,
  children: PropTypes.node
};

export default Button;