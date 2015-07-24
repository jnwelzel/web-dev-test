'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import Footer from 'components/Footer.js';

describe('Footer', () => {
    let FooterComponent;

    beforeEach(() => {
        FooterComponent = createComponent(Footer);
    });

    it('should have its component name as default className', () => {
        expect(FooterComponent._store.props.className).toBe('Footer');
    });
});
