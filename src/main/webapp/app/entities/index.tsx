import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Student from './student';
import Club from './club';
import Event from './event';
import Meeting from './meeting';
import Invoice from './invoice';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}student`} component={Student} />
      <ErrorBoundaryRoute path={`${match.url}club`} component={Club} />
      <ErrorBoundaryRoute path={`${match.url}event`} component={Event} />
      <ErrorBoundaryRoute path={`${match.url}meeting`} component={Meeting} />
      <ErrorBoundaryRoute path={`${match.url}invoice`} component={Invoice} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
