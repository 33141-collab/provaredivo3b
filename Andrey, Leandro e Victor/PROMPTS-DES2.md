# PROMPTS: Grupo ____

**Integrantes:**

1. Leandro Volpe
2. Andrey Vinicius
3. Victor Hugo

**Prova:** API em MVC

**Usamos IA?** (X) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):**

usamos o chat gpt para ajudar na estutura e no auxilio dos codigos

## Registro, na ordem

Copie o bloco abaixo para cada prompt. Escreva o prompt exatamente como foi enviado.

### Prompt 1

**O prompt (cópia exata):**

> de acordo com essa topologia me de os codigos

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** (x) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**

### Prompt 2

**O prompt (cópia exata):**

> a estrutura que fizemos esta correta?

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** ( ) usamos como veio  ( ) alteramos  (x) descartamos

**Por quê (o que conferimos, o que mudamos):**

(continuem com quantos blocos precisarem)

## Como conferimos

Descrevam como vocês testaram o que ficou pronto. Colem aqui a saída do programa (POO) ou o resultado do roteiro (API) e digam se bateu com a tabela da prova. Se não bateu, digam o que fizeram.

## Onde a IA errou, ou onde nós erramos

Contem pelo menos um erro que apareceu durante a prova: o que era, como perceberam e como resolveram. Se não apareceu nenhum, expliquem como vocês têm certeza disso.

## Respostas finais, sem consultar a IA

Respondam com as suas palavras, nos últimos 5 minutos. Não copiem de lugar nenhum.

**Pergunta 1:**
Quando alguém pede para reservar uma sala, o Controller recebe o pedido e manda para a Service. A Service verifica se a sala existe e se já está reservada. O Repository procura os dados no banco e o Model guarda as informações da sala e seu status. Depois disso, a resposta volta para o usuário.

**Pergunta 2:**
Porque a Service é responsável pelas regras do sistema. Assim, o Controller fica mais simples e só recebe os pedidos e envia as respostas.

**Pergunta 3:**
apenas o Repository precisaria mudar, porque ele é responsável por acessar o banco de dados. As outras camadas continuariam funcionando normalmente.