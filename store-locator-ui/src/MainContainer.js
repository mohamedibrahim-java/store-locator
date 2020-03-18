import React from 'react';
import { Map, GoogleApiWrapper, Marker, InfoWindow } from 'google-maps-react';

export class MapContainer extends React.Component {
  state = {
    latit: 0,
    longi: 0,
    locations: [],
    Counter: 0
  }


  componentDidMount() {
    navigator.geolocation.getCurrentPosition(
      position => {
        this.state.latit = position.coords.latitude;
        this.state.longi = position.coords.longitude;
        this.getNearbyLocations();
        console.log(this.state.locations);
        this.forceUpdate();
      }
    );

  }

  getNearbyLocations() {
    // fetch('http://JumboStoreLocator-env.eba-pgcmrnzf.eu-central-1.elasticbeanstalk.com/store-locator-service/api/v1/stores/?longitude=' + this.state.longi + '&latitude=' + this.state.latit)
    fetch('http://JumboStoreLocator-env.eba-pgcmrnzf.eu-central-1.elasticbeanstalk.com/store-locator-service/api/v1/stores/?longitude=4.821771&latitude=52.380655')
      .then(res => res.json())
      .then((data) => {
        this.state.locations = data
        console.log(this.state.locations);
        this.forceUpdate();
      })
      .catch(console.log)
  }

  onClickMarker(each) {
    return (
      <InfoWindow onClose={this.onInfoWindowClose}>
        <div>
          <h1>{each.addressName}</h1>
        </div>
      </InfoWindow>
    )
  }

  render() {
    return (
      <div>
        <Map google={window.google} zoom={12}
          center={{
            // lat: this.state.latit,
            // lng: this.state.longi

            lat: 52.380655,
            lng: 4.821771
          }} >

          {
            this.state.locations.map((each) =>
              <Marker
                key={each.complexNumber}
                title={each.addressName}
                name={each.addressName}
                onClick={this.onMarkerClick}
                position={{ lat: each.latitude, lng: each.longitude }} />
            )
          }
          <InfoWindow
            marker={this.state.activeMarker}
            visible={this.state.showingInfoWindow}
            onClose={this.onClose}/>
        </Map>
      </div>
    );
  }
}

export default GoogleApiWrapper({
  apiKey: ('')
})(MapContainer)
