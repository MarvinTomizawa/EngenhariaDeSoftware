DECLARE 
Cursor cursor1 is 
  select CODCLIENTE id_cliente, NOME nome_cliente 
  from cliente;
  
Cursor cursor2(v_CODCLIENTE in cliente.CODCLIENTE%type) is 
  select CODPEDIDO id_pedido, nf NF , valortotal valor
  from PEDIDO where CODCLIENTE = v_CODCLIENTE;
  
Cursor cursor3(v_codpedido in pedido.codpedido%type) is
  select pro.descricao , itempe.valorunitario, itempe.quantidade
  from produto pro inner join itempedido itempe inner join pedido pe
  on pro.CODPRODUTO = itempe.CODPRODUTO 
  and itempe.codproduto = v_CODPRODUTO
  and itempe.codpedido = pe.codpedido;

RC1 cursor1%rowtype;
RC2 cursor2%rowtype;
RC3 cursor3%rowtype;

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
      open cursor3(RC2.id_pedido);
      
      loop
        fetch cursor3 into RC3;
        exit when cursor3%notfound;
        DBMS_OUTPUT.PUT_LINE('      item pedido :' || RC3.descricao|| ' Quantidade = ' || RC3.quantidade || ' Valor = ' || RC3.valorunitario );
      end loop;
      
      close cursor3;
        
    end loop;
    
    close cursor2;
    DBMS_OUTPUT.PUT_LINE('');
  end loop;
  
  CLOSE cursor1;
END;


