DECLARE 
Cursor cursor1 is -- Cria um cursor a partir de um select
  select CODCLIENTE id_cliente, NOME nome_cliente 
  from cliente;
  v_nome_cliente CLIENTE.NOME%type;
  v_id_cliente CLIENTE.CODCLIENTE%type;
RC1 cursor1%rowtype; -- Cria um registro de uma linha a partir da estrutura do cursor
BEGIN
  OPEN cursor1; -- Salva os dados para a memória permitindo a manipulação
  fetch cursor1 into RC1;-- Joga os valores no indice atual do cursor para dentro de algo (ROWTIPE ou ESTRUTURA DE COLUNAS) e passa para o próximo registro
  fetch cursor1 into v_id_cliente, v_nome_cliente;

  DBMS_OUTPUT.PUT_LINE('Com rowtype' || RC1.id_cliente || ' : ' || RC1.nome_cliente);
  DBMS_OUTPUT.PUT_LINE('Com rowtype' || v_id_cliente || ' : ' || v_nome_cliente);
  CLOSE cursor1;
END;
