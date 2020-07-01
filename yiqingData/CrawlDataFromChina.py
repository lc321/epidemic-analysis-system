import requests;
from lxml import etree;
import json;
import datetime;
import pymysql;
import time;

#数据抓取
def crawl():
    #第一步下载网页源码
    url = "https://ncov.dxy.cn/ncovh5/view/pneumonia?from=timeline&isappinstalled=0"
    #模拟浏览器访问网站
    rs = requests.get(url);
    rs.encoding = "UTF-8";
    #获取网页源码
    html = rs.text;
    #print(html);
    #第二步解析源码
    html = etree.HTML(html);
    #第三步提取数据
    info = html.xpath("//script[@id='getAreaStat']/text()");
    #print(info);
    #列表转字符串
    info = str(info);
    #print(info);
    #截取字符串
    message = info[29:-13];
    #print(message);
    # 转换成列表
    lists = json.loads(message);
    #print(lists)
    lm1 = [];
    lm2 = [];
    for x in lists:
        #print("省份：", x["provinceShortName"]);
        li = x["cities"];
        #print("现存确诊：", x["currentConfirmedCount"]);
        #print("累计确诊：", x["confirmedCount"]);
        #print("治愈人数：", x["curedCount"]);
        #print("死亡人数：", x["deadCount"]);
        # 获取系统当前时间
        nowTime = datetime.datetime.now().strftime("%Y-%m-%d");
        t1 = (nowTime, x["provinceShortName"],None, x["confirmedCount"],
                x["curedCount"], x["deadCount"]);
        lm1.append(t1);
        for y in li:
            #print("地区：",y["cityName"]);
            #print("现存确诊：", y["currentConfirmedCount"]);
            #print("累计确诊：", y["confirmedCount"]);
            #print("治愈人数：", y["curedCount"]);
            #print("死亡人数：", y["deadCount"]);
            t2 = (nowTime, x["provinceShortName"],y["cityName"], y["confirmedCount"],
                y["curedCount"], y["deadCount"]);
            lm2.append(t2);
    #查询今日数据是否存在
    iss = select();
    if iss == True:
        print("今日数据已爬取完毕");
    else:
        #print("省份数据：", lm1);
        insert(lm1);
        #print("地区数据：", lm2);
        insert(lm2);

#数据插入
def insert(m):
    # 创建数据库连接端口默认3306
    con = pymysql.connect("localhost", "root", "1234", "yiqing", charset="utf8");
    # 创建游标对象（数据库操作对象）
    cur = con.cursor();
    # 定义批量插入的sql语句
    # sql = "insert into student (userName,age) values(%s,%s)";
    # sql = "insert into testinfo (time,provinceName,currentConfirmedCount,confirmCount,curedCount,deadCount) " \
    #    "values(%s,%s,%s,%s,%s,%s)";
    sql = "insert into info (time,provinceName,areaName,confirmCount,curedCount,deadCount) " \
          "values(%s,%s,%s,%s,%s,%s)";
    try:
        # 运行sql
        cur.executemany(sql, m);
        # 事务提交
        con.commit();
        print("批量插入成功");
    except Exception as e:
        print(e);
        # 事务回滚
        con.rollback();
        print("批量插入失败");
    finally:
        con.close();
        cur.close();

#查询
def select():
    #创建数据库连接端口默认3306
    con = pymysql.connect("localhost","root","1234","yiqing",charset="utf8");
    #创建游标对象（数据库操作对象）
    cur = con.cursor();
    #定义sql语句
    sql = "select * from info where time = NOW()";
    #sql = "select * from student where userName="%(name);
    #运行sql
    cur.execute(sql);
    #拿到查询结果
    res = cur.fetchall();
    #打印结果
    #print(res);
    #关闭游标和数据库连接
    cur.close();
    con.close();
    #判断查询结果是否有数据
    if(len(res) > 0):
        return  True;
    else:
        return False;

#定义一个定时任务
def scheduledTask():
    crawl();
    while True:
        time.sleep(5);
        crawl();

if __name__ == "__main__":
    scheduledTask();