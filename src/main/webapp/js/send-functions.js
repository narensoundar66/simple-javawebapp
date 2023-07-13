function sendGet() {
    $.ajax({
        type: "GET",
        url: '/',
        data: {
            update: true
        },
        success: function () {
            location.reload()
        }
    });
}

function sendPost() {
    $.ajax({
        type: "POST",
        url: '/',
        success: function() {
            location.reload();
        }
    });
}

function sendPut() {
    $.ajax({
        type: "PUT",
        url: '/',
        success: function() {
            location.reload();
        }
    });
}

function sendDelete() {
    $.ajax({
        type: "DELETE",
        url: '/',
        success: function() {
            location.reload();
        }
    });
}