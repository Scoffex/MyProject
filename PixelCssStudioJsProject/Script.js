const grid = document.getElementById("gridMain");
const color = document.getElementById("color");
const save = document.getElementById("save");
const upload = document.getElementById("upload");
const reset = document.getElementById("reset");
const col = document.getElementById("col");
const addColor = document.getElementById("addColor");
const inputColor = document.getElementById("colorPicker");
const restore = document.getElementById("restore");
const name = document.getElementById("nameOpera");
const stampaNomiOpere = document.getElementById("stampaNomiOpere");
const sideBar = document.getElementById("sideBar");
const cont2 =     document.querySelector('.container2');
let check = false;
let arrColor = ["#FF0000", "#FF7800", "#FFE800", "#9BFF00", "#00FF15", "#00FFE0", "#00A7FF", "#0300FF", "#A400FF", "#FF00CC", "#FDFDFD", "#000000"]
let mouse = false;



sideBar.onclick = () => {
    if (check == false) {
        sideBar.style.backgroundColor="black";
        sideBar.style.color="white";
        cont2.style.WebkitTransform = "translate(0)";
        check = true;
    } else {
        sideBar.style.backgroundColor="white";
        sideBar.style.color="black";
        cont2.style.WebkitTransform = "translate(-100%)";
        check = false;
    }
}



const stampaNomi = () => {
    let arr = Object.keys(localStorage);
    arr.map(elem => { if (elem != "ArrColor") { stampaNomiOpere.innerHTML += `<div class="scritta"><p>${elem}</p> <button class="deleteAutogen" id="${elem}" style="margin-left:10px">Delete</button><button class="updateAutogen" id="${elem}" style="margin-left:10px">Upload</button></div>` } });

    const deleteAuto = document.getElementsByClassName("deleteAutogen");
    const updateAuto = document.getElementsByClassName("updateAutogen");

    for (let i = 0; i < deleteAuto.length; i++) {
        deleteAuto[i].onclick = () => {
            localStorage.removeItem(deleteAuto[i].id);
            stampaNomiOpere.innerHTML = "<h2>Last PixelArt Name: </h2>";
            stampaNomi();
        }
    }
    
    for (let i = 0; i < updateAuto.length; i++) {
        updateAuto[i].onclick = () => {
        grid.innerHTML = JSON.parse(localStorage.getItem(updateAuto[i].id));
        render();
        }
}
}



const stampaGriglia = () => {
    grid.innerHTML = "";
    color.innerHTML = "";
    for (let i = 0; i < 624; i++) {
        grid.innerHTML += `<div class="pixel"></div>`
    }
    render();
}



const stampaColori = () => {
    let colorTemp = "";
    arrColor.map(elem => colorTemp += `<div class="colorPixel" id="${elem}" style="background-color: ${elem};"></div>`);
    color.innerHTML = colorTemp;
    render();
}



const doSome = (elem) => {
    if (elem == restore) {
        localStorage.removeItem("ArrColor");
    }
    else {
        arrColor.push(inputColor.value);
        localStorage.setItem("ArrColor", JSON.stringify(arrColor));
    }

    stampaColori();
}



//-----------------------------------------
window.onload = () => {
    stampaGriglia();

    stampaNomi();
    if (JSON.parse(localStorage.getItem("ArrColor")) != null)
        arrColor = JSON.parse(localStorage.getItem("ArrColor"));

    stampaColori();
};

document.onmousedown = () => mouse = true;
document.onmouseup = () => mouse = false;
reset.onclick = () => location.reload();
restore.onclick = () => doSome(restore);
addColor.onclick = () => doSome(addColor);
//-----------------------------------------



const render = () => {

    const colorPicker = document.getElementsByClassName("colorPixel");
    const pixel = document.getElementsByClassName("pixel");
    let colorPixel = "";

    for (let i = 0; i < colorPicker.length; i++) {

        colorPicker[i].onclick = () => {

            for (let d = 0; d < colorPicker.length; d++) {
                colorPicker[d].style.opacity = `1`;
            }

            colorPicker[i].style.opacity = `0.3`;
            colorPixel = colorPicker[i].id;
        }
    }

    for (let i = 0; i < pixel.length; i++) {
        pixel[i].onclick = () => {
            pixel[i].style.backgroundColor = `${colorPixel}`;
        }
        pixel[i].onmouseover = () => {
            if (mouse == true) {
                pixel[i].style.cursor = "pointer";
                pixel[i].style.backgroundColor = `${colorPixel}`;
            }
        }

    }
}



save.onclick = () => {


    let AllPixel = document.getElementsByClassName("pixel");
    let NewPixel = "";
    for (let i = 0; i < AllPixel.length; i++) {
        NewPixel += AllPixel[i].outerHTML;
    }
    localStorage.setItem(document.getElementById("nameOpera").value, JSON.stringify(NewPixel));
    name.value = "";
    location.reload();
}







