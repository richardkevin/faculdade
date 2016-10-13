import csv
import json

jsonfile = open('ratings.json', 'w')

users = {}
ratings = []

with open('ratings.csv', 'r') as csvfile:
    reader = csv.reader(csvfile)
    for row in reader:
        ratings.append(row)

header = ratings[0]
header.pop()
ratings.pop(0)

for rate in ratings:
    aux = {}
    for i in enumerate(rate[1:]):
        aux[header[i[0]]] = i[1]
    users[rate[0]] = aux

json.dump(users, jsonfile, indent=4)
jsonfile.write('\n')
jsonfile.close()


def checkIfUserRatedItem(user, item):
    if users[user][item] != "?":
        return True
    return False


def countUserRates(user):
    for user in users:
        count = 0
        for i in users[user]:
            if users[user][i] == "?":
                count += 1
        print "o usuario {0} avaliou {1} itens".format(user, 10-count)


def howManyUsersRatedItem(item):
    count = 0
    for user in users:
        if users[user][item] != "?":
            count += 1
    print "{0} usuarios avaliaram o item {1}".format(count, item)


def userInput():
    print "Informe o Usuario desejado: "
    user = input()
    print "Informe o Item desejado: "
    item = input()
    return user, item


def checkEqualUserRates(user):
    count = 0
    for u in users:
        if user != u:
            if users[u] == users[user]:
                count += 1
    return count


def checkUsersThatRatedItemY(item):
    count = 0
    for user in users:
        if checkIfUserRatedItem(user, item):
            count += 1
    return count


user, item = userInput()

if checkIfUserRatedItem(user, item):
    print "Rxy"
else:
    print "Quantas pessoas avaliaram o item {}?".format(item)
    howManyUsersRatedItem(item)
    print "Quantos itens o {} avaliou?".format(user)
    countUserRates(user)
    print "Numero de usuarios que avaliou os mesmos itens que o {}".format(user)
    print checkEqualUserRates(user)
    print "Numero de usuarios que avaliaram o {}".format(item)
    print checkUsersThatRatedItemY(item)
