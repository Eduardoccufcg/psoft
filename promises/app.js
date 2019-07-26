let $contador  = document.getElementById("cout");

let contador  = 0;

function conta(){
    contador += 1;
    let now = new Date();
    let segundos = now.getSeconds();
    $contador.innerText = segundos;
    setTimeout(conta,0);
}
conta();