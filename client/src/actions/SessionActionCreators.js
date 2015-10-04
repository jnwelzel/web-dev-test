'use strict';

var Dispatcher = require('../dispatcher/ClientAppDispatcher');
var ActionTypes = require('scripts/constants');
var Api = require('scripts/WebApiUtils');

var SessionActionCreators = {

  newSession: function(email, password) {
    Api.authenticateUser(email, password, function(resp) {
      var dispatchObj;
      if(resp.success) {
        dispatchObj = {
          type: ActionTypes.LOGIN_SUCCESSFUL,
          candidate: resp.candidate,
          jwt: resp.jwt
        };
      } else {
        dispatchObj = {
          type: ActionTypes.LOGIN_ERROR,
          message: resp.message
        };
      }

      Dispatcher.dispatch(dispatchObj);
    });
  }

};

module.exports = SessionActionCreators;
