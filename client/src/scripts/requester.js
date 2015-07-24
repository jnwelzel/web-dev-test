'use strict';

var axios = require('axios');

var _apiUrl = 'http://localhost:8080/';

function _getApiUrl() {
  return _apiUrl;
}

var requester = {
  new: function(method, path, params) {
    var _path = path.startsWith('/') ? path.split('/')[1] : path;
    return axios({
      method: method,
      url: _getApiUrl() + _path,
      data: !!params ? params : null
    });
  }
};

module.exports = requester;
