'use strict';

// const ADDR = "http://localhost";

// Divs
// const RESULTS_DIV = document.querySelector("#results-div");
// const FORM_DIV = document.querySelector("#form-div")

// Selectors
let resultsDiv = document.querySelector("#results");
let inputFN = document.querySelector("#inputFN");
let inputLN = document.querySelector("#inputLN");
let inputP = document.querySelector("#inputP");
let inputID = document.querySelector("#inputID");

// // Setup
// const setup = () => {
//     getAll();
// }

// Inputs
const FIRSTNAME = document.querySelector(".firstname-input");
const LASTNAME = document.querySelector(".lastname-input");
const POWER = document.querySelector(".power-input");

// Buttons
let getBtn = document.querySelector("#get");
let postBtn = document.querySelector("#post");
let delBtn = document.querySelector("#delete");
let updBtn = document.querySelector("#put");
let viewBtn = document.querySelector("#view");

// GET - READ
let getRequest = () => {
    // results.innerHTML ="";
    axios.get("http://localhost:8080/avenger/getAll")
        .then((response) => {
            // resultsDiv.innerHTML = "";
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}

// Get By ID
let getByIdRequest = () => {

    let obj = {
        "id":inputID.value
    }
    axios.get("http://localhost:8080/avenger/getById/", obj)
        .then((response) => {
            resultsDiv.innerHTML = "";
            console.log(response);
            
            const text = document.createTextNode(`ID : ${response.data.entryId}`); 
            const text2 = document.createTextNode(`Name : ${response.data.name} : ${response.data.entry}`);
            const text3 = document.createTextNode(`Power :  ${response.data.power}`);
            resultsDiv.appendChild(Div);
        })
        .catch((err) => {
            console.error(err);
        });
// const getAll = () => {
//     axios.get(`${ADDR}:${location.port}/api/getAll/${id}`)
//     .then((resp) => {
//         RESULTS_DIV.innerHTML = "";
//         const RESULTS = resp.data;
//         for (let result of RESULTS) {
//             printResults(result);
//         }
//     }).catch((err) => console.error(err))
// }


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

    let obj = {
        "Id":inputID.value,
        "firstName":inputFN.value,
        "lastName":inputLN.value,
        "power":inputP.value

    }
    
    axios.get("http://localhost:8080/avenger/getAll")
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
    
    axios.delete("http://localhost:8080/avenger/delete/", obj)
        .then((response) => {
            resultsDiv.innerHTML = "";
            console.log(response.data);
            displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}

// Display Result

let displayResult = (data) => {
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        const text = document.createTextNode(`ID: ${entry.id} | First Name: ${entry.first_name} | Last Name: ${entry.lastName} | Power: ${entry.power}`);

        // const img = document.createElement("img");
        // img.setAttribute("src", entry.avatar);
        // img.setAttribute("class", "avatars");

        entryDiv.appendChild(text);
        resultsDiv.appendChild(entryDiv);
        // resultsDiv.appendChild(img);
    }
}

// const del = (id) => {
//     axios.delete(`${ADDR}:${location.port}/api/remove/${id}`)
//     .then((resp) => {
//         getAll();
//     }).catch((err) => {
//         alert(err);
//     })
// }

// let mainDiv = document.querySelector("#addToMe");
// let newDiv = document.createElement("div");
// let newText = document.createTextNode(`${entry.id}, ${entry.firstName}, ${entry.lastName}, ${entry.power}`);

// Event Listeners
getBtn.addEventListener("click", getRequest);
getBtn.addEventListener("click", displayResult);
postBtn.addEventListener("click", postRequest);
delBtn.addEventListener("click", deleteRequest);
updBtn.addEventListener("click", postRequest);
viewBtn.addEventListener("click", getByIdRequest);
}