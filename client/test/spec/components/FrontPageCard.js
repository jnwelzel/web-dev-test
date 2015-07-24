'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import FrontPageCard from 'components/FrontPageCard.js';

describe('FrontPageCard', () => {
    let FrontPageCardComponent;

    beforeEach(() => {
        FrontPageCardComponent = createComponent(FrontPageCard);
    });

    it('should have its component name as default className', () => {
        expect(FrontPageCardComponent._store.props.className).toBe('FrontPageCard');
    });
});
