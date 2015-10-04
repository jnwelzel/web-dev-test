'use strict';

var React = require('react/addons');
var ReactTransitionGroup = React.addons.TransitionGroup;
var Header = require('./Header');
var RouteHandler = require('react-router').RouteHandler;
var Footer = require('./Footer');
var belle = require('belle');

// CSS
require('normalize.css');
require('../styles/main.css');
require('../styles/simplegrid.css');

belle.style.card.style = {
  marginTop: 40,
  padding: 20,
  borderRadius: 2,
  boxShadow: '0 1px 1px rgba(0, 0, 0, 0.2)',
  boxSizing: 'border-box'
};


var ClientApp = React.createClass({
  render: function() {
    return (
      <div className="main" ref="ClientApp">
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
