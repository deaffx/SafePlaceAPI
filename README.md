# SafePlace API

SafePlace é uma aplicação backend desenvolvida com o objetivo de auxiliar pessoas em situações de emergência, permitindo a localização de abrigos e pontos de doação por meio de um sistema seguro e de fácil acesso. O projeto conta ainda com integração futura com uma solução IoT baseada em um botão de emergência comunitário.

## 👥 Integrantes

- Celso Canaveze Teixeira Pinto - RM556118
- Sofia Domingues Gonçalves - RM554920
- Thiago Moreno Matheus - RM554507

## 📽️ Apresentações

- Pitch do Projeto: https://www.youtube.com/watch?v=DNxab_41oIo&ab_channel=SofiaDominguesgoncalves
- Demonstração do Sistema em Funcionamento: https://www.youtube.com/watch?v=pO8aTz4dxlA&ab_channel=ThiagoMatheus

## 🧰 Tecnologias Utilizadas

- Linguagem: Java 17
- Framework: Spring Boot
- Gerenciador de Dependências: Maven
- Banco de Dados: PostgreSQL
- Autenticação: Spring Security com JWT (JSON Web Token)
- IDE: Visual Studio Code

## 📁 Estrutura de Diretórios

SafePlaceAPI/
├── Controller/
├── Model/
├── Repository/
├── Service/
├── Security/
├── Config/
└── application.properties

## 🚀 Como Executar o Projeto

1. Clone o repositório:

   git clone https://github.com/seu-usuario/SafePlaceAPI.git

2. Importe o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code)

3. Configure o banco de dados Oracle e atualize o arquivo `application.properties` com as seguintes propriedades:

   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

4. Execute a aplicação a partir da classe principal:

   SafePlaceApiApplication.java

5. Acesse a API localmente via http://localhost:8080

## 🔒 Autenticação

O projeto utiliza autenticação baseada em JWT. Após o login bem-sucedido, o token JWT é retornado e deve ser incluído no cabeçalho `Authorization` das requisições protegidas:

Authorization: Bearer SEU_TOKEN

## 📌 Principais Endpoints da API

### Usuário
- POST /api/usuarios/register : Cadastrar novo usuário
- POST /api/usuarios/login : Login e geração de token JWT
- GET /api/usuarios : Listar todos os usuários (protegido)
- DELETE /api/usuarios/{id} : Remover usuário

### Abrigo
- GET /api/abrigos : Listar abrigos
- POST /api/abrigos : Cadastrar novo abrigo
- PUT /api/abrigos/{id} : Atualizar abrigo
- DELETE /api/abrigos/{id} : Excluir abrigo

### Alerta
- GET /api/alertas : Listar alertas
- POST /api/alertas : Cadastrar novo alerta
- PUT /api/alertas/{id} : Atualizar alerta
- DELETE /api/alertas/{id} : Excluir alerta
