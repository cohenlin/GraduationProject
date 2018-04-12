var TaskList = function () {

    return {

        initTaskWidget: function () {
            $('input.list-child').change(function () {
                if ($(this).is(':checked')) {
                    $(this).parents('li').addClass("task-done");
                } else {
                    $(this).parents('li').removeClass("task-done");
                }
            });
        }

    };

}();

function getNodeOfTask(data) {
    var status;
    if(data.finish == true) {
        status = "<span class=\"badge bg-theme\">Done</span>";
    } else {
    status = "<span class=\"badge bg-success\">"+ data. +" Days</span>";
    }
    var node = "<li>" +
                    "<div class=\"task-checkbox\">" +
                        "<input type=\"checkbox\" class=\"list-child\" value=\"\" />" +
                    "</div>" +
                    "<div class=\"task-title\">" +
                        "<span class=\"task-title-sp\">" + data.taskInfo+"</span> " +
                        "<span class=\"badge bg-theme\">Done</span>" +
                        "<div class=\"pull-right hidden-phone\">" +
                            "<button class=\"btn btn-success btn-xs\">" +
                                "<i class=\" fa fa-check\"></i>" +
                            "</button>" +
                            "<button class=\"btn btn-primary btn-xs\">" +
                                "<i class=\"fa fa-pencil\"></i>" +
                            "</button>" +
                            "<button class=\"btn btn-danger btn-xs\">" +
                                "<i class=\"fa fa-trash-o \"></i>" +
                            "</button>" +
                        "</div>" +
                    "</div>" +
                "</li>";
    return node;
}