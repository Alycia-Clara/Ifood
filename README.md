# 🍔 Sistema de Pedidos (iFood)

## 📄 Sobre o Projeto
O objetivo deste projeto é desenvolver um sistema de pedidos de restaurante (similar ao iFood), aplicando na prática os pilares da **Programação Orientada a Objetos (POO)** e desenvolvimento de **Interface Gráfica** em Java.

O sistema permite a interação de dois perfis de usuários: **Dono de Restaurante** (gerenciamento) e **Cliente** (pedidos).

---

## 👥 Equipe
* Alycia Brasil
* Francinetti de Paula
* Flavia Martins
* Paulo de Lucas

---

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java
* **Interface Gráfica:** 
* **Compilador:** VS Code

---

## ⚙️ Funcionalidades

### 👨‍🍳 Módulo: Dono do Restaurante
- [x] **Cadastro de Restaurante:** Inserção de nome e endereço.
- [x] **Gerenciamento de Cardápio:** Adicionar, editar e remover produtos.
- [x] **Categorização:** Produtos divididos em `Comida` (com tipo de cozinha e flag vegano) e `Bebida` (com tamanho em ml e seu teor álcolico.)
- [x] **Persistência:** Salvar as alterações realizadas no sistema.

### 🧑‍💻 Módulo: Cliente
- [x] **Visualização:** Listagem dos restaurantes cadastrados.
- [x] **Pedido:** Seleção de restaurante e escolha de produtos do cardápio.
- [x] **Resumo:** Exibição do valor total do pedido e tempo estimado de entrega.

---

## 🧩 Arquitetura e Conceitos de POO Aplicados

Este projeto foi estruturado para atender aos critérios de avaliação "Excelente" nas seguintes competências:

### 1. Herança e Polimorfismo
A estrutura de classes evita repetição de código e facilita a manutenção:
* **Classe Abstrata `Produto`:** Base para todos os itens. Define atributos comuns (preço, nome).
    * `Comida extends Produto`: Adiciona `tipoCozinha` e `isVegano`.
    * `Bebida extends Produto`: Adiciona `tamanhoMl` e `isAlcoolica`.
* **Classe Abstrata `Usuario`:** Base para autenticação.
    * `Cliente extends Usuario`: Possui endereço e dados de entrega.
    * `DonoRestaurante extends Usuario`: Possui associação com o Restaurante.

### 2. Encapsulamento
* Todos os atributos das classes de modelo são `private`.
* O acesso é controlado rigorosamente através de **Getters** e **Setters**.
* Construtores flexíveis (sobrecarga) permitem instanciar objetos de diferentes formas.

### 3. Interfaces

---

## 📊 Diagrama de Classes (UML)



