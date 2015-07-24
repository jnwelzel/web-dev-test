'use strict';

var ClientApp = require('./ClientApp');
var React = require('react');
var Router = require('react-router');
var Route = Router.Route;
var DefaultRoute = Router.DefaultRoute;

var Content = require('./Content');
var Registration = require('./Registration');

var content = document.getElementById('content');

var Routes = (
  <Route handler={ClientApp}>
    <DefaultRoute handler={Content}/>
    <Route name="registration" handler={Registration}/>
  </Route>
);

Router.run(Routes, function (Handler) {
  React.render(<Handler/>, content);
});
