'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import Content from 'components/Content.js';

describe('Content', () => {
    let ContentComponent;

    beforeEach(() => {
        ContentComponent = createComponent(Content);
    });

    it('should have its component name as default className', () => {
        expect(ContentComponent._store.props.className).toBe('Content');
    });
});
