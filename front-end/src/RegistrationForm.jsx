import React from 'react';
const RegistrationForm = () => {
                 return(

                        <form action="http://localhost:8080/users/register" method="post">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                        First name:
                                        <input type="text" name="firstName" required />
                                    </div>
                                </div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Last name:
                                <input type="text" name="lastName" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Address:
                                <input type="text" name="address" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                City:
                                <input type="text" name="city" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Post Code:
                                <input type="text" name="postCode" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Telephone:
                                <input type="text" name="telephoneNumber" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Email:
                                <input type="email" name="email" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Username:
                                <input type="text" name="login" required />
                                    </div></div>
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Password:
                                <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                       title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or
                                       more characters" />
                                    </div></div>
                                <input type="hidden" name="role" value="User" />
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                Upload photo:
                                <input type="file" name="photo" accept="image/*" required />
                                    </div></div>
                                <input type="hidden" name="route" value="" />
                                <div class="row justify-content-center">
                                    <div class="col-sm-4">
                                <input type="submit" value="Submit" />
                                    </div></div>
                            </div>

                        </form>

                 )};
                export default RegistrationForm;