import dayjs from 'dayjs';
import { IStudent } from 'app/shared/model/student.model';

export interface IClub {
  id?: number;
  clubName?: string;
  creationDate?: string;
  students?: IStudent[] | null;
}

export const defaultValue: Readonly<IClub> = {};
