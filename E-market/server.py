import socket
import datetime
import pyodbc
import re
import time

#connect database
conn = pyodbc.connect('Driver={SQL Server};'
                      'Server=DESKTOP-****\SQLEXPRESS;' #rearrange for your system
                      'Database=****;' #rearrange for your database
                      'Trusted_Connection=yes;')

cursor = conn.cursor()

#configure socket
host_name = "localhost"
port = 9999
internet_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
internet_socket.bind((host_name,port))
internet_socket.listen()

cursor.execute('SELECT * FROM productsdb') #products are pulled from database (rename productsdb for your database)
products = cursor.fetchall() 
products = str(products) #pyodbc.row type convert to string
products = eval(products) 

#nested while loop is used to make multiple queries
while True:
    connect, adress = internet_socket.accept()   
    while True: 
        x = datetime.datetime.now()
        x = x.strftime("%c") 
        recv_querry = str(connect.recv(1024).decode()) 
        for i in range(0,len(products)): 
            result=re.search(recv_querry,products[i][0]) #regex search with data from database and query from client 
            if result: #matching product
                connect.send(str(products[i]).encode()) #send matching product to client
                time.sleep(1)
        connect.send(x.encode()) #send date to client
        connect.send("finish".encode()) #if there is no product matching the query, send finish string
        
connect.close()
conn.close()