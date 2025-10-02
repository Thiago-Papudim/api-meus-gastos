🧾 API Meus Gastos

Uma API RESTful construída em Java com Spring Boot, voltada para controle financeiro pessoal (despesas, receitas, categoria, relatórios, etc).

📋 Sumário

Descrição

Tecnologias usadas

Pré-requisitos

Como usar / executar

Endpoints da API

Modelagem / Domínio

Tratamento de erros

Dados iniciais / seed

Autor

Descrição

A API Meus Gastos permite que você registre despesas e receitas, categorize-as, consulte relatórios e mantenha um histórico financeiro pessoal. Permite operações de CRUD completas e consultas estatísticas.

Use esse projeto como base ou inspiração para suas aplicações financeiras ou de controle pessoal.

Tecnologias usadas

Java (versão compatível com Spring Boot)

Spring Boot

Spring Web (para criação de APIs REST)

Spring Data JPA (com Hibernate)

Banco de dados (ex: H2 em memória para desenvolvimento / testes)

Maven (gerenciamento de dependências / build)

(Opcional) Banco relacional como PostgreSQL ou MySQL para ambientes de produção

Pré-requisitos

Java instalado (versão mínima compatível, p.ex. Java 17+)

Maven

Git

Como usar / executar

Clone o repositório:

git clone https://github.com/Thiago-Papudim/api-meus-gastos.git
cd api-meus-gastos


Execute a aplicação:

./mvnw spring-boot:run


ou

mvn spring-boot:run


Acesse a API via localhost (por padrão http://localhost:8080).

(Opcional) Se estiver usando H2 no perfil de desenvolvimento: acesse o console H2:

http://localhost:8080/h2-console


JDBC URL geralmente: jdbc:h2:mem:testdb

Usuário: sa

Senha: (vazia ou conforme configuração)

Endpoints da API

Os endpoints abaixo são exemplos sugeridos — ajuste conforme o que existe no projeto real.

Método	Endpoint	Descrição
GET	/receitas	Lista todas as receitas
POST	/receitas	Cria nova receita
GET	/receitas/{id}	Obtém receita por ID
PUT	/receitas/{id}	Atualiza receita existente
DELETE	/receitas/{id}	Remove receita
Método	Endpoint	Descrição
GET	/despesas	Lista todas as despesas
POST	/despesas	Cria nova despesa
GET	/despesas/{id}	Obtém despesa por ID
PUT	/despesas/{id}	Atualiza despesa existente
DELETE	/despesas/{id}	Remove despesa
Método	Endpoint	Descrição
GET	/categorias	Lista todas as categorias
POST	/categorias	Cria nova categoria
etc.	…	…
Método	Endpoint	Descrição
GET	/relatorios/mensal?mes=MM&ano=YYYY	Retorna relatório financeiro mensal (receitas, despesas, saldo)
GET	/relatorios/por-categoria?ano=YYYY&categoriaId=X	Relatório por categoria
Modelagem / Domínio

As principais entidades esperadas:

Receita
Campos típicos: id, valor, data, descrição, categoria, usuário

Despesa
Campos típicos: id, valor, data, descrição, categoria, usuário

Categoria
Campos: id, nome, tipo (receita ou despesa)

Usuário (opcional)
Se a API for multiusuário, pode haver entidade de usuário com autenticação

Relações comuns:

Muitos → um entre receita/despesa e categoria

(Se existir) Um usuário → muitas receitas / despesas

Use as anotações @Entity, @ManyToOne, @OneToMany etc.

Tratamento de erros

Use @ControllerAdvice para capturar exceções globais

Retorne respostas com status HTTP adequados:

404 Not Found para recursos não encontrados

400 Bad Request para dados inválidos

201 Created para criados

204 No Content para deleções bem-sucedidas

500 Internal Server Error para falhas inesperadas

Estrutura de resposta de erro pode seguir modelo:

{
  "timestamp": "2025-10-02T12:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Receita não encontrada com ID = 5",
  "path": "/receitas/5"
}

Dados iniciais / seed

É interessante popular algumas categorias padrões e exemplos de receitas/despesas ao iniciar a aplicação — por exemplo, usando um CommandLineRunner ou arquivo SQL data.sql.

Exemplos:

Categoria “Salário” (Receita)

Categoria “Alimentação” (Despesa)

Receita de teste no valor de X

Despesa de teste no valor de Y

Isso facilita testes via Postman logo após subir a aplicação.

Autor

Thiago Papudim
