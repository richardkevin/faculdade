import csv


def read_csv_dataset(dataset):
    dataset_name = "{}.csv".format(dataset)
    users = {}
    ratings = []
    with open(dataset_name, 'r') as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            ratings.append(row)

    ratings.pop(0)
    for user in ratings:
        aux = {}
        for rate in enumerate(user[1:]):
            itemN = "Item{}".format(rate[0]+1)
            aux[itemN] = rate[1]
        users[user[0]] = aux

    return users


def userInput():
    print "Entre apenas com numero entre 1 e 10"
    num = input()
    return num if num in range(1, 11) else userInput()


def checkIfUserRatedItemY(user, item):
    return users_ratings[user][item] != '?'


def get_user_rate_item(user, item):
    return users_ratings[user][item]


def countUserRates(user):
    for user in users_ratings:
        count = 0
        for i in users_ratings[user]:
            if users_ratings[user][i] == "?":
                count += 1
        return 10-count


def howManyUsersRatedItem(item):
    count = 0
    user_with_same_rates = []
    for user in users_ratings:
        if users_ratings[user][item] != "?":
            count += 1
            user_with_same_rates.append(user)
    return (count, user_with_same_rates)


def usersRatedSameItems(user_principal):
    count = 0
    for user in users_ratings:
        same = True
        i = 1
        tam = len(users_ratings[user])
        while same and i < tam:
            itemN = "Item{}".format(i)
            if checkIfUserRatedItemY(user, itemN) != checkIfUserRatedItemY(user_principal, itemN):
                same = False
            i += 1
        if same and i == tam:
            count += 1
    return count


def users_rates(users_rated_item):
    rates = {}
    for user_r in users_rated_item[1]:
        rates[user_r] = users_ratings[user_r]
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
        medias[user] = round((soma / count), 2)
    return medias


def get_rab(principal):
    sum_rab = {}
    for item in users_ratings[principal]:
        if users_ratings[principal][item] != "?":
            sum_rab[item] = round(
                (float(users_ratings[principal][item]) - medias[principal]), 2
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
    lista = []
    for key, value in sorted(sim.iteritems(), key=lambda (k, v): (v, k), reverse=True):
        descending = {}
        descending[key] = value
        lista.append(descending)
    return lista


def higher_similarity(sim):
    key, value = max(sim.iteritems(), key=lambda x: x[1])
    return (key, value)


def user_prediction(higher_sim):
    numerador = []
    denominador = round(sum(sim.values()), 2)
    user = higher_sim[0]
    for item in rbb[user]:
        numerador.append(higher_sim[1] * rbb[user][item])
    return medias[user] + (sum(numerador) / denominador)


def item_prediction(similaritys, item_a, item_b, size):
    numerador = []
    sum_rua = []
    sum_rub = []
    sim_slice = similaritys[:size]
    for sim in sim_slice:
        for user in sim:
            if users_ratings[user][item_a] != "?" and users_ratings[user][item_b] != "?":
                numerador.append(float(users_ratings[user][item_a]) * float(users_ratings[user][item_b]))
                sum_rua.append(float(users_ratings[user][item_a])**2)
                sum_rub.append(float(users_ratings[user][item_b])**2)
    final = sum(numerador) / (sum(sum_rua)**(1/2.0) + sum(sum_rub)**(1/2.0))
    return round(final, 2)


# user, item = "User18", "Item5"
users_ratings = read_csv_dataset("dataset_Izabella_Barboza")
print "Qual usuario deseja selecionar?"
user = "User" + str(userInput())
print "Qual item deseja visualizar?"
item = "Item" + str(userInput())

if checkIfUserRatedItemY(user, item):
    print "O '{}' avaliou o '{}' com: {}".format(
        user,
        item,
        get_user_rate_item(user, item)
    )
else:
    print "Numero de usuarios que avaliaram o {}?".format(item)
    print "{} usuarios\n".format(howManyUsersRatedItem(item)[0])
    print "Numero de itens avaliados pelo {}?".format(user)
    print "{} itens\n".format(countUserRates(user))
    print "Numero de usuarios que avaliaram os mesmos itens que o {}?".format(user)
    print "{} usuarios \n".format(usersRatedSameItems(user))
    print "pred(rx,y) baseado em usuarios"
    medias = get_medias(users_ratings)
    list_users = users_ratings.copy()
    list_users.pop(user)
    rab = get_rab(user)
    rbb = get_rbb(list_users)
    sim = get_similarity(rab, rbb)
    descending_sim = descending_similarity(sim)
    higher_sim = higher_similarity(sim)
    print user_prediction(higher_sim)
    print "\npred(rx,y) baseado em itens"
    print "Qual item deseja comparar?"
    item_secundario = "Item" + str(userInput())
    # item_secundario = "Item1"
    print "pred(rx,y) = {}".format(
        item_prediction(descending_sim, item, item_secundario, 5)
    )
