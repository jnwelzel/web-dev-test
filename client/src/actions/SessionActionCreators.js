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
          user: resp.user,
          token: resp.token
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

  destroySession: function() {
    // TODO
    API.destroyCurrentSession(function(response) {
      if(response.success) {
        var dispatchObj = {
          type: ActionTypes.SESSION_DESTROY
        };
        
        Dispatcher.dispatch(dispatchObj);
      } else {
        console.log('Erro ao fazer logout');
      }
    });
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
