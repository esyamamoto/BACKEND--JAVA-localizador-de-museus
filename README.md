# `Localizador de Museus`

details>
  <summary>👨‍💻</summary><br />

Neste projeto implementei uma API cuja principal funcionalidade é facilitar a busca por museus baseada em sua localização. Os dados foram retirados [desta](http://dados.cultura.gov.br/dataset/series-historicas-cadastro-nacional-de-museus) série histórica.

</details>

<details>
  <summary><strong>📝 Habilidades trabalhadas</strong></summary>

- Criar classes de controle e suas rotas
- Criar classes de serviço
- Utilizar injeção de dependências
- Trabalhar com exceções customizadas
- Tratar exceções da API através de gerenciadores de erros
- Implementar testes unitários para cobertura de código
- Criar uma configuração Docker para sua aplicação

</details>

<details>
  <summary><strong>O que foi criado:</strong></summary>

- Dockerfile para a aplicação
- Um ControllerAdvice para tratar erros
- rota GET `/museums/closest`, que retornará o museu mais próximo
- classe controller para `/museums` com rota POST
- método getClosestMuseum na classe para a camada de serviço
- método `createMuseum`, que cria um novo museu
- uma classe para a camada de serviço

</details>

## Orientações

<details>
 
- dependências: `mvn install -DskipTests` 
- Para executar todos os testes basta rodar o comando: mvn test
- Para executar apenas uma classe de testes: mvn test -Dtest="TestClassName"

</details>

