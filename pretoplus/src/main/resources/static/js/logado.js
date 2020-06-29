function mudarStatPrest() {
    let contLogado = document.getElementsByClassName("containerLog")[0].style.left = "307px";
    let contInfoPres = document.getElementsByClassName("inforPerf")[0].style.width = "249px";
    let statusPesAtual = document.getElementsByClassName("cliPres")[0];
    let statusPesPrestador = document.getElementsByClassName("cliPres")[2];

    statusPesAtual.innerText = statusPesPrestador.innerText;
}

function mudarStatCli() {
    let contLogado = document.getElementsByClassName("containerLog")[0].style.left = "327px";
    let contInfoPres = document.getElementsByClassName("inforPerf")[0].style.width = "229px";
    let statusPesAtual = document.getElementsByClassName("cliPres")[0];
    let statusPesCliente = document.getElementsByClassName("cliPres")[1];

    statusPesAtual.innerText = statusPesCliente.innerText;
}

