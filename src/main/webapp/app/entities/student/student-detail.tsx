import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { openFile, byteSize } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './student.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const StudentDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const studentEntity = useAppSelector(state => state.student.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="studentDetailsHeading">Student</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{studentEntity.id}</dd>
          <dt>
            <span id="firstname">Firstname</span>
          </dt>
          <dd>{studentEntity.firstname}</dd>
          <dt>
            <span id="lastname">Lastname</span>
          </dt>
          <dd>{studentEntity.lastname}</dd>
          <dt>
            <span id="nationality">Nationality</span>
          </dt>
          <dd>{studentEntity.nationality}</dd>
          <dt>
            <span id="city">City</span>
          </dt>
          <dd>{studentEntity.city}</dd>
          <dt>
            <span id="filiere">Filiere</span>
          </dt>
          <dd>{studentEntity.filiere}</dd>
          <dt>
            <span id="level">Level</span>
          </dt>
          <dd>{studentEntity.level}</dd>
          <dt>
            <span id="residency">Residency</span>
          </dt>
          <dd>{studentEntity.residency}</dd>
          <dt>
            <span id="tel">Tel</span>
          </dt>
          <dd>{studentEntity.tel}</dd>
          <dt>
            <span id="mail">Mail</span>
          </dt>
          <dd>{studentEntity.mail}</dd>
          <dt>
            <span id="picture">Picture</span>
          </dt>
          <dd>
            {studentEntity.picture ? (
              <div>
                {studentEntity.pictureContentType ? (
                  <a onClick={openFile(studentEntity.pictureContentType, studentEntity.picture)}>Open&nbsp;</a>
                ) : null}
                <span>
                  {studentEntity.pictureContentType}, {byteSize(studentEntity.picture)}
                </span>
              </div>
            ) : null}
          </dd>
          <dt>User</dt>
          <dd>{studentEntity.user ? studentEntity.user.id : ''}</dd>
          <dt>Club</dt>
          <dd>
            {studentEntity.clubs
              ? studentEntity.clubs.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {studentEntity.clubs && i === studentEntity.clubs.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/student" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/student/${studentEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default StudentDetail;
