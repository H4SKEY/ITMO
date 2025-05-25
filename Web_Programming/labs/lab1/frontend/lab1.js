
let x = document.querySelector('.x-input'); 
let y = document.querySelector('.y-data'); 
let r = document.getElementById('r--input'); 
 
let xMis = document.getElementById('x-mistake'); 
let yMis = document.getElementById('y-mistake'); 
let rMis = document.getElementById('r-mistake'); 
 
let array = ['-2', '-1.5', '-1', '-0.5', '0', '0.5', '1', '1.5', '2']; 
 
let btn = document.querySelector("button"); 
btn.addEventListener('click', (event) => { 
    event.preventDefault(); 
    const startTime = performance.now(); 
 
    let xVal = x.value.replace(',', '.'); 
    let yVal = y.value; 
    let rVal = r.value.replace(',', '.'); 
 
    if (xVal === '') { 
        xMis.innerHTML = 'Заполните поле X'; 
        return; 
    } 
 
    else if (isNaN(xVal)) { 
        xMis.innerHTML = 'X должен быть числом'; 
        return; 
    } 
 
    else if (xVal < -5 || xVal > 3) { 
        xMis.innerHTML = 'X должен быть в промежутке от -5 до 3'; 
        return; 
    } 
 
    else { 
        xMis.innerHTML = ''; 
    } 
 
    if (yVal === 'Введите Y') { 
        yMis.innerHTML = 'Заполните поле Y'; 
        return; 
    } 
 
    else if (!array.includes(yVal)) { 
        console.log(yVal); 
        yMis.innerHTML = 'Y должен быть в промежутке от -2 до 2 с шагом 0.5'; 
        return; 
    } 
 
    else { 
        yMis.innerHTML = ''; 
    } 
 
    if (rVal === '') { 
        rMis.innerHTML = 'Заполните поле R'; 
        return; 
    } 
 
    else if (isNaN(rVal)) { 
        rMis.innerHTML = 'R должен быть числом'; 
        return; 
    } 
 
    else if (rVal < 1 || rVal > 4) { 
        rMis.innerHTML = 'R должен быть в промежутке от 1 до 4'; 
        return; 
    } 
 
    else { 
        rMis.innerHTML = ''; 
    } 
 
    const row = document.createElement('tr'); 
    const table = document.querySelector('tbody'); 
    let date = new Date();
    let hours = String(date.getHours()).padStart(2, '0');
    let minutes = String(date.getMinutes()).padStart(2, '0');
    let seconds = String(date.getSeconds()).padStart(2, '0');
    let now = `${hours}:${minutes}:${seconds}`;

 
    const endTime = performance.now(); 
    const executionTime = (endTime - startTime).toFixed(6); 
 
    // row.innerHTML = `<td>${xVal}</td> 
    //                  <td>${yVal}</td> 
    //                  <td>${rVal}</td> 
    //                  <td>${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}</td> 
    //                  <td>${executionTime}ms</td>`; 
 
    // table.append(row); 
 
    const url = `http://localhost:8080/fcgi-bin/lab1.jar?x_field=${xVal}&y_field=${yVal}&R_field=${rVal}`;

    function updateTable(data, x, y, r) {
        const table = document
            .getElementById("resultTable")
            .getElementsByTagName("tbody")[0];
        const addRow = table.insertRow(-1);
        const cellX = addRow.insertCell(0);
        const cellY = addRow.insertCell(1);
        const cellR = addRow.insertCell(2);
        const cellAnswer = addRow.insertCell(3);
        const cellExecuteTime = addRow.insertCell(4);
        const cellTime = addRow.insertCell(5);
    
        cellX.textContent = x;
        cellY.textContent = y;
        cellR.textContent = r;
        cellAnswer.textContent = data.hit;
        cellExecuteTime.textContent = now;
        cellTime.textContent = (endTime - startTime).toFixed(6); 
    }
    
    fetch(url, {
        method: 'POST'
    }).then(response => response
        .json())
        .then(data => {
            console.log('Ответ от сервера:', data);
            updateTable(data, xVal, yVal, rVal);
        })
        .catch(error => {
            console.error('Ошибка:', error);
        });
});
