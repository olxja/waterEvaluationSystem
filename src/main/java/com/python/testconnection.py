# coding=utf-8
import types
import urllib2
import json
duan = "--------------------------"  # 在控制台断行区别的


# 利用urllib2获取网络数据
def registerUrl():
    # type: () -> object
    try:
        url = "http://localhost:8888/getUserCompanyInfo?user_id=23"
        data = urllib2.urlopen(url).read()
        return data
    except Exception, e:
        print e


# 写入文件
def jsonFile(fileData):
    file = open("C:\Users\olxja_000\Desktop\json.txt", "w")
    file.write(fileData)
    file.close()


# 解析从网络上获取的JSON数据
def praserJsonFile(jsonData):
    value = json.loads(jsonData,encoding='UTF-8')
    rootlist = value.keys()
    print rootlist
    print duan
    for rootkey in rootlist:
        print rootkey
        newjson = json.dumps(value[rootkey], ensure_ascii=False)
        print newjson
    print duan
    # subvalue = value[rootkey]
    # print subvalue
    # print duan
    # for subkey in subvalue:
    #     print subkey, subvalue[subkey]

def firstprintf(x):
    print x
    return x

def test(a, b):
    return a + b

if __name__ == "__main__":
    # xinput = raw_input()
    # x = 130
    # xvalue = cmp(x,xinput)
    # print xvalue
    # print x/100.0

    # data = registerUrl()
    # jsonFile(data)

    # praserJsonFile(data)
    print "guess what?"

