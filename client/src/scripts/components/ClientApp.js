'use strict';

var React = require('react/addons');
var ReactTransitionGroup = React.addons.TransitionGroup;
var belle = require('belle');
var TextInput = belle.TextInput;

// CSS
require('../../styles/normalize.css');
require('../../styles/main.css');

var imageURL = require('../../images/yeoman.png');

var ClientApp = React.createClass({
  render: function() {
    return (
      <div className='main'>
        <ReactTransitionGroup transitionName="fade">
          <img src={imageURL} />
          <TextInput placeholder="lol" />
        </ReactTransitionGroup>
      </div>
    );
  }
});

module.exports = ClientApp;
