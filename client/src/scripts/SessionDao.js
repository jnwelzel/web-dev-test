'use strict';

var cookies = require('scripts/cookies');

var SessionDao = {

  isLoggedIn: function() {
    return !!cookies.getItem('user');
  },

  getUser: function() {
    return !!cookies.getItem('user') ? JSON.parse(cookies.getItem('user')) : null;
  },

  setUser: function(user) {
    cookies.setItem('user', JSON.stringify(user), Infinity);
  },

  setToken: function(token) {
    cookies.setItem('token', token, Infinity);
  },

  getToken: function() {
    return !!cookies.getItem('token') ? cookies.getItem('token') : null;
  }

};

module.exports = SessionDao;
