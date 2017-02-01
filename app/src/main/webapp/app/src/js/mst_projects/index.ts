namespace MstProjects.Index {

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
                    url: "/api/mst_projects",
                    dataType: "json",
                    success: function (projects) {
                        for (let project in projects) {
                            console.log(project);
                        }
                        that.projects = projects;

                    },
                    error: function (error) {
                        alert(JSON.stringify(error));
                    }
                });
            }
        }
    })
}
