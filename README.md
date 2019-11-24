# TC2 - PROG3 - Sistema PPGI

## Estrutura do projeto

* .zip:  

>`bin/` Contém as classes compiladas Java.  
>`out/` Conterá as saídas do programa. Fácilmente trocável na função Main.  
>`src/` Contém o codigo-fonte.  
>`ext/` Contém extras do trabalho. Isso inclui o diagrama de classes gerado da implementação utilizada.  

* repositório (contém o .zip):

>`entradas/` Contém arquivos de entradas, e um gerador de entrada  
>`testes/` Contém resultados de execução do código do professor, e scripts de comparação de respostas.  

## Script de testes

O script de testes (`test.sh`, na raíz do projeto) foi alterado para comparar as saídas no local correto de saídas, obedecendo a estrutura de pastas do projeto (`out/`), entre outras alterações menores, majoritáriamente por preferência pessoal.  

## Compilação e execução com o ant

>`ant compile` compila o código.  
>`ant run` executa o código com as entradas com nome padrão na raíz do projeto.  
>`ant run-read-only` executa o código em modo somente leitura com as entradas com nome padrão na raíz do projeto.  
>`ant run-write-only` executa o código em modo somente escrita.  
>`ant run-python` executa o código com as entradas geradas em python.  

### Outros comandos do ant

>`ant javadoc` gera os javadoc atualizados.  
>`ant clean` limpa o projeto. Remove a pasta `bin/`,