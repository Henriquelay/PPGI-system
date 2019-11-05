JFLAGS = -g -d
JC = javac
PKG = 
PROJECT = "Sistema PPGI"
SRC = $(PROJECT)/src/
BIN = $(PROJECT)/bin/
.SUFFIXES: .java .class

%.class:
	export $CLASSPATH=$(SRC)Veiculo
	$(JC) $(JFLAGS) $(BIN) $(SRC)$(PKG)$*.java

CLASSES = \
	Regra.java \
	Veiculo/Veiculo.java \
	Periodico.java \
	Conferencia.java \
	Publicacao.java \
	Docente.java \
	SistemaPPGI.java \
	Main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	-rm -rf $(BIN)*

remake: clean classes