export default interface ApiResponse<T>{
   code: any,
   message: string,
   error: any,
   data: T;
}
