![Ifood](https://img.shields.io/badge/Programação2-CESUPA-blue)
# <img src="https://img.shields.io/badge/iFood-EA1D2C?style=for-the-badge&logo=ifood&logoColor=white"> iFood Clone 
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-2D79C7?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

# 🍔 Sistema de Pedidos (iFood Clone)

<img src="https://i.pinimg.com/originals/ef/37/57/ef375738b5d3cc1bd9216f86c58148a9.gif" width="100%"/>

## 📄 Sobre o Projeto
O objetivo deste projeto é desenvolver um sistema de pedidos de restaurante (similar ao iFood), aplicando na prática os pilares da **Programação Orientada a Objetos (POO)**, o padrão de projeto **MVC/DAO** e o desenvolvimento de **Interface Gráfica Rica** em Java.

O sistema permite a interação de dois perfis de usuários: **Dono de Restaurante** (gerenciamento) e **Cliente** (pedidos), com persistência de dados em banco MySQL.

---

## 👥 Equipe
* Alycia Brasil
* Francinetti de Paula
* Flavia Martins
* Paulo de Lucas

---

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java
* **Interface Gráfica:** JavaFX (com FXML e CSS para estilização)
* **Banco de Dados:** MySQL (Conector JDBC)
* **Gerenciamento de Dependências:** Maven
* **IDE/Editor:** VS Code

---

## ⚙️ Funcionalidades e Destaques Técnicos

### 🎨 Animações (JavaFX)
O projeto conta com uma interface fluida e interativa:
* **Transições:** Uso de `TranslateTransition` e `RotateTransition` na tela de login para criar um fundo dinâmico e animado.
* **Feedback Visual:** Validação de campos em tempo real (Listeners) e animação de vibração (`vibrarCampo`) quando o usuário erra a senha ou deixa campos vazios.
* **Interatividade:** Efeitos de escala (`ScaleTransition`) ao passar o mouse sobre os produtos na tela de restaurantes.

### 👥 Perfis de Acesso (Segurança)
O sistema implementa autenticação segura:
* **Validação de Login:** Verifica se o e-mail/usuário existe e compara o hash da senha no banco de dados.
* **Cadastro Inteligente:** Impede e-mails duplicados e valida regras de negócio (tamanho de senha, formato de e-mail).

### 🗺️ Fluxo do Sistema

#### Para o Dono
1.  **Login/Cadastro:** Seleciona a opção "Sou Dono" no registro.
2.  **Cadastrar Restaurante:** Definição da identidade do local.
3.  **Gerenciar Cardápio:** Inserção de produtos com persistência SQL.

#### Para o Cliente
1.  **Ver Restaurantes:** Navegação pelas opções disponíveis.
2.  **Montar Pedido:** Interface visual para escolha de itens.
3.  **Checkout:** Resumo do valor total.

<img width="597" height="426" alt="image" src="https://github.com/user-attachments/assets/e27cc616-2cfc-4dfb-9019-35b89bd49714" />
<img width="596" height="423" alt="image" src="https://github.com/user-attachments/assets/b833add4-167b-4afa-abbf-035e4957eaed" />
<img width="798" height="627" alt="image" src="https://github.com/user-attachments/assets/65a2490e-d8ea-4066-93e3-9bd928db0ce7" />


---

## 🧩 Arquitetura e Conceitos de POO Aplicados

Este projeto foi estruturado para atender aos critérios de avaliação "Excelente", utilizando uma arquitetura separada em camadas (View, Controller, Model, DAO):

### 1. Herança e Polimorfismo
A estrutura de classes evita repetição de código e facilita a manutenção:
* **Classe Abstrata `Produto`:** Base para todos os itens (implementação planejada).
* **Classe `Usuario`:** Entidade base que mapeia os dados da tabela `usuarios`, servindo tanto para Clientes quanto para Donos através do atributo `tipo`.

### 2. Encapsulamento
* Todos os atributos das classes de modelo (`Usuario`) são `private`.
* O acesso é controlado rigorosamente através de **Getters** e **Setters**.
* A conexão com o banco é encapsulada na classe `ConexaoDataBase`, protegendo as credenciais e a lógica de driver.

### 3. Interfaces
* **`Initializable` (JavaFX):** Implementada nos controladores (`TelaDeLogin`, `TelaRestaurantes`) para garantir que a lógica de animação e configuração inicial (listeners) seja executada assim que a interface gráfica é carregada.

### 4. Padrão DAO (Data Access Object)
* A classe `UsuarioDataBase` abstrai toda a complexidade do SQL (`INSERT`, `SELECT`, `COUNT`). O restante do sistema não precisa saber SQL, apenas chama métodos como `.inserirUsuario()` ou `.verificarLogin()`.

---
## 📊 Diagrama de Classes (UML)
<img width="1060" height="3318" alt="Untitled diagram-2025-12-09-035447" src="https://github.com/user-attachments/assets/9b128f85-42b8-45b5-afed-fe84d00af174" />


