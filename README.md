# <div _ngcontent-uoy-c188="" id="programming-exercise-instructions-content" class="guided-tour instructions__content__markdown markdown-preview"><h4 id="penguinsupermarket">Penguin Supermarket</h4>
<p>For this task you should only use classes and their methods from the package <code>java.lang</code>, no imports allowed
apart from the ones we have made available to you in your git repository.</p>
<p>Penguins go shopping and unfortunately they are now firmly convinced that they must have a supermarket for this.
Since there is no supermarket yet, we will implement it ourselves.</p>
<p><ins>Important Notes:</ins></p>
<ol>
<li>If possible, mark attributes with <code>final</code>.</li>
<li>In some places, a check for validity or special treatment of exceptional cases is required.
Use the method <code>unsupportedOperation(String)</code> or <code>illegalArgument(String)</code> from the class <code>ExceptionUtil</code> included in the template,
in order to abort the execution of the method or the constructor in such exceptional cases.
In these exceptional cases we want to get an error message back, so don't be surprised.
Simply call the method at a suitable point (invalid value/status) with a meaningful error message.</li>
<li>Hide implementation details of the classes. <strong>Therefore mark all attributes with <code>private</code>.</strong>
If you write helper methods, mark them with <code>private</code> as well.</li>
<li>Be careful with the implementation, the public test cases often only test for the existence of classes and methods. What exactly is tested is included in the test case or Artemis task. Thoroughly test your implementation yourself.</li>
<li>Always use the most general possible/meaningful type for attributes. So avoid having e.g. <code>LinkedStack</code> there,
and use the <code>Stack</code> interface instead. So your implementation remains flexible and maintainable.</li>
<li>Aside from this, make sure that the source code is properly formatted.</li>
</ol>
<p>First we need a few data structures to be able to model a supermarket for penguins.</p>  

### Improve list from the lecture
 #### We now want to convert the int-List implementation of the solution into a generic list
You can find the list in your repository. Replace <code>int</code> with a generic type parameter and change the attributes to <code>private</code>.
Mark the info attribute as <code>final</code>. You don't need to insert validity tests. (A getter has to be created for <code>info</code> and <code>next</code>, as these are now private.)

### Interfaces
#### Create next three interfaces
Define the two well-known data structures Stack and Queue as a Java interface, and implement them later.

<ul>
<li>An interface <code>DataStructure</code>, which defines the following methods:<ul>
<li>a method <code>size()</code> that returns the number of stored elements as <code>int</code>.</li>
<li>a method <code>isEmpty()</code>, which returns a <code>boolean</code>, whether the data structure is empty. (You can also use a default method here)</li></ul></li>
<li>A generic interface <code>Stack</code>, which extends <code>DataStructure</code> and defines the following methods:<ul>
<li>a method <code>push(T)</code>, which adds an object of the generic type T to the stack.</li>
<li>a method <code>pop()</code>, which removes an object of the generic type T from the stack. If the stack is empty, it returns <code>null</code>.</li></ul></li>
<li>A generic interface <code>Queue</code>, which extends <code>DataStructure</code> and defines the following methods:<ul>
<li>a method <code>enqueue(T)</code>, which adds an object of the generic type T to the queue.</li>
<li>a method <code>dequeue()</code>, which removes an object of the generic type T from the queue. If the queue is empty, it returns <code>null</code>.</li></ul></li>
</ul>
All data structures described here should behave as they are known from the lecture.

## Implement interfaces
 #### Implement the generic LinkedStack class, which implements the Stack, and use the List class for this 
 Example:
```java
push "ABC"
push "DEF"
pop
```
(Sample operations from the test)

 #### Implement the generic LinkedQueue class, which implements the Queue, and use the List class for this
Example:
```java
enqueue "ABC"
enqueue "DEF"
dequeue
```
(Sample operations from the test)

### Connect data structures
Next, we want to connect data structures together in order to effectively move elements from one data structure to another.
We need this for the next subtask, so we want to find a good solution for it without using the existing interfaces overloaded with methods or made method names less descriptive.

#### First implement the generic interface DataStructureConnector
The following methods should be included:
<ul>
<li><code>hasNextElement()</code> returns whether the data structure still contains elements.</li>
<li><code>addElement(T)</code> adds an element of the generic type <code>T</code> to the data structure.</li>
<li><code>removeNextElement()</code> takes the next element (of the generic type <code>T</code>) from the data structure.
If the data structure does not contain any more elements, <code>null</code> is returned.</li>
</ul>

#### Create the generic StackConnector class that implements DataStructureConnector for Interface Stack 
<p>The <code>Stack</code> should be passed in the constructor (and of course it has to be of the same generic type).
The public test creates a new LinkedStack for <code>Integer</code>, connects it to the connector and does <code>addElement(42)</code> and <code>removeNextElement()</code>.</p>

