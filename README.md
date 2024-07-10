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

/category/edit/{id} - edita uma categoria, recebendo o ID da categoria que você deseja editar, na URL. Exemplo: http://localhost:8080/category/edit/1. Será necessário também enviar um json com os novos dados da categoria

2 - Produto

/product - retorna todos os produtos

/product/{id} - retorna um produto dado um ID especificado. Exemplo: http://localhost:8080/product/1 irá retornar o produto de ID 1

/product/create - cria um produto, recebendo um json de produto. Exemplo: http://localhost:8080/product/create, enviando um json de produto
Exemplo de json de produto:

{
    "nameProduct": "Shampoo Clear Men do CR 7",
    "detailsProduct": "Shampoo Clear Men do CRSeven",
    "priceProduct": 10,
    "idCategory": 1
}

/product/delete{id} - deleta um produto, recebendo um ID do produto. Exemplo http://localhost:8080/product/delete/1, irá deletar o produto de ID 1

/product/edit/{id} - edita um produto, recebendo o ID do produto que você deseja editar, na URL. Exemplo: http://localhost:8080/product/edit/1. Será necessário também enviar um json com os novos dados do produto

## Frontend em Angular

Para rodar o projeto em angular, basta importar o projeto para sua IDE de preferencia, navegar com com o Angular CLI até a pasta do projeto e rodar o comando ng serve
Por padrão, o projeto funciona na porta 4200. Sendo http://localhost:4200/ a raiz do nosso crud

O arquivo crud-angular-spring\app-join-front\src\app\app-routing.module contém as rotas do projeto.

1 - Models
Refere-se às nossas classes de negócio: Category e Product. as classes são basicamente pojos (cópias das tabelas do banco), ficam localizadas em crud-angular-spring\app-join-front\src\app\model

2 - Services
Refere-se às classes de serviço: CategoryService e ProductService. Essas classes são responsáveis por fazer requisições HTTP nos endpoints que nossa API em Spring serve.

3 - Componentes
Refere-se aos fragmentos de código typescript que contém os scripts das nossas páginas.
Temos 4 componentes para cada um dos nossos Models (Category e Product), totalizando 8 componentes

category-create - Contém os scripts para criação de categoria
category-details - Contém os scripts para visualização de uma categoria
category-list - Contém os scripts para visualização da lista de todas as categorias, além de botões para exclusão, visualização, edição de categorias.
category-update - Contém os scripts para atualização de uma categoria

product-create - Contém os scripts para criação de um produto
product-details - Contém os scripts para visualização de um produto
product-list - Contém os scripts para visualização da lista de todos os produtos, além de botões para exclusão, visualização, edição de produtos
product-update - Contém os scripts para atualização de um produto


