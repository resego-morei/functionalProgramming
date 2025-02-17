import { useState } from "react";
import PropTypes from 'prop-types';

const selectStyle = {
  padding: '8px',
  border: '1px solid #ccc',
  borderRadius: '4px',
  fontSize: '16px',
  color: '#333',
  backgroundColor: '#fff',
  width: '250px',
  display:'block',
};

function CustomSelect(props) {
  const [data] = useState(props.data);

  let options = data.map((item) => (
    <option key={item} value={item}>{item}</option>
  ));

  return (
    <>
      <select
        name="customSearch"
        onChange={(event) => props?.onSelectChange(event)}
        style={selectStyle}>
        <option value="">{props.title}</option>
        {options}
      </select>
      <br />
    </>
  );
}
CustomSelect.propTypes = {
  data: PropTypes.array.isRequired,
  title: PropTypes.string.isRequired,
  onSelectChange: PropTypes.func.isRequired,
};

export default CustomSelect;