'use strict';

var React = require('react/addons');


require('styles/Footer.scss');

var Footer = React.createClass({

  render: function () {
    return (
      <div className="Footer">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <span className="by">Created by <a href="http://jonwelzel.com" target="_blank">Jon Welzel</a></span>
              <span className="for">For <a href="https://meuspedidos.com.br" target="_blank">Meus Pedidos</a></span>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Footer;
