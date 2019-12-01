#!/bin/bash

chmod -R 777 ../uploads
if ![ $? ]; then
    echo "Erro ao setar permissao para publica de uploads"
fi
chmod 777 ../public
if ![ $? ]; then
    echo "Erro ao setar permissao para publica de public"
fi
chmod -R 777 ../public/downloads
if ![ $? ]; then
    echo "Erro ao setar permissao para publica de downloads"
fi

command="java Main -d ../uploads/docentes.csv -v ../uploads/veiculos.csv -p ../uploads/publicacoes.csv -q ../uploads/qualis.csv -r ../uploads/regras.csv -a $1"

echo ${command}

java Main -d ../uploads/docentes.csv -v ../uploads/veiculos.csv -p ../uploads/publicacoes.csv -q ../uploads/qualis.csv -r ../uploads/regras.csv -a $1

exit $?