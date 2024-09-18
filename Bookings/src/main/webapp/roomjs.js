 var usernameCheck;
 var dateForReservationAvailable;

/* emfanizei thn selida pou kanei login o admin h o employee*/
function fromFirstPageToLoginEmpAdmin(){
    
    document.getElementById("firstpage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "block";
    document.getElementById("GuestLoginPage").style.display = "none";
   
    
}

/* emfanizei thn arxikh selida */
function fromPageToLoginEmpAdminToFirstPage(){
    
    document.getElementById("firstpage").style.display = "block";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    
}

/* emfanizei thn arxikh selida */
function fromPageToLoginGuestToFirstPage(){
    
    document.getElementById("firstpage").style.display = "block";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
   
}

/* emfanizei thn selida gia na kanei login enas eggegramenos xrhsths h na kanei
  sindesh kapoios episkepths */
function fromFirstPageToLoginGuest(){
    
    document.getElementById("firstpage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "block";
    
    
}

/* emfanizei thn selida pou enas xrhsths mporei na kanei eggrafh*/
function fromFirstPageToSignUpGuestPage() {
    
    document.getElementById("firstpage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("GuestSignUpPage").style.display = "block";
    
}
/* emfanizei thn arxikh selida */
function fromSignUpGuestPageToFirstPage(){
    
    document.getElementById("firstpage").style.display = "block";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("GuestSignUpPage").style.display = "none";
   
    
}
/* emfanizei thn arxikh selida */
function fromSignUpEmpAdminToFirstPage(){
    
    document.getElementById("firstpage").style.display = "block";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("GuestSignUpPage").style.display = "none";
    
    
}

/* molis o xrhsths pathsei to koumpi sign up sthn selida pou kanei eggrafh pairnei ta
  stoixeia toy kai ta stelnei sthn bash kai dhmiourgei ena logariasmo */
function sendGuestToJoinInDB(){
    
    var password =  document.getElementById("passwordInputSignUpGuest").value;
    var firstname =  document.getElementById("firstnameInputSignUpGuest").value;
    var lastname =  document.getElementById("lastnameInputSignUpGuest").value;
    var email =  document.getElementById("EmailInputSignUpGuest").value;
    var username  = document.getElementById("usernameSignUpGuest").value;
    var telephone  = document.getElementById("TelephoneInputSignUpGuest").value;
    var birthday  = document.getElementById("birthdayInputSignUpGuest").value;
    
    var xhr = new XMLHttpRequest();
    
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
             
            var ret = JSON.parse(this.responseText);
            console.log(ret); 
            
            if (ret.status === "200"){
                alert("Person succesfully added in DB");
                location.reload(true);
            }
            else {
                alert("Error!!! The person didn't added in DB");
            }
            
                       
          
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'addPersonToDBServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('username=' + username + '&password=' + password + '&firstname=' + firstname + '&lastname=' + lastname +
            '&email=' + email + '&telephone=' + telephone + '&birthday=' + birthday);  
    
    
}



/* elegxei an ta stoixeia tou bazei o xrhsths otan kanei eggrafh eina ortha */
function checkValidGuestSignUpPage(){
    
    
    
     console.log("The return is: ", usernameCheck);
    
    var finalWarningMessage = "";
    var passwordsSame = 0;
    var passwordLength = 0;
   
    var usernameValid = 0;
    var FirstnameCheck = 0;
    var lastnameCheck = 0;
    var emailCheck = 0;
    var usernameEmpty = 0;
    var telephoneCheck = 0;
    var birthdayCheck = 0;
    var usernameExists = 0;
    
    
    var password1 =  document.getElementById("passwordInputSignUpGuest").value + "";
    var password2 =  document.getElementById("passwordAgainInputSignUpGuest").value + "";
    var firstnameValue =  document.getElementById("firstnameInputSignUpGuest").value + "";
    var lastnameValue=  document.getElementById("lastnameInputSignUpGuest").value + "";
    var emailValue=  document.getElementById("EmailInputSignUpGuest").value + "";
    var usernameValue  = document.getElementById("usernameSignUpGuest").value + "";
    var telephoneValue  = document.getElementById("TelephoneInputSignUpGuest").value + "";
    var birthdayValue  = document.getElementById("birthdayInputSignUpGuest").value + "";
    
    if (usernameValue.length === 0){
        
        finalWarningMessage += "&#9830; The username can't be empty.<br>";
        usernameEmpty = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The username can't be empty.<br>", "");
        usernameEmpty = 1;
    }
    
    if (usernameCheck  === 0){
        
        finalWarningMessage += "&#9830; The username already exists.<br>";
        usernameExists = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The username already exists.<br>", "");
        usernameExists = 1;
    }
    
     if (telephoneValue.length === 0 || telephoneValue.length > 10){
        
        finalWarningMessage += "&#9830; The telephone can't be empty or bigger than 10 numbers.<br>";
        telephoneCheck = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The telephone can't be empty or bigger than 10 numbers.<br>", "");
        telephoneCheck = 1;
    }
    
    if (birthdayValue.length === 0){
        
        finalWarningMessage += "&#9830; The birthday can't be empty.<br>";
        birthdayCheck = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The birthday can't be empty.<br>", "");
        console.log(birthdayValue);
        birthdayCheck = 1;
    }

    
    if (firstnameValue.length === 0){
        
        finalWarningMessage += "&#9830; The Firstname can't be empty.<br>";
        FirstnameCheck = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The Firstname can't be empty.<br>", "");
        FirstnameCheck = 1;
    }
    
    if (lastnameValue.length === 0){
        
        finalWarningMessage += "&#9830; The lastname can't be empty.<br>";
        lastnameCheck = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The lastname can't be empty.<br>", "");
        lastnameCheck = 1;
    }
    
    if (emailValue.length === 0){
        
        finalWarningMessage += "&#9830; The email can't be empty.<br>";
        emailCheck = 0;
    }
    else {
        finalWarningMessage = finalWarningMessage.replace("&#9830; The email can't be empty.<br>", "");
        emailCheck = 1;
    }
    
   
    console.log("username: ", usernameCheck);
    
    
    if (password1 !== password2){
        console.log("inside");
        finalWarningMessage += "&#9830 The passwords are not same.<br>";
        passwordsSame = 0;
    }
    else {
        passwordsSame = 1;
        finalWarningMessage = finalWarningMessage.replace("&#9830 The passwords arent same.<br>", "");
    }
    
    if (password1.length < 5 || password2.length < 5){
        passwordLength = 0;
        finalWarningMessage += "&#9830 The passwords must be at least 5 letters.<br>";
    }
    else {
        passwordLength = 1;
        finalWarningMessage = finalWarningMessage.replace("&#9830 The passwords must be at least 5 letters.<br>", "");
    }
    
    if (passwordsSame === 0 || passwordLength === 0 || usernameEmpty === 0
            || FirstnameCheck === 0 || lastnameCheck === 0 || emailCheck === 0  || birthdayCheck === 0 || telephoneCheck === 0
            || usernameExists === 0){
        console.log("problem");
        document.getElementById("divWarningMessageSignUpPage").style.display = "block";
        document.getElementById("warningMessageGuestSignUpPage").innerHTML = finalWarningMessage;
    }
    else {
        console.log("all ok");
        document.getElementById("divWarningMessageSignUpPage").style.display = "none";
        sendGuestToJoinInDB();
        
    }   
    
}


/* elegxei uparxei hdh xrhsths me auto to username */
function checkUsernamePerson() {
    
    var xhr = new XMLHttpRequest();
    var username = document.getElementById("usernameSignUpGuest").value;
    

    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
             
            var ret = JSON.parse(this.responseText);
            console.log(ret); 
            
  
            if (ret.status === "400"){
               
               usernameCheck =  0;
            }
            else {
                console.log("inside");
                usernameCheck =  1;
                
            }
            
          
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'CheckUsernamePersonServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('username=' + username);   
}


/* anoigei thn bash dedomenwn */
function openDB(){
    
    console.log("opening DB");
    

    var xhr = new XMLHttpRequest();

    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            console.log("DB opened");
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'OpenDBServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send();
    
} 

/* aposundeei ton xrhsth */
function logout(){
    location.reload(true);
}


/* stelnei ta stoixeia sindesis tou xrhsth sthn bash gia na sindethei */
function guestLogin(){
    
    var username = document.getElementById("usernameInputGuest").value;
    var password = document.getElementById("passwordInputGuest").value;
    var xhr = new XMLHttpRequest();
    
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret); 
            
            
            if (ret.status === "400"){
                alert("This account doesnt exists.");
            }
            else {
                openGuestLoggedPage();
            }

            
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'loginGuestServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('username=' + username + '&password=' + password);
    
}

function openGuestLoggedPage(){
    
    document.getElementById("firstpage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("GuestSignUpPage").style.display = "none";
    document.getElementById("guestloggedpage").style.display = "block";
    getRoomsForGuestLoggedPage();
    
}

function getRoomsForGuestLoggedPage(){
    
    const buttonContainer = document.getElementById("buttonsContainer");
    var xhr = new XMLHttpRequest();
    
    
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret); 
           
                console.log("ret.length: ", ret.length);
                if (ret.length > 0){
                    
                    
                    for (i = 0; i < ret.length; i++ ){
                        
                        var heading = document.createElement("h4");
                        heading.textContent = ret[i].name;
                       

                        var button = document.createElement("button");
                        button.className = "btn btn-primary";
                        button.textContent = "Book";
                        
                        button.id = "button" + (i+1).toString() + "," + ret[i].name + "," + ret[i].Price;
                        button.setAttribute("onclick", "fromGuestLoggedPageToMakeAReservationPage(id)");
                        


                        var text = document.createElement("p");
                        text.textContent = "Price: " + ret[i].Price;

                        var text1 = document.createElement("p");
                        text1.textContent = "MaxCapacity: " + ret[i].MaxCapacity;

                        var text2 = document.createElement("p");
                        text2.textContent = "Address: " + ret[i].Address;
                        
                        var text3 = document.createElement("p");
                        text3.textContent = "Comforts: " + ret[i].getComforts;


                        buttonContainer.appendChild(document.createElement("br"));
                        buttonContainer.appendChild(document.createElement("br"));
                        buttonContainer.appendChild(heading);
                        buttonContainer.appendChild(text);
                        buttonContainer.appendChild(text1);
                        buttonContainer.appendChild(text2);
                        buttonContainer.appendChild(text3);
                        buttonContainer.appendChild(button);
                    }
                    
                }
                else {
                    alert("There aren't Rooms");
                }   

        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'getRoomsServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send();
                  
  }

function fromMakeAReservationPageToGuestLoggedPage(){
    
    document.getElementById("guestloggedpage").style.display = "block";
    document.getElementById("makeAReservationPage").style.display = "none";
    
}

function fromGuestLoggedPageToMakeAReservationPage(roomid){
   
    
    console.log("roomid: ",roomid);
    const myArray = roomid.split(",");
    
    document.getElementById("roomNameAtMakeReservatonPage").innerHTML = "Reservation at " + myArray[1];
    document.getElementById("priceForTheRoom").innerHTML = "Price: " + myArray[2];
    
    document.getElementById("guestloggedpage").style.display = "none";
    document.getElementById("makeAReservationPage").style.display = "block";
    
}

function showCardField(){
    
   
    
    var optionValue = document.getElementById("optionMenuForPayment").value;
    
    
    if (optionValue === "2"){
        
        document.getElementById("divForCardNumber").style.display = "block";
    }
    else {
        
         document.getElementById("divForCardNumber").style.display = "none";
    }
    
}

function checkDateForReservation(){
    
   var date = document.getElementById("DateInputMakeReservatonPage").value;
   var roomidtext = document.getElementById("roomNameAtMakeReservatonPage").innerHTML;
   console.log("The value is: ", date);
   const myArray = roomidtext.split(" ");
   console.log("The id for the room is: ",myArray[3] );
   
   var xhr = new XMLHttpRequest();

    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(this.responseText); 
            
            if (ret.status === "400"){
                alert("In this date the room is booked");
                dateForReservationAvailable = 0;
            }
            else {
                dateForReservationAvailable = 1;
            }

           
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'checkDateForReservationServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('date=' + date + '&id=' + myArray[3] );
   
   
}

function checkToCallFunctionToAddReservationOnDB(){
    
       if (dateForReservationAvailable === 1){
           addReservationToDB();
       }
       else {
           alert("Please choose another date for this room!");
       }
    
}

function addReservationToDB(){
    
    var date = document.getElementById("DateInputMakeReservatonPage").value;
    var fullname = document.getElementById("fullnameMakeAReservationPage").value;
    var telephone = document.getElementById("TelephoneNumMakeAReservationPage").value;
    var roomidtext = document.getElementById("roomNameAtMakeReservatonPage").innerHTML;
    var pricetext = document.getElementById("priceForTheRoom").innerHTML;
    
    const myArray = roomidtext.split(" ");
     const myArray1 = pricetext.split(" ");
    
    console.log("The id for the room is: ",myArray[3] );
    console.log("date: " + date);
    console.log("fullname: " + fullname);
    console.log("telephone: " + telephone);
    console.log("price: " + myArray1[1]);
    
    var xhr = new XMLHttpRequest();

    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret);
            
            if(ret.status === "200"){
                alert("Booking successfully registered");
                location.reload(true);
            }
            else {
                alert("Error the book didn't registered");
            }
            
            

           
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'addReservationServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('date=' + date + '&fullname=' + fullname + '&telephone=' + telephone
            + '&roomid=' + myArray[3] + '&price=' + myArray1[1]);
    
}

