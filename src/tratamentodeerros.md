# Tratamento de exceções
- Delega o tramanto nas classes
- Tratar de forma organizada e hierárquica

### try-catch
``
try{
}
catch(nomedoerro apelidoDoErro){}
catch(ex1){}
catch(ex2){}

``
#### finaly
código que vai ser executado independente se houve excecão ou não, ex: fechar 
conexao com db, arquivo, ou um recurso especifico de processamento.

### Pilha chamada de metodos
`printStackTrace()` para prntar o erro especificamente, vai mostrar todo o fluxo 
que gerou a exceção

## Sugestão de pacotes "model"
### Model
- Entities 
- enums
- expection
- services