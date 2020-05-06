# CASTOR N QUEEN 

Ce logiciel permet de resoudre Le problème des N REINES initialement posé par K.F. Gauss en 1842

## Installation

ouvrir un Terminal [unix](https://github.com/pabios/castore-NQueen.git) et coler la  comande suivante pour le telecharger
pour l'exemple on se trouve dans un dossier costore sur le bureau

```bash
pabios@pabiosoft:~/Bureau/logique/castor$
 git clone https://github.com/pabios/castore-NQueen.git

```

## Usage

```bash
pabios@pabiosoft:~/Bureau/logique/castor$  
javac NQueen.java
pabios@pabiosoft:~/Bureau/logique/castor$  ls
NQueen.class ...
pabios@pabiosoft:~/Bureau/logique/castor$  
java NQueen 4
pabios@pabiosoft:~/Bureau/logique/castor$  ls
4queens.cnf ...
pabios@pabiosoft:~/Bureau/logique/castor$  cat 4queens.cnf

c ------------------------ Projet Castor l2 info ------------------------
c Pierre BRUYERE
c Vinicius MATTEI
c Ismaila BALDE
c ------------------------ Projet Castor l2 info ------------------------
p cnf 4 84
1 2 3 4 0
-1 -2 0
-1 -3 0
-1 -4 0
-2 -3 0
-2 -4 0
-3 -4 0
5 6 7 8 0
etc ...
...
```

## Contributing
 * Vinicius MATTEI
 * Ismaila BALDE
 * Pierre BRUYERE
 

pour resoudre ce problem cet outils  utilise [sat4j](http://sat4j.org) une inspiration java du solver minisat.
Donc pas besoin d'instaler un SOLVER pour utiliser cet outils
## Lire le Rapport 
 [pabiosoft.com/logique](http://pabiosoft.com/myRapport.php)

## Soutenance
 * Vinicius MATTEI --> historique et traduction du probleme
 * Pierre BRUYERE  --> Modelisation + exemple (n =4) 
 * Ismaila BALDE ---> Generalisation et code Source du Projet

## License
[MIT](https://choosealicense.com/licenses/mit/)

