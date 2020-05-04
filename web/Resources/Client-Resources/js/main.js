function getAboutMeC() {
    $.ajax({
        url: "ic?action=getInfoFClient",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#about-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllEduExpC(type) {
    const data = {
        type: type
    };
    $.ajax({
        url: "eec?action=getEduExpListFC",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            if (type == 2) {
                $("#experience").html(response);
            } else {
                $("#education").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllPostsC(postType) {
    {
        const data = {
            postType: postType
        };
        $.ajax({
            url: "pc?action=getPostsListCPrev",
            type: "GET",
            dataType: "html",
            data: data,
            success: function (response) {
                if (postType == 1) {
                    $("#blogsPrev").html(response);
                    getCategories();
                } else if (postType == 2) {
                    $("#newsPrev").html(response);
                } else if (postType == 3) {
                    $("#portfolioPrev").html(response);
                }
            },
            error: function () {
                alert("Error")
            }
        });
    }
}

function addMessage() {
    var context = $("#mContext").val();
    var email = $("#mEmail").val();
    var phone = $("#mPhone").val();
    var username = $("#mUsername").val();

    var data = {
        context: context,
        email: email,
        phone: phone,
        username: username,
    };

    $.ajax({
        url: "mc?action=addMessage",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                alert("Mesajınız göndərildi.\nQısa müddət ərzində cavablandırılacaqdır.");
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}

function getEduExpById(type, id, opp) {
    var data = {
        id: id,
        opp: opp,
        type: type
    };
    $.ajax({
        url: "eec?action=getEduExpById",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            if (opp == "view") {
                $("#aboutEduExpModal").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}

function getCategories() {
    $.ajax({
        url: "cc?action=getCategoriesFC",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#breadCategories").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getPostsByCatId(catId, postType) {
    var data = {
        catId: catId,
        postType: postType
    };
    $.ajax({
        url: "pc?action=getPostByIdCBread",
        type: "POST",
        dataType: "html",
        data: data,
        success: function (response) {
            $("#posts").fadeOut();
            $("#fromCatPosts").html(response).fadeIn();
        },
        error: function () {
            alert("Error")
        }
    });
}

function allPosts() {
    $("#fromCatPosts").fadeOut();
    $("#posts").fadeIn();
}

$(function () {
    getAboutMeC();
    getAllEduExpC(1);
    getAllEduExpC(2);
    getAllPostsC(1);
    getAllPostsC(2);
    getAllPostsC(3);
});