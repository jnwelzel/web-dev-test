'use strict';

var React = require('react/addons');
var belle = require('belle');
var Input = belle.TextInput;
var Button = belle.Button;


require('styles/Registration.scss');

var Registration = React.createClass({

  render: function () {
    return (
      <div className="Registration">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1>Formulário de Cadastro</h1>
              <span className="subtitle">Preencha seu nome, e-mail para contato e em seguida nos diga o quão bom você é em cada uma das tecnologias abaixo</span>

              <div className="form-card personal">
                <img src="images/personal.png" />
                <p className="card-title">Dados Pessoais</p>
                <Input placeholder="Nome completo" />
                <Input placeholder="E-mail para contato" />
              </div>

              <div className="form-card frontend">
                <img src="images/frontend.png" />
                <p className="card-title">Frontend</p>

                <label for="html">HTML</label>
                <input step="1" type="range" min="0" max="10" id="html"/>

                <label for="css">CSS</label>
                <input step="1" type="range" min="0" max="10" id="css"/>

                <label for="js">Javascript</label>
                <input step="1" type="range" min="0" max="10" id="js"/>
              </div>

              <div className="form-card backend">
                <img src="images/backend.png" />
                <p className="card-title">Backend</p>

                <label for="python">Python</label>
                <input step="1" type="range" min="0" max="10" id="python"/>

                <label for="django">Django</label>
                <input step="1" type="range" min="0" max="10" id="django"/>
              </div>

              <div className="form-card mobile">
                <img src="images/mobile.png" />
                <p className="card-title">Mobile</p>

                <label for="ios">iOS</label>
                <input step="1" type="range" min="0" max="10" id="ios"/>

                <label for="android">Android</label>
                <input step="1" type="range" min="0" max="10" id="android"/>
              </div>

              <span className="buttons-holder">
                <Button primary>Cadastrar</Button>
                <Button>Voltar</Button>
              </span>

            </div>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = Registration;
