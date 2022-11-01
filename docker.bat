
cmd /c docker.exe build -f .\Dockerfile -t ochamodev/workshop_server:%1 .

cmd /c docker.exe push ochamodev/workshop_server:%1

cmd /c scp.exe -p .\docker-compose.yml .\src\database\DB.sql root@77.243.85.26:/home

