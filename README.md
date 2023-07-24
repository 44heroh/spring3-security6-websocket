# spring3-security6-websocket

## Installation
1.😀 Склонировать данный репозиторий
```sh
git clone https://github.com/44heroh/spring3-security6-websocket.git
```
2. Создать в ручную schema в postgresql
```sh
CREATE SCHEMA IF NOT EXISTS messages;
```
3. Сделать
```sh
docker compose build
```
4. Сделать
```sh
docker compose up
```
5. dump из docker
```sh
docker exec -i postgresql pg_dump -U demo courses> dump.sql
```