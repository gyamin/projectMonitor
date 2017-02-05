require("./../common/date_util.js")
var $ = require('jquery');

class MstProjectsIndex {
  constructor() {
    this.init();
  }
  init() {
    // 編集、削除ボタンにイベント設定
    $('.btn-eidt').click(this.edit);
    $('.btn-delete').click(this.delete);
  }

  edit() {
    let id = $(this).data('id');
    location.href = "/mst_projects/edit/" + id;
  }

  delete() {
    let id = $(this).data('id');
    if(!confirm('削除しますか？')){
      return false;
    }else{
      $.ajax({
        url: '/mst_projects/' + id,
        type: 'DELETE',
      })
        .done(() => {
          location.reload();
      })
        .fail(() => {

        })
    }
  }
}


var index = new MstProjectsIndex();

