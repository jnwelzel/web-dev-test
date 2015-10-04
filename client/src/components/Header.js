'use strict';

var React = require('react/addons');
var Link = require('react-router').Link;
var SessionStore = require('stores/SessionStore');


require('styles/Header.scss');

var Header = React.createClass({

  getInitialState: function() {
    return {
      isLoggedIn: SessionStore.isLoggedIn()
    };
  },

  componentWillMount: function() {
    SessionStore.addChangeListener(this._onChange);
  },

  componentWillUnmount: function() {
    SessionStore.removeChangeListener(this._onChange);
  },

  _onChange: function() {
    console.log('_onChange: function()');
    this.setState({isLoggedIn: SessionStore.isLoggedIn()});
  },

  render: function () {
    return (
      <div className="Header">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <a href="/#">Cadastro de Candidatos</a>
              {
                this.state.isLoggedIn ? (
                  <span>
                    <ul>
                      <li><Link to="candidates">Candidatos</Link></li>
                      <li><a href="">Logout</a></li>
                    </ul>
                  </span>
                ) : (
                  <Link to="login" className="right">Login</Link>
                )
              }
            </div>
          </div>
        </div>
      </div>
    );
  }

});

module.exports = Header;
