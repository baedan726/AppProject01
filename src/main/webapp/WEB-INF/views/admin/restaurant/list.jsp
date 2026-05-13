<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PickEat - 맛집 관리</title>

<style>
* {
    box-sizing: border-box;
    font-family: 'Pretendard', 'Noto Sans KR', sans-serif;
}

body {
    margin: 0;
    background: #fff7ed;
    color: #111827;
}

.header {
    height: 70px;
    background: #fff;
    border-bottom: 1px solid #eee;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 40px;
}

.logo {
    display: flex;
    align-items: center;
    gap: 8px;
    text-decoration: none;
}

.logo-text {
    font-size: 26px;
    font-weight: 900;
    color: #111827;
}

.logo-icon {
    width: 22px;
    height: 28px;
    background: #ff6500;
    border-radius: 50% 50% 50% 0;
    transform: rotate(-45deg);
}

.nav {
    display: flex;
    gap: 32px;
}

.nav a {
    text-decoration: none;
    color: #111827;
    font-weight: 800;
}

.nav a.active {
    color: #ff6500;
}

.container {
    padding: 44px 60px;
}

.page-head {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    margin-bottom: 26px;
}

.page-title h1 {
    font-size: 38px;
    margin: 0 0 10px;
}

.page-title p {
    margin: 0;
    color: #6b7280;
    font-weight: 700;
}

.search-form {
    display: flex;
    gap: 10px;
    margin-top: 18px;
}

.search-input {
    width: 320px;
    height: 44px;
    border: 1px solid #e5e7eb;
    border-radius: 12px;
    padding: 0 16px;
    font-size: 14px;
    font-weight: 700;
    outline: none;
}

.search-input:focus {
    border-color: #ff6500;
    box-shadow: 0 0 0 3px rgba(255, 101, 0, 0.12);
}

.search-btn {
    height: 44px;
    padding: 0 18px;
    border: none;
    border-radius: 12px;
    background: #111827;
    color: white;
    font-weight: 900;
    cursor: pointer;
}

.search-btn:hover {
    background: #1f2937;
}

.btn {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    min-width: 64px;
    height: 42px;
    text-decoration: none;
    border: none;
    cursor: pointer;
    border-radius: 12px;
    padding: 0 18px;
    font-weight: 900;
    text-align: center;
    white-space: nowrap;
}

.btn-orange {
    background: #ff6500;
    color: #fff;
}

.btn-outline {
    background: #fff;
    color: #111827;
    border: 1px solid #ddd;
}

.btn-dark {
    background: #111827;
    color: #fff;
}

.admin-card {
    background: #fff;
    border-radius: 22px;
    padding: 24px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.06);
    border: 1px solid #ffe0c2;
}

.table {
    width: 100%;
    border-collapse: collapse;
    table-layout: fixed;
}

.table th {
    text-align: left;
    color: #6b7280;
    font-size: 14px;
    padding: 14px 12px;
    border-bottom: 1px solid #eee;
}

.table td {
    padding: 18px 12px;
    border-bottom: 1px solid #f1f1f1;
    font-weight: 700;
    vertical-align: middle;
    height: 92px;
}

.table th:nth-child(1),
.table td:nth-child(1) {
    width: 90px;
}

.table th:nth-child(2),
.table td:nth-child(2) {
    width: 32%;
}

.table th:nth-child(3),
.table td:nth-child(3) {
    width: 28%;
}

.table th:nth-child(4),
.table td:nth-child(4) {
    width: 110px;
}

.table th:nth-child(5),
.table td:nth-child(5) {
    width: 260px;
}

.table tr:last-child td {
    border-bottom: none;
}

.name {
    font-size: 18px;
    font-weight: 900;
    color: #111827;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.category {
    display: inline-block;
    background: #fff3e8;
    color: #ff6500;
    padding: 7px 11px;
    border-radius: 999px;
    font-weight: 900;
    font-size: 13px;
    max-width: 230px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: middle;
}

.actions {
    display: flex;
    align-items: center;
    gap: 8px;
    flex-wrap: nowrap;
}

.delete-form {
    margin: 0;
}

.empty-box {
    padding: 70px 20px;
    text-align: center;
    color: #6b7280;
    font-weight: 800;
}

.empty-box strong {
    color: #ff6500;
}

.pagination-wrap {
    display: flex;
    justify-content: center;
    gap: 8px;
    margin-top: 28px;
    flex-wrap: wrap;
}

.pagination-wrap a,
.pagination-wrap span {
    min-width: 42px;
    height: 42px;
    padding: 0 14px;
    border-radius: 12px;
    border: 1px solid #e5e7eb;
    background: #fff;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: 900;
    text-decoration: none;
    color: #111827;
}

.pagination-wrap a:hover {
    border-color: #ff6500;
    color: #ff6500;
}

.pagination-wrap a.active {
    background: #ff6500;
    border-color: #ff6500;
    color: white;
}

.pagination-wrap .disabled {
    background: #f3f4f6;
    color: #9ca3af;
}

