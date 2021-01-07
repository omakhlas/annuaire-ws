# annuaire-ws

[![Build Status](https://travis-ci.org/omakhlas/annuaire-ws.svg?branch=master)](https://travis-ci.org/omakhlas/annuaire-ws)



# CMD : mvnw clean install


Créer un web service d'annuaire rest qui se connecte a une BDD et une interface web pour rechercher un contact

données à exposer:

voir fichier mock_data.csv dans src/main/resources


# Choix d'implementation :

Spring boot 2

QueryDSL : il génère une classe QContac dans target/generated-sources/java

           Si la classe n'est pas importée automatiquement, vous devez ajouter le repertoire target/generated-sources/java dans le classpath
