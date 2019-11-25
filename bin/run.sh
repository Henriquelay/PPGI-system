#!/bin/bash

command="java Main -d ../uploads/docentes.csv -v ../uploads/veiculos.csv -p ../uploads/publicacoes.csv -q ../uploads/qualis.csv -r ../uploads/regras.csv -a $1"

echo ${command}

java Main -d ../uploads/docentes.csv -v ../uploads/veiculos.csv -p ../uploads/publicacoes.csv -q ../uploads/qualis.csv -r ../uploads/regras.csv -a $1