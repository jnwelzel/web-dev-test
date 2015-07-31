'use strict';

describe('CandidateCard', function () {
  var React = require('react/addons');
  var CandidateCard, component;

  beforeEach(function () {
    CandidateCard = require('components/CandidateCard.js');
    component = React.createElement(CandidateCard);
  });

  it('should create a new instance of CandidateCard', function () {
    expect(component).toBeDefined();
  });
});
