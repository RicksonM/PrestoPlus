// EMAIL
let iEMAIL = document.getElementById("inpEmail");
// SENHA
let senha = document.getElementById("inpSenha");

// tooltip
let too = document.getElementsByClassName("tooltip");


function validarLogin() {
  
    // VERIFICA EMAIL
    if (iEMAIL.value == "") {
        too[0].innerText = "Digite seu e-mail";
        too[0].classList.add("toolAparece");
    } else if (iEMAIL.value.indexOf(".") == -1) {
        too[0].innerText = "Está faltando um ponto";
        too[0].classList.add("toolAparece");
    }


    // VERIFICA SENHA
    if (senha.value == "") {
        too[1].innerText = "Digite a senha";
        too[1].classList.add("toolAparece");
    } else if (senha.value.length < 8){
        too[1].innerText = "Mínimo 8 caracteres";
        too[1].classList.add("toolAparece");
    } 

    
    // RETORNA EMAIL
    if (iEMAIL.value == "") {
        return false;
    } else if (iEMAIL.value.indexOf(".") == -1) {
        return false;
    }


    // RETORNA SENHA
    if (senha.value == "") {
        return false;
    } else if (senha.value.length < 8){
        return false;
    }

    return true; 
}


function validarEMAIL() {
    too[0].classList.remove("toolAparece");
}

function validarSenha() {
    too[1].classList.remove("toolAparece");
}