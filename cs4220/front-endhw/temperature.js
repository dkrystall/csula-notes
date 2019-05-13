function Convert(){
    let radio = getRadioAnswer();
    let temperature = document.getElementById("temperatureInput").value;
    
    if(temperature==""){
        alert("Temperature field is empty");
    } else {
        if (radio == "celsius"){
            toFahrenheit(temperature);
        } 
        else if (radio == "fahrenheit"){
            toCelsius(temperature);
        } 
        else {
            alert("radio button not selcted");
        }
    }
}

function getRadioAnswer(){
    let radioAnswer = document.getElementsByName("tempAnswer");
    for (var i = 0, length = radioAnswer.length; i < length; i++)
    {
        if (radioAnswer[i].checked)
        {
            return radioAnswer[i].id;
        }
    }
}

function toCelsius(amount){
    let temp = document.getElementById("tempComparison");
    var returnString = `${amount} F = ${(amount-32)*(5/9)} C`
    temp.innerHTML = returnString
}
function toFahrenheit(amount){
    let temp = document.getElementById("tempComparison");
    var returnString = `${amount} C = ${amount*(9/5)+32} F`
    temp.innerHTML = returnString
}