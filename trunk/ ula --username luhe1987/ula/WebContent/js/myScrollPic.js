/*

var scrollPic_02 = new ScrollPic();
		scrollPic_02.scrollContId   = "banner_ad"; //内容容器ID
		scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
		scrollPic_02.arrRightId     = "RightArr"; //右箭头ID

		scrollPic_02.frameWidth     = 764;//显示框宽度
		scrollPic_02.pageWidth      = 191; //翻页宽度

		scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
//		scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
		scrollPic_02.autoPlay       = true; //自动播放
		scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)

		scrollPic_02.initialize(); //初始化
		
*/

var ScrollPic = new Class ({
	Initialize: function(){
		var scrollContId   = this.scrollContId;
		var frameWidth     = this.frameWidth;//显示框宽度
		var pageWidth      = this.pageWidth; //翻页宽度
		var speed          = this.speed; //移动速度(单位毫秒，越小越快)
		var autoPlay       = this.autoPlay; //自动播放
		var autoPlayTime   = this.autoPlayTime; //自动播放间隔时间(秒)
		
		//验证属性有效
		if(scrollContId == undefined){
			alert();
			}
		//... 验证结束
		
		//
		$(scrollContId).setStyle("overflow","hidden");
		
		var myDiv = new Element("div",{
			styles :{
				height : "100%",
				width  : frameWidth + pageWidth + 100,
			}
		});
		
		var mLeft = $(scrollContId).getElement("li:last-child").getStyle("margin-left");
		$(scrollContId).clone().inject(myDiv,'top');
		$(scrollContId).set("html","");
				
		myDiv.inject($(scrollContId),"top");
		
		setInterval(function(){
			$(scrollContId).getElement("li:first-child").inject($(scrollContId).getElement("ul"),"bottom");
			$(scrollContId).getElement("li:last-child").setStyle("margin-left",mLeft);
			
			var first = $(scrollContId).getElement("li:first-child");
			var myFx = new Fx.Tween( first );		
			myFx.start("margin-left","-"+pageWidth);	
		}, speed * 1000)
	}
})