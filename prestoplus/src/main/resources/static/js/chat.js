function abrirChat() {
    let chat = document.getElementById("chat");
    chat.style.bottom = "0";
}

function closeChat() {
    let chat = document.getElementById("chat");
    chat.style.bottom = "-270px";
}



function envMen() {
    let chat = document.getElementById("chat");
    let textarea = document.getElementById("textMens");
    let paragrafo = document.createElement("p");

    paragrafo.classList.add("mensEnv");
    paragrafo.innerText = textarea.value;
    chat.appendChild(paragrafo);
    textarea.value = "";
}