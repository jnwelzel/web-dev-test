'use strict';

var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
var ClientAppDispatcher = require('../dispatcher/ClientAppDispatcher');
var Constants = require('scripts/constants');

var CHANGE_EVENT = 'change';

var CandidateStore = assign({}, EventEmitter.prototype, {

  emitChange: function() {
    this.emit(CHANGE_EVENT);
  },

  addChangeListener: function(callback) {
    this.on(CHANGE_EVENT, callback);
  },

  removeChangeListener: function(callback) {
    this.removeListener(CHANGE_EVENT, callback);
  }

});

CandidateStore.dispatchToken = ClientAppDispatcher.register(function(action) {

  switch(action.type) {

    case Constants.CANDIDATE_SEND_FORM:
      break;

    default:
  }

});

module.exports = CandidateStore;
