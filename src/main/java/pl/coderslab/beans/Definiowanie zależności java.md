<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - Spring - Definiowanie zależności

### Zadania.


#### Zadanie 1 - rozwiązywane z wykładowcą

1. Utwórz projekt Maven:
 - groupId - **pl.coderslab**
 - artifactId - **jee-spring-java**.
2. Dodaj klasę konfiguracji java.
3. W metodzie main klasy `SpringDiApplication` utwórz obiekt kontekstu na podstawie konfiguracji.
4. Uruchom i sprawdź działanie aplikacji.


#### Zadanie 2 - rozwiązywane z wykładowcą

1. Utwórz klasę `HelloWorld` w pakiecie **pl.coderslab.beans**.
2. Utwórz metodę `hello` wyświetlającą aktualną datę i godzinę na konsoli.
3. Utwórz ziarno w konfiguracji java o nazwie `helloWorld` klasy `pl.coderslab.beans.HelloWorld`.
4. Pobierz ziarno w metodzie main a następnie wywołaj na nim metodę `hello`.

-------------------------------------------------------------------------------


#### Zadanie 3

1. Utwórz klasy `Captain`  oraz `Ship`.
2. Uzupełnij klasę `Ship` o pole typu `Captain` i dodaj odpowiedni konstruktor.
3. Uzupełnij klasę `Captain` o metodę `startSailing()`, wyświetlającą komunikat **Start sailing.**.
4. Zdefiniuj ziarna w konfiguracji javy w poniższy sposób:

```java
@Bean
public Captain jackSparrow() {
    return new Captain();
}

@Bean
public Ship blackPearl() {
    return new Ship(jackSparrow());
}

```
5. Pobierz ziarno `Captain` w metodzie main programu w następujący sposób:
````java
Ship ship = ctx.getBean("blackPearl", Ship.class);
ship.getCaptain().startSailing();
````


#### Zadanie 4

1. Utwórz 2 klasy `ScopeSingleton` oraz `ScopePrototype`.
2. W konfiguracji java zdefiniuj je jako ziarna Springa.
3. Ziarno klasy `ScopePrototype` zdefiniuj z zasięgiem typu `prototype`.
4. W klasie main pobierz po 2 ziarna każdego typu a następnie je wyświetl w następujący sposób:
````java
ScopeSingleton singleton1 = context.getBean(ScopeSingleton.class);
System.out.println(singleton1);
ScopeSingleton singleton2 = context.getBean(ScopeSingleton.class);
System.out.println(singleton2);
System.out.println((singleton1 == singleton2) + ": ten sam obiekt\n");
ScopePrototype prototype1 = context.getBean(ScopePrototype.class);
System.out.println(prototype1);
ScopePrototype prototype2 = context.getBean(ScopePrototype.class);
System.out.println(prototype2);
System.out.println((prototype1 == prototype2) + ": dwa różne obiekty");

````
Zwróć uwagę że w pierwszym przypadku otrzymamy ten sam obiekt, a w drugim dwa różne.

#### Zadanie 5

1. Utwórz projekt Maven:
 - groupId - **pl.coderslab**
 - artifactId - **jee-spring-auto**.
2. Dodaj klasę konfiguracji java.
3. W klasie konfiguracji określ automatyczne skanowanie dla pakietu `pl.coderslab.beans`.
4. Utwórz dwie klasy `PersonService` oraz `PersonRepository` oznacz je adnotacją `@Component`.
5. W klasie `PersonService` wstrzyknij obiekt klasy `PersonRepository` o nazwie `personRepo`.
6. W metodzie main klasy `SpringDiApplication` utwórz obiekt kontekstu na podstawie konfiguracji.
7. Wywołaj poniższy kod:
````java
PersonService person = context.getBean(PersonService.class);
System.out.println(person.getPersonRepo().getClass().getName());
````
