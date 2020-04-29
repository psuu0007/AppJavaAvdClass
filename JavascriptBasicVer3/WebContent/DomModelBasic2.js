

   window.onload = function() {

      //bigTitle 배경색
      var bigTitleObj = document.getElementById('bigTitle');
      bigTitleObj.style.backgroundColor = 'gray';
      
      
      //setLine 보더
      var setLineTagList = document.getElementsByClassName('setLine');
      for (var i = 0; i < setLineTagList.length; i++) {
         setLineTagList[i].style.border = '2px solid blue';
         setLineTagList[i].style.backgroundColor = 'red';   
      }
      
      //setColor 배경색
      var setColorTagList = document.getElementsByClassName('setColor');
      for (var i = 0; i < setColorTagList.length; i++) {
         setColorTagList[i].style.backgroundColor = 'green';   
      }      
      
      //setFont 폰트사이즈
      var setFontTagList = document.getElementsByClassName('setFont');
      for (var i = 0; i < setFontTagList.length; i++) {
         setFontTagList[i].style.fontSize = (i+1)*10+5 + 'px';
         setFontTagList[i].style.backgroundColor = 'pink';
      }      
      
      
   }

