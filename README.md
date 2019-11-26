# TC2 - PROG3

---

## Como hostear

>`sudo docker-compose up -d`  
Para parar:  
>`sudo docker-compose down`

## Portainer

>```
$ docker volume create portainer_data
$ docker run -d -p 9000:9000 -p 8000:8000 --name portainer --restart always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer
```
