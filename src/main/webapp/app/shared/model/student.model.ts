import { IUser } from 'app/shared/model/user.model';
import { IClub } from 'app/shared/model/club.model';

export interface IStudent {
  id?: number;
  firstname?: string;
  lastname?: string;
  nationality?: string | null;
  city?: string | null;
  filiere?: string;
  level?: string;
  residency?: string | null;
  tel?: string;
  mail?: string;
  pictureContentType?: string | null;
  picture?: string | null;
  user?: IUser;
  clubs?: IClub[] | null;
}

export const defaultValue: Readonly<IStudent> = {};
