jQuery(document).ready(function($){
    //creat products
    for (var i = 1; i < 7; i++) {
        var imgName = "product-"+i;
        var productName = i;
        var oldPrice = i+1;
        var newPrice = i;
        $('.product-carousel').append("<div class='single-product'><div class='product-f-image'><img src='img/"+imgName+".jpg' alt=''><div class='product-hover'><a href='#' class='add-to-cart-link'><i class='fa fa-shopping-cart'></i> Add to cart</a><a href='single-product.html' class='view-details-link'><i class='fa fa-link'></i> See details</a></div></div><h2><a href='single-product.html'>"+productName+"</a></h2><div class='product-carousel-price'><ins>$"+newPrice+"</ins> <del>$"+oldPrice+"</del></div></div>");

    };
   
    // jQuery sticky Menu
    
	$(".mainmenu-area").sticky({topSpacing:0});
    
    
    $('.product-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:5,
            }
        }
    });  
    
    $('.related-products-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:2,
            },
            1000:{
                items:2,
            },
            1200:{
                items:3,
            }
        }
    });  
    
    $('.brand-list').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:4,
            }
        }
    });    
    
    
    // Bootstrap Mobile Menu fix
    $(".navbar-nav li a").click(function(){
        $(".navbar-collapse").removeClass('in');
    });    
    
    // jQuery Scroll effect
    $('.navbar-nav li a, .scroll-to-up').bind('click', function(event) {
        var $anchor = $(this);
        var headerH = $('.header-area').outerHeight();
        $('html, body').stop().animate({
            scrollTop : $($anchor.attr('href')).offset().top - headerH + "px"
        }, 1200, 'easeInOutExpo');

        event.preventDefault();
    });    
    
    // Bootstrap ScrollPSY
    $('body').scrollspy({ 
        target: '.navbar-collapse',
        offset: 95
    })      
});

