'use strict';

var React = require('react/addons');
var belle = require('belle');
var Input = belle.TextInput;
var Button = belle.Button;
var humane = require('humane-js');
var validations = require('scripts/validations');
var requester = require('scripts/requester');
var SessionStore = require('stores/SessionStore');
var SessionActions = require('actions/SessionActionCreators');


require('styles/Login.scss');
require('styles/humane.css');

function _validateFields(email, password) {
  var errors = [];
  if(password === null || password.length === 0) {
    errors.push('O campo \'Senha\' é obrigatório');
  } else if(password.length < 3) {
    errors.push('O campo \'Senha\' deve possuir no mínimo 3 caracteres');
  }
  if(email === null || email.length === 0) {
    errors.push('O campo \'E-mail\' é obrigatório');
  } else if(!validations.validateEmail(email)) {
    errors.push('O e-mail informado é inválido');
  }
  return errors;
}


var Login = React.createClass({

  render: function () {
    return (
      <div className="Login">
        <form id="login-form" onSubmit={this._submitForm}>
          <div className="title">Fazer login</div>
          <Input placeholder="E-mail"
            ref="email"
            style={{marginTop: '15px'}} />
          <input placeholder="Senha"
            ref="password"
            type="password"
            style={{width: '100%', marginTop: '15px'}} />
          <Button type="submit" primary style={{marginTop: '15px'}}>Entrar</Button>
        </form>
      </div>
    );
  },

  componentWillMount: function() {
    SessionStore.addChangeListener(this._onChange);
  },

  componentWillUnmount: function() {
    SessionStore.removeChangeListener(this._onChange);
  },

  _onChange: function() {
    var loginErrorMsg = SessionStore.getLoginErrorMessage();
    if(loginErrorMsg !== null) {
      humane.log(loginErrorMsg);
    } else {
      humane.log('Login realizado com sucesso');
    }
  },

  componentDidMount: function() {
    React.findDOMNode(this.refs.email).focus();
  },

  _submitForm: function(e) {
    e.preventDefault();

    var password = React.findDOMNode(this.refs.password).value.trim();
    var email = React.findDOMNode(this.refs.email).value.trim();
    var errors = _validateFields(email, password);
    if(errors.length > 0) {
      humane.log(errors);
    } else {
      console.log('asdasdasd');
      SessionActions.newSession(email, password);
    }
  }

});

module.exports = Login;

