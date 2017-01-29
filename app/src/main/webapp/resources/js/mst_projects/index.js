var MstProjects;
(function (MstProjects) {
    var Index;
    (function (Index) {
        var app = new Vue({
            el: '#v-mst-projects',
            data: {
                projects: []
            },
            methods: {
                searchProjects: function (event) {
                    var that = this;
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8102/api/mst_projects",
                        dataType: "json",
                        success: function (data) {
                            that.projects = data;
                        },
                        error: function (error) {
                            alert(JSON.stringify(error));
                        }
                    });
                }
            }
        });
    })(Index = MstProjects.Index || (MstProjects.Index = {}));
})(MstProjects || (MstProjects = {}));
//# sourceMappingURL=index.js.map