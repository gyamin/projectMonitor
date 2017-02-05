<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>プロジェクトマスタ 一覧</title>
  <script src="https://code.jquery.com/jquery-3.1.1.js"
          integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
          crossorigin="anonymous"></script>
</head>
<body>
<main id="app">
  <div>
    <ul>
      <li>
        <button>検索</button>
      </li>
    </ul>
  </div>
  <div>
    <table>
      <thead>
      <tr>
        <td>プロジェクトNo</td>
        <td>プロジェクト名</td>
        <td>営業担当者</td>
        <td>担当PL</td>
        <td>PJ開始予定日</td>
        <td>PJ終了予定日</td>
        <td>操作</td>
      </tr>
      </thead>
      <tbody>

      <c:forEach var="item" items="${projects}">
        <tr>
          <td>${item.projectNo}</td>
          <td>${item.projectName}</td>
          <td>${item.salesWorkerFamilyName} ${item.salesWorkerFirstName}</td>
          <td>${item.plWorkerFamilyName} ${item.plWorkerFirstName}</td>
          <td>${item.scheduledStartDate}</td>
          <td>${item.scheduledEndDate}</td>
          <td>
            <button class="btn-eidt" data-id="${item.id}">編集</button>
            <button class="btn-delete" data-id="${item.id}">削除</button>
          </td>
        </tr>
      </c:forEach>

      </tbody>
    </table>
  </div>
</main>
<script src="/js/mst_projects.bundle.js"></script>
</body>
</html>
