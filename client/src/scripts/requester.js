'use strict';

var axios = require('axios');
var cookies = require('scripts/cookies');


function NoTokenException() {
   this.message = "Token de autenticação não encontrado. Você fez seu login?";
   this.name = "NoTokenException";
}

function _getJwt() {
  return !!cookies.getItem('token') ? cookies.getItem('token') : null;
}

function _getAuthHeader() {
  if(!_getJwt()) {
    throw new NoTokenException();
  } else {
    return {'Authorization': 'Bearer ' + _getJwt()};
  }
}

function _getApiUrl() {
  return 'http://localhost:8080/';
}

var requester = {

  new: function(method, path, params, auth) {
    var _auth = auth !== undefined ? auth : true;
    var _headers = _auth ? _getAuthHeader() : {};
    var _path = path.startsWith('/') ? path.split('/')[1] : path;
    return axios({
      method: method,
      url: _getApiUrl() + _path,
      headers: _headers,
      data: !!params ? params : null
    });
  }

};

module.exports = requester;
