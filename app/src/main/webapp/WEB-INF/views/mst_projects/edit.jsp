<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>プロジェクトマスタ 編集</title>
  <script src="https://code.jquery.com/jquery-3.1.1.js"
          integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
          crossorigin="anonymous"></script>
</head>
<body>
<main id="app">
  <div>
    <label>プロジェクトNo</label><li>${item.projectNo}</li>
    <label>プロジェクト名</label><li>${item.projectName}</li>
    <label>営業担当者</label><li>${item.salesWorkerFamilyName} ${item.salesWorkerFirstName}</li>
    <label>担当PL</label><li>${item.plWorkerFamilyName} ${item.plWorkerFirstName}</li>
    <label>PJ開始予定日</label><li>${item.scheduledStartDate}</li>
    <label>PJ終了予定日</label><li>${item.scheduledEndDate}</li>
  </div>
</main>
<script src="/js/mst_projects.bundle.js"></script>
</body>
</html>
