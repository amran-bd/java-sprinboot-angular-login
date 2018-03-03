export class User {
  public id: number;
  public firstName: string;
  public lastName: string;
  public email:String;
  public mobile:String;

  constructor(id: number, firstName: string, lastName: string, email: string, mobile:String){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.mobile = mobile;
  }
}
