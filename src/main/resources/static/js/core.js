function billType(type) {
    $.get('billTypes', null, function (data) {
        var $selecor = $('#billsType');
        data = eval(data.data);
        if(type == 1){
            $selecor.append('<option value="">请选择</option>');
            if (data.length > 0) {
                for (i = 0; i < data.length; i++) {
                    var $type = $('<option value="' + data[i].id + '">' + data[i].name + '</option>')
                    $selecor.append($type);
                }
            }
        }else{
            var $types = $('#types');
            for (i = 0; i < data.length; i++) {
                var $input = $('<input type="radio" name="billType.id" value="'+data[i].id+'" />');
                var $span = $('<span>'+data[i].name+'</span>');
                $types.append($input);
                $types.append($span);
            }
        }
    }, 'json');
}

function PageSupport() {
    this.pageNo = 1;
    this.pageSize = 10;
    this.pageCount = 1;
    this.dataCount = 0;
    this.data = null;
    this.getData = function (pageNo, pageSize,billsType,startDate, endDate) {
        if (pageNo > this.pageCount) {
            alert('后面木有了~');
            return;
        }
        if (pageNo < 0) {
            alert('前面木有了~');
            return;
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        $.get("bills", {
            "pageNo": this.pageNo, "pageSize": this.pageSize,
            "billsType": billsType, "startDate": startDate, "endDate": endDate
        },function (data) {
            if(data.state == 200){
                this.dataCount = data.data.dataCount;
                var s = eval(data.data.data);
                var $table = $('table');
                var $title = $('.title');
                $table.html('');
                $table.append($title);
                if(s.length <= 0){
                    $table.append('<tr><td rowspan="3" colspan="8"><h2>没有找到任何账单信息</h2></td></tr>');
                    return;
                }
                for(i = 0;i<s.length;i++){
                    if(i % 2 === 0){
                        var $tr = $('<tr style="background-color: darkgray;"></tr>');
                    }else{
                        var $tr = $('<tr></tr>');
                    }
                    var $td = $('<td width="100px">'+s[i].title+'</td>');
                    $tr.append($td);
                    $td = $('<td colspan="3" width="200px">'+s[i].bill_time+'</td>');
                    $tr.append($td);
                    $td = $('<td width="100px">'+s[i].billType.name+'</td>');
                    $tr.append($td);
                    var type_id = s[i].billType.id
                    if(type_id === 1 || type_id === 4 || type_id === 7){
                        $td = $('<td width="100px" align="right">-'+s[i].price+'元</td>');
                    }else{
                        $td = $('<td width="100px" align="right">+'+s[i].price+'元</td>');
                    }
                    $tr.append($td);
                    $td = $('<td colspan="2" width="150px">'+s[i].explain+'</td>');
                    $tr.append($td);
                    $table.append($tr);
                }
            }else{
                alert(data.msg);
            }
        },'json');
    }
}