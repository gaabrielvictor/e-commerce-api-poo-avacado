# 🛒 E-commerce API — Spring Boot + MongoDB

Sistema de gerenciamento de e-commerce desenvolvido com **Spring Boot** e **MongoDB**, implementando operações CRUD completas em entidades inter-relacionadas.

---

## 📋 Sobre o Projeto

Este projeto foi desenvolvido como trabalho da 2ª fase da disciplina de POO Avançado, implementando uma API REST para gerenciamento de e-commerce com as seguintes entidades:

- **Categoria** — Classificação dos produtos
- **Produto** — Itens disponíveis para venda
- **Cliente** — Usuários da plataforma
- **Pedido** — Compras realizadas pelos clientes
- **ItemPedido** — Itens dentro de cada pedido

---

## 🔗 Relacionamentos

| Relacionamento | Entidades |
|---|---|
| Um-para-Muitos | Categoria → Produtos |
| Muitos-para-Um | Produtos → Categoria |
| Um-para-Muitos | Cliente → Pedidos |
| Muitos-para-Muitos | Produtos ↔ Pedidos (via ItemPedido) |

---

## 🛠️ Tecnologias Utilizadas

- **Java 22**
- **Spring Boot 4.0.7**
- **Spring Data MongoDB**
- **MongoDB**
- **Lombok**
- **Maven**

---

## 📁 Estrutura do Projeto

```
src/main/java/com/ecommerce/ecommerce/
├── model/
│   ├── Categoria.java
│   ├── Cliente.java
│   ├── Produto.java
│   ├── ItemPedido.java
│   └── Pedido.java
├── repository/
│   ├── CategoriaRepository.java
│   ├── ClienteRepository.java
│   ├── ProdutoRepository.java
│   └── PedidoRepository.java
├── service/
│   ├── CategoriaService.java
│   ├── ClienteService.java
│   ├── ProdutoService.java
│   └── PedidoService.java
├── controller/
│   ├── CategoriaController.java
│   ├── ClienteController.java
│   ├── ProdutoController.java
│   └── PedidoController.java
└── EcommerceApplication.java
```

---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos

- Java 22+
- Maven
- MongoDB instalado e rodando localmente

### Passo a Passo

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/ecommerce.git
cd ecommerce
```

**2. Certifique-se que o MongoDB está rodando**
```bash
mongosh
```

**3. Configure o `application.properties`**
```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=ecommerce_db
```

**4. Rode o projeto**
```bash
./mvnw spring-boot:run
```

**5. Acesse a API**
```
http://localhost:8080
```

---

## 🌐 Endpoints da API

### 📦 Categorias `/categorias`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/categorias` | Lista todas as categorias |
| GET | `/categorias/{id}` | Busca categoria por ID |
| POST | `/categorias` | Cria uma nova categoria |
| PUT | `/categorias/{id}` | Atualiza uma categoria |
| DELETE | `/categorias/{id}` | Remove uma categoria |

**Exemplo de body (POST/PUT):**
```json
{
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral"
}
```

---

### 👤 Clientes `/clientes`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/clientes` | Lista todos os clientes |
| GET | `/clientes/{id}` | Busca cliente por ID |
| POST | `/clientes` | Cria um novo cliente |
| PUT | `/clientes/{id}` | Atualiza um cliente |
| DELETE | `/clientes/{id}` | Remove um cliente |

**Exemplo de body (POST/PUT):**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "telefone": "83999999999",
  "cpf": "123.456.789-00"
}
```

---

### 🛍️ Produtos `/produtos`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca produto por ID |
| POST | `/produtos` | Cria um novo produto |
| PUT | `/produtos/{id}` | Atualiza um produto |
| DELETE | `/produtos/{id}` | Remove um produto |

**Exemplo de body (POST/PUT):**
```json
{
  "nome": "Notebook Dell",
  "descricao": "Notebook i7 16GB RAM",
  "preco": 3500.00,
  "estoque": 10,
  "categoria": { "id": "ID_DA_CATEGORIA" }
}
```

---

### 🧾 Pedidos `/pedidos`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/pedidos` | Lista todos os pedidos |
| GET | `/pedidos/{id}` | Busca pedido por ID |
| POST | `/pedidos` | Cria um novo pedido |
| PUT | `/pedidos/{id}` | Atualiza um pedido |
| DELETE | `/pedidos/{id}` | Remove um pedido |

**Exemplo de body (POST/PUT):**
```json
{
  "dataPedido": "2026-06-28T22:00:00",
  "status": "PENDENTE",
  "valorTotal": 3500.00,
  "cliente": { "id": "ID_DO_CLIENTE" },
  "itens": [
    {
      "quantidade": 1,
      "precoUnitario": 3500.00,
      "produto": { "id": "ID_DO_PRODUTO" }
    }
  ]
}
```

---

## 🗄️ Banco de Dados

O projeto utiliza **MongoDB** com as seguintes collections:

| Collection | Descrição |
|---|---|
| `categorias` | Armazena as categorias |
| `clientes` | Armazena os clientes |
| `produtos` | Armazena os produtos |
| `pedidos` | Armazena os pedidos com itens embutidos |

Para visualizar os dados no MongoDB:
```bash
mongosh
use ecommerce_db
db.categorias.find()
db.clientes.find()
db.produtos.find()
db.pedidos.find()
```

---

## 📌 Ordem de Cadastro Recomendada

Para evitar erros de referência, siga essa ordem:

```
1️⃣ Criar Categoria
2️⃣ Criar Cliente
3️⃣ Criar Produto (referenciando a Categoria)
4️⃣ Criar Pedido (referenciando Cliente e Produto)
```

---

## 👨‍💻 Autor

Desenvolvido por **Gabriel**, **Ramon** & **Angela** — UNIFACISA  
Disciplina: POO Avançado — Prof. Samara
