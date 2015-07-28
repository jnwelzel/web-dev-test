'use strict';

var React = require('react/addons');
var Card = require('./FrontPageCard');
var belle = require('belle');
var Button = belle.Button;

var Navigation = require('react-router').Navigation;

require('styles/Content.scss');


var Content = React.createClass({

  mixins: [Navigation],

  render: function () {
    return (
      <div className="Content">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1>Venha trabalhar conosco!</h1>
              <span className="subtitle">Confira abaixo nossas áreas atualmente disponíveis</span>

              <Card
                title="Desenvolvedor Frontend"
                content="Se você gosta de lidar com User Interfaces bem como User Experience, tem conhecimento afiado em HTML,
                CSS e Javascript, essa vaga é pra você. Prezamos muito pela simplicidade e beleza de nossos produtos."
                background="blue"
                image="frontend"/>
              <Card
                title="Desenvolvedor Backend"
                content="Para quem prefere trabalhar com o lado servidor da aplicação e tem experiência boa em Python e Django também.
                Procuramos em especial por pessoas com um raciocínio lógico acima da média e que consiga unir a isso criatividade e simplicidade."
                background="green"
                image="backend"/>
              <Card
                title="Desenvolvedor Mobile"
                content="Por ser uma área onde estamos apenas começando, procuramos profissionais que estejam dispostos a despejar
                todo seu talendo em trazer algo que melhore ainda mais a experiência de nossos usuários ao acessarem nossas aplicações, onde quer que eles estejam. Caso
                você acredite estar à altura de grandes desafios e possua experiência com iOS ou Android preencha já seu cadastro!"
                background="orange"
                image="mobile"/>

              <span className="button-holder">
                <Button primary onClick={() => this.transitionTo('registration')}>Quero me cadastrar!</Button>
              </span>
            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Content;
