<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>픽잇 - 맛집 리스트</title>

<style>
    * {
        box-sizing: border-box;
        font-family: 'Pretendard', 'Noto Sans KR', sans-serif;
    }

    body {
        margin: 0;
        background: #fafafa;
        color: #222;
    }

    .header {
        height: 72px;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 0 48px;
        background: #fff;
        border-bottom: 1px solid #eee;
    }

    .logo {
        font-size: 30px;
        font-weight: 800;
    }

    .logo span {
        color: #ff6b00;
    }

    .nav a {
        margin: 0 18px;
        text-decoration: none;
        color: #222;
        font-weight: 600;
    }

    .nav a.active {
        color: #ff6b00;
        border-bottom: 3px solid #ff6b00;
        padding-bottom: 24px;
    }

    .search-box {
        width: 360px;
        height: 42px;
        border: 1px solid #ddd;
        border-radius: 12px;
        padding: 0 16px;
    }

    .container {
        padding: 36px 48px;
    }

    .page-title {
        display: flex;
        align-items: end;
        gap: 18px;
        margin-bottom: 26px;
    }

    .page-title h1 {
        margin: 0;
        font-size: 34px;
    }

    .page-title p {
        margin: 0 0 6px;
        color: #777;
    }

    .filter-area {
        background: #fff;
        border-radius: 16px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.06);
        padding: 18px;
        margin-bottom: 28px;
        max-width: 1080px;
    }

    .filter-top {
        display: flex;
        gap: 12px;
        margin-bottom: 16px;
    }

    .filter-top input {
        flex: 1;
        height: 48px;
        border: 1px solid #ddd;
        border-radius: 12px;
        padding: 0 16px;
        font-size: 15px;
    }

    .filter-top button,
    .filter-list button {
        height: 46px;
        border: 1px solid #ddd;
        background: #fff;
        border-radius: 12px;
        padding: 0 18px;
        font-weight: 600;
        cursor: pointer;
    }

    .filter-list {
        display: flex;
        gap: 12px;
    }

    .content {
        display: grid;
        grid-template-columns: 1fr 1.05fr;
        gap: 28px;
    }

    .list-box {
        background: #fff;
        border-radius: 18px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.06);
        overflow: hidden;
    }

    .count {
        padding: 18px 22px;
        color: #777;
        border-bottom: 1px solid #eee;
    }

    .restaurant-card {
        display: flex;
        gap: 20px;
        padding: 18px;
        border-bottom: 1px solid #eee;
        position: relative;
    }

    .restaurant-card img {
        width: 190px;
        height: 145px;
        object-fit: cover;
        border-radius: 14px;
        background: #eee;
    }

    .rank {
        position: absolute;
        top: 20px;
        left: 20px;
        background: #ff6b00;
        color: #fff;
        width: 34px;
        height: 34px;
        border-radius: 10px 0 10px 0;
        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: 800;
    }

    .info {
        flex: 1;
        padding-top: 4px;
    }

    .info h3 {
        margin: 0 0 10px;
        font-size: 22px;
    }

    .info h3 a {
        color: #222;
        text-decoration: none;
    }

    .badge {
        display: inline-block;
        background: #fff3e8;
        color: #ff6b00;
        padding: 5px 10px;
        border-radius: 999px;
        font-size: 13px;
        font-weight: 700;
        margin-left: 8px;
    }

    .rating {
        color: #ff9500;
        font-weight: 700;
        margin-bottom: 8px;
    }

    .desc {
        color: #555;
        margin-bottom: 14px;
        line-height: 1.5;
    }

    .meta {
        color: #777;
        font-size: 14px;
    }

    .detail-link {
        position: absolute;
        right: 20px;
        bottom: 20px;
        color: #ff6b00;
        text-decoration: none;
        font-weight: 700;
    }

    .heart {
        position: absolute;
        right: 20px;
        top: 20px;
        font-size: 28px;
        color: #999;
    }

    .map-section {
        position: sticky;
        top: 92px;
        height: 680px;
    }

    .view-tab {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
        margin-bottom: 16px;
    }

    .view-tab button {
        border: 1px solid #eee;
        background: #fff;
        padding: 14px 28px;
        border-radius: 12px;
        font-weight: 700;
    }

    .view-tab .active {
        background: #fff3e8;
        color: #ff6b00;
    }

    #map {
        width: 100%;
        height: 610px;
        border-radius: 18px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.08);
    }

    .pagination {
        display: flex;
        justify-content: center;
        gap: 26px;
        padding: 24px;
    }

    .pagination a {
        text-decoration: none;
        color: #444;
        font-weight: 600;
    }

    .pagination .active {
        color: #ff6b00;
    }
