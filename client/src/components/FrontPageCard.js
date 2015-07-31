'use strict';

var React = require('react/addons');
var belle = require('belle');
var Card = belle.Card;


require('styles/FrontPageCard.scss');

var FrontPageCard = React.createClass({

  render: function () {
    return (
      <div className="FrontPageCard">
        <Card className={this.props.image + ' clearfix'}>
          <img className="card-icon" src={'images/' + this.props.image + '.png'} />
          <p className="title">{this.props.title}</p>
          <p>{this.props.content}</p>
        </Card>
      </div>
    );
  }
});

module.exports = FrontPageCard;