#### Create the generic QueueConnector class that implements DataStructureConnector for Interface Queue
<p>The <code>Queue</code> should be passed in the constructor (and of course it has to be of the same generic type).
The public test creates a new LinkedQueue for <code>Integer</code>, connects it to the connector and does <code>addElement(42)</code> and <code>removeNextElement()</code>.</p>

#### Create the class generic DataStructureLink
<p>A <code>DataStructureLink</code> should receive two <code>DataStructureConnector</code>s in the constructor (they must be of the same generic type).
The DataStructureLink offers two public methods:</p>
<ul>
<li><code>moveNextFromAToB()</code> moves the next element from the first connector to the second connector (remove and then add).
If the first connector is no longer an element, the method returns <code>false</code> and nothing happens, otherwise an element is transferred and<code>true</code> is returned.</li>
<li><code>moveAllFromAToB()</code> moves all elements from the first connector to the second connector; if the first is empty, nothing happens. Nothing is returned.</li>
</ul>
<p>Tests (always in the format <code>&lt;A&gt; -&gt; &lt;B&gt;</code>, the error messages of the tests show the order of insertion, don't get confused by it):</p>
<ul>
<li><code>stackToStackSingle</code> uses <code>moveNextFromAToB()</code> with <code>StackConnector</code>s on <code>["ööö", "abc"] -&gt; ["xyz"]</code>.</li>
<li><code>stackToStackAll</code> uses <code>moveAllFromAToB()</code> with <code>StackConnector</code>s on <code>["xyz", "Niugnip", "Penguin"] -&gt; ["NiugnPinguin"]</code>.</li>
<li><code>queueToStackAll</code> uses <code>moveAllFromAToB()</code> with <code>QueueConnector</code> to <code>StackConnector</code> on <code>["Pinguin", "Niugnip", "xyz"] -&gt; ["NiugnPinguin"]</code>.</li>
</ul>

### Objects from the application area Penguinsupermarket
#### The FishyProduct class
<p>A <code>FishyProduct</code> essentially has two properties:</p>
<ul>
<li>name (<code>String</code>)</li>
<li>price (<code>int</code>, penguins don't take it too seriously)</li>
</ul>
<p>Implement the class <code>FishyProduct</code> with the mentioned attributes and provide the getters:</p>
<ul>
<li><code>getName()</code></li>
<li><code>getPrice()</code></li>
</ul>
<p>Make the attributes <code>final</code> so that their value is only set once when the constructor <code>FishyProduct(String, int)</code> is called.
Check the values for validity. Neither the name <code>null</code> nor the price should be less than or equal to 0 (penguins don’t give away anything,
especially food). Override the <code>toString</code> method so that the return value contains the most important characteristics of a product.</p>
<p>Example in the test case: <code>new FishyProduct("Micro Mac with Soft Fish", 1254)</code></p>

#### The PenguinCustomer class
<p>The <code>PenguinCustomer</code> puts <code>FishyProduct</code>s in his shopping cart, waits at the checkout and finally pays.
For this we need the following attributes:</p>
<ul>
<li>name (<code>String</code>)</li>
<li>available money (<code>int</code>, penguins still don't take it too seriously)</li>
<li>the products in the shopping cart (<code>Stack&lt;FishyProduct&gt;</code>, penguins always stack the goods)</li>
</ul>
<p>Implement the class <code>PenguinCustomer</code> with the mentioned attributes and provide the getters:</p>
<ul>
<li><code>getName()</code></li>
<li><code>getMoney()</code></li>
<li><code>getProducts()</code></li>
</ul>
<p>A few more methods are also necessary:</p>
<ul>
<li>with <code>addProductToBasket(FishyProduct)</code> a penguin can add the transferred product to his product stack. (This can also be multiple).</li>
<li>with <code>placeAllProductsOnBand(Queue&lt;FishyProduct&gt;)</code> the penguin places all its products on the belt at the checkout (the transferred queue).
Use a DataStructureLink for this.</li>
<li>with <code>takeAllProductsFromBand(Queue&lt;FishyProduct&gt;)</code> the penguin takes all products from the tape at the till (the transferred queue) into its product stack.
Use a DataStructureLink for this.</li>
<li>with <code>pay(int)</code> the penguin pays the transferred amount. The amount must not be negative and the available money must not be negative as well (penguins cannot have debts).</li>
</ul>
<p>Make all attributes - if possible - final so that their value is only set once when the <code>PenguinCustomer(String name, int initialMoney)</code> constructor is called.
Check the values for validity. So neither the name <code>null</code> nor the money available should be negative (penguins cannot have debts).
Override the <code>toString</code> method so that the return value contains the most important characteristics of a PenguinCustomer.</p>
<p>Example in the test case: <code>new FishyProduct("Micro Mac with Soft Fish", 1254)</code> and <code>new PenguinCustomer("Tux", 1337)</code>.
In the first test only name and money are checked, in the second the FishyProduct is placed in the shopping cart (<code>addProductToBasket</code>).</p>

#### Penguinsupermarket
##### Checkout
<p>Create the class <code>Checkout</code>, which represents a cash register in our supermarket. It consists of:</p>
<ul>
<li>a queue from <code>PenguinCustomer</code>s</li>
<li>a queue of <code>FishyProduct</code>s in front of the cashier on the belt</li>
<li>a queue of <code>FishyProduct</code>s after the cashier on the tape</li>
</ul>
<p>Implement the class <code>Checkout</code> with a parameterless constructor and the named attributes and provide the getters:</p>
<ul>
<li><code>getQueue()</code></li>
<li><code>getBandBeforeCashier()</code></li>
<li><code>getBandAfterCashier()</code></li>
</ul>
<p><code>queueLength()</code> method directly returns the length of the queue.
<code>serveNextCustomer()</code> method should be implemented so that the next penguin is served.
The procedure is as follows:</p>
<ul>
<li>the first <code>PenguinCustomer</code> leaves the queue,</li>
<li>puts all his products on the belt in front of the cashier (<code>bandBeforeCashier</code>),</li>
<li>the cashier scans all the products and calculates the price, moving the products to the rear belt (<code>bandAfterCashier</code>).</li>
<li>the <code>PenguinCustomer</code> takes all products from the back belt into the shopping cart (product stack)</li>
<li>and the <code>PenguinCustomer</code> is asked to pay. (An error may arise here, if he cannot do that, that's how it should be)</li>
</ul>
<p>If there is no penguin to operate, nothing happens when it is called (it waits).
Overwrite <code>toString</code> here as well.</p>
<p>Example in the test case: <code>new FishyProduct("Micro Mac with Soft Fish", 1254)</code> and <code>new PenguinCustomer("Tux", 1337)</code>.
"Tux" has the product in the shopping cart and is at the checkout. <code>ServeNextCustomer()</code> is called.
He then has the product and is no longer at the checkout.</p>  

##### PenguinSupermarket
<p>Create the class <code>PenguinSupermarket</code> that represents our supermarket. It consists of:</p>
<ul>
<li>an array of <code>Checkout</code>s (theoretically you can use something else here too.)</li>
</ul>
<p>Implement the class <code>PenguinSupermarket</code> with the mentioned attributes and provide the getters:</p>
<ul>
<li><code>getCheckouts()</code>, which in any case provides an array of all open <code>Checkout</code>s (registers).</li>
</ul>
<p>In the constructor, the <code>PenguinSupermarket</code> receives the number of registers (must be greater than 0).
There should be other methods for this purpose:</p>
<ul>
<li><code>getCheckoutWithSmallestQueue()</code> returns the first of all <code>Checkout</code>s (foremost in the array), which has the smallest queue length.
Now write the <code>goToCheckout(PenguinSupermarket)</code> method for the <code>PenguinCustomer</code> class, which can be called
the <code>PenguinCustomer</code> places itself in the shortest queue of the handed over supermarket.</li>
<li><code>closeCheckout(index)</code> closes the cash register at the index passed (starting from 0). If one does not exist,
an error message should be output; and also print an error if this is the last remaining cash register.
When a cash register is closed, the register is removed from the array of registers (the array becomes smaller),
and the penguins have to look for another cash register.
However, this happens in the reverse order of the queue, the last are then the first.
You can do this with <code>DataStructureLink</code> and <code>goToCheckout(PenguinSupermarket)</code>.</li>
<li><code>serveCustomers()</code> calls <code>serveNextCustomer()</code> once for each register.</li>
</ul>
<p>Example in the test case: <code>new FishyProduct("Micro Mac with Soft Fish", 1254)</code> and <code>new PenguinCustomer("Tux", 1337)</code>.
Supermarket <code>new PenguinSupermarket(2)</code>. "Tux" has the product in the shopping cart and goes to the checkout (<code>goToCheckout</code>).
Cash register 1 is closed (<code>closeCheckout(1)</code>)
<code>ServeCustomers()</code> is called.
He then has the product and is no longer at the checkout.</p>
<p>Remarks:</p>
<ul>
<li><p>All methods specified here in the task are public and not static.</p></li>
<li><p>Unspecified or obvious from the context methods return <code>void</code>.</p></li>
<li><p>When class java.lang.Object is mentioned in the error messages, it is almost always related to the type parameters.
(see Type Erasure in Java, at runtime every free type parameter is of the type java.lang.Object)</p></li>
</ul>
