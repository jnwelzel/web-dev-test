'use strict';

var React = require('react/addons');


require('styles/Header.scss');

var Header = React.createClass({

  render: function () {
    return (
      <div className="Header">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <a href="/#">Cadastro de Candidatos</a>
              <a className="source" href="https://github.com/jnwelzel/web-dev-test" target="_blank">GitHub</a>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Header;
