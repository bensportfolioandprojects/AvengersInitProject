'use strict';

const ADDR = "http://localhost";

// Divs
const RESULTS_DIV = document.querySelector("#results-div");
const FORM_DIV = document.querySelector("#form-div")
// Selectors
let resultsDiv = document.querySelector("#results");
let getBtn = document.querySelector("#get");
let postBtn = document.querySelector("#post");

// HTTP Requests - Request/Response
// Axios uses promises
// We must handle the success, and the failure

// Setup
const setup = () => {
    getAll();
}

// Inputs
const FIRSTNAME = document.querySelector(".firstname-input");
const LASTNAME = document.querySelector(".lastname-input");
const POWER = document.querySelector(".power-input");

// Buttons
const CREATE_BTN = document.querySelector("#create-btn");



GET - READ
let getRequest = () => {
    axios.get("http://localhost:8080/avenger/getAll")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
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
        "firstName":"Steve",
        "lastName":"Rodgers",
        "power":"asuper human strength and speed"
    }

    axios.post("http://localhost:8080/avenger/create", obj)
        .then((response) => {
            console.log(response);
            // displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
// PUT/PATCH - UPDATE

let putRequest = () => {
    axios.get("http://localhost:8080/avenger/getAll")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}

// DELETE - DELETE

let displayResult = (data) => {
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        const text = document.createTextNode(`ID: ${entry.id} | First Name: ${entry.firstName} | Last Name: ${entry.lastName} | Power: ${entry.power}`);

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

// Event Listeners
getBtn.addEventListener("click", getRequest);
postBtn.addEventListener("click", postRequest);