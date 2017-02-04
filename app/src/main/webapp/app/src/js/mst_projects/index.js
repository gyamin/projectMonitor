class MstProjectsModel {
  getProjects () {
    var defer = $.Deferred();
    $.ajax({
      method: "GET",
      url: "/api/mst_projects",
      success: defer.resolve,
      error: defer.reject
    });
    return defer.promise();
  }
}

var model = new MstProjectsModel();
var app = new Vue({
  el: '#app',
  data: {
    items: []
  },
  methods: {
    getProjects: () => {
      model.getProjects().done( (data) => {
        console.log(data);
        app.items = data;
      })
    }
  }
});

