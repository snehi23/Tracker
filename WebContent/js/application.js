$(document).ready(function() {
    $('.carousel-control').on('click', function(event) {
      event.preventDefault();
      // Act on the event
    });
    $("#carousel-example-generic").carousel('cycle');
    $("#carousel-example-generic").touchwipe({
         wipeLeft: function() {
            console.log("swipeleft");
            $("#carousel-example-generic").carousel('next');
         },
         wipeRight: function() { console.log("swipe right");
            $("#carousel-example-generic").carousel('prev');
         },
         min_move_x: 20,
         min_move_y: 20,
         preventDefaultEvents: false
    });
    // $.getJSON("https://api.twitter.com/1/statuses/user_timeline/cognitiveclouds.json?count=1&include_rts=1&callback=?", function(data) {
    //  var result = data[0].text.replace(/(\b(https?|ftp|file):\/\/[\-A-Z0-9+&@#\/%?=~_|!:,.;]*[\-A-Z0-9+&@#\/%=~_|])/img, '<a target="_blank" href="$1">$1</a>');
    //  $("#tweat").html(result);
    // });
    $(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );
    if ($('.expertise').get(0)) {
        var hash = window.location.hash;
        var selector = 'a[href="'+hash+'"]';
        console.log($(selector));
        $(selector).trigger('click');
        $(window).resize(function(event) {
            var width = Math.floor($(window).width()/290)*290;
            $('#da-thumbs').width(width);
        });
        $(window).resize();
    }
    if ($('.contact').get(0)) {
        var hash = window.location.hash;
        if (hash == "#sucess") {
            $('.sucess').show();
            window.location.hash = '';
        }
    }
    // $('#contact-us-form').formValidate();
});
