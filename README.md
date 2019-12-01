# TC2 - PROG3

---

## Como hostear

>`sudo docker-compose up -d`  
Para parar:  
>`sudo docker-compose down`

Caso não esteja rodando, certifique que a sua pasta é visível para o root. Mete uns 777 aí sei lá.  
Principalmente em todo o caminho até a raiz do projeto, public/, public/downloads/, e uploads/ (caso essa pasta não exista, crie-a).

## Portainer

```
$ docker volume create portainer_data
$ docker run -d -p 9000:9000 -p 8000:8000 --name portainer --restart always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer
```
