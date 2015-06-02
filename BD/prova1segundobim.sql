
select ClienteNome, ContaAbertura, CartaoLimite from Clientes, CartaoCredito, Contas 
where CartaoCredito.ClienteCodigo = Clientes.ClienteCodigo and Clientes.ClienteCodigo = Contas.ClienteCodigo

select top 1 ClienteNome from Clientes, Emprestimos 
where Clientes.ClientesCodigo = Emprestimos.ClienteCodigo 
order by EmprestimoTotal desc 

Select DepositoValor, AgenciaNome, ClienteNascimento from Agencias, Clientes, Depositantes, Contas 
where Agencias.AgenciaCodigo = Depositantes.AgenciaCodigo and Depositante.ClienteCodigo = Clientes.ClienteCodigo 
and Contas.ClienteCodigo = Clientes.ClienteCodigo and AgenciaCidade = ClienteCidade and AgenciaNome = AgenciaCidade 
and ClienteRua like "06%" and ContaNumero like "%4%"

Select ContaNumero, ClienteNascimento from Contas, Clientes 
where Clientes.ClienteCodigo = Contas.ClienteCodigo and ClienteNome like "%a"



