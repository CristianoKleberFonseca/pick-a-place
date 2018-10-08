# pick-a-place
Requisitos de ambiente necessários para compilar e rodar o software
	Deverá ser instalado o Maven 3.5.2 ou superior e Java 8 ou superior.
	Deverá ser instalado o Postman como interface de chamada dos serviços.
	Um ponto importante é que o servidor de aplicação Tomcat irá iniciar automaticamente quando a aplicação for inicializada e a porta configurada é a 9093.
	As campos data estão no formato yyyy-MM-dd hh:mm:ss.
Instruções de como utilizar o sistema.
	Como não foi criada nenhuma interface gráfica a ferramenta utilizada será o Postman, os serviços poderão ser exportados através do xml na pasta /pick-a-place/src/main/resources/docs do projeto.
	A sequência de chamadas dos serviços para votação é a seguinte:
		Chamar o serviço de Login utilizando as credenciais "userName": "userone" e "password": "123456";
		Chamar o serviço ListAllRestaurant;
		Chamar o serviço Voting informando no corpo da requisição as credenciais do usuário e o código do restaurante escolhido:
			{  
			   "user":{  
				  "userName":"userfive",
				  "password": "567890"
			   },
			   "restaurant":{  
				  "id":1
			   }
			}
	Existe uma sequência de chamadas dos serviços para processamento do voto, porém eu optei para que seja feita automaticamente.
	Para verificar o resultado chamar o serviço 
O que vale destacar no código implementado?
	O código implementado está bem distribuído em camadas e com um bom tratamento de exceção, os nomes dos serviços bem descritos.
	Como não implementei banco de dados, conforme requisito informado, foi utilizado um recurso do Java 8 para melhorar o desempenho na busca das listas que armazenam os registros, função lambda.
	O processamento dos votos será feito automaticamente por uma tarefa diária agendada para às 11:30.
	
O que poderia ser feito para melhorar o sistema?
	O login poderia ser feito com autenticação OAuth2.
	As interfaces poderiam ser desenvolvidas com algum framework baseado em JS como Angular.
	Automatização da criação da base pelo framework JPA.
	Poderia ser explorado microservices para uma melhor distribuição do sistema e melhoria de performance.

Algo a mais que você tenha a dizer
	Os cenários das Estórias estão comentados no código.
	Para o teste unitário da Estória 2, como eu coloquei a seleção da data pelo backend para não depender do envio desta informação do client não criei o teste unirário, porém a regra está criada.
	Gostaria de agradecer a oportunidade por participar do processo seletivo da DBServer.
