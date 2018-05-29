# TIL (Today's I Learned)
## Spinner에서 onItemSelected() 메서드의 자동호출에 대하여
  ```
  spinner.setOnItemSelectedListener(this);
  ```  

  위 코드 구문은 자동적으로 onItemSelected() 리스너를 호출하게 된다.  
  보통 setOnItemSelectedListener()는 onCreate()메서드 블럭 안에서 호출되므로   
  실행 때 한번, 유저가 스피너에서 아이템을 선택했을 때 한 번.  
  총 두번 호출 된다. 이를 막기 위해서는 아래 두 가지 방법 중 하나를 쓰면 된다.
  
  1. onItemSelected() 메서드 안에 호출 횟수를 측정하는 변수 설정 

         public void onItemSelected(AdapterView<?> parent, View view, int  position, long id)     
          {  
           if( ++check > 1 ){  
            // Some executions...
           }
          }
  
  2. setSelected와 setSelection 메서드를 설정
  
            spinner.setAdapter(adapter);
            spinner.setSelected(false); // must
            spinner.setSelection(0, false); // must
            spinner.setOnItemSelectedListener(this);




   두 경우를 통해서 스피너의 onItemSelected()메서드가 중복호출 되는 것을 막을 수 있다.
   그러나 두번째 경우에는 선택된 아이템을 가져오지 못하는 경우가 있으므로 첫번째 방법을 권한다. 
