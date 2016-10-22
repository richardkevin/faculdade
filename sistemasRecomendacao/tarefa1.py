from collections import OrderedDict
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


def get_user_rate_item(user, item):
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


def users_rates(users_rated_item):
    rates = {}
    for user_r in users_rated_item[1]:
        rates[user_r] = users[user_r]
    return rates


def get_medias(rates):
    medias = {}
    for user in rates:
        soma = 0
        count = 0
        for item in rates[user]:
            aux = rates[user][item]
            if aux != "?":
                count += 1
                soma += float(aux)
        medias[user] = soma / count
    return medias


def get_rab(principal):
    sum_rab = {}
    for item in users[principal]:
        if users[principal][item] != "?":
            sum_rab[item] = round(
                (float(users[principal][item]) - medias[principal]), 2
            )
    return sum_rab


def get_rbb(list_users):
    sum_rbb = {}
    for user in list_users:
        aux = {}
        for item in list_users[user]:
            rbb = list_users[user][item]
            if rbb != "?":
                aux[item] = round((float(rbb) - medias[user]), 2)
        sum_rbb[user] = aux
    return sum_rbb


def get_similarity(rab, rbb):
    similaritys = {}
    for user in rbb:
        numerador = []
        denominador = []
        rab_denominador = []
        rbb_denominador = []
        for item in rbb[user]:
            if item in rab and item in rbb[user]:
                prod_rab = rab[item]
                prod_rbb = rbb[user][item]
                numerador.append(prod_rab * prod_rbb)
                rab_denominador.append(prod_rab**2)
                rbb_denominador.append(prod_rbb**2)
                denominador.append(
                    sum(rab_denominador)**(1/2.0) * sum(rbb_denominador)**(1/2.0)
                )
        sim = round((sum(numerador) / sum(denominador)), 2)
        similaritys[user] = sim
    return similaritys


def descending_similarity(sim):
    for key, value in sorted(sim.iteritems(), key=lambda (k,v): (v,k), reverse=True):
        print "{}: {}".format(key, value)
# while True: quit()


def predBasedItems():
    pass


user, item = "User 9", "Item 10"

# print "Qual usuario deseja selecionar?"
# user = "User " + str(userInput())
# print "Qual item deseja visualizar?"
# item = "Item " + str(userInput())

if checkIfUserRatedItem(user, item):
    print "O '{}' avaliou o '{}' com: {}".format(
        user,
        item,
        get_user_rate_item(user, item)
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
    medias = get_medias(users)
    list_users = users.copy()
    list_users.pop(user)
    rab = get_rab(user)
    rbb = get_rbb(list_users)
    sim = get_similarity(rab, rbb)
    descending_similarity(sim)
