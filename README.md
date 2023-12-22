# DAC-Projeto-03

## ROTAS

### POST - http://localhost:8080/auth/register

```
{
  "login": "lucas",
  "password": "123456789",
  "role": "ADMIN"
}
```

### POST - http://localhost:8080/auth/login

```
{
  "login": "lucas",
  "password": "123456789"
}
```

### POST - http://localhost:8080/empresa
```
{
  "nome": "Google",
  "setor": "TI",
  "endereco": "Norte"
}

```

### POST - http://localhost:8080/orientador
```
{
  "nome": "Cristiano",
  "departamento": "ADS"
}

```

### POST - http://localhost:8080/estudante
```
{
  "nome": "Italo",
  "curso": "ADS",
  "estagio": {
    "id": 1
   },
   "empresa": {
    "id": 1
   },
  "orientador": {
    "id": 1
   }
}
```

### POST - http://localhost:8080/estagio
```
{
    "nome": "Estágio de Inverno",
    "dataInicio": "2023-02-01",
    "dataFim": "2023-12-15",
    "cargaHorariaTotal": 200,
    "status": "Em andamento",
    "aluno": {
        "id": 1
    },
    "empresa": {
        "id": 1
    },
    "orientador": {
        "id": 1
    }
}
```
