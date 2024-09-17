#!/bin/zsh

#IPADDRESS=$(ipconfig getifaddr en0)
#ECHO "export IPADDRESS=\"$IPADDRESS\"" >> ~/.bash-profile

echo "export IPADDRESS=$(ipconfig getifaddr en0)">>~/.zshrc
echo "export KEYCLOAK_ADMIN_PASSWORD=admin">>~/.zshrcdo
#set -e
#mongosh <<EOF
#use admin
#db.createUser({
#  user: '$MONGODB_USER',
#  pwd:  '$MONGODB_PASSWORD',
#  roles: [{
#    role: 'readWrite',
#    db: '$MONGODB_DB'
#  }]
#})
#EOF
