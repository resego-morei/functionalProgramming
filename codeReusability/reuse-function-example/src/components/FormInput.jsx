import { useState } from "react";
import PropTypes from 'prop-types';

const inputStyle = {
  padding: '8px',
  border: '1px solid #ccc',
  borderRadius: '4px',
  color: '#333',
  backgroundColor: '#fff',
  width: '250px',
  display: 'block',
};

function FormInput(props) {
  const [inputType] = useState(props.type);
  const [inputValue, setInputValue] = useState('');

  function handleChange(event) {
    const newValue = event.target.value
    setInputValue(newValue);
    if (props.onChange) props.onChange(newValue);
  };

  return (
    <>
      <span>{props?.title? props.title : "Untitled input"}: &nbsp; </span>
      <input
        type={inputType}
        value={inputValue}
        name="input-form"
        onChange={handleChange}
        placeholder={props?.placeholder}
        autoComplete={props?.autocomplete ? props.autocomplete : "off"}
        style={inputStyle} />
      <br />
    </>
  );
};
FormInput.propTypes = {
  type: PropTypes.string.isRequired,
  title: PropTypes.string,
  placeholder: PropTypes.string,
  autocomplete: PropTypes.string,
  onChange: PropTypes.func,
};

export default FormInput;