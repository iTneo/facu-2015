--1) Mostre qual o percentual dos fundos 
--de cada agência está comprometido com 
--empréstimo

-- select agencianome, (sum(EmprestimoTotal)*100)/Agenciafundos  from agencias join emprestimos on (agencias.AgenciaCodigo = Emprestimos.AgenciaCodigo) group by agencianome, AgenciaFundos



--2) Mostre os meses que tiveram depósito 
--acima média para o banco, classificando 
--esses meses em: Acima da Média e Abaixo 
--da Média.
--Não esqueça de ordenar os meses
--Pesquise sobre as funões abaixo para 
--resolver o problema:


--select datename(mm,depositodata) as 'mês',
--case 
--	when sum(depositovalor) > (select avg(depositovalor) from depositantes) then 'Acima da média'
--	else 'Abaixo da média'
--end as 'Classificação'
---from depositantes
--group by datename(mm,depositodata),depositodata
--order by MONTH(depositodata)







--DATENAME

--3) Crie uma lista classificando as 
--agências que tiveram mais de 4 depósitos
 --em acima da média,  
 --menos que dois abaixo da meta 
 --e entre esses dois anteriores dentro da meta

--select agenciaNome, 
---case 
--	when count(depositoValor) >= 4 then 'Acima da média'
--	when count(depositovalor) < 2 then 'Abaixo da meta'
--	else 'Dentro da meta' 
--end as 'Meta'
--from agencias join depositantes on (agencias.AgenciaCodigo = depositantes.agenciacodigo) group by Agencianome

--4) Encontre os 3 maiores devedores do banco
--select ClienteNome, DevedorSaldo from clientes join devedores on (clientes.ClienteCodigo = devedores.ClienteCodigo)
--order by DevedorSaldo  desc


--5) Mostre os 5 clientes mais velhos 
--select top 5 clienteNome, YEAR(getdate()) - YEAR(clienteNascimento) from clientes order by ClienteNascimento asc







--6) Mostre os clientes mais novos
--select clienteNome, YEAR(getdate()) - YEAR(clienteNascimento) from clientes order by ClienteNascimento desc
