Write-Host "---------------iniciando script---------------"

Write-Host "--------------parando e excluindo containers em execução---------------"
docker-compose -f .\docker\rinha-compose.yml down

Write-Host "---------------limpando targetr---------------"
mvn clean

Write-Host "---------------removendo imagem docker anterior---------------"
docker rmi rinha-de-backend-2024-q1-micronaut:latest

Write-Host "---------------construindo imagem docker nativa com graalvm---------------"
mvn package -Dpackaging=docker-native -DskipTests

Write-Host "---------------iniciando containers---------------"
docker-compose -f .\docker\rinha-compose.yml up -d

