![Ifood](https://img.shields.io/badge/Projeto-Ifood-red)

# 🍔 Sistema de Pedidos (iFood)
<img src="https://i.pinimg.com/originals/ef/37/57/ef375738b5d3cc1bd9216f86c58148a9.gif"/><img width="640" height="360" alt="image" src="


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

# 👥 Perfis de Acesso

O sistema é dividido em duas áreas de atuação, cada uma com funcionalidades específicas:

### 👨‍🍳 Dono do Restaurante
Responsável pela gestão do estabelecimento.
* **Cadastro:** Insere nome e endereço do restaurante.
* **Gerenciamento de Produtos:** Adiciona, modifica e remove produtos do cardápio.
* **Persistência:** Salva as alterações realizadas no sistema.

### 🧑‍💻 Cliente
Usuário final que realiza o pedido.
* **Visualização:** Acessa a lista de restaurantes cadastrados.
* **Seleção:** Escolhe um restaurante e seleciona os produtos desejados.
* **Finalização:** Recebe o cálculo do valor total e o tempo estimado de espera do pedido.

## 🗺️ Fluxo do Sistema

O fluxo de utilização do software segue as etapas abaixo para cada perfil:

### Para o Dono
1.  **Login/Cadastro:** Acesso inicial.
2.  **Cadastrar Restaurante:** Definição da identidade do local.
3.  **Gerenciar Cardápio:** Inserção de Comidas e Bebidas com seus respectivos preços e tempos de preparo.

### Para o Cliente
1.  **Ver Restaurantes:** Navegação pelas opções disponíveis.
2.  **Montar Pedido:** Seleção de itens (o sistema trata polimorficamente comidas e bebidas na mesma lista).
3.  **Checkout:** O sistema exibe o resumo: `Total a Pagar` + `Tempo Estimado de Entrega`.
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



