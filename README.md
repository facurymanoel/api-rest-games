# 🎮 DSList – API de Gerenciamento de Listas de Jogos

## 📌 Sobre o Projeto

O DSList é uma API REST desenvolvida com Java e Spring Boot, com o objetivo de gerenciar jogos e organizá-los em listas personalizadas.

A aplicação permite consultar informações sobre jogos, acessar diferentes listas e alterar a posição dos jogos dentro de uma determinada lista.

O principal objetivo deste projeto é aplicar conceitos de desenvolvimento backend, incluindo APIs REST, programação orientada a objetos, relacionamentos entre entidades, DTOs e implementação de regras de negócio.

## 🎯 Objetivos do Projeto

- Gerenciar informações de jogos.
- Organizar jogos em diferentes listas.
- Consultar informações completas ou resumidas dos jogos.
- Exibir os jogos de acordo com suas posições dentro de uma lista.
- Permitir a alteração da ordem dos jogos.
- Persistir as alterações realizadas no banco de dados.

## 🚀 Funcionalidades

- **Consulta de Jogos:** permite consultar todos os jogos ou buscar um jogo específico pelo seu ID.
- **Listas de Jogos:** permite consultar as listas disponíveis.
- **Consulta por Lista:** exibe os jogos pertencentes a uma determinada lista.
- **Reordenação de Jogos:** permite alterar a posição dos jogos dentro de uma lista.
- **Persistência da Ordenação:** armazena as novas posições dos jogos no banco de dados.

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate / JPA
- API REST
- Lombok
- DTO (Data Transfer Object)
- JPA Projections
- SQL (Consultas Nativas)
- Maven

## 🏗️ Arquitetura do Projeto

A aplicação utiliza uma arquitetura em camadas, separando as responsabilidades em diferentes pacotes.

```text
src/main/java/com/devs/superior/dslist/
│
├── controllers/
│   ├── GameController.java
│   └── GameListController.java
│
├── dto/
│   ├── GameDTO.java
│   ├── GameListDTO.java
│   ├── GameMinDTO.java
│   └── ReplacementDTO.java
│
├── entities/
│   ├── Game.java
│   ├── GameList.java
│   ├── Belonging.java
│   └── BelongingPk.java
│
├── projections/
│   └── GameMinProjection.java
│
├── repositories/
│   ├── GameRepository.java
│   └── GameListRepository.java
│
├── services/
│   ├── GameService.java
│   └── GameListService.java
│
└── DslistRevisaoApplication.java
```

## 🧠 Regra de Negócio – Reordenação de Jogos

Uma das principais funcionalidades do projeto é permitir que o usuário altere a posição dos jogos dentro de uma lista.

Para implementar essa funcionalidade, foi utilizada a entidade `Belonging`, responsável por representar o relacionamento entre jogos e listas, armazenando também a posição de cada jogo.

Quando o usuário solicita uma alteração de posição, a aplicação:

1. Recupera os jogos pertencentes à lista selecionada.
2. Identifica as posições de origem e destino.
3. Reorganiza os jogos em memória.
4. Atualiza as posições correspondentes no banco de dados.
5. Persiste as alterações utilizando uma operação transacional.

Essa funcionalidade demonstra a aplicação de regras de negócio, relacionamentos entre entidades e gerenciamento de transações com Spring.

## 🔗 Endpoints da API

### Jogos

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/games` | Consulta todos os jogos |
| GET | `/games/{id}` | Consulta um jogo pelo ID |

### Listas de Jogos

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/lists` | Consulta todas as listas |
| GET | `/lists/{listId}/games` | Consulta os jogos de uma lista específica |
| POST | `/lists/{listId}/replacement` | Altera a posição dos jogos dentro de uma lista |

### Exemplo de Reordenação de Jogos

**POST** `/lists/1/replacement`

Corpo da requisição:

```json
{
  "sourceIndex": 0,
  "destinationIndex": 2
}
```

A requisição move o jogo que está na posição 0 para a posição 2 dentro da lista selecionada. As posições começam em zero.

## 📚 Conceitos Aplicados

- Programação Orientada a Objetos (POO).
- Arquitetura em Camadas.
- Desenvolvimento de APIs REST.
- Relacionamentos entre Entidades e Chaves Primárias Compostas.
- Padrão DTO.
- JPA Projections.
- Repositórios com Spring Data JPA.
- Consultas SQL nativas.
- Gerenciamento de Transações com `@Transactional`.
- Separação de Responsabilidades.

## 👨‍💻 Autor

**Manoel Dalmo Facuri Filho**

Desenvolvedor Java Backend

- GitHub: [@facurymanoel](https://github.com/facurymanoel)
- LinkedIn: [Manoel Facuri](https://www.linkedin.com/in/manoel-facuri/)