.page-info {
    text-align: center;
    margin-top: 12px;
    color: #6b7280;
    font-weight: 800;
}

@media (max-width: 900px) {
    .container {
        padding: 30px 20px;
    }

    .page-head {
        flex-direction: column;
        align-items: flex-start;
        gap: 16px;
    }

    .search-form {
        width: 100%;
        flex-direction: column;
    }

    .search-input {
        width: 100%;
    }

    .admin-card {
        overflow-x: auto;
    }

    .table {
        min-width: 900px;
    }
}
</style>
</head>

<body>

<header class="header">
    <a href="${contextPath}/" class="logo">
        <span class="logo-text">픽잇</span>
        <span class="logo-icon"></span>
    </a>

    <nav class="nav">
        <a href="${contextPath}/">홈</a>
        <a href="${contextPath}/recommend">추천</a>
        <a href="${contextPath}/restaurants">맛집 리스트</a>
        <a href="${contextPath}/bookmark/list">즐겨찾기</a>
        <a href="${contextPath}/admin/restaurants" class="active">맛집 관리</a>
    </nav>
</header>

<main class="container">

    <section class="page-head">
        <div class="page-title">
            <h1>맛집 관리 🍽️</h1>

            <p>등록된 맛집을 확인하고 수정하거나 삭제할 수 있어요.</p>

            <form class="search-form"
                  action="${contextPath}/admin/restaurants"
                  method="get">

                <input type="text"
                       name="keyword"
                       class="search-input"
                       placeholder="맛집명을 검색하세요"
                       value="${keyword}">

                <input type="hidden" name="size" value="${pageDTO.size}">

                <button type="submit" class="search-btn">
                    검색
                </button>

                <a href="${contextPath}/admin/restaurants"
                   class="btn btn-outline">
                    초기화
                </a>
            </form>
        </div>

        <a class="btn btn-orange" href="${contextPath}/admin/restaurants/add">
            + 맛집 등록
        </a>
    </section>

    <section class="admin-card">

        <c:choose>
            <c:when test="${empty restaurantList}">
                <div class="empty-box">
                    <c:choose>
                        <c:when test="${not empty keyword}">
                            <strong>${keyword}</strong>에 해당하는 맛집이 없습니다.
                        </c:when>

                        <c:otherwise>
                            등록된 맛집이 없습니다.
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:when>

            <c:otherwise>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>맛집명</th>
                            <th>카테고리</th>
                            <th>평점</th>
                            <th>관리</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="restaurant" items="${restaurantList}">
                            <tr>
                                <td>${restaurant.restaurantId}</td>

                                <td>
                                    <div class="name">${restaurant.name}</div>
                                </td>

                                <td>
                                    <span class="category" title="${restaurant.categoryName}">
                                        ${restaurant.categoryName}
                                    </span>
                                </td>

                                <td>★ ${restaurant.rating}</td>

                                <td>
                                    <div class="actions">
                                        <a class="btn btn-dark"
                                           href="${contextPath}/restaurants/${restaurant.restaurantId}">
                                            보기
                                        </a>

                                        <a class="btn btn-outline"
                                           href="${contextPath}/admin/restaurants/update?restaurantId=${restaurant.restaurantId}">
                                            수정
                                        </a>

                                        <form class="delete-form"
                                              action="${contextPath}/admin/restaurants/delete"
                                              method="post"
                                              onsubmit="return confirm('정말 삭제하시겠습니까?');">
                                            <input type="hidden"
                                                   name="restaurantId"
                                                   value="${restaurant.restaurantId}">

                                            <button type="submit"
                                                    class="btn btn-outline">
                                                삭제
                                            </button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <c:if test="${pageDTO.totalPage > 0}">
                    <div class="pagination-wrap">

                        <c:choose>
                            <c:when test="${pageDTO.page > 1}">
                                <a href="${contextPath}/admin/restaurants?page=${pageDTO.page - 1}&size=${pageDTO.size}&keyword=${keyword}">
                                    이전
                                </a>
                            </c:when>

                            <c:otherwise>
                                <span class="disabled">이전</span>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="num"
                                   begin="${pageDTO.startPage}"
                                   end="${pageDTO.endPage}">
                            <a href="${contextPath}/admin/restaurants?page=${num}&size=${pageDTO.size}&keyword=${keyword}"
                               class="${pageDTO.page == num ? 'active' : ''}">
                                ${num}
                            </a>
                        </c:forEach>

                        <c:choose>
                            <c:when test="${pageDTO.page < pageDTO.totalPage}">
                                <a href="${contextPath}/admin/restaurants?page=${pageDTO.page + 1}&size=${pageDTO.size}&keyword=${keyword}">
                                    다음
                                </a>
                            </c:when>

                            <c:otherwise>
                                <span class="disabled">다음</span>
                            </c:otherwise>
                        </c:choose>

                    </div>

                    <div class="page-info">
                        현재 ${pageDTO.page}페이지 / 전체 ${pageDTO.totalPage}페이지
                    </div>
                </c:if>

            </c:otherwise>
        </c:choose>

    </section>

</main>

</body>
</html>