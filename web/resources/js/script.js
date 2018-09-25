$(function () {
    $("#searchButton").click(function () {
        let movieValue = $("#movieInput").val();
        console.log(movieValue);
        getInfo(movieValue);
    });

    $('.card-text').ellipsis({
        lines: 3,
        ellipClass: 'ellip',
        responsive: true
    });
    
    $("#watchlist").click(function (e) {
       if($(this).hasClass("added"))
       {

           $.ajax({
               url : "/watchlist",
               data :  {
                   movieId : $("#movieId").val(),
                   add: false
               },
               type : "POST",
               success : function (data) {
                   console.log(data);
                   $(this).html("Add to WatchList <i class=\"fa fa-check-circle-o\" aria-hidden=\"true\"></i>");
                   $(this).removeClass("added").addClass("not_added");
               }
           });
       }
       else {
           $.ajax({
               url : "/watchlist",
               data :  {
                   movieId : $("#movieId").val(),
                   add: true
               },
               type : "POST",
               success : function (data) {
                   console.log(data);
                   $(this).html("Added WatchList <i class=\"fa fa-check-circle\" aria-hidden=\"true\"></i>");
                   $(this).removeClass("not_added").addClass("added");
               }
           });
       }
    });
})

function getInfo(movieValue){
    getMovieInfo(movieValue)
}

function getMovieInfo(movieValue){
    $.ajax({
        url:"https://api.themoviedb.org/3/search/movie?api_key=132df4c1e5f3c8f5022c2e5a94fedce4&query="+movieValue,
        success:function(data){

            renderSearchResult(data);

            $('.portfolio-item .card-text').ellipsis({
                lines: 4,
                ellipClass: 'ellip',
                responsive: true
            });
        },

        error:function(){
            alert("Not Found");
        }
    })
}
function renderSearchResult(data)
{
    let imgPrefix = "https://image.tmdb.org/t/p/w500/";
    var target = $("#searchResult");
    target.empty();
    var html = "";
    for(let i=0;i<data.results.length;i++) {

        html += ' <div class="col-lg-4 col-sm-6 portfolio-item">' +
            '<div class="card h-100">\n' +
            '                <a href="/movie?id='+data.results[i].id+'" target="_blank"><img class="card-img-top" alt="" src="' + imgPrefix + data.results[i].poster_path + '"></a>\n' +
            '                <div class="card-body">\n' +
            '                    <h4 class="card-title">\n' +
            '                        <a href="/movie?id='+data.results[i].id+'" target="_blank">'+ data.results[i].title + '</a>\n' +
            '                    </h4>\n' +
            '                    <p class="card-text">'+ data.results[i].overview +'<p>\n' +
            '                </div>\n' +
            '            </div> </div>';

    }

    target.append(html);
}