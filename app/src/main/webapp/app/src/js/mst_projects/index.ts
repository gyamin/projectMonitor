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
          success: function(data) {
            that.projects = data;
          },
          error: function (error) {
            alert(JSON.stringify(error));
          }
        });
      }
    }
  })
}