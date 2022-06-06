'use strict';

// const ADDR = "http://localhost";

// Divs
// const RESULTS_DIV = document.querySelector("#results-div");
// const FORM_DIV = document.querySelector("#form-div")

// Selectors
let resultsDiv = document.querySelector("#results_div");
// let = document.querySelector("viewbody");
let inputFN = document.querySelector("#inputFN");
let inputLN = document.querySelector("#inputLN");
let inputP = document.querySelector("#inputP");
let inputID = document.querySelector("#inputID");

let getBtn = document.querySelector("#getAll");
let postBtn = document.querySelector("#post");
let delBtn = document.querySelector("#delete");
let updBtn = document.querySelector("#put");
let viewBtn = document.querySelector("#view");
let editSaveBtn = document.querySelector("#editsave")

// // Setup
// const setup = () => {
//     getAll();
// }

// Inputs
const FIRSTNAME = document.querySelector(".firstname-input");
const LASTNAME = document.querySelector(".lastname-input");
const POWER = document.querySelector(".power-input");

// Functionality

let displayResult = (data) => {
    resultsDiv.innerHTML="";
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        entryDiv.innerHTML=`Avenger ID: ${entry.id}<br/> First Name: ${entry.firstName}<br/> Last Name: ${entry.lastName}<br/> Power: ${entry.power}<br/>`;
        entryDiv.classList.add("bordered");
        resultsDiv.appendChild(entryDiv);
    }
}

// API
// GET - READ
let getRequest = () => {
    axios.get("http://localhost:8080/avenger/getAll")
        .then((response) => {
            displayResult(response.data);
            // resultsDiv.innerHTML = "";
            console.log(response.data);
            
        })
        .catch((error) => {
            console.error(error);
        });
}

// Get By ID
let getByIdRequest = () => {

    let obj = {
        "id":inputID.value
    }
    axios.get(`http://localhost:8080/avenger/getById/`, obj)
        .then((response) => {
            resultsDiv.innerHTML = "";
            console.log(response);
            
            const text = document.createTextNode(`ID : ${response.data.Id}`); 
            const text2 = document.createTextNode(`Name : ${response.data.name} : ${response.data.entry}`);
            const text3 = document.createTextNode(`Power :  ${response.data.power}`);
            resultsDiv.appendChild(Div);
        })
        .catch((err) => {
            console.error(err);
        });

    }
// POST - CREATE
let postRequest = () => {

    let obj = {
        "firstName":inputFN.value,
        "lastName":inputLN.value,
        "power":inputP.value
    }

    axios.post("http://localhost:8080/avenger/create", obj)
        .then((response) => {
            // resultsDiv.innerHTML = "";
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
    
       
}
// PUT/PATCH - UPDATE

let putRequest = () => {
    displayResult;

    let obj = {
        "Id":inputID.value,
        "firstName":editInputFN.value,
        "lastName":editInputLN.value,
        "power":editInputP.value
    }
    
    axios.put(`http://localhost:8080/avenger/update/${inputID.value}`, obj)
        .then((response) => {
            resultsDiv.innerHTML = "";
            console.log(response.data);
            displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}

// DELETE - DELETE

let deleteRequest = () => {

    let obj = {
        "Id":inputID.value,
    }
    
    axios.delete(`http://localhost:8080/avenger/delete/${inputID.value}`, obj)
        .then((response) => {
            resultsDiv.innerHTML = "";
            console.log(response.data);
            displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}

// Event Listeners
getBtn.addEventListener("click", getRequest);
postBtn.addEventListener("click", postRequest);
delBtn.addEventListener("click", deleteRequest);
editSaveBtn.addEventListener("click", postRequest);
viewBtn.addEventListener("click", getByIdRequest);
