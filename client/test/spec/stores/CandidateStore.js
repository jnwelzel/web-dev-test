'use strict';

describe('CandidateStore', function() {
  var store;

  beforeEach(function() {
    store = require('stores/CandidateStore.js');
  });

  it('should be defined', function() {
    expect(store).toBeDefined();
  });
});
