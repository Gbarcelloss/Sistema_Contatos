# Sistema de Contatos

Esse é um projeto que desenvolvi em Java usando Spring MVC, com o objetivo de praticar o conteúdo que venho aprendendo na faculdade de Análise e Desenvolvimento de Sistemas.  
Tenho 24 anos e estou no 3º semestre (1 ano e meio de curso).

A ideia do sistema é permitir que o usuário crie uma conta, faça login e consiga gerenciar contatos (cadastrar, consultar, editar e excluir).

Também implementei um sistema de recuperação de senha via e-mail. Se o usuário esquecer a senha, ele recebe uma senha aleatória no e-mail cadastrado. Depois de fazer login com essa senha temporária, ele pode acessar a área "minha conta" e cadastrar uma nova senha de sua escolha.

## Tecnologias utilizadas

- Java
- Spring MVC
- JSP / JSTL
- HTML / CSS
- JDBC
- Maven
- Servidor Apache Tomcat
- Eclipse IDE
- API de envio de e-mail (JavaMail)

## Funcionalidades

- Criar conta de usuário
- Login com verificação
- Recuperação de senha via e-mail
- Alterar senha após login
- Cadastrar, consultar, editar e excluir contatos
- Filtro de segurança para impedir acesso sem login
- Logout

## Como rodar o projeto

1. Clone o repositório:
git clone https://github.com/Gbarcelloss/Sistema_Contatos.git



2. Importe o projeto no Eclipse como **projeto Maven**

3. Configure o Tomcat no Eclipse (versão 9 ou superior)

4. Rode o projeto no servidor

5. Acesse no navegador:
http://localhost:8080/Sistema_Contatos



## Status do projeto

✅ Projeto finalizado para fins de estudo e portfólio.
