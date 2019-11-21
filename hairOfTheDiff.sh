#!/bin/bash

# From
# https://unix.stackexchange.com/a/401338

same='-' #unchanged
up='△' #exists in first line, but not in second 
down='▽' #exists in second line, but not in first
reset=''

reset=$'\e[0m'
same=$reset
up=$reset$'\e[1m\e[7m'
down=$reset$'\e[1m\e[7m\e[31m'

timeout=1


if [[ "$1" != '' ]]
then
    paste -d'\n' "$1" "$2" | "$0"
    exit
fi

function demo {
    "$0" <<EOF
Paris in the spring 
Paris in the the spring
A cat on a hot tin roof.
a cant on a hot in roof
the quikc brown box jupps ober the laze dogs 
The quickbrown fox jumps over the lazy dogs
EOF
}

# Change \x20 to \x02 to simplify parsing diff's output,
#+   then change \x02 back to \x20 for the final output. 
# Change \x09 to \x01 to simplify parsing diff's output, 
#+   then change \x01 into → U+1F143 (Squared Latin Capital Letter T)
function input {
    sed \
        -e "s/\x09/\x01/g" \
        -e "s/\x20/\x02/g" \
        -e "s/\(.\)/\1\n/g"
}
function output {
    sed -n \
        -e "s/\x01/→/g" \
        -e "s/\x02/ /g" \
        -e "s/^\(.\) *\x3C$/\1 \x3C  /g" \
        -e "s/\(.\) *\(.\) \(.\)$/\1\2\3/p"
}

ifs="$IFS"
IFS=$'\n'
demo=true

while IFS= read -t "$timeout" -r a
do
    demo=false
    IFS= read -t "$timeout" -r b
    if [[ $? -ne 0 ]]
    then
        echo 'No corresponding line to compare with' > /dev/stderr
        exit 1
    fi

    diff --text -yt -W 19  \
        <(echo "$a" | input) \
        <(echo "$b" | input) \
    | \
    output | \
    {
        type=''
        buf=''
        while read -r line
        do
            if [[ "${line:1:1}" != "$type" ]]
            then
                if [[ "$type" = '|' ]]
                then
                    type='>'
                    echo -n "$down$buf"
                    buf=''
                fi

                if [[ "${line:1:1}" != "$type" ]]
                then
                    type="${line:1:1}"

                    echo -n "$type" \
                        | sed \
                            -e "s/[<|]/$up/" \
                            -e "s/>/$down/" \
                            -e "s/ /$same/"
                fi
            fi

            case "$type" in
            '|')
                buf="$buf${line:2:1}"
                echo -n "${line:0:1}"
                ;;
            '>')
                echo -n "${line:2:1}"
                ;;
            *)
                echo -n "${line:0:1}"
                ;;
            esac
        done

        if [[ "$type" = '|' ]]
        then
            echo -n "$down$buf"
        fi
    }

    echo -e "$reset"
done

IFS="$ifs"

if $demo
then
    demo
fi