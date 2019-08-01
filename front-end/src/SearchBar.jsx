// import React from "react";
import React, { Component } from "react";
import DatePicker from "react-datepicker";
// import moment = require("moment");
import moment from "moment";

import "react-datepicker/dist/react-datepicker.css";
import "bootstrap/dist/css/bootstrap.min.css";

class SearchBar extends React.Component {
  constructor(props) {
    super(props);

    this.state = { to: "", from: "" };

    this.startDateHandleChange = this.startDateHandleChange.bind(this);
    this.endDateHandleChange = this.EndDateHandleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

    this.fromHandleChange = event => {
      this.setState({ from: event.target.value });
    };
    this.toHandleChange = event => {
      this.setState({ to: event.target.value });
    };
  }
  handleChange(date) {
    this.setState({
      startDate: date
    });
  }

  handleSubmit(e) {
    e.preventDefault();
    let to = this.state.to;
    let from = this.state.from;
    let main = this.state.startDate;
    console.log({ main });
    console.log({ to });
    console.log({ from });
  }
  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <h1>{this.state.from}</h1>
          <h1>{this.state.to}</h1>
          <input
            type="text"
            placeholder="From"
            name="from"
            value={this.state.from}
            onChange={this.fromHandleChange.bind(this)}
          />
          <div className="container">
            <div className="form-group">
              <label>Select Date: </label>
              <DatePicker
                todayButton={"Vandaag"}
                selected={this.state.startDate}
                onChange={this.startDateHandleChange}
                showTimeSelect
                timeFormat="HH:mm"
                timeIntervals={15}
                dateFormat="MMMM d, yyyy h:mm aa"
                timeCaption="time"
              />
            </div>
          </div>
          <input
            type="text"
            placeholder="To"
            name="to"
            value={this.state.to}
            onChange={this.toHandleChange.bind(this)}
          />
          <div className="container">
            <div className="form-group">
              <label>Select Date: </label>
              <DatePicker
                todayButton={"Vandaag"}
                selected={this.state.EndDate}
                onChange={this.endDateHandleChange}
                showTimeSelect
                timeFormat="HH:mm"
                timeIntervals={15}
                dateFormat="MMMM d, yyyy h:mm aa"
                timeCaption="time"
              />
            </div>
          </div>
          <div className="form-group">
            <button className="btn btn-success">Add Date</button>
          </div>
        </form>
      </div>
    );
  }
}
export default SearchBar;
