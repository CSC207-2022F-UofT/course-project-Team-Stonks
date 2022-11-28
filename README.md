# Group Members:
- Inaam (Inaam2)
- Noel 
- Elad
- Hoa
- Elliot
- Rohan
- Ben
- Jack

## Stock Market Simulation

The Stockmarket Simulator is a program that allows a user to simulate the environment of stock investments. It allows a user to register an account and then have the options to buy/sell/watchlist a stock and naturally develop multiple portfolios and an interest in the investment world!

## Entities

# Portfolio
The portfolio class stores the portfolios of each user
Contains attributes:
- String name
- String username
- Map symbolToStock (Maps from symbol name to stock object)
- StockFactory stockFactory
- iEntityDBGate dbGateway (To connect to database)

This entity provides the means to sell stocks, pull stocks and update stock values in the user's portfolio. 

# Portfolio Factory
# Stock
The stock class stores the stock information in the form of a Stock object.
Contains attributes:
- String symbol
- double value
- int quantity
- iEntityDBGateway dbGateway

# Stock Factory
# User
# User Factory
# User Manager

## Use Cases

(TODO)

## Controllers
(TODO)

## GUI
(TODO)


(TODO)
