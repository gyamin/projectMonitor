<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>プロジェクトマスタ 新規登録</title>
  <script src="https://code.jquery.com/jquery-3.1.1.js"
          integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
          crossorigin="anonymous"></script>
</head>
<body>
<main id="app">
  <form method="post" action="/mst_projects/edit/${project.id}">
  <div>
    <ul>
    <label>プロジェクトNo</label><li><input type="text" value=""></li>
    <label>プロジェクト名</label><li><input type="text" value=""></li>
    <label>営業担当者</label><li></li>
    <label>担当PL</label><li></li>
    <label>PJ開始予定日</label><li><input type="date" value=""></li>
    <label>PJ終了予定日</label><li><input type="date" value=""></li>
    </ul>
  </div>

  <div>
    <button>戻る</button>
    <button>登録</button>
  </div>
  </form>
</main>
<script src="/js/mst_projects.bundle.js"></script>
</body>
</html>
