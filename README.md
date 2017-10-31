# MarsHover

Documentação da API: https://swaggerhub.com/apis/hebertsouza87/mars-hover/0.0.1

Aplicação em execução no AWS para demonstração: http://13.59.31.20:8080

Apesar de não fazer sentido, eu criei o recurso /string/mars/{comandos}, que tem a saída conforme os cenários de teste abaixo. E o recurso rest retornam um json.


Requisitos do desafio:


O terreno deverá ser iniciado com 5x5 posições;

O robô inicia na coordenada (0,0,N);

Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;

O Robô não pode se movimentar para fora da área especificada;

Não deve guardar estado do robô para consulta posterior;


Alguns cenários de teste:

Movimento com rotações para direita:

curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM

Saída esperada: (2, 0, S)

Movimento para esquerda:

Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML

Saída esperada: (0, 2, W)

Repetição da requisição com movimento para esquerda:

Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML

Saída esperada: (0, 2, W)

Comando inválido:

curl -s --request POST http://localhost:8080/rest/mars/AAA

Saída esperada: 400 Bad Request

Posição inválida:

curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM


Saída esperada: 400 Bad Request

Requisitos técnicos:

Deve ter teste

O desafio deve ser entregue escrito utilizando Java 8;

O projeto deverá ser compilado utilizando o Maven;

Deverão ser utilizadas apenas as biblioteca do SpringBoot e JUnit;

O desafio será executado como uma aplicação SpringBoot;

A interface de comunicação com o robô é REST;
