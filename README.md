# algorithmsite

## 🗂 배포
![](https://velog.velcdn.com/images/sgh9702/post/cde904b5-6a44-47fd-b892-fa3c08c902d1/image.png) <br>
로드밸런싱 완료<br><br>
나중에 CI구축, 무중단 배포, Auto Scaling 진행 예정
<br/><br/>


## 🗂 데이터베이스 설계

<img width="636" alt="스크린샷 2022-04-29 오후 8 19 16" src="https://user-images.githubusercontent.com/79779676/165934708-77984fa3-703e-4919-9585-56bdec9cb90b.png">

<br/><br/>

## 🗂 백준 웹크롤링

Jsoup 라이브러리를 사용하여 웹크롤링을 진행했다. (공통 클래스 찾기와 img태그에서 src 값을 빼오는 코드를 생각하는게 오래걸렸다.)

데이터가 총 20000개 이상인데, 이걸 한번에 처리하려니까 계속 Exception이 터져서 100개씩 끊어서 데이터베이스에 추가했다.

그림과같이 백준의 모든 문제를 데이터베이스에 추가했다.

<img width="700" alt="스크린샷 2022-04-29 오후 8 10 00" src="https://user-images.githubusercontent.com/79779676/165934037-5943a921-eb86-4f15-9be8-f45aea51ed21.png">

```java
    @Transactional
    public int refreshAllProblem(){
        try {
            int page_num = 1;
            while (true) {
                List<Problem> problems = new ArrayList<>();

                String CUR_URL = BOJ_PROBLEM_URL + page_num;
                Document document = Jsoup.connect(CUR_URL).userAgent("Mozilla").get();
                Elements problem_number = document.select(".hysUdN"); // 클래스를 이용해서 문제 번호 검색
                Elements problem_name = document.select(".__Latex__"); // 클래스를 이용해서 문제 이름 검색
                Elements tier_url = document.select("img[src$=.svg]"); // img태그의 src가 끝이 .svg끝나는 태그 검색

                if (tier_url.size() == 0) break; // 검색되는게 없으면 멈추기
                
                for (int i = 0; i < tier_url.size(); i++) {
                    Problem problem = Problem.builder()
                            .problem_number(Integer.parseInt(problem_number.get(i).text())) // 불필요한 태그를 제거하고 텍스트부분만 추출
                            .problem_name(problem_name.get(i).text()) // 불필요한 태그를 제거하고 텍스트부분만 추출
                            .tier_url(tier_url.get(i).attr("src")) // tier_url 객체의 src 옵션 정보를 가져옴.
                            .build();
                    problems.add(problem);
                }
                problemRepository.saveAll(problems); // 100개씩 저장
                page_num++;
            }
            return HttpStatus.OK.value();
        }catch (IOException e){
            log.warn("ProblemService refreshAllProblem IOException");
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
    }
```
