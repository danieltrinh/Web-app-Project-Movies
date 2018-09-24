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

})

function getInfo(movieValue){
    getMovieInfo(movieValue)
}

function getMovieInfo(movieValue){
    $.ajax({
        url:"https://api.themoviedb.org/3/search/movie?api_key=132df4c1e5f3c8f5022c2e5a94fedce4&query="+movieValue,
        success:function(data){
            // showMovePic(data);
            // showMoveTitle(data);
            // showMoveText(data);
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
//
// function showMovePic(data){
//
//     let imgPrefix = "https://image.tmdb.org/t/p/w500/";
//     for(let i=0;i<data.results.length;i++) {
//         $($(".card-img-top")[i]).attr("src", imgPrefix + data.results[i].poster_path);
//     }
// }
//
// function showMoveTitle(data){
//     for(let i=0;i<data.results.length;i++) {
//         $($(".card-title")[i]).text(data.results[i].title);
//     }
// }
//
// function showMoveText(data){
//     for(let i=0;i<data.results.length;i++) {
//         $($(".card-text")[i]).text(data.results[i].overview);
//     }
// }

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