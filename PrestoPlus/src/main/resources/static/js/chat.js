/**
 * Abrir e fechar chat
 */
function abrirChat() {
    let chat = document.getElementById("chat");
    let iClose = document.getElementById("closeChat");
    chat.style.bottom = "0";
    if (chat.style.bottom = "0") {
        iClose.style.display = "block";
    }  
}

function closeChat() {
    let chat = document.getElementById("chat");
    let iClose = document.getElementById("closeChat");
    chat.style.bottom = "-273px";
    if (chat.style.bottom = "-273px") {
        iClose.style.display = "none";
    }   
}


/**
 * Enviar mensagem
 */
let alturaTotalParag = 0;
let marginTotalParag = 0;

let index = 0;

let MensagensEnviadas = document.getElementById("MensagensEnviadas");

function envMen() {
    let textarea = document.getElementById("textMens");
    if (textarea.value === "") {
        console.log("vazio");
    } else {
        let paragrafo = document.createElement("p");

        paragrafo.classList.add("mensEnvAzul");
        paragrafo.innerText = textarea.value;
        MensagensEnviadas.appendChild(paragrafo);
        textarea.value = "";
        textarea.style.height = "16px";
    }
}

setInterval(() => {
    while (index < MensagensEnviadas.children.length) {
        alturaTotalParag += 
        parseFloat(window.getComputedStyle(MensagensEnviadas.children[index], null).getPropertyValue("height").slice(0, 2));
        marginTotalParag += 
        parseFloat(window.getComputedStyle(MensagensEnviadas.children[index], null).getPropertyValue("margin-bottom").slice(0, 1));
        // console.log("Altura" + alturaTotalParag, "Margim" + marginTotalParag);
        // console.log("Filho ", index, "Mensagens ", MensagensEnviadas.children.length);

        if (alturaTotalParag + marginTotalParag >= 200) {
            let demTamaPara = alturaTotalParag - 200;
            let soma = demTamaPara + marginTotalParag;
            MensagensEnviadas.scrollBy(0, soma);
        }
        index++;
    }   
}, 50);


/**
 * Mudar cor do status
 */
setInterval(() => {
    let statusCor = document.querySelector("#statusOnline");
    let status = document.querySelector("#OnOrOff").innerText;
   
    if (status === "Online" || status === "online") {
        statusCor.style.backgroundColor = "#21BA45";
    } else {
        statusCor.style.backgroundColor = "#ff0000";
    }
}, 1000);


function verMens() {
    let textarea = document.getElementById("textMens");

    if (textarea.value.length <= 29) {
        textarea.style.height = "16px";
    } 
    if (textarea.value.length >= 30) {
       textarea.style.height = "32px";
    } 
    if (textarea.value.length >= 60) {
        textarea.style.height = "48px";
    }
}