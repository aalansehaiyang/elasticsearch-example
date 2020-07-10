```


GET _search
{
  "query": {
    "match_all": {}
  }
}

GET /ecommerce/product/_search
{
    "query" : {
      "match_all" : {}
   }
}
 
PUT /ecommerce/product/1
{
    "productId" : 1,
    "name" : "苹果手机",
    "desc" :  "可以打电话、发短信、玩游戏",
    "price" :  6000,
    "producer" : "美国",
    "tags": [ "手机", "apple" ],
    "shopId":[10,11,12],
    "city":"12 13 14 156 134 343 123 164"
}

PUT /ecommerce/product/2
{
    "productId" : 2,
    "name" : "苹果",
    "desc" :  "产地烟台，有红又大的红富士苹果",
    "price" :  10,
    "producer" : "烟台",
    "tags": [ "苹果", "水果" ],
    "shopId":[10],
    "city":"12 14 13  16  134 343 17"
}

PUT /ecommerce/product/3
{
    "productId" : 3,
    "name" : "小米手机",
    "desc" :  "小米10系列，新一代LPDDR5内存，突破5G性能极限；90Hz流速屏，对称式立体声，突破5G影音极限",
    "price" :  3000,
    "producer" :  "中国",
    "tags": [ "手机" ],
    "shopId":[10,11,12,13],
    "city":"12 14 13  16  18 34 56 17 178"
}

PUT /ecommerce/product/4
{
    "productId" : 4,
    "name" : "手机测试数据苹果",
    "desc" :  "可以打电话、发短信、玩游戏",
    "price" :  9000,
    "producer" : "美国",
    "tags": [ "手机1", "apple" ],
    "shopId":[10,11,12],
    "city":"1 3  10 11 14  16  18  56 17 "

}

GET /ecommerce/product/2

GET /ecommerce/product/_search
 {
   "query" : {
      "match" : {
       "name" : "苹果"
      }
    },
    "sort" : [
      { "price" : "asc"}
      ],
      "from": 0,
      "size": 2
      
}


GET /ecommerce/product/_search
 {
   "query" : {
      "match_phrase" : {
       "name":{
         "query": "手机小米",
         "slop": 100
       }
      }
    },
    "sort" : [
      { "price" : "asc"}
      ],
      "from": 0,
      "size": 2
}

GET /ecommerce/product/_search
 {
   "query" : {
      "match_phrase" : {
       "city":{
         "query": "16   18",
         "slop": 100
       }
      }
    },
    "sort" : [
      { "price" : "asc"}
      ],
      "from": 0,
      "size": 2
}

GET /ecommerce/product/_search
 {
    "query" : {
      "bool" : {
        "must" : {
          "match" : {
            "name" : "手机"
        }
    },
    "filter" : {
      "range" : {
        "price": {"gt" : 1000}
          }
        }
      }
    }
  }
  

GET /ecommerce/product/_search
{
    "query" : {
      "match" : {
        "tags":   "手机" 
      }
   }
}

GET /ecommerce/product/_mapping




PUT range_index
{
  "mappings": {
    "my_type": {
      "properties": {
        "name": {
          "type": "text"
        },
        "time_frame": {
          "type": "date_range", 
          "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis"
        }
      }
    }
  }
}

PUT range_index/my_type/1
{
   "name" : "小米手机",
  "time_frame" : { 
    "gte" : "2015-10-31 12:00:00", 
    "lte" : "2015-11-01"
  }
}

GET /range_index/my_type/_mapping

GET /range_index/my_type/_search
{
    "query" : {
      "match_all" : {}
   }
}
 

delete  range_index



POST /_bulk
{"create":{"_index":"othermovies","_type":"doc","_id":"1"}}
{"title": "复仇者联盟4","director": "安东尼·罗素","year": 2019,"genres": ["科幻","动作"],"actors": ["小罗伯特·唐尼","克里斯·埃文斯","娜塔丽·波曼"]}
{"create":{"_index":"othermovies","_type":"doc","_id":"2"}}
{"title": "爱在记忆消失前","director": "保罗·维尔奇","year": 2017,"genres": ["剧情"],"actors": ""}
{"create":{"_index":"othermovies","_type":"doc","_id":"3"}}
{"title": "肥猫流浪记","director": "曹建南","year": 1988,"genres": ["剧情"], "actors": "郑则仕"}

GET /othermovies/doc/_mapping


POST /othermovies/_search
{
  "query": {
    "match": {
      "title": "爱在"
    }
  }
}



```