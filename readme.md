# Capstone 2: DELI-cious
For this project, I created an application that represents an online deli, where customers can order customized 
sandwiches, drinks, and chips. Sandwiches and drinks come in different sizes, which differ in pricing. And certain 
sandwich toppings cost extra. Once an order has been confirmed, the application generates a receipt in the form of a
`.txt` file.

***During the creation of my application...***
- I got stuck trying to implement every new idea that popped up in my head, and would attempt to implement said ideas 
as soon as they came to mind so that I wouldn't forget them. This ended up slowing down my process quite a bit.


- Something I struggled with was allowing the customer to select multiple options.
    - I figured out that the easiest way around it was to create new methods (unique and overloaded) to specifically 
handle the case of selecting multiple options.
      -  My `multiOptionsSelection()` method was the primary method that I created in order to achieve this.


- Something else that I struggled with was creating the `toString()` for the `Sandwich` class exactly as I wanted to 
appear.
  - It took some time to figure out how to add the elements of each `ArrayList` property, in the `Sandwich` class, 
to the variable of type `String` that was to be printed out by the `toString()` method. As well as how to only print out 
a property of type `boolean` if the instance of the `Sandwich` class had the property evaluated as `true`.


***Something I enjoyed while creating my application...***
- Something I enjoyed while creating my application was not only seeing my ideas become reality, but also the process 
of turning them into reality. It was very gratifying.

## Screenshots of command line

------------


***If I was given more time, I would've liked to have worked more on...***
- I would've liked to have worked more on the aesthetics of the application as well add some more products for 
customers to order.
  - A few ideas I had were:
    - Adding an option to order a salad.
    - Adding ASCII art (colored or uncolored).
    - Creating a depiction of the product or deli using Java Swing (GUIs).

### One interesting piece of code
```java
Iterator<String> iterator = allOptions.iterator();
```
- Can't recall ever using an `Iterator` object before, so it was interesting to research them and implement one 
in order to iterate through and remove an element at any index inside an `ArrayList`.