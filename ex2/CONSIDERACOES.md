Neste projeto, a classe Main utiliza de Busy-Wait para detectar a conclus�o. Quais as implica��es dessa implementa��o e quais as alternativas?

R:A estratégia em questão,que é utilizada no código é a de busy-wait, uma das estratégias mais simples para implementar a concorrência entre processos, mas que em contrapartida causa inúmeros problemas ao código, principalmente quando se escala essa solução. O grande problema é que, para garantir que ocorra a exclusão mútua, ele se utiliza de uma técnica onde o processo sempre procura uma condição para continuar sua execução. 

Essa técnica causa inúmeros problemas para a execução de um código em concorrência, tais como: 
1. A CPU fica ociosa, ou seja, durante esse tempo ela fica bloqueada para fazer alguma outra atividade.
2. Se houver um processo que tenha uma prioridade maior de execução ele não pode interromper o outro processo para começar a executar. 
3. Além disso existem chances de causar starvation, que nada mais é do que um processo ficar em espera sem saber quando vai ser executado e podendo não ser executado.

Existem algumas estratégias para se usar no lugar de busy-wait, são elas: semáforos, locks, monitores.
