'use strict';

var React = require('react/addons');
var ReactTransitionGroup = React.addons.TransitionGroup;
var Header = require('./Header');
var Content = require('./Content');

// CSS
require('normalize.css');
require('../styles/main.css');
require('../styles/simplegrid.css');


var ClientApp = React.createClass({
  render: function() {
    return (
      <div className="main">
        <ReactTransitionGroup transitionName="fade">
          <Header/>
          <Content/>
        </ReactTransitionGroup>
      </div>
    );
  }
});

module.exports = ClientApp;
