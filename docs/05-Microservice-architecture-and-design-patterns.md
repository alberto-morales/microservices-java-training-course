
## Why synchronous communication between microservices would be a bad idea?

 There are certain tradeoffs in synchronous communication between microservices:
 
- It requires a deliberate balancing of the capacity for all the services. 
- It's likely that synchronous communication leaves upstream services susceptible to cascading failure.
- Increased Service Discovery Overhead: each service needs to participate in a central service discovery setup.
- A synchronous system can exhibit much **tighter coupling** over a period of time. Without abstractions in between, services bind directly to the contracts of the other services.

It had been said that synchronous REST can turn microservices back into monoliths.

Sync REST could be ok in external client->microservice communication, internal microservice->microservice communication should rely on asynchronous message-passing.

— Jonas Bonér (@jboner) March 4, 2016

### What does "Async IO" means?

It means that when you communicate over the network (e.g. with another service), your current thread is not blocked until the remote service has responded, but is free to do other things in between.

![sync. v.s. async. IO](./images/sync-async-io.png)

But this is not the kind of asynchronicity you should be worried about when it comes to communication between your (micro)-services.

### Asynchronous service integration

Pros:

- An asynchronous set-up fares better with temporary bursts of requests.
- Each service connects to a message queue as a consumer or producer. Only the message queue requires service discovery. So the need for a central service discovery solution is less pressing.
- Additionally, since multiple instances of a service are connected to a queue, external load balancing is not required. 


Contras:
- Asynchronous systems tend to be significantly more complex than synchronous ones: Half-a-dozen applications now turn into hundreds of little microservices.
- Reads/Queries require mediation.
- Message buses are a SPOC. This is not a trade-off, but a precaution. 
- Eventual Consistency: An asynchronous system can be eventually consistent. It means that results in queries may not be latest, even though the system has issued the writes. While this trade-off allows the system to scale better, it is something to factor-in into system’s design and user experience both.

![Eventual Consistency](./images/eventual-consistency.jpg)

You can read more about "factors of distributed software" in great depth [here](https://martinfowler.com/articles/microservice-trade-offs.html#distribution) from the master Fowler.

### Orchestation v.s. Choreography

How to stitch microservice modules working together?

- When a service oriented architecture uses an **orchestration** pattern for communication, there are point-to-point connection between the services. 
- Applying a **choreography** pattern means that one service doesn’t talk to another service in order to instruct an action (several patterns: Event Sourcing, CQRS...)

![Orchestation v.s. Choreography](./images/orchestation-vs-choreography.png)

<div align="center" size="100%"><h6><sub>Orchestration vs. Choreography, Source: <i>www.thoughtworks.com</i></sub></h6></div>

## Bibliography

![Building microservices - Sam Newman](./images/building-microservices-sam-newman.png)

Building microservices is a 2015 book by Sam Newman. It's a practical book that covers the topics that system architects and administrators must consider when building, managing, and evolving microservice architectures.