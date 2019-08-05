set CIDADES;
set SUBESTACOES;
param custo_energia {SUBESTACOES, CIDADES} >= 0;
param demanda {CIDADES} >= 0;
param capacidade {SUBESTACOES} >= 0;
var x {SUBESTACOES, CIDADES} >= 0;
minimize custo_total: sum {i in SUBESTACOES, j in CIDADES} custo_energia[i,j] * x[i,j];
subject to restricao1{i in SUBESTACOES}: sum{j in CIDADES} x[i,j] <= capacidade[i];
subject to restricao2{j in CIDADES}: sum{i in SUBESTACOES} x[i,j] >= demanda[j]; 