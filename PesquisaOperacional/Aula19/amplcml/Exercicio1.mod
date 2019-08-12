set Professores;
set Turmas;

param conflito_turma {Turmas, Turmas} >= 0;
param satisfacao_professor {Professores,Turmas} >= 0;
param carga_horaria_turma {Turmas} >= 0;
param carga_horaria_professor {Professores} >= 0;

var x {Turmas, Professores} >= 0;

maximize satisfacao_total : sum {i in Professores, j in Turmas}
satisfacao_professor[i,j] * x[j,i];

subject to restricao1 {j in Turmas}:
sum {i in Professores} x[j,i]=1;

subject to restricao2 {i in Professores}:
sum {j in Turmas} x[j,i] * carga_horaria_turma[j] <= carga_horaria_professor[i];

subject to restricao3 {i in Professores}:
sum {j in Turmas} sum {k in Turmas} conflito_turma[j,k] * x[j,i] * x[k,i] = 0;