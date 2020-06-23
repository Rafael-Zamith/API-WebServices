let BASE_URL = "https://localhost:8080/graph";
function onFormSubmit() {
    var formData = readForm();
    
}
function readForm() {
    var formData = {};
    formData["id"] = document.getElementById("id").value;
    formData["date"] = document.getElementById("date").value;
    formData["val"] = document.getElementById("val").value;
    return formData;
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
    let deleteURL = BASE_URL + '/' + id;

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
    let deleteURL = BASE_URL + '/' + id;

    var xhr = new XMLHttpRequest();
    xhr.open('UPDATE', deleteURL, true);
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