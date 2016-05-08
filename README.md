# WALL-E


##### 接口地址：
    http://www.tuling123.com/openapi/api

##### 请求方式：

    HTTP POST

##### 请求参数格式： 
   
    json

##### 示例

  <1>请求示例

      {

      “key”: “APIKEY”,

      “info”: “明天北京到拉萨的飞机”
     
       }

  <2>返回数据

      {

     "code": 200000,

     "text": "亲，已帮你找到航班信息",

     "url": "http://touch.qunar.com/h5/flight/flightlist?bd_source=chongdong&startCity=%E5%8C%97%E4%BA%AC&destCity=%E6%8B%89%E8%90%A8&startDate=2015-12-25&backDate=&flightType=oneWay&priceSortType=1"

     }

  <3>数据说明
  
       字段 	说明
       
       code 	链接类标识码
       
       text 	提示语
       
       url 	链接地址
