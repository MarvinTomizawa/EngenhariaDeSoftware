set TAREFAS;  
set MAQUINAS;

param custo_por_tarefa	{MAQUINAS,TAREFAS} >= 0;
param demanda       	{TAREFAS} >= 0;
param capacidade    	{MAQUINAS} >= 0;

param x {MAQUINAS,TAREFAS} = 1;
param c {TAREFAS,MAQUINAS} = 1;

minimize custo_total: sum {i in TAREFAS, j in MAQUINAS} custo_por_tarefa[i,j];

subject to restricao1 {i in TAREFAS}: prod {j in MAQUINAS} x[i,j] = x[i,j];
subject to restricao2 {j in MAQUINAS}: prod{i in TAREFAS} x[i,j] = c[i,j];


