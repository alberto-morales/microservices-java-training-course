
#Getting started with Apache Kafka

## How to install Apache Kafka on Ubuntu

Prerequisites:
 
- (obvious) O.S. up & running
- At least 4Gb RAM. 
- Java JVM installed.

### Steps

* Creating a user for kafka, with sudo capabilities:

```shell
sudo useradd kafka -m
sudo passwd kafka
sudo adduser kafka sudo
```

* Downloading and extractiong latest stable Kafka binaries

```shell
su -l kafka
mkdir ~/Downloads
curl "https://www.apache.org/dist/kafka/2.3.1/kafka_2.11-2.3.1.tgz" -o ~/Downloads/kafka.tgz
mkdir ~/kafka && cd ~/kafka
tar -xvzf ~/Downloads/kafka.tgz --strip 1
```

* Configuring the Kafka server

Edit KAFKA_HOME/config/server.properties and add this line to the bottom of the file, to allow us to delete Kafka topics:

```file
delete.topic.enable = true
```

* Creating Systemd Unit Files and Starting the Kafka Server

Service file for Zookeeper (`/etc/systemd/system/zookeeper.service`):

```file
[Unit]
Requires=network.target remote-fs.target
After=network.target remote-fs.target

[Service]
Type=simple
User=kafka
ExecStart=/home/kafka/kafka/bin/zookeeper-server-start.sh /home/kafka/kafka/config/zookeeper.properties
ExecStop=/home/kafka/kafka/bin/zookeeper-server-stop.sh
Restart=on-abnormal

[Install]
WantedBy=multi-user.target
```

Service file for Kafka (`/etc/systemd/system/kafka.service`):

```file
[Unit]
Requires=zookeeper.service
After=zookeeper.service

[Service]
Type=simple
User=kafka
ExecStart=/bin/sh -c '/home/kafka/kafka/bin/kafka-server-start.sh /home/kafka/kafka/config/server.properties > /home/kafka/kafka/kafka.log 2>&1'
ExecStop=/home/kafka/kafka/bin/kafka-server-stop.sh
Restart=on-abnormal

[Install]
WantedBy=multi-user.target
```

And finally start the service:

```shell
sudo systemctl start kafka
```

If you want Kafka to be started automatically when system reboots, run:

```shell
sudo systemctl enable kafka
```

To check Kafka state out:

```shell
sudo journalctl -u kafka
```

## A brief contact with Apache Zookeeper

Model:

Similar to a filesystem, you can create nodes in a heirachical way. Each Znode maintains statistical data like version number, ACL's and timestamps.

![ZooKeeper model](./images/zookeeper-model.png)

API:
- create data path
- delete path
- exists path
- get path [watch]
- set path data [version]
- sync path

Zookeeper shell:

```shell
sudo su -l kafka
cd kafka
./bin/zookeeper-shell.sh lab
...
./bin/zookeeper-shell.sh lab ls /
...
./bin/zookeeper-shell.sh lab ls /brokers/ids
...
```

## Starting with Kafka topics

Creamos el topic "curso" con 1 partición, y factor de replicación 1:

```shell
./bin/kafka-topics.sh --zookeeper lab --create --topic curso --partitions 1 --replication-factor 1
```

*Created topic curso.*

Podemos listar los topics:

```shell
./bin/kafka-topics.sh --list --zookeeper lab
```

Y para ilustrar su uso, ponemos en funcionamiento un productor 

```shell
./bin/kafka-console-producer.sh --broker-list lab:9092 --topic curso
```

y un consumidor:

```shell
./bin/kafka-console-producer.sh --broker-list lab:9092 --topic curso
```

## Bibliography

![Kafka: The definitive guide](./images/confluent-kafka-definitive-guide.png)

"Kafka: The definitive guide" is a 2017 book by Neha Narkhede. Engineers from Confluent and LinkedIn who are responsible for developing Kafka explain how to deploy production Kafka clusters, write reliable **event-driven microservices**, and build scalable stream-processing applications with this platform. Through detailed examples, you’ll learn Kafka’s design principles, reliability guarantees, key APIs, and architecture details, including the replication protocol, the controller, and the storage layer.
