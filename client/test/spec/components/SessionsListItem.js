'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import SessionsListItem from 'components/SessionsListItem.js';

describe('SessionsListItem', () => {
    let SessionsListItemComponent;

    beforeEach(() => {
        SessionsListItemComponent = createComponent(SessionsListItem);
    });

    it('should have its component name as default className', () => {
        expect(SessionsListItemComponent._store.props.className).toBe('SessionsListItem');
    });
});
