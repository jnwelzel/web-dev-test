'use strict';

var request = require('scripts/requester');

module.exports = {

  authenticateUser: function(email, password, callbackFn) {
    var params = {email: email, password: password};
    request.new('post', 'session/login', params, false).then(function(response) {
      callbackFn({
        success: true,
        candidate: response.data.candidate,
        jwt: response.data.jwt
      });
    }).catch(function (response) {
      var message;
      switch (response.status) {
        case 404:
          message = 'Nenhum registro foi encontrado com o e-mail informado';
          break;
        case 403:
          message = 'A senha informada é inválida';
          break;
        default:
          message = 'Desculpe-nos mas parece que nossos servidores estão com problemas :(';
      }

      callbackFn({
        success: false,
        message: message
      });
    });
  }

};
