'use strict';

var React = require('react/addons');


require('styles/SessionsListItem.scss');

var SessionsListItem = React.createClass({

  render: function () {
    return (
      <div className="SessionsListItem">
        <div className={this.props.current + ' grid'}>
          <div className="col-3-12">{this.props.address}</div>
          <div className="col-5-12">{this.props.agent}</div>
          <div className="col-3-12">{this.props.lastAccess}</div>
          <div className="col-1-12 red">X</div>
        </div>
      </div>
      );
  }
});

module.exports = SessionsListItem;
