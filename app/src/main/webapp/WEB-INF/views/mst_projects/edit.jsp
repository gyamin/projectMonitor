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
  <form method="post" action="/mst_projects/edit/${project.id}">
  <div>
    <ul>
    <label>プロジェクトNo</label><li><input type="text" value="${project.projectNo}"></li>
    <label>プロジェクト名</label><li><input type="text" value="${project.projectName}"></li>
    <label>営業担当者</label><li>${project.salesWorkerFamilyName} ${project.salesWorkerFirstName}</li>
    <label>担当PL</label><li>${project.plWorkerFamilyName} ${project.plWorkerFirstName}</li>
    <label>PJ開始予定日</label><li><input type="date" value="${project.scheduledStartDate}"></li>
    <label>PJ終了予定日</label><li><input type="date" value="${project.scheduledEndDate}"></li>
    </ul>
  </div>

  <div>
    <p>プロジェクト管理対象の受注</p>
    <ul>
      <c:forEach var="relatedOrder" items="${projectOrders}">
        <li><input type="checkbox" value="${relatedOrder.id}">${relatedOrder.orderName}</li>
      </c:forEach>
    </ul>
  </div>

  <div>
    <p>プロジェクト管理対象外の受注</p>
    <ul>
    <c:forEach var="notRelatedOrder" items="${projectNotRelatedOrders}">
      <li><input type="checkbox" value="${notRelatedOrder.id}">${notRelatedOrder.orderName}</li>
    </c:forEach>
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
