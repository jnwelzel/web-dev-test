'use strict';

// Uncomment the following lines to use the react test utilities
// import React from 'react/addons';
// const TestUtils = React.addons.TestUtils;

import createComponent from 'helpers/createComponent';
import Registration from 'components/Registration.js';

describe('Registration', () => {
    let RegistrationComponent;

    beforeEach(() => {
        RegistrationComponent = createComponent(Registration);
    });

    it('should have its component name as default className', () => {
        expect(RegistrationComponent._store.props.className).toBe('Registration');
    });
});
