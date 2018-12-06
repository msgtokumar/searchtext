GIT_REPO := https://github.com/DuoDuoMelb/java-maven-junit-helloworld.git
DIR := "dev"
OS := $(shell uname)

build:
	#./scripts/my-important-task.sh my-parameter
	@echo    build..started
	mvn verify compile -DskipTests

package:
	@echo    Package${GIT_REPO}
	mvn  package -DskipTests=true

test:
	mvn  test

clean:
	@echo    "Clean starts."
	mvn  clean
