'use strict';

var React = require('react/addons');
var Link = require('react-router').Link;
var SessionDao = require('scripts/SessionDao');


require('styles/Header.scss');

var Header = React.createClass({

  render: function () {
    return (
      <div className="Header">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <a href="/#">Cadastro de Candidatos</a>
              {
                SessionDao.isLoggedIn() ? (
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
