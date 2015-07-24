'use strict';

var Dispatcher = require('../dispatcher/ClientAppDispatcher');
var Constants = require('scripts/constants');

var CandidateActionCreators = {

  sendForm: function(candidate, fnCallback) {
    Dispatcher.dispatch({
      type: Constants.CANDIDATE_SEND_FORM,
      candidate: candidate,
      callback: fnCallback
    });
  }

}

module.exports = CandidateActionCreators;
