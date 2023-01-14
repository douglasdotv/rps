# rps-1

[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/douglasdotv/rps-1/blob/master/README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/douglasdotv/rps-1/blob/master/README.pt-br.md)

Esta é uma solução que desenvolvi para o [rps](https://hyperskill.org/projects/314?track=12), um dos projetos da trilha Java Backend Developer da Hyperskill.

Trata-se de um jogo simples no qual o usuário pode jogar contra o computador. O usuário é solicitado a digitar seu nome e seu rating é obtida por meio de um arquivo denominado "rating.txt" que contém uma coleção de jogadores e ratings. Se o usuário não for encontrado no arquivo, o rating é definido como 0. O usuário, em seguida, entra com uma lista de movimentos que deseja jogar, separados por vírgulas. Se nenhum movimento for digitado, movimentos padrões serão selecionados. O computador escolherá aleatoriamente um dos movimentos, e também há uma lógica embutida para decidir a fraqueza de cada um dos movimentos. Se o usuário digitar "!exit", o jogo terminará. Se digitar "!rating", seu rating atual será exibido. O jogo continuará rodando até que o usuário determine o encerramento. A cada rodada, se o usuário e o computador escolherem o mesmo movimento, haverá um empate e a rating do usuário aumentará em 50. Se o usuário vencer, a rating do usuário aumentará em 100.

Este projeto é composto pelas seguintes classes:

- Main: ponto de entrada da aplicação
- GameManager: gerencia o jogo, possui métodos para perguntar o nome do jogador, estabelecer o rating, perguntar os movimentos e processar o jogo com eles
- FileHandler: lê o arquivo "rating.txt" e coloca os dados lidos num HashMap
- Player: classe modelo do jogador, guarda o nome e a rating do jogador

### Como rodar

1. Certifique-se de ter o Java 8 ou superior e o Maven instalado.
2. Abra o prompt de comando (ou uma ferramenta semelhante) e navegue até um diretório de sua escolha.
3. Clone o repositório por meio do comando a seguir: 
```
git clone https://github.com/douglasdotv/rps-1.git
```
4. No diretório raiz do projeto, execute o seguinte comando para gerar a build do projeto:
```
mvn package
```
5. Execute seguinte o comando para iniciar o jogo: 
```
java -jar target/rps-1.0-SNAPSHOT.jar
```

Observação: se você encontrar algum problema ao fazer a build ou executar o projeto, verifique se você tem a versão mais recente do Java e do Maven instalados e se as variáveis de ambiente do sistema estão configuradas corretamente.
