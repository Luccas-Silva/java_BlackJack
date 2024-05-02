# Projeto Java BlackJack

### Introdução
Este projeto "Java BlackJack" implementa um sistema completo para gerenciar o jogo de Blackjack, utilizando a Deck of Cards API `(https://www.deckofcardsapi.com/)` e um banco de dados. O projeto segue a arquitetura em camadas e utiliza Maven para organização do código.

## Arquitetura em Camadas
O projeto segue a arquitetura em camadas, dividindo o código em módulos distintos com responsabilidades específicas:
- **Camada de Modelo:** Define as classes que representam os objetos do jogo, como cartas, jogadores e partidas.
- **Camada de Serviço:** Contém as regras do jogo e a lógica para realizar ações, como embaralhar cartas, distribuir cartas aos jogadores e verificar vencedores.
- **Camada de DAO (Data Access Object):** Fornece acesso ao banco de dados, permitindo persistir e recuperar dados das partidas.
- **Camada de Visão:** Implementa a interface de console para interagir com o usuário, exibindo informações sobre o jogo e permitindo que o usuário realize ações.

## Consumo de API
O projeto utiliza a biblioteca HttpClient e HttpEntity para realizar requisições HTTP à Deck of Cards API. As respostas da API são deserializadas em objetos Java usando bibliotecas como Gson.

## Gerenciamento de Banco de Dados
O projeto utiliza um gerenciador de banco de dados relacional, como MySQL, para armazenar os dados do jogo. A biblioteca JDBC é utilizada para estabelecer a conexão com o banco de dados e executar operações SQL.

## Salvando Dados no Banco de Dados
Os dados processados durante o jogo são salvos no banco de dados para consultas posteriores. Isso permite que o usuário visualize o histórico de partidas, consulte estatísticas de jogadores e acompanhe seu progresso ao longo do tempo.

## Tecnologias Utilizadas
- `Java`
- `Maven`
- `HTTP Client`
- `Gson`
- `JDBC`
- `Banco de dados relacional (MySQL)`

## Benefícios
- **Arquitetura robusta e escalável:** A arquitetura em camadas facilita a manutenção, reutilização e teste do código.
- **Gerenciamento eficiente de dados:** O consumo de API e o armazenamento em banco de dados permitem a manipulação e consulta eficiente de dados.
- **Interface de usuário amigável:** A interface de console permite que o usuário interaja com o sistema de forma simples e intuitiva.

## Conclusão
O projeto "Java BlackJack" demonstra a aplicação de conceitos importantes de desenvolvimento de software, como arquitetura em camadas, consumo de API, gerenciamento de banco de dados e interface de usuário. O projeto pode ser facilmente estendido para incluir novas funcionalidades, como suporte a diferentes tipos de jogos de cartas ou a implementação de uma interface gráfica.
