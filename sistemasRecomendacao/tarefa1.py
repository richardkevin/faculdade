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


def userInput():
    print "Entre apenas com numero entre 1 e 10"
    num = input()
    return num if num in range(1, 11) else userInput()


def checkIfUserRatedItem(user, item):
    if users[user][item] != "?":
        return True
    return False


def getItemRated(user, item):
    return users[user][item]


def usersThatRatedItemY(item):
    count = 0
    for user in users:
        if checkIfUserRatedItem(user, item):
            count += 1
            return count


def countUserRates(user):
    for user in users:
        count = 0
        for i in users[user]:
            if users[user][i] == "?":
                count += 1
        return 10-count


def howManyUsersRatedItem(item):
    count = 0
    user_with_same_rates = []
    for user in users:
        if users[user][item] != "?":
            count += 1
            user_with_same_rates.append(user)
    return (count, user_with_same_rates)


def checkEqualUserRates(user):
    count = 0
    for u in users:
        if user != u:
            if users[u] == users[user]:
                count += 1
    return count


def predBasedUsers(user, item):
    users_rated = howManyUsersRatedItem(item)
    rates = {}
    diff_user = {}
    for user_r in users_rated[1]:
        rates[user_r] = users[user_r]
    for r in rates:
        diff_rates = {}
        for item_r in rates[r]:
            diff_rates[item_r] = (users[user][item_r], rates[r][item_r])
        diff_user[r] = diff_rates
    # comparar e ver similaridades



def predBasedItems():
    pass


user, item = "User 9", "Item 10"
# predBasedUsers(user, item)
# print "Qual usuario deseja selecionar?"
# user = "User " + str(userInput())
# print "Qual item deseja visualizar?"
# item = "Item " + str(userInput())
if checkIfUserRatedItem(user, item):
    print "O '{}' avaliou o '{}' com: {}".format(
        user,
        item,
        getItemRated(user, item)
    )
else:
    print "Quantas pessoas avaliaram o {}?".format(item)
    print "{} usuarios\n".format(howManyUsersRatedItem(item)[0])
    print "Quantos itens o {} avaliou?".format(user)
    print "{} itens\n".format(countUserRates(user))
    print "Quantos usuarios avaliaram os mesmos itens que o {}?".format(user)
    print "{} usuarios \n".format(checkEqualUserRates(user))
    print "Quantos usuarios avaliaram o {}?".format(item)
    print "{} usuarios\n".format(usersThatRatedItemY(item))
    print "pred(rx,y) baseado em usuarios"
    print predBasedUsers(user, item)
