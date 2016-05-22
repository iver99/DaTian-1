/**
 * check the extention of uploaded file
 */
//文档和图片都可以上传
function fileChange(value){
		var file_ext=new Array();
		file_ext[0]="zip";
		file_ext[1]="doc";
		file_ext[3]="docx";
		file_ext[4]="xls";
		file_ext[5]="txt";
		file_ext[6]="jpg";
		file_ext[7]="png";
		file_ext[8]="gif";
		file_ext[9]="bmp";
		file_ext[10]="jpeg";
		ext=value.split(".")[1];
		for(x in file_ext){
			if( ext== file_ext[x]){
				return true;
			}
		}
		//格式不符合，清空文件信息并提示用户
		$("#upload_btn4").val(undefined);
		$("#apply_attachment1").val("");
		alert("文件格式不正确，只能上传zip,doc,docx,txt,xls,jpg,png,jpeg,gif,bmp格式！");
        return false;
	}

//只能上传图片 
function fileChangePicOnly(value){
	var file_ext=new Array();
	file_ext[0]="jpg";
	file_ext[1]="png";
	file_ext[2]="gif";
	file_ext[3]="bmp";
	file_ext[4]="jpeg";
	ext=value.split(".")[1];
	for(x in file_ext){
		if( ext== file_ext[x]){
			return true;
		}
	}
	//格式不符合，清空文件信息并提示用户
	$("#upload_btn4").val(undefined);
	$("#apply_attachment1").val("");
	alert("文件格式不正确，只能上传jpg,png,jpeg,gif,bmp格式！");
    return false;
}
function fileChangeDocOnly(value){
	var file_ext=new Array();
	file_ext[0]="zip";
	file_ext[1]="doc";
	file_ext[3]="docx";
	file_ext[4]="xls";
	file_ext[5]="txt";
	ext=value.split(".")[1];
	for(x in file_ext){
		if( ext== file_ext[x]){
			return true;
		}
	}
	//格式不符合，清空文件信息并提示用户
	$("#upload_btn4").val(undefined);
	$("#apply_attachment1").val("");
	alert("文件格式不正确，只能上传zip,doc,docx,txt,xls格式！");
    return false;
}

function fileChangeZipOnly(value){
	ext=value.split(".")[1];
	if( ext== "zip"){
		return true;
	}
	//格式不符合，清空文件信息并提示用户
	$("#upload_btn4").val(undefined);
	$("#apply_attachment1").val("");
	alert("文件格式不正确，只能上传zip格式！");
    return false;
}