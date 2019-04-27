from threading import Thread
import socket
import sys

# porta default 9090 (ou o que vier na linha de comando)
porta = int(sys.argv[1] if len(sys.argv) > 1 else 9092
)

# cria o socket
s = socket.socket()
s.bind(('localhost', porta))
s.listen()

listaConexoes = []

def saiu(conexao,endereco):
	mgs = "%s:%s saiu" % endereco
	conexao.sendall("Você saiu".encode('utf-8'))
	for conex in listaConexoes:
		conex.sendall(mgs.encode('utf-8'))
	
def threaded():
	while True:
		print('Aguardando conexões na porta %s...' % porta)
		conexao,endereco  = s.accept()
		listaConexoes.append(conexao)
		Thread(target=verifica, args=(conexao,endereco)).start()
		print('Conexão estabelecida de %s:%s' % endereco)



Thread(target = threaded).start()

def verifica(conexao,endereco):
		while True:	
			
			mensagem = conexao.recv(4096)
			if(mensagem == b'bye\n'):
				listaConexoes.remove(conexao)
				saiu(conexao,endereco)
				conexao.close()
				break
			for i in range(len(listaConexoes)):
				nome =  "%s:%s diz: " % endereco 
				if(listaConexoes[i] != conexao):
					
					listaConexoes[i].sendall(nome.encode('utf-8'))
					listaConexoes[i].sendall(mensagem)
				
			
			

