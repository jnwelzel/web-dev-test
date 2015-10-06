'use strict';

var React = require('react/addons');
var requester = require('scripts/requester');
var humane = require('humane-js');
var WarningCard = require('./WarningCard');
var CandidateCard = require('./CandidateCard');


require('styles/Candidates.scss');

function _buildCandidates(candidates) {
  return candidates.map(function(candidate) {
    return <CandidateCard name={candidate.name} email={candidate.email} frontend={candidate.frontend}
      backend={candidate.backend} mobile={candidate.mobile} key={candidate.id} />;
  });
}

var Candidates = React.createClass({

  render: function () {
    return (
      <div className="Candidates">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1 className="title">Lista de Candidatos</h1>
              <span className="subtitle">Confira abaixo os candidatos que já se cadastraram</span>
            </div>
          </div>
        </div>

        {this.state !== null && this.state.candidates.length > 0 ? (
            <div>
              <div className="grid grid-pad header">
                <div className="col-3-12">
                  <span>Nome</span>
                </div>
                <div className="col-3-12">
                  <span>Email</span>
                </div>
                <div className="col-2-12">
                  <span>Front-end</span>
                </div>
                <div className="col-2-12">
                  <span>Back-end</span>
                </div>
                <div className="col-2-12">
                  <span>Mobile</span>
                </div>
              </div>

              {_buildCandidates(this.state.candidates)}
            </div>
          ) : (
            <WarningCard message="Nenhum candidato se cadastrou ainda." />
          )
        }
      </div>
    );
  },

  componentDidMount: function() {
    requester.new('get', 'candidates').then(function(resp) {
      this.setState({candidates: resp.data});
    }.bind(this)).catch(function (response) {
      console.log('Erro no servidor remoto %o', response);
      humane.log('Desculpe-nos mas parece que nossos servidores estão com problemas :(');
    });
  }

});

module.exports = Candidates;

