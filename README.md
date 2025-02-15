# Aplicação Java para Publicar e Consumir Mensagens da Fila SQS

Esta aplicação Java é responsável por interagir com a AWS SQS (Simple Queue Service), permitindo que você publique e
consuma mensagens de uma fila SQS.

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter o seguinte:

- **Java 17** ou superior instalado.
- **AWS SDK for Java** (incluso nas dependências do projeto).
- **Credenciais AWS** configuradas em sua máquina
- **Fila SQS** criada na AWS ou Localstack ou acesso a uma fila existente.

## Configuração do Projeto

### Dependências

O projeto utiliza o **AWS SDK** para Java. Se você estiver utilizando o Maven, adicione as seguintes dependências ao
seu `pom.xml`:

```xml
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-aws-starter-sqs</artifactId>
</dependency>
```
