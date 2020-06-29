// Nome e sobrenome
let nome = document.getElementById("inpPNome");
let sobrenome = document.getElementById("inpUNome");
let letras = /^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+$/;
// Data
let iData = document.getElementById("inpDate");
// CPF
let iCPF = document.getElementById("inpCPF");
// EMAIL
let iEMAIL = document.getElementById("inpEmail");
// TELEFONE
let iTEL = document.getElementById("inpTelF");
// CELULAR
let iCEL = document.getElementById("inpCel");
// CHECKBOXS
let IRADIOS = document.getElementById("whatsSim");
let IRADION = document.getElementById("whatsNao");
// SELECT ESTADO
let selecEst = document.getElementById("selectEst");
// SELECT CIDADE
let selecCid = document.getElementById("selectCid");
// SENHA UM
let senha = document.getElementById("inpSenha");
// SENHA CONFIRMAR
let conSenha = document.getElementById("inpConSenha");
// CHECKBOX TERMOS E CONDIÇOES
let checkTermos = document.getElementById("checkConect");



// tooltip
let too = document.getElementsByClassName("tooltip");


function validarCadastro() {
  
    // VERIFICA NOME E SOBRENOME
    let nomeSobrenome = [nome, sobrenome];
    for (let index = 0; index < nomeSobrenome.length; index++) {
        if (nomeSobrenome[index].value == "") {
            too[index].innerText = "Não pode estar vazio";
            too[index].classList.add("toolAparece");
        } else if (nomeSobrenome[index].value.match(/\s/g)) {
            too[index].innerText = "Espaço em branco não permitido";
            too[index].classList.add("toolAparece");
        } else if (!nomeSobrenome[index].value.match(letras)) {
            too[index].innerText = "Apenas letras são permitidas";
            too[index].classList.add("toolAparece"); 
        } else if (nomeSobrenome[index].value.length < 3){
            too[index].innerText = "Mínimo 3 caracteres";
            too[index].classList.add("toolAparece");
        }
    }

    // VERIFICA DATA
    if (iData.value == "") {
        too[2].innerText = "Digite uma data válida";
        too[2].classList.add("toolAparece");
    }

    // VERIFICA CPF
    if (iCPF.value == "") {
        too[3].innerText = "Não pode estar vazio";
        too[3].classList.add("toolAparece");
    }

    // VERIFICA EMAIL
    if (iEMAIL.value == "") {
        too[4].innerText = "Não pode estar vazio";
        too[4].classList.add("toolAparece");
    } else if (iEMAIL.value.indexOf(".") == -1) {
        too[4].innerText = "Está faltando um ponto";
        too[4].classList.add("toolAparece");
    }

    // // VERIFICA TELEFONE
    // if (iTEL.value == "") {
    //     too[5].innerText = "Não pode estar vazio";
    //     too[5].classList.add("toolAparece");
    // }

    // VERIFICA CELULAR
    if (iCEL.value == "") {
        too[6].innerText = "Não pode estar vazio";
        too[6].classList.add("toolAparece");
    }

    // VERIFICA RADIO
    if (IRADIOS.checked == false && IRADION.checked == false) {
        too[7].innerText = "Escolha uma opção";
        too[7].classList.add("toolAparece");
    }

    // VERIFICA SELECT ESTADO
    if (selecEst.value == "Selecione o estado") {
        too[8].innerText = "Selecione um estado";
        too[8].classList.add("toolAparece");
    }

    // VERIFICA SELECT CIDADE
    if (selecCid.value == "Selecione o estado" || selecCid.value == "Selecione a cidade") {
        too[9].innerText = "Selecione uma cidade";
        too[9].classList.add("toolAparece");
    }

    // VERIFICA SENHA
    if (senha.value == "") {
        too[10].innerText = "Digite a senha";
        too[10].classList.add("toolAparece");
    } else if (senha.value.length < 8){
        too[10].innerText = "Mínimo 8 caracteres";
        too[10].classList.add("toolAparece");
    } 

    // COMFIRMA SENHA
    if (conSenha.value == "") {
        too[11].innerText = "Confirme a senha";
        too[11].classList.add("toolAparece");
    } else if (senha.value != conSenha.value) {
        too[11].innerText = "Senhas diferentes";
        too[11].classList.add("toolAparece");
    }

    // CHECKBOX TERMOS
    if (checkTermos.checked == false) {
        too[12].innerText = "Aceite os termos";
        too[12].classList.add("toolAparece");
    }
    

    // RETORNA NOME E SOBRENOME
    for (let index = 0; index < nomeSobrenome.length; index++) {
        if (nomeSobrenome[index].value == "") {
            return false;
        } else if (nomeSobrenome[index].value.match(/\s/g)) {
            return false;
        } else if (!nomeSobrenome[index].value.match(letras)) {
            return false;
        } else if (nomeSobrenome[index].value.length > 10){
            return false;
        } else if (nomeSobrenome[index].value.length < 3){
            too[index].innerText = "Mínimo 3 caracteres";
            too[index].classList.add("toolAparece");
            return false;
        }  
    }

    // RETORNA DATA
    let dataGlobalg = new Date();
    let anoAtualg = dataGlobalg.getFullYear();
    let dataAnog = iData.value.slice(0, 4);
    let dataAnoIntg = parseInt(dataAnog);

    if (iData.value == "") {
        return false;
    } else if (dataAnoIntg > anoAtualg - 15) {
        return false;
    } else if (dataAnoIntg < 1950) {
        return false;
    }

    // RETORNA CPF
    if (iCPF.value == "") {
        return false;
    }

    // RETORNA EMAIL
    if (iEMAIL.value == "") {
        return false;
    } else if (iEMAIL.value.indexOf(".") == -1) {
        return false;
    }

    // // RETORNA TELEFONE
    // if (iTEL.value == "") {
    //     return false;
    // }

    // RETORNA CELULAR
    if (iCEL.value == "") {
        return false;
    }

    // RETORNA RADIOS
    if (IRADIOS.checked == false && IRADION.checked == false) {
        return false;
    }

    // RETORNA SELECT ESTADOS
    if (selecEst.value == "Selecione o estado") {
        return false;
    }

    // RETORNA SELECT CIDADE
    if (selecCid.value == "Selecione o estado" || selecCid.value == "Selecione a cidade") {
        return false;
    }

    // RETORNA SENHA
    if (senha.value == "") {
        return false;
    } else if (senha.value.length < 8){
        return false;
    } 

    // RETORNA CONFIRMA SENHA
    if (conSenha.value == "") {
        return false;
    } else if (senha.value != conSenha.value) {
        return false;
    }

    // RETORNA TERMOS
    if (checkTermos.checked == false) {
        return false;
    }

    return true; 
}


