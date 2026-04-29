<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>PickEat - 날씨 기반 맛집 추천</title>

<style>
* {
	box-sizing: border-box;
}

html {
	scroll-behavior: smooth;
}

body {
	margin: 0;
	font-family: 'Noto Sans KR', Arial, sans-serif;
	color: #111827;
	background: radial-gradient(circle at 10% 12%, rgba(255, 122, 0, 0.18),
		transparent 28%),
		radial-gradient(circle at 86% 8%, rgba(255, 197, 98, 0.25),
		transparent 30%),
		radial-gradient(circle at 48% 50%, rgba(255, 241, 219, 0.85),
		transparent 42%),
		linear-gradient(135deg, #fffaf4 0%, #fff2df 44%, #f8fbff 100%);
}

a {
	text-decoration: none;
	color: inherit;
}

.header {
	height: 64px;
	background: rgba(255, 255, 255, 0.88);
	border-bottom: 1px solid #e5e7eb;
	display: flex;
	align-items: center;
	padding: 0 36px;
	backdrop-filter: blur(12px);
	position: sticky;
	top: 0;
	z-index: 100;
}

.logo {
	font-size: 29px;
	font-weight: 900;
	letter-spacing: -1px;
	display: flex;
	align-items: center;
	gap: 7px;
	color: #111827;
}

.logo-icon {
	width: 25px;
	height: 31px;
	background: #ff6500;
	border-radius: 50% 50% 50% 0;
	transform: rotate(-45deg);
	display: inline-block;
	box-shadow: 0 8px 18px rgba(255, 101, 0, 0.25);
}

.nav {
	flex: 1;
	display: flex;
	justify-content: center;
	gap: 46px;
	font-size: 14px;
	font-weight: 800;
}

.nav a {
	color: #111827;
	transition: 0.2s;
}

.nav a:hover {
	color: #ff6500;
}

.header-actions {
	display: flex;
	gap: 10px;
}

.header-btn {
	border-radius: 10px;
	padding: 10px 17px;
	font-weight: 900;
	font-size: 13px;
	transition: 0.2s;
}

.header-login {
	background: #111827;
	color: #ffffff;
}

.header-join {
	background: #ff6500;
	color: #ffffff;
}

.header-btn:hover {
	transform: translateY(-1px);
}

.main {
	min-height: calc(100vh - 64px);
}

.hero {
	max-width: 1180px;
	margin: 0 auto;
	padding: 74px 24px 44px;
	display: grid;
	grid-template-columns: 1.02fr 0.98fr;
	gap: 48px;
	align-items: center;
}

.hero-badge {
	display: inline-flex;
	align-items: center;
	gap: 8px;
	padding: 9px 15px;
	border-radius: 999px;
	background: rgba(255, 255, 255, 0.82);
	border: 1px solid rgba(255, 101, 0, 0.18);
	box-shadow: 0 12px 30px rgba(255, 101, 0, 0.08);
	color: #ff6500;
	font-size: 13px;
	font-weight: 900;
	margin-bottom: 22px;
}

.hero-title {
	font-size: 56px;
	line-height: 1.12;
	letter-spacing: -2.6px;
	margin: 0 0 22px;
	font-weight: 950;
}

.hero-title span {
	color: #ff6500;
}

.hero-desc {
	font-size: 18px;
	line-height: 1.85;
	color: #6b7280;
	margin: 0 0 32px;
}

.hero-buttons {
	display: flex;
	gap: 14px;
	align-items: center;
	flex-wrap: wrap;
}

.primary-btn, .secondary-btn {
	height: 48px;
	padding: 0 24px;
	border-radius: 14px;
	font-size: 14px;
	font-weight: 900;
	display: inline-flex;
	align-items: center;
	justify-content: center;
	transition: 0.2s;
}

.primary-btn {
	background: #ff6500;
	color: white;
	box-shadow: 0 18px 35px rgba(255, 101, 0, 0.24);
}

.secondary-btn {
	background: white;
	color: #111827;
	border: 1px solid #e5e7eb;
}

.primary-btn:hover, .secondary-btn:hover {
	transform: translateY(-2px);
}

.hero-stats {
	margin-top: 34px;
	display: flex;
	gap: 14px;
	flex-wrap: wrap;
}

.stat-card {
	min-width: 132px;
	padding: 15px 17px;
	border-radius: 18px;
	background: rgba(255, 255, 255, 0.75);
	border: 1px solid rgba(255, 255, 255, 0.9);
	box-shadow: 0 12px 30px rgba(17, 24, 39, 0.06);
}

.stat-card strong {
	display: block;
	font-size: 20px;
	color: #111827;
	margin-bottom: 4px;
}

.stat-card span {
	font-size: 12px;
	color: #6b7280;
	font-weight: 800;
}

.hero-panel {
	position: relative;
	min-height: 540px;
	border-radius: 32px;
	background: rgba(255, 255, 255, 0.74);
	border: 1px solid rgba(255, 255, 255, 0.95);
	box-shadow: 0 28px 80px rgba(255, 101, 0, 0.14);
	backdrop-filter: blur(18px);
	overflow: hidden;
	padding: 28px;
}

.hero-panel::before {
	content: "";
	position: absolute;
	inset: 0;
	background-image: radial-gradient(rgba(255, 101, 0, 0.13) 1px,
		transparent 1px);
	background-size: 25px 25px;
	opacity: 0.45;
}

.weather-card {
	position: relative;
	z-index: 2;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 18px 20px;
	border-radius: 22px;
	background: rgba(255, 255, 255, 0.86);
	border: 1px solid rgba(255, 255, 255, 0.92);
	box-shadow: 0 18px 45px rgba(31, 41, 55, 0.08);
	margin-bottom: 18px;
}

.weather-left {
	display: flex;
	align-items: center;
	gap: 14px;
}

.weather-icon {
	width: 52px;
	height: 52px;
	border-radius: 18px;
	background: #fff3cc;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 28px;
}

.weather-title {
	font-size: 15px;
	font-weight: 900;
	margin-bottom: 4px;
}

.weather-sub {
	font-size: 12px;
	color: #6b7280;
	font-weight: 700;
}

.weather-temp {
	font-size: 28px;
	font-weight: 950;
	color: #ff6500;
}

.map-card {
	position: relative;
	z-index: 1;
	height: 286px;
	border-radius: 26px;
	background: linear-gradient(135deg, rgba(255, 255, 255, 0.25),
		rgba(255, 255, 255, 0.6)),
		linear-gradient(120deg, #fef3c7 0%, #fed7aa 38%, #dbeafe 100%);
	overflow: hidden;
	border: 1px solid rgba(255, 255, 255, 0.85);
	box-shadow: inset 0 0 0 1px rgba(255, 255, 255, 0.2);
}

.map-line {
	position: absolute;
	height: 10px;
	border-radius: 999px;
	background: rgba(255, 255, 255, 0.72);
	transform: rotate(-18deg);
}

.line1 {
	width: 360px;
	left: -60px;
	top: 84px;
}

.line2 {
	width: 420px;
	right: -120px;
	top: 168px;
	transform: rotate(24deg);
}

.line3 {
	width: 280px;
	left: 70px;
	bottom: 54px;
	transform: rotate(8deg);
}

.pin {
	position: absolute;
	width: 34px;
	height: 34px;
	background: #ff6500;
	border-radius: 50% 50% 50% 0;
	transform: rotate(-45deg);
	box-shadow: 0 12px 26px rgba(255, 101, 0, 0.32);
}

.pin::after {
	content: "";
	position: absolute;
	width: 12px;
	height: 12px;
	background: white;
	border-radius: 50%;
	left: 11px;
	top: 11px;
}

.pin-main {
	left: 50%;
	top: 43%;
}

.pin-sub1 {
	left: 22%;
	top: 62%;
	width: 24px;
	height: 24px;
	opacity: 0.75;
}

.pin-sub2 {
	right: 22%;
	top: 26%;
	width: 24px;
	height: 24px;
	opacity: 0.75;
}

.pin-sub1::after, .pin-sub2::after {
	width: 8px;
	height: 8px;
	left: 8px;
	top: 8px;
}

.recommend-card {
	position: relative;
	z-index: 3;
	margin-top: 18px;
	padding: 18px;
	border-radius: 24px;
	background: rgba(255, 255, 255, 0.92);
	border: 1px solid rgba(255, 255, 255, 0.92);
	box-shadow: 0 18px 45px rgba(31, 41, 55, 0.09);
}

.recommend-top {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 14px;
}

.recommend-title {
	font-size: 16px;
	font-weight: 950;
}

.recommend-tag {
	padding: 7px 10px;
	border-radius: 999px;
	background: #fff4e8;
	color: #ff6500;
	font-size: 11px;
	font-weight: 900;
}

.food-list {
	display: grid;
	grid-template-columns: 1fr 1fr;
	gap: 12px;
}

.food-item {
	display: flex;
	gap: 10px;
	align-items: center;
	padding: 12px;
	border-radius: 18px;
	background: #f9fafb;
	border: 1px solid #eef2f7;
}

.food-emoji {
	width: 42px;
	height: 42px;
	border-radius: 15px;
	background: white;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 23px;
	box-shadow: 0 8px 20px rgba(17, 24, 39, 0.05);
}

.food-name {
	font-size: 13px;
	font-weight: 900;
	margin-bottom: 3px;
}

.food-meta {
	font-size: 11px;
	color: #6b7280;
	font-weight: 700;
}

.section {
	max-width: 1180px;
	margin: 0 auto;
	padding: 54px 24px;
}

.section-title-area {
	text-align: center;
	margin-bottom: 30px;
}

.section-kicker {
	color: #ff6500;
	font-size: 13px;
	font-weight: 950;
	margin-bottom: 8px;
}

.section-title {
	font-size: 34px;
	font-weight: 950;
	letter-spacing: -1.5px;
	margin: 0 0 12px;
}

.section-desc {
	color: #6b7280;
	font-size: 15px;
	line-height: 1.7;
	margin: 0;
}

.feature-grid {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 18px;
}

.feature-card {
	padding: 26px;
	border-radius: 26px;
	background: rgba(255, 255, 255, 0.78);
	border: 1px solid rgba(255, 255, 255, 0.95);
	box-shadow: 0 20px 50px rgba(17, 24, 39, 0.07);
}

.feature-icon {
	width: 52px;
	height: 52px;
	border-radius: 18px;
	background: #fff3e8;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 26px;
	margin-bottom: 18px;
}

.feature-card h3 {
	margin: 0 0 10px;
	font-size: 19px;
	font-weight: 950;
}

.feature-card p {
	margin: 0;
	color: #6b7280;
	font-size: 14px;
	line-height: 1.75;
}

.popular-section {
	max-width: 1180px;
	margin: 0 auto;
	padding: 30px 24px 72px;
}

.popular-box {
	border-radius: 32px;
	background: rgba(255, 255, 255, 0.78);
	border: 1px solid rgba(255, 255, 255, 0.95);
	box-shadow: 0 24px 70px rgba(17, 24, 39, 0.08);
	padding: 28px;
}

.popular-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-end;
	gap: 16px;
	margin-bottom: 20px;
}

.popular-header h2 {
	margin: 0;
	font-size: 28px;
	font-weight: 950;
	letter-spacing: -1px;
}

.popular-header p {
	margin: 8px 0 0;
	color: #6b7280;
	font-size: 14px;
}

.view-more {
	color: #ff6500;
	font-size: 13px;
	font-weight: 950;
}

.restaurant-grid {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 16px;
}

.restaurant-card {
	overflow: hidden;
	border-radius: 24px;
	background: #ffffff;
	border: 1px solid #eef2f7;
	box-shadow: 0 12px 30px rgba(17, 24, 39, 0.06);
}

.restaurant-img {
	height: 130px;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 46px;
	background: radial-gradient(circle at 30% 20%, rgba(255, 255, 255, 0.55),
		transparent 28%), linear-gradient(135deg, #fff0dc, #ffd0a3);
}

.restaurant-body {
	padding: 15px;
}

.restaurant-name {
	font-size: 15px;
	font-weight: 950;
	margin-bottom: 7px;
}

.restaurant-info {
	font-size: 12px;
	color: #6b7280;
	line-height: 1.6;
	font-weight: 700;
}

.restaurant-rating {
	margin-top: 10px;
	color: #ff6500;
	font-size: 12px;
	font-weight: 950;
}

.footer {
	background: #111827;
	color: #d1d5db;
	padding: 34px 36px;
}

.footer-inner {
	max-width: 1180px;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
	gap: 20px;
	align-items: center;
}

.footer-logo {
	color: white;
	font-size: 24px;
	font-weight: 950;
	margin-bottom: 8px;
}

.footer-text {
	font-size: 13px;
	color: #9ca3af;
	line-height: 1.7;
}

.footer-links {
	display: flex;
	gap: 18px;
	font-size: 13px;
	font-weight: 800;
}

.footer-links a:hover {
	color: white;
}

@media ( max-width : 980px) {
	.nav {
		display: none;
	}
	.hero {
		grid-template-columns: 1fr;
		padding-top: 48px;
	}
	.hero-title {
		font-size: 43px;
	}
	.feature-grid {
		grid-template-columns: 1fr;
	}
	.restaurant-grid {
		grid-template-columns: repeat(2, 1fr);
	}
	.footer-inner {
		flex-direction: column;
		align-items: flex-start;
	}
}

@media ( max-width : 560px) {
	.header {
		padding: 0 18px;
	}
	.header-actions {
		display: none;
	}
	.hero-title {
		font-size: 36px;
	}
	.hero-panel {
		padding: 18px;
		min-height: auto;
	}
	.food-list {
		grid-template-columns: 1fr;
	}
	.restaurant-grid {
		grid-template-columns: 1fr;
	}
	.popular-header {
		align-items: flex-start;
		flex-direction: column;
	}
}

.user-name {
	display: inline-flex;
	align-items: center;
	padding: 0 12px;
	font-size: 14px;
	font-weight: 900;
	color: #111827;
	background: rgba(255, 255, 255, 0.78);
	border: 1px solid #e5e7eb;
	border-radius: 999px;
}
</style>
</head>

<body>

	<header class="header">
		<a href="${contextPath}/" class="logo"> PickEat <span
			class="logo-icon"></span>
		</a>

		<nav class="nav">
			<a href="${contextPath}/">홈</a> <a href="${contextPath}/recommend">추천</a>
			<a href="${contextPath}/restaurants">맛집 리스트</a> <a
				href="${contextPath}/review">리뷰</a> <a href="${contextPath}/mypage">마이페이지</a>
		</nav>

		<div class="header-actions">

			<c:choose>
				<c:when test="${not empty sessionScope.loginMember}">
					<span class="user-name"> ${sessionScope.loginMember.name}님 </span>

					<a href="${contextPath}/member/mypage"
						class="header-btn header-login"> 마이페이지 </a>

					<a href="${contextPath}/member/logout"
						class="header-btn header-join"> 로그아웃 </a>
				</c:when>

				<c:otherwise>
					<a href="${contextPath}/member/login"
						class="header-btn header-login"> 로그인 </a>

					<a href="${contextPath}/member/signup"
						class="header-btn header-join"> 회원가입 </a>
				</c:otherwise>
			</c:choose>

		</div>
	</header>

	<main class="main">

		<section class="hero">
			<div class="hero-content">
				<div class="hero-badge">☀️ Weather Based Restaurant Pick</div>

				<h1 class="hero-title">
					오늘 날씨엔<br> 어떤 맛집이<br> <span>딱 좋을까요?</span>
				</h1>

				<p class="hero-desc">
					PickEat은 현재 위치와 날씨, 사용자의 취향을 바탕으로<br> 지금 가장 어울리는 맛집을 추천해주는
					서비스입니다.
				</p>

				<div class="hero-buttons">
					<a href="${contextPath}/recommend" class="primary-btn">지금 추천받기</a>
					<a href="${contextPath}/restaurants" class="secondary-btn">맛집
						둘러보기</a>
				</div>

				<div class="hero-stats">
					<div class="stat-card">
						<strong>날씨</strong> <span>API 연동 예정</span>
					</div>
					<div class="stat-card">
						<strong>위치</strong> <span>지도 기반 추천</span>
					</div>
					<div class="stat-card">
						<strong>취향</strong> <span>개인 맞춤 필터</span>
					</div>
				</div>
			</div>

			<div class="hero-panel">
				<div class="weather-card">
					<div class="weather-left">
						<div class="weather-icon">☀️</div>
						<div>
							<div class="weather-title">현재 위치 날씨</div>
							<div class="weather-sub">서울 · 맑음 · 맛집 탐색 좋은 날</div>
						</div>
					</div>
					<div class="weather-temp">23℃</div>
				</div>

				<div class="map-card">
					<div class="map-line line1"></div>
					<div class="map-line line2"></div>
					<div class="map-line line3"></div>

					<div class="pin pin-main"></div>
					<div class="pin pin-sub1"></div>
					<div class="pin pin-sub2"></div>
				</div>

				<div class="recommend-card">
					<div class="recommend-top">
						<div class="recommend-title">오늘의 추천 메뉴</div>
						<div class="recommend-tag">날씨 기반</div>
					</div>

					<div class="food-list">
						<div class="food-item">
							<div class="food-emoji">🍜</div>
							<div>
								<div class="food-name">따뜻한 라멘</div>
								<div class="food-meta">쌀쌀한 날씨 추천</div>
							</div>
						</div>

						<div class="food-item">
							<div class="food-emoji">🍲</div>
							<div>
								<div class="food-name">얼큰한 찌개</div>
								<div class="food-meta">비 오는 날 추천</div>
							</div>
						</div>

						<div class="food-item">
							<div class="food-emoji">🥗</div>
							<div>
								<div class="food-name">가벼운 샐러드</div>
								<div class="food-meta">더운 날 추천</div>
							</div>
						</div>

						<div class="food-item">
							<div class="food-emoji">🍛</div>
							<div>
								<div class="food-name">든든한 카레</div>
								<div class="food-meta">혼밥 추천</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="section">
			<div class="section-title-area">
				<div class="section-kicker">SERVICE POINT</div>
				<h2 class="section-title">PickEat은 이렇게 추천해요</h2>
				<p class="section-desc">단순 맛집 목록이 아니라, 현재 상황에 맞는 음식을 먼저 생각합니다.</p>
			</div>

			<div class="feature-grid">
				<div class="feature-card">
					<div class="feature-icon">🌦️</div>
					<h3>날씨 기반 추천</h3>
					<p>맑음, 비, 더위, 추위 같은 날씨 조건을 참고해 어울리는 음식과 맛집을 추천합니다.</p>
				</div>

				<div class="feature-card">
					<div class="feature-icon">📍</div>
					<h3>현재 위치 기반</h3>
					<p>사용자의 위치를 기준으로 가까운 맛집을 보여주고, 지도 화면에서 위치를 쉽게 확인할 수 있습니다.</p>
				</div>

				<div class="feature-card">
					<div class="feature-icon">🧡</div>
					<h3>취향 맞춤 필터</h3>
					<p>선호 카테고리, 가격대, 상황별 선택을 반영해 사용자에게 더 잘 맞는 결과를 제공합니다.</p>
				</div>
			</div>
		</section>

		<section class="popular-section">
			<div class="popular-box">
				<div class="popular-header">
					<div>
						<h2>인기 맛집 미리보기</h2>
						<p>나중에 DB와 연결하면 이 영역에 실제 맛집 목록을 출력하면 됩니다.</p>
					</div>
					<a href="${contextPath}/restaurants" class="view-more">전체보기 →</a>
				</div>

				<div class="restaurant-grid">
					<div class="restaurant-card">
						<div class="restaurant-img">🍣</div>
						<div class="restaurant-body">
							<div class="restaurant-name">스시 온도</div>
							<div class="restaurant-info">
								일식 · 800m<br> 깔끔한 점심 추천
							</div>
							<div class="restaurant-rating">★ 4.8</div>
						</div>
					</div>

					<div class="restaurant-card">
						<div class="restaurant-img">🍜</div>
						<div class="restaurant-body">
							<div class="restaurant-name">라멘 하루</div>
							<div class="restaurant-info">
								라멘 · 1.2km<br> 쌀쌀한 날 추천
							</div>
							<div class="restaurant-rating">★ 4.7</div>
						</div>
					</div>

					<div class="restaurant-card">
						<div class="restaurant-img">🥩</div>
						<div class="restaurant-body">
							<div class="restaurant-name">고기집 오늘</div>
							<div class="restaurant-info">
								한식 · 650m<br> 저녁 모임 추천
							</div>
							<div class="restaurant-rating">★ 4.6</div>
						</div>
					</div>

					<div class="restaurant-card">
						<div class="restaurant-img">🍝</div>
						<div class="restaurant-body">
							<div class="restaurant-name">파스타 무드</div>
							<div class="restaurant-info">
								양식 · 950m<br> 데이트 추천
							</div>
							<div class="restaurant-rating">★ 4.5</div>
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>

	<footer class="footer">
		<div class="footer-inner">
			<div>
				<div class="footer-logo">PickEat</div>
				<div class="footer-text">
					날씨와 위치, 취향을 바탕으로 맛집을 추천하는 서비스<br> Team Project · Weather
					Restaurant Recommendation
				</div>
			</div>

			<div class="footer-links">
				<a href="${contextPath}/">홈</a> <a href="${contextPath}/recommend">추천</a>
				<a href="${contextPath}/restaurants">맛집 리스트</a> <a
					href="${contextPath}/member/login">로그인</a>
			</div>
		</div>
	</footer>

</body>
</html>