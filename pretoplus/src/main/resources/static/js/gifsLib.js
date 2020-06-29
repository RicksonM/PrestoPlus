var todasPalavras = "";
var valorDoTextArea = document.getElementById("tMLibras");





/* INICIO TELA DE GIFS*/
function enviarOla() {
    var palavraOla = document.getElementsByClassName("DesGif")[0].innerText;
    todasPalavras += `${palavraOla} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarOi() {
    var palavraOi = document.getElementsByClassName("DesGif")[1].innerText;
    todasPalavras += `${palavraOi} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarComoVai() {
    var palavraComoVai = document.getElementsByClassName("DesGif")[2].innerText;
    todasPalavras += `${palavraComoVai} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarBoaNoite() {
    var palavraBoaNoite = document.getElementsByClassName("DesGif")[5].innerText;
    todasPalavras += `${palavraBoaNoite} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarBoaTarde() {
    var palavraBoaTarde = document.getElementsByClassName("DesGif")[4].innerText;
    todasPalavras += `${palavraBoaTarde} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarBomDia() {
    var palavraBomDia = document.getElementsByClassName("DesGif")[3].innerText;
    todasPalavras += `${palavraBomDia} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarCliente() {
    var palavraCliente = document.getElementsByClassName("DesGif")[7].innerText;
    todasPalavras += `${palavraCliente} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarPrestador() {
    var palavraPrestador = document.getElementsByClassName("DesGif")[6].innerText;
    todasPalavras += `${palavraPrestador} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function enviarFraseGostaria() {
    var palavraFraseGostaria = document.getElementsByClassName("DesGif")[8].innerText;
    todasPalavras += `${palavraFraseGostaria} `;
    valorDoTextArea.value = `${todasPalavras}`;
}

function ReceberValores() {
    todasPalavras = valorDoTextArea.value;
}




function abrirGifs() {
    document.getElementById("secaoCatGifs").style.left = "50%";
    let boxLibras = document.getElementById("Mlibras");
    boxLibras.style.animationName = "abrirMLibras";
    boxLibras.style.display = "block";
}

function fecharGifs(event) {
    if (event.target.id == "fecGifs") {
        document.getElementById("secaoCatGifs").style.left = "-50%";
    } else {
        let boxLibras = document.getElementById("Mlibras");
        boxLibras.style.animationName = "fecharMLibras";
        document.getElementById("secaoCatGifs").style.left = "-50%";
    } 
}

/* function enviarPalavras() {
    if (valorDoTextArea.value.length == 0) {
        alert("O campo de mensagem não pode estar vazio");
    } else {


    }
} */

// Copiar texto de libras
function copTexto() {
   let spTexCop = document.getElementById("sptCop");

   if (valorDoTextArea.value.length == 0) {
       spTexCop.classList.add("tCopErr");
       spTexCop.innerText = "Sem texto";
       setTimeout( () => {spTexCop.classList.remove("tCopErr")}, 2000);
   } else {
    valorDoTextArea.select();
    valorDoTextArea.setSelectionRange(0, 9999);
    document.execCommand("copy");

    spTexCop.innerText = "Texto copiado";
    spTexCop.classList.add("tCopSucAparece");
    setTimeout( () => {spTexCop.classList.remove("tCopSucAparece")}, 2000); 
   }
}

function apaTexto() {
    valorDoTextArea.value = "";
    todasPalavras = "";
}