### Introduction

I tried to keep in pass of the time proposed to develop this solution and show my ideas about this task.

I tried to show the main ideias in a software development process, the tools and strategies that I belive they are a good principles shared in the comunity.
This solution is written in Kotlin a new language that I just learnt and decided to use for this task, so few things could be wrongly made in not a 
Kotlinish way.

The main concepts used to develop this solution was the use of <b>DDD</b>, <b>TDD</b>, <b>Clean Architecture</b> and <b>Design  Pattern Concepts</b>.

The project Architecture is organized in:

- main.kt: Its the setup of the project where the requests are made, its like a webpage client.
- Domain: This layer is responsible to maintain all business rules and are separeted in <b>Bounded Context</b> for each business domain.
- Application: This layer is responsible to orchestrate other layers, like what the client needs to what the Domain layer have. 
  All actions in the software can be found here.
- Infrastructure: This layer is responsible in a way to provide support to the others. Holding database connections, mail and printer service everything that 
  is not core business but is considerable important to the main function and support.

### What I have done

I started looking the macro picture and to analysis what could be done in terms of <b>DDD</b> to the Domain Layer, to started I used the main
<b>Desing Strategies Tools</b> to separete in a few <b>Bounded Context</b> to see what is core and subdomains and theirs context mapping,
also got some <b>Ubiquitous Language</b> that come to my mind.

Once I had this macro picture the <b>TDD</b> came out to provide a good way to design the solution. Test first strategy 
its the best way to follow SOLID principles and avoid drawdowns in a long software development run. It helps in to keep the software a 
good interface/design and his consequence is a testable quality software.

The only framework that I used was Junit for unit test, due the curving learning in Kotlin I just coded few tests as example.

In the Infrastructure Layer can be found the repository and service support context. The problem do not asked to implement those concepts, 
so I implemented fake inteligence just to find the `Product` and `Order` and save the product int the following `Order`, a `MailService` and `ShippingLabelService` as well.

On the Application Layer I used the <b>CQRS</b> with <b>Command Pattern</b> concepts to perform the challenge's use cases which are:
 - `AddProductToOrderCommand` responsible to add a `Product` in the following `Order`.
 - `PerformOrderPaymentCommand` responsible to pay the current `Order`.
 
 The setup of the commands is found on `main.kt`

Once the payment is performed each item into the `Order` is closed and the `OrderItem` publish an <b>event</b> dealing with `ProductType`.

I think that <b>Domain Event</b> was one easy way to deal the problem of differents `ProductType`.

The <b>Observable Pattern</b> was used to keep track of changes on `isClosed` attribute, so each time the attribute changes his value to `true`
the `ItemOrder` is close and an event is publish with the right `event_type` (Its sort of like a <b>Strategy Pattern</b>).

Still on Application Layer there is a context for `event`.

The `DomainEvent` deals with the `eventType` and `eventData`. For each `ProductType` there is a different approach for shipping that can be found into the `Handlers` classes.


### Future Improvements
- Create another `Address` Entity for the `Order` Domain, once Address can have different atributes and meaning for each Domain. 
To keep it simple for the solution the `Order` and `Customer` Domain share the same `Address`.
- On events, dealing with `ProductType` that do not exist.
- Get a better understanding of nullability in Kotlin to create a better approach for nullable properties.
- Improvements on unit tests, get a better understanding of Junit assertions and verifications to create a better unit test anotomy with 3 phases (Arrange, Act and Assert)
