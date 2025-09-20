# AcessorXPSOA — Serviço de Assessoria (SOA + Web Services)

Sprint 3 de ARQUITETURA ORIENTADA A SERVICOS E WEB SERVICES. 

## Alunos:
* Bruno Venturi Lopes Vieira - 99431
* Guilherme Alves de Lima - 550433
* Pedro Guerra de Souza Freitas - 99526
* Leonardo de Oliveira Ruiz - 98901

## 👀 Visão Geral
- **Domínio:** Ativos, Clientes, Recomendação de Carteira (Conservador/Moderado/Arrojado).
- **Banco:** H2 (memória) versionado com Flyway (`ddl-auto: validate`).
- **Validações:** DTOs com `jakarta.validation` e params com `@Validated`.
- **Erros:** `@RestControllerAdvice` com payload consistente.
- **Interface de Acesso:** 
  - **Postman Collection** e **Environment** (prontos neste repositório/artefato).
  - Alternativa: **cURL** (script `demo.sh`) e **H2 Console**

## ⚙️ Requisitos
- JDK 17
- Maven 3.9+

## ▶️ Como executar
```bash
mvn clean spring-boot:run
```
Verifique no log: `Flyway ... Successfully applied ...` e sem exceções.
H2 Console: `http://localhost:8080/h2`  
JDBC: `jdbc:h2:mem:assessor` | user: `sa` | senha: *(vazio)*

## 🔌 Endpoints principais
`/api/ativos` — CRUD  
`/api/clientes` — CRUD  
`/api/recomendacoes` — Geração de carteira por perfil do cliente  
`/api/variaveis-macro` (EM DESENVOLVIMENTO) — CRUD  

## 🧪 Como **demonstrar o consumo** (Interface de acesso)
### Opção A — **Postman**
1. Importe o arquivo:
   - `AcessorXPSOA.postman_collection.json`
2. Execute em ordem:
   - **Clientes → Criar Cliente**
   - **Ativos → Criar Ativo**
   - **Recomendação → Gerar Recomendação**
4. Inspecione as respostas e payloads retornados.

### Opção B — **Console do H2**
1. Acesse `http://localhost:8080/h2`
2. Rode:
```sql
SELECT * FROM CLIENTES;
SELECT * FROM ATIVOS;
SELECT * FROM FLYWAY_SCHEMA_HISTORY;
```

## 📡 Exemplos de requisições e respostas
### Criar Cliente
**POST** `/api/clientes`
```json
{
  "nome":"Pedro",
  "cpf":"12345678901",
  "perfil":"MODERADO"
}
```
**201 Created**
```json
{
  "id": 1,
  "nome": "Pedro",
  "cpf": "12345678901",
  "perfil": "MODERADO"
}
```

### Criar Ativo
**POST** `/api/ativos`
```json
{
  "nome":"ETF BOVA11",
  "classe":"RENDA_VARIAVEL",
  "retornoHistorico":10.2,
  "liquidezDias":2
}
```
**201 Created** — corpo com o ativo criado.

### Gerar Recomendação
**POST** `/api/recomendacoes`
```json
{ "clienteId": 1 }
```
**200 OK**
```json
{
  "risco":"MODERADO",
  "alocacao":[
    {"classe":"RENDA_FIXA","percentual":50.0},
    {"classe":"RENDA_VARIAVEL","percentual":25.0},
    {"classe":"MULTIMERCADO","percentual":15.0},
    {"classe":"CAMBIAL","percentual":10.0}
  ],
  "explicacao":"..."
}
```

## 🧱 Tecnologias
- **Java 17**, **Spring Boot 3** (Web, JPA, Validation)
- **H2 Database**, **Flyway**
- **Lombok** (opcional), **springdoc-openapi** (opcional)

## 🧰 Estrutura
- `controller/` — endpoints REST (`AtivoController`, `ClienteController`, `RecomendacaoController`)
- `service/` — regras de negócio + transações
- `repository/` — Spring Data JPA
- `dto/` e `mapper/` — transporte/mapeamento
- `domain/` — entidades e VOs
- `exception/` — `ResourceNotFoundException`, `GlobalExceptionHandler`
- `db/migration/` — scripts Flyway `Vx__...sql`

## ✅ Check de qualidade
- Padrão de respostas com `ResponseEntity`
- Validações em DTOs e parâmetros
- Tratamento de erro consistente (400/404/409/500)
- Migrations versionadas e `ddl-auto: validate`
