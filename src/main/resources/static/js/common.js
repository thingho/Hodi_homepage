
function next(area){
	$(area).css("left","-100%");
	$(area).append($(area).find("div:first"));
	$(area).animate(
		{
			"left":"0"
		},
		400,
		"easeOutExpo",
		function(){
			//alert("finish");
			$(area).css("left","0px");
		}
	);
}

function prev(area){
	$(area).css("left","0");
	$(area).animate(
		{
			"left":"-100%"
		},
		400,
		"easeOutExpo",
		function(){
			$(area).css("left","0");
			$(area).prepend($(area).find("div:last"));
		}
	);
}

$(document).ready(function() {
	var $html = $('html'),
		$body = $('body'),
        $overlay = $('.overlay'),
        $navContainer = $('.navContainer'),
        $navigation = $('.navigation'),
		$navImg = $('.navImg'), timeout,
		gotoTop;


	$navigation.hover(function() {
		// console.log(arguments);
		if (window.innerWidth <= 820) {
			return;
		}
		if (timeout) {
			clearTimeout(timeout);
			timeout = null;
		}
		$navContainer.stop().animate({'max-height': '400px'},500);

	}, function() {
		if (window.innerWidth <= 820) {
			return;
		}
		$navContainer.stop().animate({'max-height': '0'},500);
	});


	/*
	var togglecount = 0;
	var toggleattr;
	var dep_height ;
	$(".cur").click(function(){
		var obj = $(this).parents("li").children("ul");
		toggleattr = $(obj).attr('id');
		dep_height =  $(this).next().height();
		if(toggleattr == "toggle-show"){
			$(this).parents("li").children("ul").stop(true).animate({'height': 0}, 300, function() {
				$(this).css({'display': 'none'});	
				$(this).css({'height': dep_height});	
			});
			toggleattr = $(obj).attr('id','toggle-hide');		
		}else{
			$(obj).stop(true).css({'display': 'block', 'height': 0}).animate({'height': dep_height}, 300);
			toggleattr = $(obj).attr('id','toggle-show');			
		}

	});
	*/


		$(".left_slide").click(
			function(){
				if($(".img_area").is(":animated") == false){
					var div = $(this).parent().find('div:eq(0)').find('div:eq(0)');
					prev(div);
				}
			}
		);

		$(".right_slide").click(
			function(){
				/*
						$().is("상태값") : 상태값을 확인해서 true / false로 알려줌.
						대표적으로 사용되는 경우는 :checked / :animated 가 있다.
				*/
				if($(".img_area").is(":animated") == false){
					var div = $(this).parent().find('div:eq(0)').find('div:eq(0)');
					next(div);
				}
			}
		);


	$('.inlineMenu>ul>li').click(function() {
		if (this.className.indexOf('active') !== -1) {
			return;
		}
		var id;
		$('.inlineMenu>ul>li.active').removeClass('active');
		id = $(this).addClass('active').attr('data-id');


		$('.tabs>.active').removeClass('active');
		$('#' + id).addClass('active');
		$(window).resize();
	});



	if ( getCookie( "Notice1" ) != "done" ) { 
		$('#layer1').fadeIn();
	}
	if ( getCookie( "Notice" ) != "done" ) { 
		$('#layer2').fadeIn();
	}
    $(".pop-layer").draggable();
	/*
	('a.btn-layerClose').click(function(){
		$('.pop-layer').fadeOut();
		return false;
	});

	$('.iClose').click(function(){
		$('.pop-layer').fadeOut();
		return false;
	});
	
	$('.tClose').click(function(){
		setCookie( "Notice", "done" , 1);//1은 하루동안 새창을 열지 않게 합니다. 
		$('.pop-layer').fadeOut();
		return false;
	});
	*/


});
function closePop(target){
	$('#'+target).fadeOut();
}
function closePopT(eve,target){
	setCookie( eve, "done" , 1);//1은 하루동안 새창을 열지 않게 합니다. 
	$('#'+target).fadeOut();
	
}
function getCookie( name ){ 
	var nameOfCookie = name + "="; 
	var x = 0; 
	while ( x <= document.cookie.length ) 
	{ 
	var y = (x+nameOfCookie.length); 
	if ( document.cookie.substring( x, y ) == nameOfCookie ) { 
	if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) 
	endOfCookie = document.cookie.length; 
	return unescape( document.cookie.substring( y, endOfCookie ) ); 
	} 
	x = document.cookie.indexOf( " ", x ) + 1; 
	if ( x == 0 ) 
	break; 
	} 
	return ""; 
}
function setCookie( name, value, expiredays ) 
{ 
	var todayDate = new Date(); 
	todayDate.setDate( todayDate.getDate() + expiredays ); 
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
} 