"use strict";
$(function(){
    $('#save-button').click(function (e) {
        e.preventDefault();
        newReview();
    });
});
function newReview() {
    var headline=$('#headlineReview').val();
    var newReview=$('#new-review').val();
    var rating=$('input[name=rating]:checked').val();
    var movieId =$('#movieId').val();

    $.ajax({
        type: "POST",
        url:"review",
        data:{"headline":headline,"newReview":newReview, "rating":rating, "movieId" : movieId},
        success: function (data) {
            if (data){
                // window.location = data;
                location.reload();

            } else{
                alert("Username or password is wrong");
            }
        }
    })
}