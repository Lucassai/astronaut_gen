# 🎮 Astronaut Games

Projeto desenvolvido para gerenciar categorias e produtos de uma loja de jogos. Este sistema permite criar, listar, buscar, atualizar e excluir categorias, além de facilitar a integração com um banco de dados relacional.🚀

---

## 📝 **Descrição Geral**

O SGRH automatiza e controla as informações dos colaboradores, facilitando tarefas comuns do setor de RH.  
Desenvolvido em **Java**, com **Spring Boot** e banco de dados **MySQL**, o sistema oferece uma API eficiente para integrações futuras.  

---

## 🛠️ **Funcionalidades Principais**

1. **Cadastro de Jogos (Create)** ✍️  
   - Insira novos jogos para o estoque da loja e gerencie as suas categorias.  

2. **Leitura de Dados (Read)** 📄  
   - Exiba dados gerais ou específicos dos jogos como preços, categorias ou número no estoque.  

3. **Atualização de Dados (Update)** 🔄  
   - Atualize o número de jogos no estoque ou mude o nome para acrescentar dlcs.  

4. **Exclusão de jogos ou categorias(Delete)** ❌  
   - Remova registros utilizando o ID.  

5. **Pesquisa por categoria ** 🔍  
   - Consulte informações da tabela de jogos por categoria.
   - 
6. **Pesquisa por id ** 🔍  
   - Consulte informações de jogos especificos pelo ID de cada jogo.  
---

## 🔧 **Tecnologias Utilizadas**

- **Java** ☕: Backend robusto e confiável.  
- **Spring Boot** ⚙️: Framework para rápida criação de aplicações web.  
- **Spring Data JPA** 🛢️: Interação com MySQL através de ORM.  
- **MySQL** 🗄️: Banco de dados relacional para armazenamento seguro.  
- **Insomnia** 🧪: Testes e validações das APIs RESTful.  


🛤️ Endpoints categoria

Método	Endpoint	Descrição
GET	/categorias	Lista todas as categorias.
GET	/categorias/{nomeCategoria}	Busca uma categoria pelo nome.
POST	/categorias	Cadastra uma nova categoria.
PUT	/categorias/{id}	Atualiza uma categoria existente.
DELETE	/categorias/{id}	Exclui uma categoria existente.









