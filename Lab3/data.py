import os
import random

f = open('./200010021_2.sql','a')

part = ['Axel', 'Radio', "Gps", 'Seat', 'Frame', 'Engine', 'Brakes', 'flash']

price = list(range(100, 10000, 1000))

color = ['violet', 'indigo', 'blue', 'green', 'yellow', 'orange', 'purple', 'gray']

weight = [x/10 for x in range(10, 26, 2)]

sup_name = [ 'DF', 'AJ', 'RR', 'GT', 'FG', 'HJ']

city = ['HYD', 'DELHI', 'KOLKATA', 'DHARWAD', 'BELUR', 'VIZAG', 'CHENNAI', 'AGRA']

partship = [0]*(len(part)+1)
for i in range(2,50):
    c = random.randint(1,17)

    f.write(f"({i}, {c}, {random.randint(1,7)}, STR_TO_DATE('2020-{i%12}-{i%30}', '%Y-%m-%d'), {i}, {price[i%len(price)]} ), \n")

    if c < 10:
        partship[c-1] += 1
    if c >= 10:
        partship[c-8-1] += 1

for i in range(9):
    if (partship[i] < 4):
        k = partship[i]

        while k<=4 :
            f.write(f"({51+i}, {i+1}, {random.randint(1,7)}, STR_TO_DATE('2020-10-11', '%Y-%m-%d'), {i+1}, {price[i%len(price)]}), \n")
            k+=1
