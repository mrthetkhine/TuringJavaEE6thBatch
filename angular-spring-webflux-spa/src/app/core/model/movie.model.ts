import {Actor} from "./actor.model";

interface MovieDetails{
  id?: string;
  details:string;
}
export interface Movie {
  id?: string;
  name:string;
  year:number;
  director:string;
  genres:string[];
  details: MovieDetails;
  actors?:Actor[];
}
