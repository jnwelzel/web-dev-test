'use strict';

var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
var ClientAppDispatcher = require('../dispatcher/ClientAppDispatcher');
var ActionTypes = require('scripts/constants');
var cookies = require('scripts/cookies');

var CHANGE_EVENT = 'change';

function _setUser(user) {
  cookies.setItem('user', JSON.stringify(user), Infinity);
}

function _setToken(token) {
  cookies.setItem('token', token, Infinity);
}

var _loginErrorMsg = null;

var SessionStore = assign({}, EventEmitter.prototype, {

  emitChange: function() {
    this.emit(CHANGE_EVENT);
  },

  addChangeListener: function(callback) {
    this.on(CHANGE_EVENT, callback);
  },

  removeChangeListener: function(callback) {
    this.removeListener(CHANGE_EVENT, callback);
  },

  isLoggedIn: function() {
    return !!cookies.getItem('user');
  },

  getUser: function() {
    return !!cookies.getItem('user') ? JSON.parse(cookies.getItem('user')) : null;
  },

  getToken: function() {
    return !!cookies.getItem('token') ? cookies.getItem('token') : null;
  },

  getLoginErrorMessage: function() {
    console.log('getLoginErrorMessage: function()');
    return _loginErrorMsg;
  }

});

SessionStore.dispatchToken = ClientAppDispatcher.register(function(action) {

  switch(action.type) {
    case ActionTypes.LOGIN_SUCCESSFUL:
      console.log('SessionStore LOGIN_SUCCESSFUL');
      _setUser(action.user);
      _setToken(action.token);
      _loginErrorMsg = null;
      SessionStore.emitChange();
      break;

    case ActionTypes.LOGIN_ERROR:
      console.log('SessionStore LOGIN_ERROR');
      _loginErrorMsg = action.message;
      SessionStore.emitChange();
      break;

    default:
  }

});

module.exports = SessionStore;