#!/bin/bash
set -e
# Start MySQL
/docker-entrypoint.sh "$@"

# Check database is empty
if [ ! -f /data/db/medilabo/patients.ibd ]; then
  echo "Initializing database with data..."
  mysql -h localhost -u root -ppassword medilabo < /docker-entrypoint-initdb.d/2-data.sql
else
  echo "Database already initialized. Skipping data insertion."
fi
