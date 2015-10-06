'use strict';

var React = require('react/addons');
var SessionStore = require('stores/SessionStore');
var SessionActions = require('actions/SessionActionCreators');
var SessionItem = require('./SessionsListItem');
var moment = require('moment');


require('styles/SessionsList.scss');

function _buildListItems(sessions) {

  return sessions.map(function(session) {
    moment.locale('pt-BR');
    var lastAccess = moment(Number.parseInt(session.lastAccess)).fromNow();
    return <SessionItem key={session.id} address={session.address} agent={session.agent} lastAccess={lastAccess}
            current={SessionStore.getUser().sessionId === session.id ? 'active' : ''} />;
  });
}

var SessionsList = React.createClass({

  getInitialState: function() {
    return {
      sessions: []
    };
  },

  componentWillMount: function() {
    SessionStore.addChangeListener(this._syncWithStore);
  },

  componentWillUnmount: function() {
    SessionStore.removeChangeListener(this._syncWithStore);
  },

  componentDidMount: function() {
    SessionActions.showAllSessions();
  },

  _syncWithStore: function() {
    this.setState({ sessions: SessionStore.getSessionsList() });
  },

  render: function () {
    return (
      <div className="SessionsList">
        <div className="grid grid-pad">
          <div className="col-1-1">
            <div className="content">
              <h1 className="title">Lista de Sessões Ativas</h1>
              <span className="subtitle">Abaixo estão listadas as sessões que você possui em aberto</span>
            </div>
          </div>
        </div>

        <div className="grid grid-pad header">
          <div className="col-3-12">
            <span>Endereço</span>
          </div>
          <div className="col-5-12">
            <span>Agente</span>
          </div>
          <div className="col-3-12">
            <span>Último Acesso</span>
          </div>
          <div className="col-1-12">
            <span>Opções</span>
          </div>
        </div>

        {_buildListItems(this.state.sessions)}
      </div>
    );
  }
});

module.exports = SessionsList;
