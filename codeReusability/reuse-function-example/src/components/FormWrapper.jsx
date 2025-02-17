import PropTypes from 'prop-types';

const FormWrapper = (props) => {
    return (
      <form onSubmit={ event => props?.onSubmit?.({event}) }>
        <fieldset>
          <legend>{props?.title}:</legend>
          {props?.children}
        </fieldset> 
      </form>
      );
  };

FormWrapper.propTypes = {
  onSubmit: PropTypes.func,
  title: PropTypes.string,
  children: PropTypes.node
};

export default FormWrapper;