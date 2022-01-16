import dayjs from 'dayjs';
import { IClub } from 'app/shared/model/club.model';

export interface IMeeting {
  id?: number;
  title?: string;
  meetingDate?: string;
  meetingPlace?: string;
  content?: string | null;
  club?: IClub;
}

export const defaultValue: Readonly<IMeeting> = {};
