'use strict';

var React = require('react/addons');
var Link = require('react-router').Link;


require('styles/Header.scss');

var Header = React.createClass({

  render: function () {
    return (
      <div className="Header">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <a href="/#">Cadastro de Candidatos</a>
              <Link to="candidates" className="right">Candidatos</Link>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Header;
