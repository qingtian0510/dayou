import csv
import json
import requests
from time import sleep
import sys


class InstagramUtils:
    # 目标用户name 外部传入
    userName = ''
    # 目标用户id 从ins爬取得到
    userId = ''
    # 用来爬取数据的用户
    searchUserId = ''

    headers = {
        'accept': '*/*',
        'accept-encoding': 'gzip, deflate, br',
        'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8',
        'origin': 'https://www.instagram.com',
        'referer': 'https://www.instagram.com/',
        'sec-ch-ua': '"Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105"',
        'sec-ch-ua-mobile': '?0',
        'sec-ch-ua-platform': '"macOS"',
        'sec-fetch-dest': 'empty',
        'sec-fetch-mode': 'cors',
        'sec-fetch-site': 'same-site',
        'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36',
        'x-asbd-id': '198387',
        'x-csrftoken': 'jeq7pLTD0VKLy8yPB6Sh8v69sd5QRP5c',
        'x-ig-app-id': '936619743392459',
        'x-ig-www-claim': 'hmac.AR0ADB7RuSt24NttcwVS4vn3wNzVNtxNWaiX1NtoU16Pcm-z',
        'x-instagram-ajax': '1006355913',
    }

    def __init__(self, username, userid):
        self.userName = username
        self.searchUserId = userid
        self.headers['cookie'] = r'mid=YxarXgAEAAHLH7WKZ2AUY3DRb61Y; ig_did=AEE56D8C-F03B-48D2-85A7-0A32E4E168E5; ig_nrcb=1; csrftoken=jeq7pLTD0VKLy8yPB6Sh8v69sd5QRP5c; ds_user_id=%s; datr=IqwWY0hsZOGo58I7hTUa8DIX; dpr=2; shbid="13598\054240473023\0541696834299:01f734c54f080c188546f870f7644eb5f97af4bb9fec366c563eee4a3d51b60767133944"; shbts="1665298299\054240473023\0541696834299:01f70b9339ef5d6a6e654163724c4f43c9f9fcb9707162ba4102cf82211b4366645d70e5"; sessionid=240473023:mc08WaoaYy96bN:3:AYeoVCYdOTlPxBIsH7fF2kw6M6si7ChvjhFTkEcppQ; rur="NCG\054240473023\0541696842644:01f7ac387b067c68d3840859500d82c8993e085e50f086fd091b6d39231a1452a694a1c2"' % userid

    def get_id_by_name(self):
        params = (
            ('username', self.userName),
        )
        response = requests.get('https://i.instagram.com/api/v1/users/web_profile_info/', headers=self.headers, params=params)
        res = response.json()
        name = res['data']['user']['id']
        # print(res)
        response.close()
        return name

    def get_funs_by_id(self, userid, count):
        url = 'https://i.instagram.com/api/v1/friendships/%s/followers/' % userid
        params = (
            ('count', count),
            ('search_surface', 'follow_list_page'),
        )
        response = requests.get(url, headers=self.headers, params=params)
        print(response.text)
        res = response.json()
        response.close()
        return res


if __name__ == '__main__':

    # utils = InstagramUtils('qingtian423', '55407457717')
    # userid = utils.get_id_by_name()
    # print(userid)
    userName = sys.argv[1]
    searchUserId = sys.argv[2]
    count = sys.argv[3]
    print("input args: userName=%s,searchUserId=%s,count=%s" % (userName, searchUserId, count))

    utils = InstagramUtils(userName, searchUserId)
    #
    # # userid = '240473023'
    userId = utils.get_id_by_name()
    print("name: %s, id: %s. and sleep 3s" % (userName, userId))
    sleep(3)
    resJson = utils.get_funs_by_id(userId, count)
    fans = []
    for user in resJson['users']:
        dic = {'id': user['pk'], 'name': user['username'], 'full_name': user['full_name']}
        fans.append(dic)

    print(fans)

