'use strict';

var React = require('react/addons');
var Link = require('react-router').Link;
var SessionStore = require('stores/SessionStore');
var SessionActions = require('actions/SessionActionCreators');


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
                      <li><Link to="sessions">Sessões</Link></li>
                      <li><a href="#" onClick={this._logout}>Logout</a></li>
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
  },

  _logout: function() {
    console.log('_logout');
    SessionActions.closeSession();
  }

});

module.exports = Header;
