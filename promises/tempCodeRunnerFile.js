console.log("FAZENDO O PEDIDO");
let dados = fetch(fetch.txt);
console.log("PEDIDO FEITO");
dados.then(r => r.text()) // retorna uma promise (response)
.then(t => {
    console.log(t);
})