<@p.page>
<@p.tree root="${action.getBundle('admin.tree.root')}" display="block">
<script type="text/javascript"> 
var treeMenu = [
	{ level:1, name:"<@s.property value="%{getText('admin.tree.weather')}"/>", link:"weather/weatherAdmin.action"},
	{ level:1, name:"<@s.property value="%{getText('admin.tree.recommend')}"/>", link:"recommend/recommendAdmin.action"},
	{ level:1, name:"<@s.property value="%{getText('admin.tree.resource.title')}"/>"},
	{ level:2, name:"<@s.property value="%{getText('admin.tree.resource')}"/>", link:"resource/resourceAdmin.action"},
	{ level:2, name:"<@s.property value="%{getText('admin.tree.subscriber')}"/>", link:"subscriber/subscriberAdmin.action"},
	
	
	{ level:1, name:"关于我们"},
	{ level:2, name:"公司介绍", link:"about/company!admin.action"},
	{ level:2, name:"业务范围", link:"about/biz!admin.action"},
	{ level:2, name:"美好回忆", link:"about/memory!admin.action"},
	{ level:2, name:"人员介绍", link:"about/team!admin.action"},
	
	{ level:1, name:"关于大连"},
	{ level:2, name:"大连介绍", link:"city/intro!admin.action"},
	{ level:2, name:"大连历史", link:"city/history!admin.action"},
	{ level:2, name:"城市地图", link:"city/citymap!admin.action"},
	{ level:2, name:"景点、公园"},
	{ level:3, name:"市内", link:"city/tour.action?articleType=dalian"},
	{ level:3, name:"旅顺", link:"city/tour.action?articleType=lvshun"},
	{ level:3, name:"开发区、金石滩", link:"city/tour.action?articleType=devzone"},
	{ level:2, name:"大连美食", link:"city/food.action"},
	{ level:2, name:"大连居住", link:"city/housing.action"},
	{ level:2, name:"大连酒店" },
	{ level:3, name:"酒店文章管理", link:"hotel/hotelarticle.action"},
	{ level:3, name:"酒店参数管理", link:"hotel/hotelparam.action"},
	{ level:3, name:"酒店相册管理", link:"hotel/hotelalbum.action"},
	
	{ level:2, name:"大连购物", link:"city/shopping.action"},
	{ level:2, name:"大连交通", link:"city/transportation.action"},
	{ level:2, name:"大连治疗", link:"city/therapy.action"},
	{ level:2, name:"大连节日", link:"city/festival.action"},
	{ level:2, name:"展会信息", link:"city/exhibition.action"},
	{ level:2, name:"其它信息"},
    { level:3, name:"保险", link:"city/insurance!admin.action"},
    { level:3, name:"法律常识", link:"city/law!admin.action"},
    { level:3, name:"手机信息", link:"city/cellphone!admin.action"},
    { level:3, name:"实用建议", link:"city/advice!admin.action"},
	
	{ level:1, name:"旅游项目"},
	{ level:2, name:"本月推荐行程", link:"program/recommend!admin.action"},
	{ level:2, name:"常规行程", link:"program/regular!admin.action"},
	{ level:2, name:"治疗行程", link:"program/therapy!admin.action"},
	{ level:2, name:"汉语学习行程", link:"program/chineselanguage!admin.action"},
	{ level:2, name:"夏令营行程", link:"program/summercamp!admin.action"},
	{ level:2, name:"温泉游行程", link:"program/hotspring!admin.action"},
	{ level:2, name:"乡村游行程", link:"program/countryside!admin.action"},
	{ level:2, name:"会展、展览", link:"program/exhibition!admin.action"},
	
	{ level:1, name:"特色服务"},
	{ level:2, name:"签证", link:"special/visa!admin.action"},
	{ level:2, name:"各项委托"},
	{ level:3, name:"代订车、船票", link:"special/ticket!admin.action"},
	{ level:3, name:"租车服务", link:"special/carrental!admin.action"},
	{ level:3, name:"翻译服务", link:"special/translation!admin.action"},
	{ level:3, name:"代邮寄纪念品", link:"special/souvenir!admin.action"},
	{ level:2, name:"俄罗斯留学生之家", link:"special/russianstudents!admin.action"},
	
	{ level:1, name:"支付方式"},
	{ level:2, name:"支付方式", link:"payment/payment!admin.action"},
	
	{ level:1, name:"联系我们"},
	{ level:2, name:"客户入口"},
	{ level:3, name:"俄罗斯客户", link:"contact/rugroup!admin.action"},
	{ level:3, name:"中国客户", link:"contact/cngroup!admin.action"},
	{ level:2, name:"游客入口", link:"contact/person!admin.action"},
	
	
	{ level:1, name:"友情链接"},
	{ level:2, name:"友情链接", link:"link/link!admin.action"}

	
	
];
</script>
</@p.tree>
</@p.page>