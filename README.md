# password-validator

##  Detalhes sobre sua solução

Serviço para verificação de senha feito com SprigBoot.

A idéia dp serviço é suportar o uso de validadores embutidos, para validar a complexidade da nova senha de acordo com um conjunto de regras selecionado.


## Instruções básicas de como executar o projeto

* git clone repo
* cd [root path application]
* ./mvnw clean package spring-boot:repackage
* java -jar target/password-validator-0.0.1-SNAPSHOT.jar


## Características de regras

* Comprimento mínimo: verificação do comprimento mínimo da senha.

* Letras maiúsculas: verificação para confirmar se a senha contém letras maiúsculas.

* Caracteres minúsculos: verificação para confirmar se a senha contém caracteres minúsculos.

* Caracteres numéricos: verificação para confirmar se a senha contém um caractere numérico.

* Caracteres especiais: verificação para confirmar se a senha contém algum dos caracteres especiais fornecidos
