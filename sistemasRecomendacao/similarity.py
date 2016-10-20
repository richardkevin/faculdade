rates = {
    'Alice': {
        'item1': 5,
        'item2': 3,
        'item3': 4,
        'item4': 4,
        'item5': '?'
    },
    'User1': {
        'item1': 3,
        'item2': 1,
        'item3': 2,
        'item4': 3,
        'item5': 3
    }
}

a = {  # sim = 0,85
    'User2': {
        'item1': 4,
        'item2': 3,
        'item3': 4,
        'item4': 3,
        'item5': 5
    },  # sim = 0,71
    'User3': {
        'item1': 3,
        'item2': 3,
        'item3': 1,
        'item4': 5,
        'item5': 4
    },  # sim = 0,00
    'User4': {
        'item1': 1,
        'item2': 5,
        'item3': 5,
        'item4': 2,
        'item5': 1
    },
}


def get_medias(rates):
    medias = {}
    for user in rates:
        soma = 0
        for item in rates[user]:
            aux = rates[user][item]
            if aux != "?":
                soma = float(aux)
        medias[user] = soma
    return medias


def get_similarity(principal, list_users):
    produto_rab_rbb = []
    for user in list_users:
        for item in list_users[user]:
            prod = 1
            rab = rates[principal][item]
            if rab != "?":
                rab_media = rab - medias[principal]
            else:
                rab_media = 1
            rbb = list_users[user][item]
            if rbb != "?":
                rbb_media = rbb - medias[user]
            else:
                rbb_media = 1
            prod = rab_media * rbb_media
            produto_rab_rbb.append(prod)
    numerador = sum(produto_rab_rbb)



# print item
# print "principal: ", rate_principal
# print "media ", medias[principal]
# print "neighboor: ", rate_neighboor
# print "media ", medias[user]
# print "rab: " , rab
# print "rbb: " , rbb
# prod = rab * rbb
# print "prod: " , prod
# print "**************"

medias = get_medias(rates)
list_users = rates.copy()
list_users.pop("Alice")
get_similarity("Alice", list_users)
