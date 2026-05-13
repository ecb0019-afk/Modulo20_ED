# Git Cheat Sheet — Resumen rápido

Crear un nuevo repositorio
- git init: crea un repositorio Git 

Estado y seguimiento
- git status: muestra archivos modificados/no trackeados
- git add <archivo>: añade archivos al área de staging
- git add: añade los cambios
- git rm -cached <archivo: deja de trackear 

Commits
- git commit -m "mensaje": guarda cambios del staging con mensaje
- git log --oneline: historial corto

Branches
- git branch: lista ramas
- git branch <nombre>: crea rama
- git checkout -b <nombre>: crea y cambia a la ram
- git merge <rama>: fusiona <rama> en la rama actual

Remoto
- git remote add origin <url>: enlaza repo remoto
- git push -u origin main: sube y establece upstream
- git push origin --delete <branch>: elimina rama remota

Consejos
- Hacer commits pequeños y descriptivos
- Usar ramas para funciones nuevas 
- Antes de merge: ejecutar git pull en main para evitar conflictos
