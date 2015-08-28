'use strict';

var React = require('react/addons');
var belle = require('belle');
var Input = belle.TextInput;
var Button = belle.Button;
var Navigation = require('react-router').Navigation;
var requester = require('scripts/requester');
var humane = require('humane-js');
var validations = require('scripts/validations');


require('styles/Registration.scss');
require('styles/humane.css');

function _validateFields(name, email) {
  var errors = [];
  if(name === null || name.length === 0) {
    errors.push('O campo \'Nome\' é obrigatório');
  } else if(name.length < 3) {
    errors.push('O campo \'Nome\' deve possuir no mínimo 3 caracteres');
  }
  if(email === null || email.length === 0) {
    errors.push('O campo \'E-mail\' é obrigatório');
  } else if(!validations.validateEmail(email)) {
    errors.push('O e-mail informado é inválido');
  }
  return errors;
}

function _buildSkillsArray(scoresObj) {
  var skills = [];
  skills.push({description: 'HTML', score: scoresObj.html, skillGroup: 'FRONTEND'});
  skills.push({description: 'CSS', score: scoresObj.css, skillGroup: 'FRONTEND'});
  skills.push({description: 'Javascript', score: scoresObj.js, skillGroup: 'FRONTEND'});
  skills.push({description: 'Python', score: scoresObj.python, skillGroup: 'BACKEND'});
  skills.push({description: 'Django', score: scoresObj.django, skillGroup: 'BACKEND'});
  skills.push({description: 'Desenvolvimento iOS', score: scoresObj.ios, skillGroup: 'MOBILE'});
  skills.push({description: 'Desenvolvimento Android', score: scoresObj.android, skillGroup: 'MOBILE'});
  return skills;
}


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
                  onUpdate={this._handleNameChange}
                  value={this.state.candidateName} />
                <Input placeholder="E-mail para contato (obrigatório)"
                  style={{color: '#ddd'}}
                  ref="candidateEmail"
                  onUpdate={this._handleEmailChange}
                  value={this.state.candidateEmail} />
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
    // console.log('this.state.candidateName %s', this.state.candidateName);
    var name = this.state.candidateName.trim();
    var email = this.state.candidateEmail.trim();
    var errors = _validateFields(name, email);
    if(errors.length > 0) {
      humane.log(errors);
    } else {
      var params = {name: name, email: email, skills: _buildSkillsArray(this.state.scores)};
      requester.new('post', 'candidates', params).then(function(response) {
        console.log('Tudo certo %o', response);
        humane.log('Seus dados foram enviados com sucesso, em breve entraremos em contato');
        this._resetForm();
      }.bind(this)).catch(function (response) {
        console.log('Erro no servidor remoto %o', response);
        humane.log('Desculpe-nos mas parece que nossos servidores estão com problemas :(');
      });
    }
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
  },

  _resetForm: function() {
    this.setState({
      candidateName: '',
      candidateEmail: '',
      scores: {html: 0, css: 0, js: 0, python: 0, django: 0, ios: 0, android: 0}
    });
  }
});

module.exports = Registration;
