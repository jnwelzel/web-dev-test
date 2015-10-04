'use strict';

var Dispatcher = require('../dispatcher/ClientAppDispatcher');
var ActionTypes = require('scripts/constants');
var API = require('scripts/WebApiUtils');

var SessionActionCreators = {

  newSession: function(email, password) {
    API.authenticateUser(email, password, function(resp) {
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
  },

  closeSession: function() {
    // TODO
  },

  showAllSessions: function() {
    API.getAllSessions(function(response) {
      var dispatchObj = { type: ActionTypes.SESSIONS_LIST };
      if(response.success) {
        dispatchObj.sessions = response.sessions;
      } else {
        dispatchObj.sessions = [];
      }

      Dispatcher.dispatch(dispatchObj);
    });
  }

};

module.exports = SessionActionCreators;
