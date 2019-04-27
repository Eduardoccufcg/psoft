
import socket
import sys
# definir porta

porta = int(sys.argv[1] if len(sys.argv) > 1 else 9096)

with socket.socket() as s:
	s.bind(('localhost',porta))
	s.listen()
	print('Waiting for connections on the port %s...' % porta)
	conexao,endereco  = s.accept()
	print('established connection of %s:%s' % endereco)
	with conexao:
	
		while True:	
			print('awaiting message from %s:%s' % endereco)
			 
			mensagem = conexao.recv(4096)
			print('Message: %s\n' % mensagem)
			if not mensagem:break
			conexao.sendall(mensagem.upper())
