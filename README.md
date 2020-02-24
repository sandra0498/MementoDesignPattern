# MementoDesignPattern
 
In this example of the design pattern, icecream was used as the object that had to be restored.
In this case,the customer would be given a choice of an icecream cone and have the ability to freely go back to a previous choice.

The actor classes:
- Memento class (IceCreamMemento) : deals with creating the object itself 
- Originator class (AdvancedIceCreamCone) : deals with the states of the object
- Caretaker class (IceCreamCaretaker) : stores the different states of the object [in the case, they are written into a file]
