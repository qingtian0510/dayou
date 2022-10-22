
import csv
import json
import requests
from time import sleep

id = '545774776'
source_id = '55407457717'
# url = 'https://i.instagram.com/api/v1/friendships/545774776/followers/?count=12&search_surface=follow_list_page'
url = 'https://i.instagram.com/api/v1/friendships/%s/followers/' % id
print(url)
# cookie 是需要替换的，referer 最好是替换一下
headers = {
    # 'sec-ch-ua': 'Google Chrome 77',
    # 'sec-fetch-mode': 'cors',
    # 'dnt': '1',
    # 'x-ig-www-claim': 'hmac.AR1P1exDcpFRvpFAYKNm_Wnajygy1QK5l3HC7cN5943dNlY-',
    # 'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8',
    # 'sec-fetch-dest': 'empty',
    # 'x-requested-with': 'XMLHttpRequest',
    # 'cookie': r'mid=YxarXgAEAAHLH7WKZ2AUY3DRb61Y; ig_did=AEE56D8C-F03B-48D2-85A7-0A32E4E168E5; ig_nrcb=1; csrftoken=jeq7pLTD0VKLy8yPB6Sh8v69sd5QRP5c; ds_user_id=240473023; shbid="13598\054240473023\0541693966221:01f70c9d70ff217bf517b65e76fcc7ee93af1eb06ec0bc230f87f2d52531c98affb148e9"; shbts="1662430221\054240473023\0541693966221:01f72cc8a6c085bf5c5df57832c6c5116a060648c90b816feb995673bbf4c9a249772684"; dpr=2; datr=IqwWY0hsZOGo58I7hTUa8DIX; sessionid=240473023:mc08WaoaYy96bN:3:AYexuGTC33S3T8BbEtQkGWbvd6Cid1WFm-dL7KfnZg; rur="VLL\054240473023\0541694057007:01f775585a4cb7fd2cc6ddb0a80da7be00f1b00232deedcbf76bea0466aad0c1b6890c3b"',
    # 'x-csrftoken': '1vBpb3wLDDDbC63ckwu06IzIy351nB12',
    # 'x-ig-app-id': '936619743392459',
    # 'accept-encoding': 'gzip, deflate, br',
    # 'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.75 Safari/537.36',
    # 'accept': '*/*',
    # # 'referer': 'https://www.instagram.com/linda_ledo_carlights/following/',
    # 'referer': 'https://www.instagram.com/04_02_15_/?hl=zh-cn',
    # 'authority': 'www.instagram.com',
    # 'sec-fetch-site': 'same-origin',
    'accept': '*/*',
    'accept-encoding': 'gzip, deflate, br',
    'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8',
    'cookie': r'mid=YxarXgAEAAHLH7WKZ2AUY3DRb61Y; ig_did=AEE56D8C-F03B-48D2-85A7-0A32E4E168E5; ig_nrcb=1; csrftoken=jeq7pLTD0VKLy8yPB6Sh8v69sd5QRP5c; ds_user_id=%s; datr=IqwWY0hsZOGo58I7hTUa8DIX; dpr=2; shbid="13598\054240473023\0541696834299:01f734c54f080c188546f870f7644eb5f97af4bb9fec366c563eee4a3d51b60767133944"; shbts="1665298299\054240473023\0541696834299:01f70b9339ef5d6a6e654163724c4f43c9f9fcb9707162ba4102cf82211b4366645d70e5"; sessionid=240473023:mc08WaoaYy96bN:3:AYeoVCYdOTlPxBIsH7fF2kw6M6si7ChvjhFTkEcppQ; rur="NCG\054240473023\0541696842644:01f7ac387b067c68d3840859500d82c8993e085e50f086fd091b6d39231a1452a694a1c2"' % source_id,
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


params = (
    ('count', 50),
    ('search_surface', 'follow_list_page'),
)

response = requests.get(url, headers=headers, params=params).text
print(response)

# end_cursor = ''
# has_next = True
#
# while has_next:
#     # id是需要替换的，每一个用户的 id 不一样
#     #545774776 5848320586
#     params = (
#         ('count', 12),
#         ('search_surface', 'follow_list_page'),
#     )
#     QVFBQVpVcS1mQjk5RGg3UkhuWlhZV0h4UC0wb3liTXNEY3hCTVhUcXZoMi0zcmZKVWRUbjZXamlyaURpRGdxaGxiQmZxRzdYWmx6V3VpbUx0UDNraWVMZg==",
#     QVFBQVpVcS1mQjk5RGg3UkhuWlhZV0h4UC0wb3liTXNEY3hCTVhUcXZoMi0zcmZKVWRUbjZXamlyaURpRGdxaGxiQmZxRzdYWmx6V3VpbUx0UDNraWVMZg
#     response = requests.get(url, headers=headers, params=params).text
#     print(response)
#
#     res = json.loads(response)
#     has_next = res['data']['user']['edge_follow']['page_info']['has_next_page']
#     print(has_next)
#     end_cursor = res['data']['user']['edge_follow']['page_info']['end_cursor']
#     edges = res['data']['user']['edge_follow']['edges']
#
#     out = open("ig.csv", "a+", newline="", encoding="utf-8-sig")
#     csv_writer = csv.writer(out, dialect="excel")
#
#     for i in edges:
#         row = [i['node']['id'], i['node']['username'], i['node']['full_name']]
#         csv_writer.writerow(row)
#
#     out.close()
#     sleep(233)

print("=============搞定收工==============")

