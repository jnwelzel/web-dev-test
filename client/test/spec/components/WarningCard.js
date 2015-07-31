'use strict';

describe('WarningCard', function () {
  var React = require('react/addons');
  var WarningCard, component;

  beforeEach(function () {
    WarningCard = require('components/WarningCard.js');
    component = React.createElement(WarningCard);
  });

  it('should create a new instance of WarningCard', function () {
    expect(component).toBeDefined();
  });
});
