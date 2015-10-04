'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import SessionsList from 'components/SessionsList.js';

describe('SessionsList', () => {
    let SessionsListComponent;

    beforeEach(() => {
        SessionsListComponent = createComponent(SessionsList);
    });

    it('should have its component name as default className', () => {
        expect(SessionsListComponent._store.props.className).toBe('SessionsList');
    });
});
