# Apache Kafka Producer.

---

Kafka Producer based on Spring Kafka.

---

Send record via HTTP Post.

```shell
curl --location --request POST 'http://localhost:8089/kafka' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Fernando",
    "lastName": "Ramirez",
    "age": "29",
    "isParent": false
}'
```

Endpoint.

```
http://localhost:8089/kafka
```

## Installation

---

## The Hard Mode.

[Download](https://kafka.apache.org/downloads) Kafka binaries

[Download](https://zookeeper.apache.org/releases.html) ZooKepeer binaries

Run Zookeeper Server.

```shell
${zookeper.dir}/zookeeper-server-start.{bat|sh} ${zookeper.dir}/config/zookeeper.properties
```

Run Kafka Server.

```shell
${kafka.dir}/kafka-server-start.{bat|sh} ${kafka.dir}/config/server.properties
```

Create Kafka Topic.

```shell
${kafka.dir}/kafka-topics.{bat|sh} --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ${topic.name}
```

Create Kafka Consumer.

```shell
${kafka.dir}/kafka-console-consumer.{bat|sh} --bootstrap-server localhost:9092 --topic ${topic.name} --from-beginning
```

---

## The easy mode.

You also can run Kafka and Zookeeper Server with Docker.

Docker Zookeeper Server.

```shell
docker run --name zookeeper-server -d zookeeper:latest
```

Docker Kafka Server.

```shell
docker run \
    -d --name kafka-server \
    -p 9092:9092 \
    -e KAFKA_ZOOKEEPER_CONNECT=zookeeper-server:2181 \
    -e ALLOW_PLAINTEXT_LISTENER=yes \
    --link zookeeper-server:zookeeper-server \
    bitnami/kafka:latest
```

Enter to docker container.

```shell
docker exec -ti kafka-server bash
```

Run commands below into docker image.

##### Create topic.

```shell
/opt/bitnami/kafka/bin/kafka-topics.sh \
    --create \
    --zookeeper zookeeper-server:2181 \
    --topic ${topic.name} \
    --partitions 1 \
    --replication-factor 1
```

##### Consumer

```shell
export KAFKA_OPTS="-Djava.security.auth.login.config=/opt/bitnami/kafka/conf/kafka_jaas.conf"

kafka-console-consumer.sh \
    --bootstrap-server 127.0.0.1:9092 \
    --topic ${topic.name} \
    --consumer.config /opt/bitnami/kafka/conf/consumer.properties
```

---

## Useful Docker Commands

##### List topic

```shell
/opt/bitnami/kafka/bin/kafka-topics.sh \
    --describe \
    --zookeeper zookeeper-server:2181 \
    --topic ${topic.name}
```

