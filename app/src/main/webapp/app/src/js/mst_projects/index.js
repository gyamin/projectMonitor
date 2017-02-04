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

  shapeList (list) {
    let shapedList = [];
    Object.keys(list).forEach((key) => {
      list[key].scheduledStartDate = (new DateUtil(list[key].scheduledStartDate).getDateWithFormat())
      list[key].scheduledEndDate = (new DateUtil(list[key].scheduledEndDate).getDateWithFormat())
      shapedList.push(list[key]);
    });
    return shapedList;
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
        app.items = model.shapeList(data);
      })
    }
  }
});

