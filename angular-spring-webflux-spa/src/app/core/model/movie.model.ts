interface MovieDetails{
  details:string;
}
export interface Movie {
  id?: string;
  name:string;
  year:number;
  director:string;
  genres:string[];
  details: MovieDetails;
}
