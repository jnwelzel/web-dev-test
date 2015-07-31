'use strict';

var React = require('react/addons');


require('styles/CandidateCard.scss');

var CandidateCard = React.createClass({

  render: function () {
    return (
      <div className="CandidateCard">
        <div className="grid grid-pad">
          <div className="col-3-12">
            <span>{this.props.name}</span>
          </div>
          <div className="col-3-12">
            <span>{this.props.email}</span>
          </div>
          <div className="col-2-12">
            {this.props.frontend ? (<span className="success">&#10004;</span>) : (<span className="error">&#10008;</span>)}
          </div>
          <div className="col-2-12">
            {this.props.backend ? (<span className="success">&#10004;</span>) : (<span className="error">&#10008;</span>)}
          </div>
          <div className="col-2-12">
            {this.props.mobile ? (<span className="success">&#10004;</span>) : (<span className="error">&#10008;</span>)}
          </div>
        </div>
      </div>
    );
  }
});

module.exports = CandidateCard;

