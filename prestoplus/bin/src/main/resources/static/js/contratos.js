function aEditarPer() {
    let infoUser = document.getElementById("opcEdit");

    infoUser.style.zIndex = 1;
    infoUser.style.opacity = 1;
}

function fEditarPer() {
    let infoUser = document.getElementById("opcEdit");
    infoUser.style.zIndex = -1;
    infoUser.style.opacity = 0;
}


// Abrir form contrato
// let modal =  document.getElementsByClassName("modal")[0];
// let fContrato =  document.getElementsByClassName("formContrato")[0];


// function test() {
// 	 window.location.href = "@{/exibir/{id}(id=${contratos.id})}";
	 
// 	}

// function abrirFormContrato() {
//    modal.classList.add("modalAparece");
//    fContrato.classList.add("formContratoAparece");
// }

// function sumirModal() {
//     fContrato.classList.remove("formContratoAparece");
//     modal.classList.remove("modalAparece");
// }

// window.onclick = (event) => {
//     if (event.target == modal) {
//         fContrato.classList.remove("formContratoAparece");
//         modal.classList.remove("modalAparece");
//     }
// }

// // Mudar cor inputs date
// function MudarCorDaIni() {
//     let dataIni = document.getElementById("dataIni");
//     dataIni.style.color = "black";
// }

// function MudarCorDaTer() {
//     let dataTer = document.getElementById("dataTer");
//     dataTer.style.color = "black";
// }

// // Upload de imagens
// window.URL = window.URL || window.webkitURL;

// var fileSelect = document.getElementById("fileSelect"),
//     fileElem = document.getElementById("fileElem");

// fileSelect.addEventListener("click", function (e) {
//   if (fileElem) {
//     fileElem.click();
//   }
//   e.preventDefault(); // prevent navigation to "#"
// }, false);

// function handleFiles(files) {
//   if (!files.length) {
//     console.log("<p>No files selected!</p>");
//   } else {
//     var list = document.createElement("ul");
//     list.setAttribute("class", "ulImg");
//     for (var i = 0; i < files.length; i++) {
//       var li = document.createElement("li");
//       li.setAttribute("class", "liImg");
//       list.appendChild(li);
      
//       var img = document.createElement("img");
//       img.src = window.URL.createObjectURL(files[i]);
//       img.setAttribute("class", "imgImg");
//       // img.setAttribute("onclick", "verImg()");
//       // img.height = 60;
//       img.onload = function(e) {
//         window.URL.revokeObjectURL(this.src);
//       }
//       li.appendChild(img);
      
//       var info = document.createElement("span");
//       info.setAttribute("class", "spanImg");
//       info.innerHTML = files[i].name + ": " + files[i].size + " bytes";
//       li.appendChild(info);
//     }
//     fileList.appendChild(list);
//   }
// }


//Status contratos
window.addEventListener("load", () => {
  let status = document.getElementsByClassName("status");

  for (let index = 0; index < status.length; index++) {
    let statussEsp = status[index].innerText.trim();

    if (statussEsp === "Pendente" || statussEsp === "pendente") {
      status[index].style.color = "rgb(156, 138, 2)";
    } else if (statussEsp === "Aceito" || statussEsp === "aceito"){
      status[index].style.color = "rgb(75, 181, 67)";
    } else if(statussEsp === "Recusado" || statussEsp === "recusado") {
      status[index].style.color = "#F32013";
    }
  }
});