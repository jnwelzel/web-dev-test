'use strict';

var React = require('react/addons');
var belle = require('belle');
var Card = belle.Card;

belle.style.card.style = {
  marginTop: 40,
  padding: 20,
  borderRadius: 2,
  color: '#FFF',
  boxShadow: '0 1px 1px rgba(0, 0, 0, 0.2)',
  boxSizing: 'border-box'
};


require('styles/FrontPageCard.scss');

var FrontPageCard = React.createClass({

  render: function () {
    return (
      <div className="FrontPageCard">
        <Card className="clearfix" style={{background: this.props.background}}>
          <img className="card-icon" src={'images/' + this.props.image + '.png'} />
          <p className="title">{this.props.title}</p>
          <p>{this.props.content}</p>
        </Card>
      </div>
    );
  }
});

module.exports = FrontPageCard;
