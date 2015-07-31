'use strict';

var React = require('react/addons');
var belle = require('belle');
var Card = belle.Card;


require('styles/WarningCard.scss');

var WarningCard = React.createClass({

  render: function () {
    return (
      <div className="WarningCard">
        <div className="grid grid-pad">
          <Card className="clearfix card">
            <p><strong>Atenção!</strong> {this.props.message}</p>
          </Card>
        </div>
      </div>
    );
  }
});

module.exports = WarningCard;

