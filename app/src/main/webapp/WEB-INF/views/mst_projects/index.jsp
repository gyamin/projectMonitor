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
<body data-pageId="mst_projects/index">
<main id="app">
  <div>
    <ul>
      <li>
        <button>検索</button>
      </li>
    </ul>
  </div>
  <div>
    <p><button class="btn-new">新規作成</button></p>
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

      <c:forEach var="project" items="${projects}">
        <tr>
          <td><a href="/mst_project/report/${project.id}" />${project.projectNo}</td>
          <td>${project.projectName}</td>
          <td>${project.salesWorkerFamilyName} ${project.salesWorkerFirstName}</td>
          <td>${project.plWorkerFamilyName} ${project.plWorkerFirstName}</td>
          <td>${project.scheduledStartDate}</td>
          <td>${project.scheduledEndDate}</td>
          <td>
            <button class="btn-eidt" data-id="${project.id}">編集</button>
            <button class="btn-delete" data-id="${project.id}">削除</button>
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
