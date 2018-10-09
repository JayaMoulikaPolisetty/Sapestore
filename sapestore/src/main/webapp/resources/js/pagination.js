$(document).ready(function(){
			let noOfRows = $(".gallery > .row").length;
			let paginationHTML = '<a href="javascript:void(0)" class="page-prev hide">&lt;</a>';
			paginationHTML += '<a href="javascript:void(0)" class="active">1</a>';
			if(noOfRows>3){
				$(".gallery > .row").hide();
				let count = Math.ceil(noOfRows/3);
				for(let i=2;i<=count;i++){
					if(i<5){
						paginationHTML += '<a href="javascript:void(0)">'+i+'</a>';	
					}else{
						paginationHTML += '<a href="javascript:void(0)" class="hide">'+i+'</a>';
					}					
				}
				for(let i=0;i<3;i++){
					$($(".gallery > .row")[i]).show();
				}
				paginationHTML += '<a href="javascript:void(0)" class="page-next">&gt;</a>';
				$('.pagination').html(paginationHTML);
				$('.pagination > a').click(function(){
					$(".gallery > .row").hide();
					let currentPage=$.trim($(this).html());
					if($(this).hasClass('page-next')){
						currentPage = Number($.trim($(this).parent().find('.active').html()));
					}else if($(this).hasClass('page-prev')){
						currentPage = Number($.trim($(this).parent().find('.active').html())-2);
					}else{
						currentPage--;
					}
					for(let i=currentPage*3;(i<noOfRows && i<(currentPage+1)*3);i++){
						$($(".gallery > .row")[i]).show();
					}
					console.log(currentPage);
					$(".pagination > a.active").removeClass('active');
					$(".pagination > a").each(function(){						
						if(Number($.trim($(this).html())) == Number(currentPage+1)){
							$(this).addClass('active');
						}
					});
					if(currentPage == 0){
						$('.page-next').removeClass('hide');
						$('.page-prev').addClass('hide');
					}
					if(currentPage == count-1){
						$('.page-next').addClass('hide');
						$('.page-prev').removeClass('hide');
					}
				});
			}
		});