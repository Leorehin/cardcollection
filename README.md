#Esse é o projeto do santander Dev week Publicando API com postgrees e Railway
Infelizmente o railway nao permitiu que eu colocasse meu codigo nele, mas felizmente consegui implementar a aplicacao e subir ela com banco de dados em nuvem!

##Diagrama de classes
```mermaid
classDiagram
    class User {
        +String name
        +String login
        +String password
        +List~Card~ cardsList
    }

    class Card {
        +String name
        +String color
        +String type
        +String description
    }

    User "1"-->"n" Card
```mermaid
