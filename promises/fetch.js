console.log("FAZENDO O PEDIDO");
let dados = fetch('ex.json');
console.log("PEDIDO FEITO");
dados.then(r => r.json()) // retorna uma promise (response)
.then(t => 
    console.log(t[1]));
