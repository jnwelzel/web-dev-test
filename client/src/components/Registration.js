'use strict';

var React = require('react/addons');
var belle = require('belle');
var Input = belle.TextInput;
var Button = belle.Button;
var Navigation = require('react-router').Navigation;


require('styles/Registration.scss');

var Registration = React.createClass({

  mixins: [Navigation],

  getInitialState: function() {
    return {
      candidateName: '',
      candidateEmail: '',
      scores: {html: 0, css: 0, js: 0, python: 0, django: 0, ios: 0, android: 0}
    };
  },

  render: function () {
    return (
      <div className="Registration">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1>Formulário de Cadastro</h1>
              <span className="subtitle">Preencha seu nome, e-mail para contato e nos diga
                o quão bom você é em cada uma das tecnologias abaixo (0-10)</span>
            </div>
          </div>
        </div>

        <div className="grid">
          <div className="form-card personal clearfix">
            <div className="col-2-12">
              <div className="content img-holder">
                <img src="images/personal.png" />
              </div>
            </div>
            <div className="col-10-12">
              <div className="content">
                <p className="card-title">Dados Pessoais</p>
                <Input placeholder="Nome completo (obrigatório)"
                  style={{color: '#ddd'}}
                  ref="candidateName"
                  onUpdate={this._handleNameChange} />
                <Input placeholder="E-mail para contato (obrigatório)"
                  style={{color: '#ddd'}}
                  ref="candidateEmail"
                  onUpdate={this._handleEmailChange} />
              </div>
            </div>
          </div>
        </div>

        <div className="grid">
          <div className="form-card frontend clearfix">
            <div className="col-2-12">
              <div className="content img-holder">
                <img src="images/frontend.png" />
              </div>
            </div>
            <div className="col-10-12">
              <div className="content">
                <p className="card-title">Frontend</p>

                <label htmlFor="html">HTML ({this.state.scores.html})</label>
                <input step="1" type="range" min="0" max="10" id="html" ref="htmlScore"
                  onChange={this._handleScoreChange} data-skill="html"
                  value={this.state.scores.html} />

                <label htmlFor="css">CSS ({this.state.scores.css})</label>
                <input step="1" type="range" min="0" max="10" id="css" ref="cssScore"
                  onChange={this._handleScoreChange} data-skill="css"
                  value={this.state.scores.css} />

                <label htmlFor="js">Javascript ({this.state.scores.js})</label>
                <input step="1" type="range" min="0" max="10" id="js" ref="jsScore"
                  onChange={this._handleScoreChange} data-skill="js"
                  value={this.state.scores.js} />
              </div>
            </div>
          </div>
        </div>

        <div className="grid">
          <div className="form-card backend clearfix">
            <div className="col-2-12">
              <div className="content img-holder">
                <img src="images/backend.png" />
              </div>
            </div>
            <div className="col-10-12">
              <div className="content">
                <p className="card-title">Backend</p>

                <label htmlFor="python">Python ({this.state.scores.python})</label>
                <input step="1" type="range" min="0" max="10" id="python" ref="pythonScore"
                  onChange={this._handleScoreChange} data-skill="python"
                  value={this.state.scores.python} />

                <label htmlFor="django">Django ({this.state.scores.django})</label>
                <input step="1" type="range" min="0" max="10" id="django" ref="djangoScore"
                  onChange={this._handleScoreChange} data-skill="django"
                  value={this.state.scores.django} />
              </div>
            </div>
          </div>
        </div>

        <div className="grid">
          <div className="form-card mobile clearfix">
            <div className="col-2-12">
              <div className="content img-holder">
                <img src="images/mobile.png" />
              </div>
            </div>
            <div className="col-10-12">
              <div className="content">
                <p className="card-title">Mobile</p>

                <label htmlFor="ios">Desenvolvimento iOS ({this.state.scores.ios})</label>
                <input step="1" type="range" min="0" max="10" id="ios" ref="iosScore"
                  onChange={this._handleScoreChange} data-skill="ios"
                  value={this.state.scores.ios} />

                <label htmlFor="android">Desenvolvimento Android ({this.state.scores.android})</label>
                <input step="1" type="range" min="0" max="10" id="android" ref="androidScore"
                  onChange={this._handleScoreChange} data-skill="android"
                  value={this.state.scores.android} />
              </div>
            </div>
          </div>
        </div>

        <span className="buttons-holder">
          <Button primary onClick={this._submitForm}>Cadastrar</Button>
          <Button onClick={() => this.transitionTo('/')}>Não, obrigado</Button>
        </span>

      </div>
    );
  },

  componentDidMount: function() {
    React.findDOMNode(this.refs.candidateName).focus();
  },

  _submitForm: function() {
    console.log('this.state.candidateName %s', this.state.candidateName);
  },

  _handleNameChange: function(e) {
    this.setState({candidateName: e.value});
  },

  _handleEmailChange: function(e) {
    this.setState({candidateEmail: e.value});
  },

  _handleScoreChange: function(e) {
    var _scores = this.state.scores;
    _scores[e.target.dataset.skill] = e.target.value;
    this.setState({scores: _scores});
  }
});

module.exports = Registration;