function validarNome() {
    if (nome.value == "") {
        too[0].classList.remove("toolAparece");
    } else if (nome.value.match(/\s/g)) {
        too[0].innerText = "Espaço em branco não permitido";
        too[0].classList.add("toolAparece");
    } else if (!nome.value.match(letras)) {
        too[0].innerText = "Apenas letras são permitidas";
        too[0].classList.add("toolAparece");
    } else if (nome.value.length == 11){
        too[0].innerText = "Máximo 10 caracteres";
        too[0].classList.add("toolAparece");
    } else {
        too[0].classList.remove("toolAparece");
    }
}


function validarSobreNome() {

    if (sobrenome.value == "") {
        too[1].classList.remove("toolAparece");
    } else if (sobrenome.value.match(/\s/g)) {
        too[1].innerText = "Espaço em branco não permitido";
        too[1].classList.add("toolAparece");
    } else if (!sobrenome.value.match(letras)) {
        too[1].innerText = "Apenas letras são permitidas";
        too[1].classList.add("toolAparece");
    } else if (sobrenome.value.length == 11){
        too[1].innerText = "Máximo 10 caracteres";
        too[1].classList.add("toolAparece");
    } else {
        too[1].classList.remove("toolAparece");
    }
}


function validarData() {
let dataGlobal = new Date();
let anoAtual = dataGlobal.getFullYear();
let dataAno = iData.value.slice(0, 4);
let dataAnoInt = parseInt(dataAno);

let inicioAno = dataAno.slice(0, 1);
let inicioAnoInt = parseInt(inicioAno);

    if (iData.value == "") {
        too[2].classList.remove("toolAparece");
    } else if (dataAnoInt > anoAtual - 15 && inicioAnoInt > 0) {
        too[2].innerText = "Ano máximo de nascimento 2005";
        too[2].classList.add("toolAparece");
    } else if (dataAnoInt < 1950 && inicioAnoInt > 0) {
        too[2].innerText = "Ano mínimo de nascimento 1950";
        too[2].classList.add("toolAparece");
    } else {
        too[2].classList.remove("toolAparece");
    }
}


function validarCPF() {
    too[3].classList.remove("toolAparece");
}


function validarEMAIL() {
    too[4].classList.remove("toolAparece");
}

function validarTel() {
    too[5].classList.remove("toolAparece");
}

function validarCel() {
    too[6].classList.remove("toolAparece");
}

function validarRadios() {
    too[7].classList.remove("toolAparece");
}

function validarSenha() {
    if (senha.value == conSenha.value) {
        too[11].classList.remove("toolAparece");
    }
    too[10].classList.remove("toolAparece");
}

function validarConSenha() {
    too[11].classList.remove("toolAparece");
}

function validarCheckTer() {
    too[12].classList.remove("toolAparece");
}