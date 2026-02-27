SwingStoreSystem

System Overview 
Okay, so I just built this entire Store Management System from scratch using Java Swing! It’s basically a fully functional checkout app where you can buy products, view a history of all your past transactions, and check exactly what's left in the store's stock .

But here was the biggest plot twist: the instructions strictly banned using ArrayList or any Java Collections ! I had to figure out how to make all this data move around and update using only old-school, fixed-size arrays. It was a huge puzzle, but I actually got it working!


Frame Responsibilities (How I Split It Up)
I learned that cramming everything into one screen is messy, so I split the app into three completely separate windows (JFrames):


1. Store Transaction Frame (The Main Storefront)
This is where the magic happens and where customers actually check out .

I set up a dropdown to pick a product and a text box to enter the quantity .

I figured out how to make it automatically compute the Subtotal and Total cost !

The coolest part I added was the error handling: if you try to type a negative number or buy more items than we actually have in stock, it throws a warning pop-up at you !

When you hit "Complete Transaction", it permanently deducts the items from the warehouse and secretly saves the receipt data .

2. Transaction Logs Frame (The Receipt Book)
This frame is strictly for viewing the history of completed transactions .

I made it so whenever you open it or hit refresh, it prints out a neat list showing exactly what product was bought, how many, and the final price . It lists them perfectly in the order they happened!


3. Inventory Frame (The Warehouse Screen)
This is the monitor for the store manager .

It literally just loops through the current inventory and shows the Product Name, Price, and exactly how much stock is remaining . Because of how I shared the data, this updates dynamically the second someone buys something in the first frame!


How Arrays Are Used (The "Aha!" Moment)
Since I couldn't use the easy .add() methods from ArrayList, I had to get creative. I created a central StoreData class just to hold my arrays so all three windows could share the exact same information.


Here is how I made it work:

1. Parallel Arrays for Inventory:
Instead of making complicated product objects, I just made three arrays that line up perfectly :

A String[] for the product names (Rice, Sugar, Coffee, Milk) .

A double[] for their prices.

An int[] for the stock (starting at 20 each) .

How it works: If someone buys 5 bags of Rice (which is at index 0), my code just says stock[0] -= 5. Boom, inventory updated!

2. Giant Empty Arrays for Logs:
Because I needed to save transaction history, I created huge empty arrays (size 100) to hold future data :

A String[] for the names of things bought.

An int[] for the quantities.

A double[] for the totals.

3. The Index Counter Trick!
This was my biggest breakthrough. Because plain arrays don't know when they are "full," I had to invent my own tracker. I made a variable called currentLogIndex starting at 0.


Every time a transaction finishes, I save the data exactly at that currentLogIndex slot in all three log arrays.

Then, I do currentLogIndex++ so the next purchase goes into the next slot!

When the Logs frame prints the history, I just tell my for loop to stop at currentLogIndex so it doesn't print 90 lines of empty null spaces!
