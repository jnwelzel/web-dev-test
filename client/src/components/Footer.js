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
              <span className="by"><iframe id="fork-me" src="https://ghbtns.com/github-btn.html?user=jnwelzel&repo=web-dev-test&type=fork&count=true" frameborder="0" scrolling="0" width="110px" height="20px"></iframe></span>
              <span className="for">Created by <a href="http://jonwelzel.com" target="_blank">Jon Welzel</a> for <a href="https://meuspedidos.com.br" target="_blank">Meus Pedidos</a></span>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Footer;
