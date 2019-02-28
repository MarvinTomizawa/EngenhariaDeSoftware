DECLARE 
Cursor cursor1 is 
  select CODCLIENTE id_cliente, NOME nome_cliente 
  from cliente;
  
Cursor cursor2(v_CODCLIENTE in cliente.CODCLIENTE%type) is 
  select CODPEDIDO id_pedido, nf NF , valortotal valor
  from PEDIDO where CODCLIENTE = v_CODCLIENTE;
  
RC1 cursor1%rowtype;
RC2 cursor2%rowtype;
BEGIN
  OPEN cursor1; 
  loop
    fetch cursor1 into RC1;
    exit when cursor1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Cliente ' || RC1.id_cliente || ' : ' || RC1.nome_cliente);
    open cursor2(RC1.id_cliente);
    
    loop
      fetch cursor2 into RC2;
      exit when cursor2%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('    Pedido ' || RC2.id_pedido|| ' : ' || RC2.NF || ' Valor = ' || RC2.valor );
    end loop;
    
    close cursor2;
    DBMS_OUTPUT.PUT_LINE('');
  end loop;
  
  CLOSE cursor1;
END;