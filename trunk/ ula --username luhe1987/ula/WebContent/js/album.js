// init at first
$(function() {
	$(".album").album();
	
});

// JQuery plugin
//
//
(function($) {
	$.fn.album = function(options) {
		var defaults = {
			width    : "738px",
			height   : "470px",
			leftBtn  : "leftBtn",
			rightBtn : "rightBtn"
		}
		var options = $.extend(defaults, options);
		
		//set css
		this.css({
			width    : "738px",
			height   : "470px",
			overflow : "hidden"
		})
		//create banner
		var banner = new Banner($(this));
		
		
		
		this.hover(function() {
			$(this).css({
				backgroundColor : "rgba(0,0,0,0.8)",
				backgroundImage : "url('images/bg.png')"
			})
			banner.show();
		},function() {
			$(this).css({
				backgroundColor : "",
				backgroundImage : ""
			});
			banner.hide();
		})
		//create inner frame
		var inner = $("<div class='inner' />")
		var innerWidth = this.find("div").size() * 738;
		
		inner.css({
			width    : innerWidth,
			height   : "470px"
		});
		this.wrapInner(inner);
		
		//create new div
		var divs = this.find("div>div");
		divs.css({
			width : "738px",
			float : "left"
		})
		
		
			};
})(jQuery);

//create new banner
function Banner(element) {
	
	
	this.banner = $("<ul id='albumBanner'></ul>").css({
		width    : "30px",
		height   : "105px",
		position : "absolute",
		left     : element.position().left + element.width()  - 30,
		top      : element.position().top  + element.height() - 285,
		display  : "none"
	})
	
	var leftBtn  = $("<li><img src='images/left.png' /></li>")
					.bind("click",function(){
						if(!element.find(".inner").is(":animated")){
							if(parseInt(element.find(".inner").css("marginLeft")) == 0){
								element.find(".inner").animate({
									"margin-left": "-" + (parseInt($(".inner").width()) - 738)
								})
							}else{
								element.find(".inner").animate({
									"margin-left":"+=738px"
								})	
							}
						}
					});
					
	var rightBtn = $("<li><img src='images/right.png' /></li>")
					.bind("click",function() {
						if(!element.find(".inner").is(":animated")){
							if(parseInt(element.find(".inner").css("marginLeft")) == "-" + (parseInt($(".inner").width()) - 738)){
								element.find(".inner").animate({
									"margin-left": 0
								})
							}else{
								element.find(".inner").animate({
									"margin-left":"-=738px"
								})	
							}
						}
					});
					
	var fullBtn  = $("<li><img src='images/full.png' /></li>")
					.css({
						marginTop : "180px"
					})
					.bind("click",function() {
						var index = - parseInt(element.find(".inner").css("marginLeft"))/738
						var full = new Full(element)
						full.show(index);
					});
	
	this.banner.append(rightBtn,leftBtn,fullBtn);
	this.banner.find("li").css({
		cursor  : "pointer",
		display : "block",
		height  : "35px",
		width   : "30px"
	})
	this.banner.appendTo(element);
	
	this.show = function() {
		this.banner.show();
	}
	this.hide = function() {
		this.banner.hide();
	}
}
//banner end

//full screen
function Full(element){

	var imgs = element.find("img").not("#albumBanner img").clone();

	var bg = $("<div />").css({
		width   		: $(document.body).outerWidth(),
		height  		: $(document.body).outerHeight(),
		backgroundColor : "rgba(0,0,0,0.8)",
		backgroundImage : "url('images/bg.png')",
		position        : "absolute",
		left			: "0",
		top				: "0",
		display			: "none",
		zIndex			: "99999"
	});
	
	var frame = $("<div />").css({
		position 	: "absolute",
		left		: $(window).width()/2,
		top			: $(window).height()/2,
		"margin-left"	: - 300,
		"margin-top"	: - 225
	}).appendTo(bg);
	
	
	var leftBtn  = $("<li><img src='images/left.png' /></li>")
					.bind("click",function(){
						var index = imgs.index(frame.find("img"));
						if(index == 0) return;
						frame.html("").append(imgs[--index]);
					}).css({
						position : "absolute",
						left	 : $(document.body).outerWidth() - 200,
						top		 : 40,
						cursor	 : "pointer"
					}).appendTo(bg);
					
	var rightBtn = $("<li><img src='images/right.png' /></li>")
					.bind("click",function() {
						var index = imgs.index(frame.find("img"));
						if(index == imgs.size()-1) return;
						frame.html("").append(imgs[++index]);
					})
					.css({
						position : "absolute",
						left	 : $(document.body).outerWidth() - 150,
						top		 : 40,
						cursor	 : "pointer"
					}).appendTo(bg);
	var miniBtn  =  $("<li><img src='images/mini.png' /></li>")
					.bind("click",function() {
						bg.fadeOut(300,function() {
							bg.remove();
							$(window).unbind(winresize);
							$(window).unbind(winkey);
						})
					})
					.css({
						position : "absolute",
						left	 : $(document.body).outerWidth() - 100,
						top		 : 40,
						cursor	 : "pointer"
					})
					.appendTo(bg);
					
	this.show = function(index) {
		frame.append(imgs[index]);
		bg.appendTo(document.body);
		bg.fadeIn(300);
	}
	this.hide = function() {
		bg.remove();
	}
	
	var winresize = $(window).resize(function() {
		frame.css({
			left		: $(window).width()/2,
			top			: $(window).height()/2
		})
	});
	var winkey	  = $(window).keyup(function(e) {
		var index = imgs.index(frame.find("img"));
		if(e.keyCode == 37){
			if(index == 0) return;
			frame.html("").append(imgs[--index]);
		}else if (e.keyCode == 39) {
			if(index == imgs.size()-1) return;
			frame.html("").append(imgs[++index]);
		}
	})
	
}