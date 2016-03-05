var count = 1; /*从id为1开始动态增加*/

function additem() {  //确认意向时的动态添加信息
	count += 1;
	var carNums = $("#carNumsString").val();
	var drivers = $("#driversString").val();
    var carNum = carNums.split(",");
    var driver = drivers.split(",");
    var dymcity = document.getElementById("dym_itemlist");
    var div = document.createElement("div");

	var inputTxt2 = document.createElement("select");  //section-输入框
		inputTxt2.options[0] = new Option("选择车牌号", "");
		for(var i=1;i<=carNum.length;i++){
			inputTxt2.options[i] = new Option(carNum[i-1], carNum[i-1]);
		}
		inputTxt2.size = "1";
		inputTxt2.className = 'input_mgmt2a';
		inputTxt2.name = 'carNum'+count;
		inputTxt2.id = 'carNum'+count;

	var inputTxt2a = document.createElement("span");  //section-输入框
		inputTxt2a.className = 'span_mgmt_dynamic1';
		inputTxt2a.innerHTML = '&nbsp;--&nbsp;';

	var inputTxt3 = document.createElement("select");  //section-输入框
		inputTxt3.options[0] = new Option("选择随车司机", "");
		for(var i=1;i<=driver.length;i++){
			inputTxt3.options[i] = new Option(driver[i-1], driver[i-1]);
		}
		inputTxt3.size = "1";
		inputTxt3.className = 'input_mgmt2a';
		inputTxt3.name = 'driver'+count;
		inputTxt3.id = 'driver'+count;
    
	var inputTxt3a = document.createElement("span");  //section-输入框
		inputTxt3a.className = 'span_mgmt_dynamic1';
		inputTxt3a.innerHTML = '&nbsp;--&nbsp;';
		
	var inputTxt4 = document.createElement("input");  //section-输入框
		inputTxt4.type = 'text';
		inputTxt4.id = 'waybillNum'+count;
		inputTxt4.name = 'waybillNum'+count;
		inputTxt4.className = 'input_mgmt2';
		inputTxt4.placeholder = '请输入运单号...';
		inputTxt4.required = 'true';
		
	var del = document.createElement("img"); //section-删除
		del.src = "../images/btn_cancel2.png";
		del.className = "img_citydel";
		del.alt = "删除";
		del.onclick = function() { //删除后效果，包括计数
			this.parentNode.parentNode.removeChild(this.parentNode);
			var n = citylist.getElementsByTagName("div");
			for(var k=0; k<n.length; k++) {
				n[k].firstChild.nodeValue = k+1;
			}
			count -= 1;
		}

//页面显示内容的控制
div.appendChild(inputTxt2);
div.appendChild(inputTxt2a);
div.appendChild(inputTxt3);
div.appendChild(inputTxt3a);
div.appendChild(inputTxt4);
div.appendChild(del);
dymcity.appendChild(div);

$(function() {
	$('input, textarea').placeholder(); 
});

}
