/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*-------------------------------------------
    Sign up
-------------------------------------------*/

$(document).ready(function() {
	$("input#name").focus();
	$("#name-tooltip").show();
	$("input#name").css("-moz-border-radius", "4px 0 0 4px").css("-webkit-border-radius", "4px 0 0 4px").css("border-radius", "4px 0 0 4px");


	function check_mail(str) {
	   return /^[\w\-%~\.+]+@[\w\-\.]+\.[\w]{2,4}$/.test(str);
	}

	$("input:#username").keypress(function (e) {
		if(e.which!=8 && e.which!=95 && e.which!=0 && ((e.which<48 || e.which>57) && (e.which<65 || e.which>90) && (e.which<97 || e.which>122))) {
			return false;
		}
	});


	function tooltip_reset(id) {
		$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
		$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
		$("#"+id+"-tooltip-img").attr("src", site_url+"/img/info_16.png");
		$("#"+id+"-tooltip-text").html($("#"+id+"-tooltip-text").attr("rel"));
	}

	$(".sign-up").focus(function() {
		var id = $(this).attr("id");
		$("#"+id+"-tooltip").show();
		$(this).css("-moz-border-radius", "4px 0 0 4px").css("-webkit-border-radius", "4px 0 0 4px").css("border-radius", "4px 0 0 4px");
	});

	$(".sign-up").blur(function() {
		var id = $(this).attr("id");
		if($(this).val()=="") {
			$("#"+id+"-tooltip").hide();
			$(this).css("-moz-border-radius", "4px").css("-webkit-border-radius", "4px").css("border-radius", "4px");

			tooltip_reset(id);

			if(id=="password") {
				if($(this).val()!=$("#password2").val() && $("#password2").val()!="") {
					$("#password2-tooltip").removeClass("sign-up-tooltip-valid");
					$("#password2-tooltip").addClass("sign-up-tooltip-invalid");
					$("#password2-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#password2-tooltip-text").html("passwords do not match");
				}
			}
		}
		else {
			if(id=="name") {
				$("#"+id+"-tooltip").addClass("sign-up-tooltip-valid");
				$("#"+id+"-tooltip-img").attr("src", site_url+"/img/tick_16.png");
				$("#"+id+"-tooltip-text").html("ok");
			}
			else if(id=="username") {
				if($(this).val().length>3) {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/loading_16.gif");
					$("#"+id+"-tooltip-text").html("checking availability");
					$.post(site_url+"/public-scripts/check-username",
						{ value: $(this).val() },
							function(data){
								if(data=="0") {
									$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
									$("#"+id+"-tooltip").addClass("sign-up-tooltip-valid");
									$("#"+id+"-tooltip-img").attr("src", site_url+"/img/tick_16.png");
									$("#"+id+"-tooltip-text").html("ok");
								}
								else if(data=="2") {
									$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
									$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
									$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
									$("#"+id+"-tooltip-text").html("only use letters, numbers and \'_\'");
								}
								else {
									$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
									$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
									$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
									$("#"+id+"-tooltip-text").html("sorry, username taken");
								}
							}
					);


				}
				else {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#"+id+"-tooltip-text").html("too short");
				}

			}
			else if(id=="email") {

				if(check_mail($(this).val())) {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/loading_16.gif");
					$("#"+id+"-tooltip-text").html("checking availability");
					$.post(site_url+"/public-scripts/check-email",
						{ value: $(this).val() },
						function(data){
							if(data=="0") {
								$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
								$("#"+id+"-tooltip").addClass("sign-up-tooltip-valid");
								$("#"+id+"-tooltip-img").attr("src", site_url+"/img/tick_16.png");
								$("#"+id+"-tooltip-text").html("ok");
							}
							else {
								$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
								$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
								$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
								$("#"+id+"-tooltip-text").html("you are already a member");
							}
						}
					);
				}
				else {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#"+id+"-tooltip-text").html("enter a valid email address");
				}
			}
			else if(id=="password") {
				if($(this).val().length>5) {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/tick_16.png");
					$("#"+id+"-tooltip-text").html("ok");
				}
				else {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#"+id+"-tooltip-text").html("too short");
				}
				if($(this).val()!=$("#password2").val() && $("#password2").val()!="") {
					$("#password2-tooltip").removeClass("sign-up-tooltip-valid");
					$("#password2-tooltip").addClass("sign-up-tooltip-invalid");
					$("#password2-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#password2-tooltip-text").html("passwords do not match");
				}
				else if($(this).val()==$("#password2").val() && $(this).val().length>5) {
					$("#password2-tooltip").removeClass("sign-up-tooltip-invalid");
					$("#password2-tooltip").addClass("sign-up-tooltip-valid");
					$("#password2-tooltip-img").attr("src", site_url+"/img/tick_16.png");
					$("#password2-tooltip-text").html("ok");
				}
			}
			else if(id=="password2") {
				if($(this).val()==$("#password").val() && $(this).val().length>5) {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/tick_16.png");
					$("#"+id+"-tooltip-text").html("ok");
				}
				else {
					$("#"+id+"-tooltip").removeClass("sign-up-tooltip-valid");
					$("#"+id+"-tooltip").addClass("sign-up-tooltip-invalid");
					$("#"+id+"-tooltip-img").attr("src", site_url+"/img/block_16.png");
					$("#"+id+"-tooltip-text").html("passwords do not match");
				}

			}

		}
	});

	$(".facebook-signin-button").click(function() {
		$("#facebook-signin").trigger('click');
	});
});