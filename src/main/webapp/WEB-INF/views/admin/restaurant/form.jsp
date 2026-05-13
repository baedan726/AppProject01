<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 등록/수정</title>

<style>
body {
	font-family: 'Pretendard';
	background: #fff7ed;
	margin: 0;
}

.container {
	padding: 40px;
}

.card {
	background: white;
	border-radius: 20px;
	padding: 30px;
	max-width: 800px;
	margin: auto;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.05);
}

h1 {
	margin-bottom: 20px;
}

.input-group {
	margin-bottom: 15px;
}

label {
	font-weight: 800;
	display: block;
	margin-bottom: 6px;
}

input, textarea {
	width: 100%;
	padding: 10px;
	border-radius: 10px;
	border: 1px solid #ddd;
}

textarea {
	resize: none;
}

.btn {
	margin-top: 20px;
	padding: 12px 16px;
	border: none;
	border-radius: 10px;
	font-weight: 900;
	cursor: pointer;
}

.primary {
	background: #ff6500;
	color: white;
}
</style>
</head>

<body>

	<div class="container">
		<div class="card">

			<h1>
				<c:choose>
					<c:when test="${empty restaurant.restaurantId}">
                    맛집 등록
                </c:when>
					<c:otherwise>
                    맛집 수정
                </c:otherwise>
				</c:choose>
			</h1>

			<form
				action="${contextPath}/admin/restaurants/${empty restaurant.restaurantId ? 'add' : 'update'}"
				method="post">

				<input type="hidden" name="restaurantId"
					value="${restaurant.restaurantId}" />

				<div class="input-group">
					<label>이름</label> <input type="text" name="name"
						value="${restaurant.name}">
				</div>

				<div class="input-group">
					<label>주소</label> <input type="text" name="address"
						value="${restaurant.address}">
				</div>

				<div class="input-group">
					<label>전화번호</label> <input type="text" name="phone"
						value="${restaurant.phone}">
				</div>

				<!-- 수정: 카카오 원본 카테고리 -->
				<div class="input-group">
					<label>카카오 카테고리명</label> <input type="text"
						name="kakaoCategoryName" value="${restaurant.kakaoCategoryName}">
				</div>

				<!-- 수정: 카카오맵 상세 URL -->
				<div class="input-group">
					<label>카카오맵 상세 URL</label> <input type="text" name="placeUrl"
						value="${restaurant.placeUrl}">
				</div>

				<div class="input-group">
					<label>가격대</label> <input type="text" name="priceRange"
						value="${restaurant.priceRange}">
				</div>

				<div class="input-group">
					<label>영업시간</label> <input type="text" name="openingHours"
						value="${restaurant.openingHours}">
				</div>

				<div class="input-group">
					<label>설명</label>
					<textarea name="description">${restaurant.description}</textarea>
				</div>

				<div class="input-group">
					<label>위도</label> <input type="text" id="lat" name="latitude"
						value="${restaurant.latitude}">
				</div>

				<div class="input-group">
					<label>경도</label> <input type="text" id="lng" name="longitude"
						value="${restaurant.longitude}">
				</div>

				<!-- 지도 -->
				<div id="map" style="width: 100%; height: 300px; margin-top: 20px;"></div>

				<button class="btn primary">저장</button>
			</form>

		</div>
	</div>

	<!-- 카카오맵 -->
	<script
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a87f90deda3136d9524a194c121dcf1"></script>

	<script>
		var lat = $
		{
			restaurant.latitude != null ? restaurant.latitude : 37.5665
		};
		var lng = $
		{
			restaurant.longitude != null ? restaurant.longitude : 126.9780
		};

		var mapContainer = document.getElementById('map');
		var mapOption = {
			center : new kakao.maps.LatLng(lat, lng),
			level : 3
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);

		var marker = new kakao.maps.Marker({
			position : new kakao.maps.LatLng(lat, lng)
		});

		marker.setMap(map);

		// 지도 클릭 이벤트
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

			var latlng = mouseEvent.latLng;

			document.getElementById("lat").value = latlng.getLat();
			document.getElementById("lng").value = latlng.getLng();

			marker.setPosition(latlng);
		});
	</script>

</body>
</html>