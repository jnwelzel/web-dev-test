'use strict';

describe('Candidates', function () {
  var React = require('react/addons');
  var Candidates, component;

  beforeEach(function () {
    Candidates = require('components/Candidates.js');
    component = React.createElement(Candidates);
  });

  it('should create a new instance of Candidates', function () {
    expect(component).toBeDefined();
  });
});
