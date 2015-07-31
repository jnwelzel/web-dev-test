'use strict';

var ClientApp = require('./ClientApp');
var React = require('react');
var Router = require('react-router');
var Route = Router.Route;
var DefaultRoute = Router.DefaultRoute;

// ROUTES
var Content = require('./Content');
var Registration = require('./Registration');
var Candidates = require('./Candidates');

var content = document.getElementById('content');

var Routes = (
  <Route handler={ClientApp}>
    <DefaultRoute handler={Content}/>
    <Route name="registration" handler={Registration}/>
    <Route name="candidates" handler={Candidates}/>
    <Route name="/" handler={Content}/>
  </Route>
);

Router.run(Routes, function (Handler) {
  React.render(<Handler/>, content);
});
