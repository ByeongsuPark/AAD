# TIL(Today's I learned)
## Git에서의 병합 충돌(merge conflict) 해결  
  
    
  ![Example of Merge conflict](https://i.stack.imgur.com/9HUTt.png)

  위의 그림에서 볼 수 있듯, 두번째 과정에서 Git은 파일을 cat으로 바꿔야할지  
  dog로 바꾸어야 할지 모르게 된다. 이 때 생기는 것이 merge conflict로 
  주로 아래 방법으로 해결이 가능하다.  

   1. origin에서 project를 pull해서 최신 변경사항 동기화
   2. 이 후 원하는 부분 수정
   3. 다시 Push 하면 충돌 없이 정상적으로 push


