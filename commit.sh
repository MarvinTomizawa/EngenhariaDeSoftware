MENSAGEM="$1"
git config user.name marvintomizawa
git config user.email marvintomizawa@hotmail.com
git add .
git commit -m "$MENSAGEM"
git push origin BancoDeDados
