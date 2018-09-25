"use strict";
$(function() {

    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});
$(function(){
    $('#login-submit').click(login);
});
function login() {
    var user=$('#username').val();
    var pwd=$('#password').val();
    var rmb=$('#remember').val();

    $.ajax({
            type: "POST",
            url:"login",
            data:{"username":user,"password":pwd, "remember":rmb},
            success: function (data) {
                if (data){
                    window.location = data;
                } else{
                    alert("Username or password is wrong");
                }
            }
        })
    }

$(function(){
    $('#register-submit').click(register);
});
function register() {
    var user=$('#usernameReg').val();
    var pwd=$('#passwordReg').val();
    var address=$('#address').val();
    var fullname=$('#fullName').val();
    var telephone=$('#telephone').val();

    $.ajax({
        type: "POST",
        url:"register",
        data:{"username":user,"password":pwd, "address":address,"fullName" : fullname, "telephone": telephone},
        success: function (data) {
          
                window.location = data;

        },
        fail: function () {
            alert("Register fail,check your information again");
        }
    })
}
$(function(){
    $('#confirm-password').focusout(test);
    $('#passwordReg').focusout(test);

});

function test(){
    var test1 = $('#passwordReg').val();
    var test2 = $('#confirm-password').val();
    var test3 = $('#passwordReg').val() != $('#confirm_password').val();
    var test4 = $('#confirm-password').val() != "";
    if ($('#passwordReg').val() != $('#confirm-password').val() && $('#confirm-password').val() != "") {
        alert("Password is not match");
    }
}