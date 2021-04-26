<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="resource/includes/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<style>
.test {
	border: 1px solid;
	width: 30%;
	height: 300px;
	float: left;
	margin: 3% 0 3% 3%;
	cursor: pointer;
}

.thumbnail {
	border: 1px solid;
	width: 80%;
	height: 55%;
	display: block;
	margin: 0 auto;
	margin-top: 15px;
}

li {
	text-align: center;
	text-decoration: none;
	list-style: none;
}

@import
	url('https://fonts.googleapis.com/css?family=Noto+Sans+KR|ZCOOL+QingKe+HuangYou')
	;

* {
	margin: 0;
	padding: 0;
	color: #000;
	font-family: 'ZCOOL QingKe HuangYou', cursive;
	box-sizing: border-box;
}

.fn-font {
	font-family: 'Noto Sans KR', sans-serif;
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
	outline: none;
}

.container {
	width: 1440px;
	margin: 0 auto;
}

header {
	width: 100%;
	height: 100px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: beige;
}

header>h2 {
	margin-left: 20px;
}

header>nav {
	width: 600px;
	height: 100%;
}

header ul {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
}

header ul>li {
	font-size: 20px;
	height: 100%;
	display: flex;
	align-items: center;
}

header ul li :hover {
	color: brown;
}
/*-----------------------------------------------------*/
.center {
	border: 2px solid;
	width: 90%;
	height: 1600px;
	margin: 0 auto;
	margin-top: 50px;
	margin-bottom: 50px;
}
/*-----------------------------------------------------*/
.footer {
	width: 100%;
	height: 200px;
	padding: 15px 0;
	text-align: center;
	color: white;
	background-color: beige;
	position: absolute;
}
</style>
<script type="text/javascript">
  (function() {
    var w = window;
    if (w.ChannelIO) {
      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
    }
    var ch = function() {
      ch.c(arguments);
    };
    ch.q = [];
    ch.c = function(args) {
      ch.q.push(args);
    };
    w.ChannelIO = ch;
    function l() {
      if (w.ChannelIOInitialized) {
        return;
      }
      w.ChannelIOInitialized = true;
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
      s.charset = 'UTF-8';
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
    if (document.readyState === 'complete') {
      l();
    } else if (window.attachEvent) {
      window.attachEvent('onload', l);
    } else {
      window.addEventListener('DOMContentLoaded', l, false);
      window.addEventListener('load', l, false);
    }
  })();
  ChannelIO('boot', {
    "pluginKey": "d500bf30-80e9-4adc-8152-4bb473354edd", //please fill with your plugin key
    "memberId": "asd@ad.com", //fill with user id
    "profile": {
      "name": "김상혁", //fill with user name
      "mobileNumber": "010-0000-0000", //fill with user phone number
      "CUSTOM_VALUE_1": "VALUE_1", //any other custom meta data
      "CUSTOM_VALUE_2": "VALUE_2"
    }
  });
</script>
<body>

	<div class="header">
		<div class="container">
			<header>
				<h2>Sangkun-Svg Portfolio</h2>
				<nav>
					<ul>
						<c:if test="${session == null}">
							<li><a href="${pageContext.request.contextPath}/signin">Login</a></li>
							<li><a href="${pageContext.request.contextPath}/signup">Join</a></li>
						</c:if>
						<c:if test="${session != null}">
							<li>${user.userName}님환영합니다.</li>
							<li><a href="${pageContext.request.contextPath}/signout">Logout</a></li>
							<li><a href="${pageContext.request.contextPath}/myInfo?n=${user.userId}">My Info</a></li>
						</c:if>
					</ul>
				</nav>
			</header>
		</div>
	</div>


	<div class="center">
		<c:forEach items="${prolist}" var="prolist">
			<div class="test" onclick="location.href='${pageContext.request.contextPath}/proInfo?n=${prolist.bno}'">

			<div class="thumbnail">
				<img src="" alt="Err">
			</div>
				<br><li>이름 : <c:out value="${prolist.proName}"/></li><br>
				<li>가격 : <c:out value="${prolist.proPrice}"/></li>
			</div>
		</c:forEach>
	</div>
	
	<div class="footer">
		<br>
		<h2>
			<p>Sangkun-svg</p>
		</h2>
		<br>
		<p>Copyrightⓒ All Right Reserved.</p>
	</div>

</body>
</html>