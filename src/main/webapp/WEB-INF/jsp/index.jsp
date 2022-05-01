<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" sizes="96x96" href="/img/favicon-96x96.png">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/index.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/4251e77ff2.js" crossorigin="anonymous"></script>
    <style>
        body, h1, h2, h3, h4, h5, h6, p, span, div {
            font-family: 'Pretendard';
        }
    </style>
    <title>단고리즘</title>
</head>
<body>
    <!-- 메뉴바 -->
    <header class="border-bottom pt-1 pb-1 " style="border-color: grey; border-bottom: 2rem">
        <nav class="navbar navbar-expand-lg navbar-light mx-5 fs-6">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp"><img src="/img/logo.png" height="50px"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item ms-5">
                            <a class="nav-link" aria-current="page" href="#"><i class="fa-solid fa-book"></i>&nbsp;&nbsp;문제</a>
                        </li>
                        <li class="nav-item ms-3">
                            <a class="nav-link" href="#"><i class="fa-solid fa-trophy"></i>&nbsp;&nbsp;대회</a>
                        </li>
                        <li class="nav-item dropdown ms-3">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fa-solid fa-user-group"></i>&nbsp;&nbsp;그룹
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">팀 정보</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">내 팀으로 이동</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- 로그인 전 -->
                    <ul class="navbar-nav">
                        <li class="nav-item ms-3">
                            <a class="nav-link" aria-current="page" href="#">&nbsp;로그인</a>
                        </li><li class="nav-item ms-3">
                            <a class="nav-link" aria-current="page" href="#">&nbsp;회원가입</a>
                        </li>
                    </ul>
                    <!-- 로그인 후
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                ghdcks33
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">로그아웃</a></li>
                            </ul>
                        </li>
                    </ul>
                -->
                </div>
            </div>
        </nav>
    </header>
    <!-- 여기까지 메뉴바 -->
    
    <section class="mt-5 ps-5" style="background: #FFFEFE;box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);border-radius: 10px;">
        <div class="container position-absolute px-5" style="background: #FFFEFE;box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);border-radius: 10px;">
            <div class="row">
                <div class="col mt-5 ms-5">
                    <h1 class="mg">공지사항</h1>
                </div>
            </div>
            <div class="row" style="height: 60px;">
        
            </div>
            

            <div class="row mx-1 text-center mx-5">
                <div class="row rowHead fs-4 pb-1 mb-2" style="font-weight: bold; border-bottom:1px solid black;">
                    <div class="col-md-2">날짜</div>
                    <div class="col-md-8">내용</div>
                    <div class="col-md-2">작성자</div>
                </div>
                <!-- DB를 이용한 처리가 필요한 부분 -->
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-04</div>
                    <div class="col-md-8">문제가 나타나지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">대회 타이머가 동작하지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">추가된 문제 업데이트</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-04</div>
                    <div class="col-md-8">문제가 나타나지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">대회 타이머가 동작하지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">추가된 문제 업데이트</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-04</div>
                    <div class="col-md-8">문제가 나타나지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">대회 타이머가 동작하지 않는 오류 수정</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <div class="row fs-6 mb-2">
                    <div class="col-md-2">2022-04-01</div>
                    <div class="col-md-8">추가된 문제 업데이트</div>
                    <div class="col-md-2">ghdcks33</div>
                </div>
                <!-- -->
            </div>
            <div style="height: 30px;;"></div>
            <div style="height: 50px;text-align:right;padding-right:3rem;">
                <button style="width: 100px; color:white; font-weight:bold;">글쓰기</button>
            </div>
            <div style="text-align: center;">
                <button><i class="fa-solid fa-chevron-left"></i></button><button><i class="fa-solid fa-chevron-right"></i></button>
            </div>
            <div style="height: 50px;"></div>
        </div>
        <div class="bg_logo"></div>
    </section>
    
    <footer style="background: rgba(196, 196, 196, 0.63); height:200px;font-size:0.8rem">
        <div style="margin:0 auto;text-align:center;color: #707070;">
            <br/><br/>
            <strong>DanGorithm Dankook univ. OJ</strong><br /> 
            Copyright ⓒ 2022. Ver.1.0.0<br/>
            문제해결을위한 자바활용 1분반 Group 4 (서지현, 신승경, 홍찬희)<br />
        </div>
    </footer>
</body>
</html>