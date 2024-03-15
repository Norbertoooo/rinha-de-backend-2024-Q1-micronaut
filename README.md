## Rinha de backend 2024 - Q1 - versão: Micronaut


Link da rinha: https://github.com/zanfranceschi/rinha-de-backend-2024-q1


## Anotações pessoais
Aqui trago algumas opiniões pessoais sobre o desenvolvimento com as ferramentas utilizadas


- O framework se mostra de fato como se propõe, algo simples e direto tanto na suas anotações como nas dependências

- É incrível ver na prática o quanto o fato de evitar reflection impacta no artefato final

- O resultado é incrível, uma aplicação em java rodando na graalvm consumir no pico menos de 50Mb é surpreendente e sem
quase perder performance

- A parte de desenvovimento foi tranquilo, exatamente devido à familiaridade com spring, mas a parte de empacotar 
para rodar na graalvm, deu muita dor de cabeça!, pois algumas dependências por sei lá que motivo, impedia da aplicação
iniciar após empacotar e subir no container

- No começo tentei usar o micronaut-data-jpa e flyway, mas tive que retirar exatamente pelo problema acima, resultando
em usar o micronaut-data-jdbc

- Nem tudo são flores, o ganho que se tem no artefato final é incrivel, mas o tempo de build da imagem para graalvm é 
bem mais demorado 

- O tamanho da imagem docker também surpreendeu, menos de 100 MB

- Creio que deva existir uma versão estável que não aconteça os problemas que tive, dessa forma vejo um framework com
apenas ganhos

- Alguns dados para comparação com a versão em spring
  
- | Recurso       | Spring | Micronaut |
  |---------------|--------|-----------|
  | Memória       | 200    |     50    |
  | Imagem docker | 200.23 |   98.68   |





