'use strict';

describe('SessionStore', () => {
  let store;

  beforeEach(() => {
    store = require('stores/SessionStore.js');
  });

  it('should be defined', () => {
    expect(store).toBeDefined();
  });
});
