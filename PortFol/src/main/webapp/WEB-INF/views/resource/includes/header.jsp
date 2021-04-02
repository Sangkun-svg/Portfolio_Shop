<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+KR|ZCOOL+QingKe+HuangYou');

* {
	margin:0;
	padding:0;
	color:#000;
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
	width:1440px;
	margin:0 auto;
}

header {
	width:100%;
	height:100px;
	display: flex;
	align-items: center;
	justify-content: space-between;
   background-color: beige;
}
header > h2 {
	margin-left:20px;
}

header > nav {
	width:600px;
	height:100%;
}

header ul {
	width:100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
}

header ul > li {
	font-size:20px;
	height: 100%;
	display: flex;
	align-items: center;
}
header ul li :hover{
   color: brown;
}
</style>
<body>
    <div class="header">  
        <div class="container">
            <header>
                <h2>Sangkun-Svg Portfolio</h2>
                <nav>
                    <ul>
                        <li><a href="#">Login</a></li>
                        <li><a href="">Join</a></li>
                        <li><a href="">My Info</a></li>
                    </ul>
                </nav>
            </header>
        </div>            
    </div>
</body>