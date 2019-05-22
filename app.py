import optparse


def init_opt():
    parse = optparse.OptionParser()
    parse.add_option("-u", action="store", dest="username", help="username")
    parse.add_option("-U", action="store", dest="username_file", help="file of usernames")
    parse.add_option("-P", action="store", dest="password_file", help="file of passwords")
    (options, args) = parse.parse_args()
    return options

# def login(username, password):

# def read_file(filename):


def read_file(filename):
    with open(filename, 'r', encoding='utf8') as f:
        result = f.readlines()
    return result


def build_users_and_pass(opt):
    usernames = []
    if opt.has_option('username'):
        usernames.append(opt['username'])
    elif opt.has_option('username_file'):
        usernames = read_file(opt['username_file'])
    password_file = opt['password_file']
    passwords = read_file(password_file)
    return usernames, passwords


if __name__ == '__main__':
    options = init_opt()
    print(type(options))
    usernames, passwords = build_users_and_pass(options)
    print(usernames)

