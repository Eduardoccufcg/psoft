import socket
import sys
import os.path


def procurandoArquivo(name):
    arquivo = ""
    diretorio = os.listdir(".")
    for arc in diretorio:
        if(arc == name):
            arquivo = arc
            break

    return arquivo

def httpStatus(verbo,recurso):
    response = "HTTP/1.1"
    if(verbo != "GET"):
        response +=" 405\nContent-Type:text/html;charset=utf-8\n\n"
    elif(recurso != "/"):
        nome = recurso[1:]
        if(os.path.exists(nome)):
            arqui = procurandoArquivo(nome)
            arquivo = open(os.getcwd()+"/"+ arqui,'r')
            body = ""
            for i in arquivo.readlines():
                body += i
            response += " 200 OK\nContent-Type:text/html;charset=utf-8\n\n" + body
        else:

            response += " 404\nContent-Type:text/html;charset=utf-8\n\n" + "404 File not found"

    else:
        response += " 200 OK\nContent-Type:text/html;charset=utf-8\n\n" + "Este é o conteúdo do recurso %s neste servidor\n" % recurso
        
    return response   


def parse_request(mensagem):
    # LISTA
    b = mensagem.split("\\n")
    request = b[0].split(" ")

    verbo = request[0]
    recurso = request[1]
   
    # DESCONSIDERO
    protocolo = request[2]
    # Removo o request
    b.pop(0)
    headers = {}
    for i in range(len(b)):
        listaAux = b[i].split("\n")
        lista = listaAux[0].split(": ")
        headers[lista[0]] = lista[1]
    return httpStatus(verbo,recurso)   

# porta default 9090 (ou o que vier na linha de comando)
porta = int(sys.argv[1] if len(sys.argv) > 1 else 9098)

with socket.socket() as s:
    s.bind(('localhost', porta))
    s.listen()

    print('Aguardando conexões na porta %s...' % porta)
    conexao, endereco = s.accept()
    with conexao:
        print('Conexão estabelecida de %s:%s' % endereco)
        while True:
            print('Aguardando mensagem de %s:%s' % endereco)
            mensagem = conexao.recv(4096)
           
            if not mensagem: break
            a = parse_request(mensagem.decode('utf-8'))
            conexao.sendall(a.encode('utf-8'))
            

