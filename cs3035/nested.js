function main(){
  var x;
  function bigsub(){ //static parent of sub1
    var a,b,c;
    function sub1(){ //this methods static parent is bigsub
      var a,d;
      a=b+c;
    }
    function sub2(x){
      var b,e;
      function sub3(){ //static parent is sub2
        var c,e;
        sub1();
        e = b+a;
      }
      sub3();
      a = d+e;
    }
    sub2(7);
  }
  bigsub();
}
//Where it's defined is it's static scoping
