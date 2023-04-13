# Sistema para Gerência de Sorveterias
Este sistema foi desenvolvido como projeto final da disciplina PCS3623 - Banco de Dados, da Escola Politécnica da USP. Trata-se do backend no estilo REST API para consumo do banco de dados para gerência de sorveterias, que seria utilizado pelo [front-end](https://github.com/IzaqueSena/ice-cream-platform-frontend) desenvolvido pelos outros colegas do grupo. O escopo do projeto envolvia as seguinte etapas de desenvolvimento:

1. Definição do domínio de negócio a ser representado
2. Modelagem no estilo Entidade-Relação das entidades do modelo de negócios
3. Definição das consultas a serem feitas no banco de dados
4. Criação das tabelas correspondentes ao modelo
5. Inserção das entidades na tabela através do SGDB escolhido
6. Implementação de uma aplicação para execução das consultas definidas no banco de dados criado

## Diagrama entidade-relação do banco de dados


## Arquitetura da aplicação
A arquitetura geral da solução conta com 4 pacotes principais, cujas responsabilidades se complementam para implementação dos requisitos definidos. As classes do sistemas estão divididas como:

-Model: classes que representam as entidades salvas no banco de dados e os DTOs que representam a informação enviada ao front-end.
-Controllers: classes responsáveis por receber as requisições HTTP do front-end e acionar a lógica de negócios correspondente 
-Repositories: classes responsáveis pelo consumo dos dados do banco de dados, através das consultas previamente definidas
-Services: classes responsáveis pela aplicação da lógica de negócios. No escopo da nossa aplicação, são acionadas pelos controllers e acionam os repositories. Responsabilidade também do gerenciamento de conexões lógicas com o banco de dados utilizando o driver do SGBD.

Como foi descrito acima, esta API foi feita apenas para consumo dos dados inseridos através do SGDB, podendo ser expandida para todas as operações CRUD, visto que os componentes model, service e repositories já estão implementados

## Tecnologias utilizadas
-Java: utilizou-se a linguagem Java para codificação do sistema. As consultas definidas foram implementadas utilizando a API JDBC para conexão com o banco de dados.
-Spring: framework Java para desenvolvimento web, utilizado para criação da API REST que recebe as requisições que acionam os serviços da aplicação. 
-MySQL: SGBD escolhido para uso na aplicação. Através do MySQL Workbench, criou-se o banco de dados, as tabelas e as entidades de cada uma das tabelas.