</style>
</head>

<body>

<header class="header">
    <div class="logo">픽잇<span>📍</span></div>

    <nav class="nav">
        <a href="/">홈</a>
        <a href="/recommend">추천</a>
        <a href="/restaurant/list" class="active">맛집 리스트</a>
        <a href="/review/list">리뷰</a>
        <a href="/mypage">마이페이지</a>
    </nav>

    <input class="search-box" type="text" placeholder="음식, 지역, 가게명을 검색해 보세요">
</header>

<main class="container">

    <div class="page-title">
        <h1>맛집 리스트</h1>
        <p>원하는 조건으로 맛집을 검색해 보세요.</p>
    </div>

    <section class="filter-area">
        <div class="filter-top">
            <input type="text" placeholder="음식, 지역, 가게명을 검색해 보세요">
            <button>📍 내 주변 검색</button>
        </div>

        <div class="filter-list">
            <button>카테고리 전체⌄</button>
            <button>거리 전체⌄</button>
            <button>가격대 전체⌄</button>
            <button>평점 전체⌄</button>
            <button>상황 전체⌄</button>
            <button>↻ 필터 초기화</button>
        </div>
    </section>

    <section class="content">

        <div class="list-box">
            <div class="count">
                총 ${restaurantList.size()}개의 맛집이 있습니다.
            </div>

            <c:forEach var="r" items="${restaurantList}" varStatus="status">
                <div class="restaurant-card">
                    <div class="rank">${status.index + 1}</div>

                    <c:choose>
                        <c:when test="${not empty r.imageUrl}">
                            <img src="${r.imageUrl}" alt="${r.name}">
                        </c:when>
                        <c:otherwise>
                            <img src="/resources/images/no-image.png" alt="기본 이미지">
                        </c:otherwise>
                    </c:choose>

                    <div class="info">
                        <h3>
                            <a href="/restaurant/detail/${r.restaurantId}">
                                ${r.name}
                            </a>
                            <span class="badge">${r.categoryName}</span>
                        </h3>

                        <div class="rating">★ ${r.rating}</div>

                        <div class="desc">
                            진한 맛과 분위기가 좋은 인기 맛집입니다.
                        </div>

                        <div class="meta">
                            📍 ${r.categoryName}
                            <c:if test="${not empty r.distance}">
                                · ${r.distance}km
                            </c:if>
                        </div>
                    </div>

                    <div class="heart">♡</div>
                    <a class="detail-link" href="/restaurant/detail/${r.restaurantId}">
                        상세보기 〉
                    </a>
                </div>
            </c:forEach>

            <div class="pagination">
                <a href="#">‹</a>
                <a href="#" class="active">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">›</a>
            </div>
        </div>

        <aside class="map-section">
            <div class="view-tab">
                <button class="active">☰ 리스트 보기</button>
                <button>🗺 지도 보기</button>
            </div>

            <div id="map"></div>
        </aside>

    </section>

</main>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=여기에_카카오맵_JavaScript키"></script>
<script>
    var mapContainer = document.getElementById('map');

    var mapOption = {
        center: new kakao.maps.LatLng(37.5665, 126.9780),
        level: 5
    };

    var map = new kakao.maps.Map(mapContainer, mapOption);

    <c:forEach var="r" items="${restaurantList}">
        <c:if test="${not empty r.latitude and not empty r.longitude}">
            var markerPosition = new kakao.maps.LatLng(${r.latitude}, ${r.longitude});

            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            marker.setMap(map);
        </c:if>
    </c:forEach>
</script>

</body>
</html>