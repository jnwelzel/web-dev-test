'use strict';

var React = require('react/addons');
var Card = require('./FrontPageCard');

require('styles/Content.scss');

var Content = React.createClass({

  render: function () {
    return (
      <div className="Content">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1>Venha trabalhar conosco!</h1>
              <span className="subtitle">Confira abaixo nossas áreas atualmente disponíveis</span>
              <Card title="Desenvolvedor Frontend" content="Se você gosta de lidar com User Interfaces bem como User Experience, tem conhecimento afiado em HTML,
              CSS e Javascript, essa vaga é pra você. Prezamos muito pela simplicidade e beleza de nossos produtos."/>
              <Card title="Desenvolvedor Backend" content="Para quem prefere trabalhar com o lado servidor da aplicação e tem experiência boa em Python e Django também.
              Procuramos em especial por pessoas com um raciocínio lógico acima da média e que consiga unir a isso criatividade e simplicidade."/>
              <Card title="Desenvolvedor Mobile" content=""/>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Content;