function loginAdmin(){
    
    var username = document.getElementById("usernameInputAdminEmp").value;
    var password = document.getElementById("passwordInputAdminEmp").value;
    
    var xhr = new XMLHttpRequest();
    
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret);
            
            if(ret.status === "200"){
               openAdminLoggedPage();
                
            }
            else {
                alert("This account doesnt exist");
            }         
           
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'loginAdminServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('username=' + username + '&password=' + password );
    
    
}


function openAdminLoggedPage(){
    
    document.getElementById("firstpage").style.display = "none";
    document.getElementById("EmpAdminLoginpage").style.display = "none";
    document.getElementById("GuestLoginPage").style.display = "none";
    document.getElementById("GuestSignUpPage").style.display = "none";
    document.getElementById("guestloggedpage").style.display = "none";
    document.getElementById("Adminloggedpage").style.display = "block";
    getReservationsToConfirmThem();
}



function getReservationsToConfirmThem(){
    
    const resContainer = document.getElementById("ReservationsContainer");
    resContainer.innerHTML = "";
    
    var xhr = new XMLHttpRequest();
    
    
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret); 
           
                console.log("ret.length: ", ret.length);
                if (ret.length > 0){
                    
                    
                    for (i = 0; i < ret.length; i++ ){
                        
                        var heading = document.createElement("h4");
                        heading.textContent = "Customer: " + ret[i].fullname;
                       

                        var button = document.createElement("button");
                        button.className = "btn btn-primary";
                        button.textContent = "Confirm Reservation";
                        
                        button.id = ret[i].telephone;
                        button.setAttribute("onclick", "updateReservationToConfirmed(id)");
                        


                        var text = document.createElement("p");
                        text.textContent = "Date: " + ret[i].date;

                        var text1 = document.createElement("p");
                        text1.textContent = "Telephone: " + ret[i].telephone;

                        var text2 = document.createElement("p");
                        text2.textContent = "Room id: " + ret[i].roomid;
                        
                        


                        resContainer.appendChild(document.createElement("br"));
                        resContainer.appendChild(document.createElement("br"));
                        resContainer.appendChild(heading);
                        resContainer.appendChild(text);
                        resContainer.appendChild(text1);
                        resContainer.appendChild(text2);
                      
                        resContainer.appendChild(button);
                    }
                    
                }
                else {
                    alert("There aren't Reservations for confirmation");
                }   

        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'getReservationsServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send();
                  
  }
   
function updateReservationToConfirmed(tel){
    
    console.log("The telephone is: ", tel);
    
    var xhr = new XMLHttpRequest();

    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            
            var ret = JSON.parse(this.responseText);
            console.log(ret);
            
            if(ret.status === "200"){
                alert("Booking successfully confirmed");
                getReservationsToConfirmThem();
                
            }
            else {
                alert("Error the book didn't confirmed");
            }
            
        } else if (xhr.status !== 200) {
            alert("Request Failed.Returned status of " + xhr.status);
        }
    };

    xhr.open('POST', 'confirmReservationServlet', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('telephone=' + tel);
    
}

            
        
        



