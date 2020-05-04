//***************************************************
//----------------------GLOBALS----------------------
//***************************************************
var globType;


//***************************************************
//-----------------------UTILS-----------------------
//***************************************************
function closeModal() {
    $(".show").removeClass("show");
    $(".fade").removeClass("fade");
    $(".modal-backdrop").removeClass("modal-backdrop");
    $("body").removeClass("modal-open");
    $("body").css("padding", "0");
}


//***************************************************
//----------------------GET ALL----------------------
//***************************************************
function getAboutMe() {
    $.ajax({
        url: "ic?action=getInfo",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllContacts() {
    $.ajax({
        url: "sc?action=getSocialList",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllEduExp(type) {
    const data = {
        type: type
    };
    $.ajax({
        url: "eec?action=getEduExpList",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllPosts(postType) {
    const data = {
        postType: postType
    };
    $.ajax({
        url: "pc?action=getPostsList",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getAllCategories() {
    $.ajax({
        url: "cc?action=getAllCategories",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getCategoriesForAddPost() {
    $.ajax({
        url: "cc?action=getAllCategoriesForAddPost",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#addPostBody").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

function getMessages() {
    $.ajax({
        url: "mc?action=getMessages",
        type: "GET",
        dataType: "html",
        success: function (response) {
            $("#main-wrapper").html(response);
        },
        error: function () {
            alert("Error")
        }
    });
}

//***************************************************
//---------------------GET BY ID---------------------
//***************************************************
function getContactById(id, opp) {
    const data = {
        id: id,
        opp: opp,
    };
    $.ajax({
        url: "sc?action=getSocialById",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            if (opp == "upd") {
                $("#updSocModalBody").html(response);
            } else if (opp == "del") {
                $("#delSocModalBody").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}

function getEduExpById(type, id, opp) {
    globType = type;
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
            if (opp == "del") {
                $("#delEduExpModalBody").html(response);
            } else if (opp == "upd") {
                $("#updEduExpModalBody").html(response);
            }
            else if (opp == "view") {
                $("#aboutEduExpModal").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}

function getPostById(postType, id, opp) {
    globType = postType;
    var data = {
        id: id,
        opp: opp,
        postType: postType
    };
    $.ajax({
        url: "pc?action=getPostById",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            if (opp == "del") {
                $("#delPostModalBody").html(response);
            } else if (opp == "upd") {
                $("#updPostModalBody").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}

function getFileById(fileId, opp) {
    var data = {
        fileId: fileId,
        opp: opp
    };
    $.ajax({
        url: "fc?action=getFileById",
        type: "GET",
        dataType: "html",
        data: data,
        success: function (response) {
            if (opp == "upd") {
                $("#updateFileModalBody").html(response);
            } else if (opp == "del") {
                $("#deleteFileModalBody").html(response);
            }
        },
        error: function () {
            alert("Error")
        }
    });
}


//***************************************************
//------------------------ADD------------------------
//***************************************************
function addContact() {
    var socName = $("#socName").val();
    var link = $("#link").val();
    var icon = $("#icon").val();
    var place = $("#place").val();
    var accName = $("#accName").val();

    var data = {
        socName: socName,
        link: link,
        icon: icon,
        place: place,
        accName: accName,
    };
    $.ajax({
        url: "sc?action=addSocial",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#addModal").hide();
                closeModal();
                alert("Sosial şəbəkə əlavə edildi.");
                getAllContacts();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}

function addEduExp(type) {
    var place = $("#place").val();
    var prof = $("#profession").val();
    var years = $("#years").val();
    var queue = $("#queue").val();
    var aboutEduExp = $("#aboutEduExpTxt").val();

    var data = {
        place: place,
        prof: prof,
        years: years,
        queue: queue,
        type: type,
        aboutEduExp: aboutEduExp
    };
    $.ajax({
        url: "eec?action=addEduExp",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#addModal").hide();
                closeModal();
                alert("Məlumat əlavə edildi.");
                getAllEduExp(type)
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function addCategorie() {
    var catName = $("#newCat").val();
    var data = {
        catName: catName,
    };
    $.ajax({
        url: "cc?action=addCategorie",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                alert("Kateqoriya əlavə edildi.");
                getAllCategories();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}

//***************************************************
//-----------------------UPDATE----------------------
//***************************************************
function updateAbout() {
    var about = $("#about").val();

    var data = {
        about: about,
    };
    $.ajax({
        url: "ic?action=updateInfo",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                closeModal();
                alert("Məlumatda dəyişiklik edildi !!! ");
                getAboutMe();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}

function updateEduExp(id) {
    var place = $("#updPlace").val();
    var prof = $("#updProfession").val();
    var years = $("#updYears").val();
    var queue = $("#updQueue").val();
    var aboutEduExp = $("#updAboutEduExpTxt").val();

    var data = {
        id: id,
        place: place,
        prof: prof,
        years: years,
        queue: queue,
        type: globType,
        aboutEduExp:aboutEduExp
    };
    $.ajax({
        url: "eec?action=updateEduExp",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#editModal").hide();
                closeModal();
                alert("Məlumat dəyişdirildi.");
                getAllEduExp(globType)
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function updateSocial(id) {
    var socName = $("#updSocName").val();
    var accName = $("#updAccName").val();
    var link = $("#updLink").val();
    var icon = $("#updIcon").val();
    var place = $("#updPlace").val();

    var data = {
        id: id,
        socName: socName,
        accName: accName,
        link: link,
        icon: icon,
        place: place
    };
    $.ajax({
        url: "sc?action=updateSocial",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#editModal").hide();
                closeModal();
                alert("Məlumat dəyişdirildi.");
                getAllContacts();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function updateCategorie(id) {
    var catName = $("#cn-" + id).val();
    var data = {
        id: id,
        catName: catName
    };
    $.ajax({
        url: "cc?action=updCategorie",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                alert("Kateqoriyada dəyişiklik edildi !!! ");
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}

//***************************************************
//---------------------SOFT DELETE-------------------
//***************************************************
function deleteEduExp(id) {
    var data = {
        id: id,
        type: globType
    };
    $.ajax({
        url: "eec?action=deleteEduExp",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#deleteModal").hide();
                closeModal();
                alert("Məlumat silindi.");
                getAllEduExp(globType)
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function deleteSocial(id) {
    var data = {
        id: id
    };
    $.ajax({
        url: "sc?action=deleteSocial",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#deleteModal").hide();
                closeModal();
                alert("Sosial şəbəkə silindi.");
                getAllContacts();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function deletePost(id) {
    var data = {
        id: id,
        postType: globType
    };
    $.ajax({
        url: "pc?action=deletePost",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#deleteModal").hide();
                closeModal();
                alert("Paylaşım silindi.");
                getAllPosts(globType)
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function deleteFile(id) {
    var data = {
        id: id,
        postType: globType
    };
    $.ajax({
        url: "fc?action=deleteFileById",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                $("#deleteModal").hide();
                closeModal();
                alert("Fayl silindi.");
                getAllPosts(globType)
            } else if (response == "fail") {
                alert("Xəta");
            }
        }
    })
}

function deleteCategorie(id) {
    var data = {
        id: id,
    };
    $.ajax({
        url: "cc?action=delCategorie",
        type: "POST",
        data: data,
        dataType: "text",
        success: function (response) {
            if (response == "success") {
                alert("Kateqoriyada silindi !!! ");
                getAllCategories();
            } else if (response == "fail") {
                alert("Xəta");
            }
        }

    })
}