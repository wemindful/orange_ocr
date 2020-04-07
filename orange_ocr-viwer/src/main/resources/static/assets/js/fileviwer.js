jQuery.DuoImgsYulan = function(file, id) {
    for (var i = 0; i < 3; i++) {
        if (file[i].size > 320 * 480) {
            alert("图片不能大于500kb");
            continue;
        }
        var img;
        console.log(document.getElementById("fileImg"));
        console.log(file[i]);
        console.log("file-size=" + file[i].size);
        var reader = new FileReader();
        reader.onloadstart = function(e) {
            console.log("开始读取....");
        }
        reader.onprogress = function(e) {
            console.log("正在读取中....");
        }
        reader.onabort = function(e) {
            console.log("中断读取....");
        }
        reader.onerror = function(e) {
            console.log("读取异常....");
        }
        reader.onload = function(e) {
            console.log("成功读取....");
            var div = document.createElement("div"); //外层 div
            div.setAttribute("style", "position:relative;width:inherit;height:inherit;float:left;z-index:2;width:150px;margin-left:8px;margin-right:8px;");
            var del = document.createElement("div"); //删除按钮div
            del.setAttribute("style", "position: absolute; bottom: 4px; right: 0px; z-index: 99; width: 30px; height:30px;border-radius:50%;")
            var delicon = document.createElement("img");
            /*delicon.setAttribute("src", "http://www.jq22.com/tp/f26c324f-24db-4f08-91d6-f7ffc9ca1516.png");*/
            delicon.setAttribute("title", "删除");
            delicon.setAttribute("style", "cursor:pointer;width: 30px; height:30px");
            del.onclick = function() {
                this.parentNode.parentNode.removeChild(this.parentElement);
                ClearfirtsImg();
            };
            del.appendChild(delicon);
            div.appendChild(del);
            var imgs = document.createElement("img"); //上传的图片
            imgs.setAttribute("name", "loadimgs");
            imgs.setAttribute("src", e.target.result);
            imgs.setAttribute("width", 300);
            if (document.getElementById(id).childNodes.length > 1) {
                document.getElementById(id).removeChild(document.getElementById(id).firstChild);
            }
            div.appendChild(imgs)
            document.getElementById(id).appendChild(div);
			// 调用上传接口
			uploadImg();
        }
        reader.readAsDataURL(file[i]);
    }
}

function FirstImg() {
    $.DuoImgsYulan(document.getElementById("FirstfileImg").files, "ccc");
}

function ClearfirtsImg() {
    var file = $("#FirstfileImg")
    file.after(file.clone().val(""));
    file.remove();
}
// 上传图片
function uploadImg() {
	// 校验是否登录
    $("#ocr_result").html("");
    //debugger;
    if($("#firstImg").val() !== "") {
		var progress = $.AMUI.progress;
		 progress.start();
        var formdata=new FormData();
        formdata.append('fileName',$('#FirstfileImg').get(0).files[0]);
        $.ajax({
            async: false,
            type: 'POST',
            url: "/imageUpload",
            dataType: 'json',
            data: formdata,
            contentType:false,//ajax上传图片需要添加
            processData:false,//ajax上传图片需要添加
            success: function (data) {
                $("#ocr_result").html(data.ocr_result);
                alert(data.result_msg);
            },
            error: function (e) {
                alert("error");
            }
        })
    } else {
        js.showMessage("请先选择文件");
    }
}
