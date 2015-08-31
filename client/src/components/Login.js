'use strict';

var React = require('react/addons');
var belle = require('belle');
var Input = belle.TextInput;
var Button = belle.Button;
var humane = require('humane-js');
var validations = require('scripts/validations');
var requester = require('scripts/requester');


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

  componentDidMount: function() {
    React.findDOMNode(this.refs.email).focus();
  },

  _submitForm: function(e) {
    console.log('_submitForm');
    e.preventDefault();

    var password = React.findDOMNode(this.refs.password).value.trim();
    var email = React.findDOMNode(this.refs.email).value.trim();
    var errors = _validateFields(email, password);
    if(errors.length > 0) {
      humane.log(errors);
    } else {
      var params = {password: password, email: email};
      requester.new('post', 'session/login', params).then(function(response) {
        // console.log('Tudo certo %o', response);
        humane.log('Login realizado com sucesso');
      }.bind(this)).catch(function (response) {
        // console.log('Erro no servidor remoto %o', response);
        switch (response.status) {
          case 404:
            humane.log('Nenhum registro foi encontrado com o e-mail informado');
            break;
          case 403:
            humane.log('A senha informada é inválida');
            break;
          default:
            humane.log('Desculpe-nos mas parece que nossos servidores estão com problemas :(');
        }
      });
    }
  }

});

module.exports = Login;

