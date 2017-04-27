# for windows

CPATH = -classpath .;..\lib\Ani.jar;..\libcontrolP5.jar;..\lib\core.jar;..\lib\minim.jar
SRC   = *.java
DUMP  = *.class
# windows command
DEL   = del


all: $(SRC)
	javac $(CPATH) $(SRC)
	jar -cfm Main.jar manifest.mf $(DUMP)
	$(DEL) $(DUMP)
	java -jar Main.jar
clean: $(DUMP)
	$(DEL) $(DUMP)