import re
import socket
import time
import pyodbc
import datetime

host_name = "localhost"
port = 9999
internet_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
internet_socket.connect((host_name,port))

#max 2 words or min 1 word
def limit():
    query=None
    while True:
        search = input("The product you want to search: ")
        counter1 = search.split()
        if len(counter1)<=2 and len(counter1)>=1:
            query=search
            break
        else:
            print("Please enter at least one and at most two words")
    return query
    
#discount with entered school number exp:201913171034    
def reduced(school_number):
    x = school_number[:4]
    x = int(x)
    x = 2023 - x
    
    e = school_number[8:9]
    e = int(e)
    
    f = school_number[9:10]
    f = int(f)
    
    g = school_number[10:11]
    g = int(g)
    
    h = school_number[11:12]
    h = int(h)
    
    discount =(e*x**3+f*x**2+g*x+h)/x**4
    
    return discount
   
print("connection succesful !! {}:{} ". format(host_name , port))

school_number = input("School id: ")
promo = reduced(school_number)

query = limit() #first query taken


while query!="exit":
    internet_socket.send(query.encode()) #the query entered by the user is sent to the server
    while True:    
        data = internet_socket.recv(1024).decode() 
        if data=="finish":
            break #break the loop for taking new query
        try:
            print1 = data.split(",") 
            cost = int(print1[1])
            discount = (1-promo)*cost
            print(f"product name:{print1[0]}\nproduct price: {print1[1]} TL\ndiscounted price: {discount} TL\nproduct stock: {print1[2]}")
        except IndexError:
            print(f"product search date and time: {data}")    
    query = limit()
    
internet_socket.close()