# code-orange-talents

## Primeiros Passos:

Para utilizar verificar o funcionamento da API o ideial e utilizar o Postman pra isso.

Rotas:

POST: https://codechallengerorange.herokuapp.com/cadPessoa
POST: https://codechallengerorange.herokuapp.com/vacina

GET: https://codechallengerorange.herokuapp.com/cadPessoa/{id}
GET: https://codechallengerorange.herokuapp.com/vacina/{id}

O Corpo da requisição deverá ser enviado dessa forma:

Pessoa:
  {
    "nome": "Joao",
    "email": "joao@gmail.com",
    "cpf": "70950585475",
    "dataNasc": "21/10/2013"
  }
  
Vacina:
  {
    "nome": "CoronaVAC",
    "dataVacinacao": "01/03/2021",
    "pessoa": 1
  }
