DECLARE 
Cursor cursor1 is 
  select CODCLIENTE id_cliente, NOME nome_cliente 
  from cliente;
  v_nome_cliente CLIENTE.NOME%type;
  v_id_cliente CLIENTE.CODCLIENTE%type;
RC1 cursor1%rowtype;
BEGIN
  OPEN cursor1; 
  loop
    fetch cursor1 into RC1;
    
    DBMS_OUTPUT.PUT_LINE('Com rowtype' || RC1.id_cliente || ' : ' || RC1.nome_cliente);
  exit when cursor1%NOTFOUND;
  end loop;
  
  CLOSE cursor1;
END;