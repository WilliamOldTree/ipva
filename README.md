# Validação IPVA

### Regras

- Na tela de exibição de todos os carros, serão mostrados os dados dos carros e também se o mesmo tem que pagar IPVA ou não.
- Para os carros com ano <= ao cadastrado na tabela IPVA será também exibido: Sem IPVA. Caso contrário: Com IPVA
- Se a tabela IPVA estiver vazia, então todos os carros exibidos deverão mostrar: Com IPVA.
- Não deve haver mais de 1 registro na tabela IPVA.
- Quando feita qualquer atualização na tabela ipva, os carros exibidos deverão atualizar Sem IPVA ou Com IPVA baseado nas condições acima.
- Acima da exibição de todos os carros, deve-se exibir a quantidade de carros cadastrados e a quantidade de carros que pagam IPVA
- Entregáveis:
- Link github contendo o projeto completo
- Documento contendo:
- Imagens do funcionamento do sistema
- Queries de criação e manipulação das tabelas

### Executar

- Criar database;
- Na tabela carros têm-se: ID, MODEL and YEAR; 
- Na tabela ipva têm-se: ID and YEAR;
- Criar camada de persistencia;
- Criar um CRUD para cadastro de carros e de IPVA;
- Criar as tabelas front-end;
- Aplicar regras de negocio.

 


### Executado
- [:heavy_check_mark:]
