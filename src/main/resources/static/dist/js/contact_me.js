$(function() {

    $("input,textarea").jqBootstrapValidation({
        preventSubmit: true,
        submitError: function($form, event, errors) {
            // additional error messages or events
        },
        submitSuccess: function($form, event) {
            event.preventDefault(); // prevent default submit behaviour
            // get values from FORM
            var params = getParams();
    		doSave(params);
           
          
        },
        filter: function() {
            return $(this).is(":visible");
        },
    });

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });
    
    
    $("input#account").blur(function(){
		 var username=$("input#account").val();
		 
        $.ajax({
      	  
             url: "/user/checkName", // 默认当前地址,发送请求的地址
               data: { username: username}, // 发送到服务器的数据
				type: "post",
				dataType: "json",
               success: function(data) {
              	 var msg = data.name;
              	var msg1 = $("input#account").val().length;
              	
              	console.log(msg1)
              
              	if(msg==username){
                  $("div.form-group #span").html("用户名已存在");
                  $("div.form-group #span").css("color",'red');
                
              	}else if(msg1==0) {
              		
                  	$("div.form-group #span").html("须填写用户名");
                  	$("div.form-group #span").css("color",'red');
                  }else {
                		$("div.form-group #span").html("用户名可使用");
                      	$("div.form-group #span").css("color",'green');
                  }
               
               }
              
               
           });
   });
    
    
    
});
function doSave(params){
	var url = "/user/doSaveUser";
	//debugger
 	 $.getJSON(url,params,function(status){
		if(status.state==1){
			alert(status.message)
//			 Success message
              $('#success').html("<div class='alert alert-success'>");
              $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                  .append("</button>");
              $('#success > .alert-success')
                  .append("<strong>Your message has been sent. </strong>");
              $('#success > .alert-success')
                  .append('</div>');

              //clear all fields
              $('#contactForm').trigger("reset");
              $("div.form-group #span").html("");
          }
		
		if(status.state==0){
			alert(status.message)
	//		 Fail message
              $('#success').html("<div class='alert alert-danger'>");
              $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                  .append("</button>");
              $('#success > .alert-danger').append("<strong>Sorry " +params.username+ ", it seems that your account has been registered. Please try again later!");
              $('#success > .alert-danger').append('</div>');
              //clear all fields
              $('#contactForm').trigger("reset");
              $("div.form-group #span").html("");
          }
			
	
		
	})  
	
//	debugger
//	  $.ajax({
//          url: "/user/doSaveUser",
//          type: "POST",
//          data: {
//              params: params,
//              
//             
//          },
//          cache: false,
//          success: function() {
//              // Success message
//              $('#success').html("<div class='alert alert-success'>");
//              $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
//                  .append("</button>");
//              $('#success > .alert-success')
//                  .append("<strong>Your message has been sent. </strong>");
//              $('#success > .alert-success')
//                  .append('</div>');
//
//              //clear all fields
//              $('#contactForm').trigger("reset");
//          },
//          error: function() {
//              // Fail message
//              $('#success').html("<div class='alert alert-danger'>");
//              $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
//                  .append("</button>");
//              $('#success > .alert-danger').append("<strong>Sorry " + firstName + ", it seems that my mail server is not responding. Please try again later!");
//              $('#success > .alert-danger').append('</div>');
//              //clear all fields
//              $('#contactForm').trigger("reset");
//          },
//      })
//	var url = "/user/doSaveUser";
// 	 $.getJSON(url,params,function(status){
//		if(status.state==1){
//			toastr.success('注册成功');
//			setTimeout(function(){ 
//				window.open('loginpage','_self');
//			}, 1000);
//		}
//		if(status.state==0){
//			alert(status.message)
//		}
//			
//	})  
	
}

function getParams(){
var username = $("input#account").val();
var password = $("input#password").val();
var mobile = $("input#mobile").val();
var email = $("input#email").val();

var params = {
		"username" : username,
		"password" : password,
		"mobile" : mobile,
		"email" : email
};
return params;
}

/*When clicking on Full hide fail/success boxes */
$('#name').focus(function() {
    $('#success').html('');
});
