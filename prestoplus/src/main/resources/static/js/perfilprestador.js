/* INICIO CLASSIFICAÇÃO PRESTADOR */

let contEstr = document.getElementsByClassName("tEstrelas")[0].children;
let campoNumEstrelas = document.getElementById("txtNumEstre");

contEstr[0].addEventListener("click", function () {
  clsPres(0);
});
contEstr[1].addEventListener("click", function () {
  clsPres(1);
});
contEstr[2].addEventListener("click", function () {
  clsPres(2);
});
contEstr[3].addEventListener("click", function () {
  clsPres(3);
});
contEstr[4].addEventListener("click", function () {
  clsPres(4);
});

function clsPres(estrela) {
  if (estrela === 4) {
    for (let index = 0; index < 5; index++) {
      contEstr[index].classList.replace("far", "fas");
    }
    campoNumEstrelas.value = 5;
  }

  if (estrela === 3) {
    for (let index = 0; index < 4; index++) {
      contEstr[index].classList.replace("far", "fas");
    }
    contEstr[4].classList.replace("fas", "far");
    campoNumEstrelas.value = 4;
  }

  if (estrela === 2) {
    for (let index = 0; index < 3; index++) {
      contEstr[index].classList.replace("far", "fas");
    }
    contEstr[4].classList.replace("fas", "far");
    contEstr[3].classList.replace("fas", "far");
    campoNumEstrelas.value = 3;
  }

  if (estrela === 1) {
    for (let index = 0; index < 2; index++) {
      contEstr[index].classList.replace("far", "fas");
    }
    contEstr[4].classList.replace("fas", "far");
    contEstr[3].classList.replace("fas", "far");
    contEstr[2].classList.replace("fas", "far");
    campoNumEstrelas.value = 2;
  }

  if (estrela === 0) {
    for (let index = 0; index < 1; index++) {
      contEstr[index].classList.replace("far", "fas");
    }
    contEstr[4].classList.replace("fas", "far");
    contEstr[3].classList.replace("fas", "far");
    contEstr[2].classList.replace("fas", "far");
    contEstr[1].classList.replace("fas", "far");
    campoNumEstrelas.value = 1;
  }
}
/* FIM CLASSIFICAÇÃO PRESTADOR */

// Abrir form contrato
let modal = document.getElementsByClassName("modal")[0];
let fContrato = document.getElementsByClassName("formContrato")[0];

function abrirFormContrato() {
  modal.classList.add("modalAparece");
  fContrato.classList.add("formContratoAparece");
}

function sumirModal() {
  fContrato.classList.remove("formContratoAparece");
  modal.classList.remove("modalAparece");
}

// Abrir form classificação
let mClasficar = document.getElementsByClassName("modalClassificar")[0];
let fClasficar = document.getElementsByClassName("formClasfcar")[0];

function abrirClasfcar() {
  mClasficar.classList.add("modalClassificarAparece");
  fClasficar.classList.add("formClasfcarAparece");
}

function fecharClasfcar() {
  fClasficar.classList.remove("formClasfcarAparece");
  mClasficar.classList.remove("modalClassificarAparece");
}

window.onclick = (event) => {
  if (event.target == modal) {
    fContrato.classList.remove("formContratoAparece");
    modal.classList.remove("modalAparece");
  } else if (event.target == mClasficar) {
    fClasficar.classList.remove("formClasfcarAparece");
    mClasficar.classList.remove("modalClassificarAparece");
  }
};

// Mudar cor inputs date
function MudarCorDaIni() {
  let dataIni = document.getElementById("dataIni");
  dataIni.style.color = "black";
}

function MudarCorDaTer() {
  let dataTer = document.getElementById("dataTer");
  dataTer.style.color = "black";
}



// Upload de imagens
window.URL = window.URL || window.webkitURL;

var fileSelect = document.getElementById("fileSelect"),
    fileElem = document.getElementById("fileElem");

fileSelect.addEventListener("click", function (e) {
  if (fileElem) {
    fileElem.click();
  }
  e.preventDefault(); // prevent navigation to "#"
}, false);

function handleFiles(files) {
  if (!files.length) {
    console.log("<p>No files selected!</p>");
  } else {
    var list = document.createElement("ul");
    list.setAttribute("class", "ulImg");
    for (var i = 0; i < files.length; i++) {
      var li = document.createElement("li");
      li.setAttribute("class", "liImg");
      list.appendChild(li);
      
      var img = document.createElement("img");
      img.src = window.URL.createObjectURL(files[i]);
      img.setAttribute("class", "imgImg");
      // img.setAttribute("onclick", "verImg()");
      // img.height = 60;
      img.onload = function(e) {
        window.URL.revokeObjectURL(this.src);
      }
      li.appendChild(img);
      
      var info = document.createElement("span");
      info.setAttribute("class", "spanImg");
      info.innerHTML = files[i].name + ": " + files[i].size + " bytes";
      li.appendChild(info);
    }
    fileList.appendChild(list);
  }
}