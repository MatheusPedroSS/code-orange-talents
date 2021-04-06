# code-orange-talents

## OBS:

Para testa a API e necessario o Postman ou Insomnia.

### Rotas:

- POST: https://codechallengerorange.herokuapp.com/cadPessoa
- POST: https://codechallengerorange.herokuapp.com/vacina

- GET: https://codechallengerorange.herokuapp.com/cadPessoa/{id}
- GET: https://codechallengerorange.herokuapp.com/vacina/{id}

O Corpo da requisição deverá ser enviado dessa forma:

```
Pessoa:
  {
    "nome": "Joao",
    "email": "joao@gmail.com",
    "cpf": "70950585475",
    "dataNasc": "21/10/2013"
  }
```
``` 
Vacina:
  {
    "nome": "CoronaVAC",
    "dataVacinacao": "01/03/2021",
    "pessoa": 1
  }
``` 
