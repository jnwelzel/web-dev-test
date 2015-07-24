'use strict';

describe('ClientApp', () => {
  let React = require('react/addons');
  let ClientApp, component;

  beforeEach(() => {
    let container = document.createElement('div');
    container.id = 'content';
    document.body.appendChild(container);

    ClientApp = require('components/ClientApp.js');
    component = React.createElement(ClientApp);
  });

  it('should create a new instance of ClientApp', () => {
    expect(component).toBeDefined();
  });
});
