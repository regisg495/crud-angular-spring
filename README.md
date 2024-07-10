# crud-angular-spring
Uma API rest usando spring boot para o backend e angular para o front end

Observações
Tem duas pastas no projeto, a pasta "join" é o projeto backend em Java, a pasta app-join-front é o frontend em Angular.
Para o backend, a arquitetura escolhida foi o Rest.
O arquivo data.sql contém os scripts para criação das tabelas e alguns inserts para popular o banco de dados. O Banco de dados escolhido foi o MySQL.
Você deverá ter os dois projetos funcionando simultaneamente, o backend com spring e o front com angular.

## Backend em Java
As configurações do projeto ficam, como padrão, no arquivo join\src\main\resources\application.properties
O projeto funciona na porta 8080. Para ficar mais simples, você pode simplesmente baixar o projeto e importar a pasta "join" para o seu eclipse e criar um projeto a partir dela. Feito isso, apenas dê um start application no seu eclipse ou IDE de preferêcia.

Endpoints

Para uso dos endpoints, use seu programa para requisições http (é possível fazer pelo navegador, também), no meu caso, estou usando Postman

1 - Categoria

/category - retorna todas as categorias

/category/{id} - retorna uma categoria dado um ID especificado. Exemplo: http://localhost:8080/category/1 irá retornar a categoria de ID 1

/category/create - cria uma categoria, recebendo um json de categoria. Exemplo http://localhost:8080/category/create, enviando um json de categoria
Exemplo de json de categoria: 
{
    "nameCategory": "Informática",
    "detailsCategory": "Contém produtos de informática"
}

/category/delete/{id} - deleta uma categoria, recebendo um ID da categoria, Exemplo: http://localhost:8080/category/delete/4, irá deletar a categoria de ID 4

/category/{id}/edit - edita uma categoria, recebendo o ID da categoria que você deseja editar, na URL Exemplo: http://localhost:8080/category/1/edit. Será necessário também enviar um json com os novos dados da categoria

