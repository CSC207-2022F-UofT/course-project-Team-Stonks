# Group Members:
- Inaam (Inaam2)
- Noel 
- Elad
- Hoa (Peacful36)
- Elliot
- Rohan
- Ben
- Jack

## Stock Market Simulation

The Stockmarket Simulator is a program that allows a user to simulate the environment of stock investments. It allows a user to register an account and then have the options to buy/sell/watchlist a stock and naturally develop multiple portfolios and an interest in the investment world!

# Entities

## Portfolio
The portfolio class stores the portfolios of each user
Contains attributes:
- String name
- String username
- Map symbolToStock (Maps from symbol name to stock object)
- StockFactory stockFactory
- iEntityDBGate dbGateway (To connect to database)

This entity provides the means to sell stocks, pull stocks and update stock values in the user's portfolio. 

## Portfolio Factory
The portfolio factory class is used to create portfolios for each user
## Stock
The stock class stores the stock information in the form of a Stock object.
Contains attributes:
- String symbol
- double value
- int quantity
- iEntityDBGateway dbGateway

## Stock Factory
The stock factory class is used to create stock objects 
## User
The user class stores the user information in the form of a User object.
Contains attributes:
- String username
- String password
- String email
- iEntityDBGateway dbGateway
- PortfolioFactory portfolioFactory
- Portfolio portfolio
- Map portfolioMap (Maps from portfolio name to portfolio object)
- Map symbolToStock (Maps from symbol name to stock object)
- StockFactory stockFactory
## User Factory
The user factory class is used to create user objects
## User Manager
The user manager class is used to manage the user objects

# Use Cases

## Registration use case

This use case provides the interface to register a user with a username and password. This use case has the following functions:
- signUpUser() 
  - Takes in the username, password and password confirmation to check with the input data is suitable to be registered given that it passes certain conditions
- passwordValid()
  - Takes in the password and password confirmation and checks if it follows the neccessary conditions of being a valid password. If it does, it will return True, otherwise False
- usernameValid()
  - Takes in the input username and checks if it follows the neccessary conditions of being a valid username. If it does, it will return True, otherwise False
  
## Login use case

## Portfolio use case

## Search Stock use case

## Buy Stock use case

## Sell Stock use case

## Watchlist use case

## Leaderboard use case



(TODO)

# Controllers
(TODO)

# GUI
(TODO)


(TODO)
