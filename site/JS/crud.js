let BASE_URL = "http://localhost:8080/graph";

function alerta() {
    location.reload();
}

function onFormSubmit() {
    class Data {
        constructor() {
            this.id = document.getElementById("id").value;
            this.date = document.getElementById("date").value;
            this.value = document.getElementById("val").value;
        }
    }
    let dat = new Data();
    if (document.getElementById("op").value == 1) {
        createProduct(dat, alerta);
    }
    
    if (document.getElementById("op").value == 2) {
        updateProduct(dat, alerta);
     }
    if (document.getElementById("op").value == 3) {
        deleteProduct(document.getElementById("id").value, alerta)
    }
    
}





function getJSON(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true); //abrindo requisição para a url de forma assíncrona
    xhr.responseType = 'json';
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
        } else {
            console.log('DEU RUIM!' + status);
        }
        callback(status, xhr.response);
    }
    xhr.send();
}

function deleteProduct(id, callback) {
    let deleteURL = BASE_URL;

    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', deleteURL, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send();
}

function updateProduct(product, callback) {
    let deleteURL = BASE_URL;

    var xhr = new XMLHttpRequest();
    xhr.open('PUT', deleteURL, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send(JSON.stringify(product));
}

function createProduct(product, callback) {
    let deleteURL = BASE_URL;

    var xhr = new XMLHttpRequest();
    xhr.open('POST', deleteURL, true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            console.log('DEU BOM!');
            callback(status, xhr.response);
        } else {
            console.log('DEU RUIM!' + status);
        }
    }
    xhr.send(JSON.stringify(product));
}