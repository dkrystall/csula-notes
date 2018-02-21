/* addX
* returns function(y)
*/
function addX(x){  //referencing envinronment of the closure is preserved, which is why the x value is saved in func(y)
  return function(y){
    return x+y;
  };
};

var add10 = addX(10); //Stores function(y), the 10 is saved in add10
console.log(add10(3)); //returns 13

console.log(addX(40)(20)); // calls addX then calls anon function(y) x = 40, y = 20;
// OR
var add40 = addX(40);
console.log(add40(20));


for(var i = 0; i <5; i++){
  console.log(add10(i)); //
}
