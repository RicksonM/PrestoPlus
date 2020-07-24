function pegarNomeDoc() {
    let nomeDocuEnviado = document.getElementById("nomeArq");
    let nomeDocuInp = document.getElementById("enviarFile");
    if (nomeDocuInp.value.length > 4) {      
        nomeDocuEnviado.innerText = nomeDocuInp.value; 
    }    
}


// Profissoes
let profissoes = document.getElementById("profissoes");
// Estados
let estados = document.getElementsByClassName("selClas");
// Div das cidades
let divCidades = document.getElementsByClassName("divCidades");
// Option profissoes
let optProf = document.getElementsByClassName("optPro");
// Option estados
let optEstados = document.getElementsByClassName("optClas");



function mudarCorPro(){
    profissoes.style.color = "black";
}

function mudarCorEst() {
    estados[0].style.color = "black";
}

function funProf() {
    if (optProf[0].disabled == false) {
        optProf[0].disabled = true;
    }
}


function mudarEstPres(val) {
    if (val != `Selecione o estado`) {

       if (optEstados[0].disabled == false) {
        optEstados[0].disabled = true;
       }

        while (divCidades[0].hasChildNodes()) {
            divCidades[0].removeChild(divCidades[0].firstChild);
        }
            


        if (val == `pernambuco`) {
            // Array de cidades de pernambuco
            let cidadesDePe = ["Recife", "Olinda", "Abreu e Lima"];

             // Cria as cidades
                for (let index = 0; index < cidadesDePe.length; index++) {
                // Cria o elemento
                let criarCheck = document.createElement("input");
                let criarLab = document.createElement("label");
                let criarBr = document.createElement("br");
                // Coloca a classe
                criarCheck.setAttribute("type", `checkbox`);
                criarCheck.setAttribute("id", `IdCheck${index}`);
                criarCheck.setAttribute("class", "classCheck");

                criarLab.setAttribute("class", "labCid");
                criarLab.htmlFor = `IdCheck${index}`;
                // Coloca o value do checkbox
                criarCheck.setAttribute("name", cidadesDePe[index].replace(/ /g, '').toLowerCase());
                // Coloca o nome da cidade
                criarLab.innerText = cidadesDePe[index];
                // Coloca como filho do select cidade
                divCidades[0].appendChild(criarCheck);
                divCidades[0].appendChild(criarLab);  
                divCidades[0].appendChild(criarBr);
            }
        }



        if (val == `paraíba`) {
             // Array de cidades da paraiba
             let cidadesDaPa = ["João Pessoa", "Campina Grande", "Tavares"];

             // Cria as cidades
                for (let index = 0; index < cidadesDaPa.length; index++) {
                // Cria o elemento
                let criarCheck = document.createElement("input");
                let criarLab = document.createElement("label");
                let criarBr = document.createElement("br");
                // Coloca a classe
                criarCheck.setAttribute("type", `checkbox`);
                criarCheck.setAttribute("id", `IdCheck${index}`);
                criarCheck.setAttribute("class", "classCheck");

                criarLab.setAttribute("class", "labCid");
                criarLab.htmlFor = `IdCheck${index}`;
                // Coloca o value do checkbox
                criarCheck.setAttribute("name", cidadesDaPa[index].replace(/ /g, '').toLowerCase());
                // Coloca o nome da cidade
                criarLab.innerText = cidadesDaPa[index];
                // Coloca como filho do select cidade
                divCidades[0].appendChild(criarCheck);
                divCidades[0].appendChild(criarLab);  
                divCidades[0].appendChild(criarBr);
            }
        }



        if (val == "ceará") {
            // Array de cidades do ceará
            let cidadesDoCe = ["Fortaleza", "Juazeiro do Norte", "Camocim"];

            // Cria as cidades
               for (let index = 0; index < cidadesDoCe.length; index++) {
               // Cria o elemento
               let criarCheck = document.createElement("input");
               let criarLab = document.createElement("label");
               let criarBr = document.createElement("br");
               // Coloca a classe
               criarCheck.setAttribute("type", `checkbox`);
               criarCheck.setAttribute("id", `IdCheck${index}`);
               criarCheck.setAttribute("class", "classCheck");

               criarLab.setAttribute("class", "labCid");
               criarLab.htmlFor = `IdCheck${index}`;
               // Coloca o value do checkbox
               criarCheck.setAttribute("name", cidadesDoCe[index].replace(/ /g, '').toLowerCase());
               // Coloca o nome da cidade
               criarLab.innerText = cidadesDoCe[index];
               // Coloca como filho do select cidade
               divCidades[0].appendChild(criarCheck);
               divCidades[0].appendChild(criarLab);  
               divCidades[0].appendChild(criarBr);
           }
       }
    }
}