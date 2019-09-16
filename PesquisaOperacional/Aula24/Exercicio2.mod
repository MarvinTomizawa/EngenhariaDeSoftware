set produtos;

set disponibilidade >= 0;
set velocidade {produtos} > 0; 
set lucro {produtos};
set limite {produtos};

var quantidade {p in produtos} >= 0 <= limite[p];

maximize lucro_total: sum { p in produtos} lucro[p] * quantidade[p];

subject to Tempo: sum {p in produtos} (1/velocidade[p]) * quantidade[p] <= disponibilidade;