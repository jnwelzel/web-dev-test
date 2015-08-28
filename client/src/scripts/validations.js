'use strict';

var validations = {

    validateEmail: function(email) {
      var validator = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
      return validator.test(email);
    }

}

module.exports = validations;
