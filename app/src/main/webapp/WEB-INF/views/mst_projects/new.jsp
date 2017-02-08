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
  <form method="post" action="/mst_projects/new">
  <div>
    <ul>
    <label>プロジェクトNo</label><li><input type="text" name="projectNo" value=""></li>
    <label>プロジェクト名</label><li><input type="text" name="projectName" value=""></li>
    <label>営業担当者</label>
      <li>
        <select name="salseWorkerId">
          <option value="" selected>未選択</option>
          <c:forEach var="worker" items="${workers}">
            <option value="${worker.id}">${worker.familyName} ${worker.firstName}</option>
          </c:forEach>
        </select>
      </li>
    <label>担当PL</label>
      <li>
        <select name="plWorkerId">
          <option value="" selected>未選択</option>
          <c:forEach var="worker" items="${workers}">
            <option value="${worker.id}">${worker.familyName} ${worker.firstName}</option>
          </c:forEach>
        </select>
      </li>
    <label>PJ開始予定日</label><li><input type="date" name="scheduledStartDate" value=""></li>
    <label>PJ終了予定日</label><li><input type="date" name="scheduledEndDate" value=""></li>
    </ul>
  </div>

  <div>
    <button>戻る</button>
    <input type="submit" value="登録">
  </div>
  </form>
</main>
<script src="/js/mst_projects.bundle.js"></script>
</body>
</html>
