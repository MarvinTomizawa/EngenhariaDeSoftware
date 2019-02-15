create table temp(
	emp_codigo number constraint primary key,
	codigo_empresa number constraint not null,
	nome_empresa varchar2(50) constraint not null,
	total_carro number constraint not null,
	descricao varchar(50) constraint not null
);

create table carros(
	temp_id number 
);

-- %type --> Associa tipo e tamanho da coluna na tabela;
-- & variavel de substituição que cria uma janela para inserir valores;
Declare
vcampos temp.emp_codigo%type;
vcodigo_empresa temp.codigo_empresa%type = &codigo;
vnome_empresa temp.nome_empresa%type;
vqtde_carro temp.total_carro%type;
vdesc temp.descricao%type;
Begin

select 		emp_codigo,	codigo_empresa,		nome_empresa,	total_carro,	descricao
	into    vcampos,	vcodigo_empresa,	vnome_empresa,	vqtde_carro,	vdesc
From temp where vcodigo_empresa = codigo_empresa;

End


DECLARE
vCodEmp temp.codigo_empresa%type = &codigo;
vNomeEmp temp.nome_empresa%type;
vQtde int;
vDesc;
BEGIN

select e.nome_empresa, count(ce.placa) quantidade 
into vNomeEmp , vQtde
from temp e inner join carro ce
on e.codigo_empresa = ce.codigo_empresa
where e.codigo_empresa = vCodEmp
group by e.nome_empresa;


if vQtde = 0 then
	vDesc := "Não tem nenhum carro associado";
elsif (vQtde < 6) then
	vDesc := "Tem até 5 carros associados";
elsif (vQtde < 12) then
	vDesc := "Tem entre 6 e 11 carros associados";
else 
	vDesc := "Tem mais do que 12 carros associados";
end if;


insert into temp(emp_codigo,codigo_empresa,nome_empresa,total_carro,descricao) values(1,vCodEmp,vNomeEmp,vQtde,"Quantidade de carros");

EXCEPTION

when NO_DATA_FOUND then
	RAISE_APPLICATION_ERROR(-20000,'Nãofoi encontrado nenhum dado');

when OTHERS then
	RAISE_APPLICATION_ERROR(-20001,SQLERRM(SQLCODE) + 'Erro não tratado no plsql');
END



