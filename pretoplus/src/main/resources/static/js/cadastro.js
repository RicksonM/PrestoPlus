// VALORES ACESSADOS GLOBALMENTE NA FUNÇÃO PAI
// Pega o select dos estados
let selectEst = document.getElementsByClassName("selecClass");
// Pega as cidades filhas do select estados
let cidade = document.getElementsByClassName("optClas");
// Pega quantos filhos tem o select relevancia


function mudarEstCad(val) {
    if (val != `Selecione o estado`) {
       
        // Pega quantos filhos tem o select estado
        let filhosEstados = selectEst[0].children.length;
        // Pega quantos filhos tem o select cidade
        let quantosFilhosCidade = selectEst[1].children.length;
    

        if (cidade[filhosEstados].innerText == "Selecione o estado") {
            // Desabilita o primeiro option de estado
            cidade[0].disabled = true;
            // Define o innertext da primeira option de cidade 
            cidade[filhosEstados].innerText = "Selecione a cidade";
            cidade[filhosEstados].disabled = true;
        }

        // Remove os filhos de cidade criados anteriormente
        let a = filhosEstados;
        a++; 
        while (quantosFilhosCidade > 1) {
            cidade[a].remove();
            quantosFilhosCidade--;
            console.log(quantosFilhosCidade);
        }
        

        // ESTADO PERNAMBUCO
        if (val == "pernambuco") {
            // Array de cidades de pernambuco
            let cidadesDePe = ["Recife", "Olinda", "Abreu e Lima"];
            
            // Cria as cidades
            for (let index = 0; index < cidadesDePe.length; index++) {
                // Cria o elemento
                let criarCid = document.createElement("option");
                // Coloca a classe
                criarCid.setAttribute("class", "optClas");
                // Coloca o value
                criarCid.setAttribute("value", cidadesDePe[index].replace(/ /g, '').toLowerCase());
                // Coloca o nome da cidade
                criarCid.innerText = cidadesDePe[index];
                // Coloca como filho do select cidade
                selectEst[1].appendChild(criarCid);  
            }
        }


        // ESTADO PARAIBA
        if (val == "paraíba") {
            // Array de cidades da paraiba
            let cidadesDaPa = ["João Pessoa", "Campina Grande", "Tavares"];

            // Cria as cidades
            for (let index = 0; index < cidadesDaPa.length; index++) {
                // Cria o elemento
                let criarCid = document.createElement("option");
                // Coloca a classe
                criarCid.setAttribute("class", "optClas");
                // Coloca o value
                criarCid.setAttribute("value", cidadesDaPa[index].replace(/ /g, '').toLowerCase());
                // Coloca o nome da cidade
                criarCid.innerText = cidadesDaPa[index];
                // Coloca como filho do select cidade
                selectEst[1].appendChild(criarCid);  
            }
        }


        // ESTADO CEARÁ
        if (val == "ceará") {
            // Array de cidades do ceará
            let cidadesDoCe = ["Fortaleza", "Juazeiro do Norte", "Camocim"];

            // Cria as cidades
            for (let index = 0; index < cidadesDoCe.length; index++) {
                // Cria o elemento
                let criarCid = document.createElement("option");
                // Coloca a classe
                criarCid.setAttribute("class", "optClas");
                // Coloca o value
                criarCid.setAttribute("value", cidadesDoCe[index].replace(/ /g, '').toLowerCase());
                // Coloca o nome da cidade
                criarCid.innerText = cidadesDoCe[index];
                // Coloca como filho do select cidade
                selectEst[1].appendChild(criarCid);  
            }
        }
    }  
}



// MUDAR A COR DO INPUT DATE
function mudarCorData() {
    document.getElementById("inpDate").style.color = "black";
}

// MUDAR A COR ESTADO
function mudarCorEst() {
    document.getElementById("selectEst").style.color = "black";
    too[8].classList.remove("toolAparece");
}

// MUDAR A COR CIDADE
function mudarCorCid() {
    document.getElementById("selectCid").style.color = "black"; 
    too[9].classList.remove("toolAparece");
}

