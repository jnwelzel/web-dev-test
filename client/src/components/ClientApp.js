'use strict';

var React = require('react/addons');
var ReactTransitionGroup = React.addons.TransitionGroup;
var Header = require('./Header');
var RouteHandler = require('react-router').RouteHandler;
var Footer = require('./Footer');

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
          <RouteHandler/>
          <Footer/>
        </ReactTransitionGroup>
      </div>
    );
  }
});

module.exports = ClientApp;
