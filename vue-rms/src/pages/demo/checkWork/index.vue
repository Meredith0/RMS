<template>
  <d2-container>
    <div aria-labelledby="myModalLabel" class="modal fade" id="addModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title">添加考勤信息</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-3 control-label" for="add_eid">工号：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="add_eid" name="eid" placeholder="工号"
                         type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="add_itime">上班时间：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="add_itime" name="itime" type="time">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="add_otime">下班时间：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="add_otime" name="otime" type="time">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">出勤：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="holiday" type="radio" value="1">
                      请假
                    </label>
                    <label>
                      <input checked name="holiday" type="radio" value="0">
                      正常
                    </label>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button class="btn btn-primary" id="ck_save_btn" type="button" @click="ck_save_btn">保存</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 编辑模态框 -->
    <div aria-labelledby="myModalLabel" class="modal fade" id="editModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title">更改考勤信息</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group" style="display: none">
                <label class="col-sm-3 control-label" for="edit_cid">cid：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="edit_cid"></p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_eid">工号：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="edit_eid"></p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_itime">上班时间：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="edit_itime" name="itime" type="time">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_otime">下班时间：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="edit_otime" name="otime" type="time">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">出勤：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="holiday" type="radio" value="1">
                      请假
                    </label>
                    <label>
                      <input checked name="holiday" type="radio" value="0">
                      正常
                    </label>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button class="btn btn-primary" id="ck_edit_btn" type="button" @click="ck_edit_btn">保存</button>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <!-- 标题-->
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <h3>考勤表</h3><hr>
        </div>
      </div>
      <!--查询-->
      <div class="row" id="search_div">
        <div style="display:inline;float:left;padding-bottom: 20px">
          <form class="my-form">
            <div class="my-form">
              <label for="s_eid">工号：</label>
              <input id="s_eid" name="eid" placeholder="工号" type="text">
            </div>
            <div class="my-form">
              <label for="s_itime">上班时间：</label>
              <input id="s_itime" name="itime" type="time">
            </div>
            <div class="my-form">
              <label for="s_otime">下班时间：</label>
              <input id="s_otime" name="otime" placeholder="下班时间" type="time">
            </div>
            <div class="my-form">
              <label for="s_holiday">假期：</label>
              <select class="span1" id="s_holiday" name="holiday">
                <option selected="selected" value="-1">空</option>
                <option value="1">请假</option>
                <option value="0">正常</option>
              </select>
            </div>
          </form>
        </div>
        <div style="float:right;padding-bottom: 20px">
          <button class="btn btn-success" id="search_btn" type="button" @click="search_btn">查询</button>
          <button class="btn btn-default" id="back_btn" type="button" @click="back_btn">退出查询</button>
          <button class="btn btn-primary" id="ck_add_btn" type="button" @click="ck_add_btn">新增</button>
          <button class="btn btn-danger" id="ck_del_btn" type="button" @click="ck_del_btn">删除</button>
        </div>
      </div>
      <!-- 表格-->
      <div class="row">
        <div class="col-md-12">
          <table class="table table-hover" id="ck_table">
            <thead>
            <tr>
              <th>
                <input id="check_all" type="checkbox" @click="check_all"/>
              </th>
              <th style="display: none">id</th>
              <th>工号</th>
              <th>上班时间</th>
              <th>下班时间</th>
              <th>假期</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div>
      </div>
      <!--分页信息-->
      <div class="row">
        <!-- 分页文字信息-->
        <div class="col-md-6" id="page_info_area">
        </div>
        <!-- 分页条-->
        <div class="col-md-6" id="page_info_nav">
        </div>
      </div>
    </div>
  </d2-container>
</template>

<script>
  import {getRequest} from "../../../utils/getRequest";
  import {postRequest} from "../../../utils/postRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";

  export default {
    name: "index",
    created() {
      to_page(1)
    },
    methods: {
      search_btn() {
        search_btn();
      },
      back_btn() {
        back_btn();
      },
      ck_add_btn() {
        ck_add_btn();
      },
      ck_del_btn() {
        ck_del_btn();
      },
      ck_edit_btn() {
        ck_edit_btn();
      },
      ck_save_btn() {
        ck_save_btn();
      },
      check_all() {
        check_all();
      }
    }
  }

  //定义全局变量
  var totalRecord, currentPage, searchState = 0;

  function to_page(pn) {

    postRequest("/checkWork/cks?pn=" + pn).then(
      result => {
        build_ck_table(result.data);
        //2、解析并显示分页信息
        build_ck_info(result.data);
        //3、解析并显示分页条信息
        build_ck_nav(result.data);
      }
    )
  }

  //判断当前是否出于查询状态
  function isSearch(pn) {
    if (searchState == 0) {
      to_page(pn)
    } else {
      to_search(pn)
    }
  }

  function build_ck_table(result) {
    $("#ck_table tbody").empty();
    var cks = result.extend.pageInfo.list;
    $.each(cks, function (index, item) {
      //alert(item.empName);
      var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
      var cidTd = $("<td style='display:none'></td>").append(item.cid);
      var eidTd = $("<td></td>").append(item.eid);
      var itimeTd = $("<td></td>").append(item.itime);
      var otimeTd = $("<td></td>").append(item.otime);
      var holidayTd = $("<td></td>").append(item.holiday == '1' ? "请假" : "正常");
      var edtBtn = $("<button></button>").addClass("btn btn-warning btn-sm ck_edit_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" ").append("编辑");
      //为编辑按钮添加一个自定义的属性，来表示当前员工id
      edtBtn.attr("edit-id", item.cid);
      var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-trash")).append(" ").append("删除");
      //为删除按钮添加一个自定义的属性来表示当前删除的员工id
      delBtn.attr("del-id", item.cid);
      var btnTd = $("<td></td>").append(edtBtn).append(" ").append(delBtn);
      $("<tr></tr>").append(checkBoxTd)
      .append(cidTd)
      .append(eidTd)
      .append(itimeTd)
      .append(otimeTd)
      .append(holidayTd)
      .append(btnTd)
      .appendTo("#ck_table tbody");
    });
  }

  function build_ck_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前为第" + result.extend.pageInfo.pageNum + "页，总共有" +
      result.extend.pageInfo.pages + "页，总共有" +
      result.extend.pageInfo.total + "条记录");
    totalRecord = result.extend.pageInfo.total;
    currentPage = result.extend.pageInfo.pageNum;
  }

  function build_ck_nav(result) {
    $("#page_info_nav").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    //构建li元素
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"))
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    //如果没有下一页，则这两个按钮不能点
    if (result.extend.pageInfo.hasPreviousPage == false) {
      firstPageLi.addClass("disabled");
      prePageLi.addClass("disabled");
    } else {
      //为元素添加翻页事件
      firstPageLi.click(function () {
        isSearch(1);
      });
      prePageLi.click(function () {
        isSearch(result.extend.pageInfo.pageNum - 1);
      });
    }

    //添加首页和前一页的提示
    ul.append(firstPageLi).append(prePageLi);

    //遍历navigatepageNums页码提示
    $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
      var numLi = $("<li></li>").append($("<a></a>").append(item));
      if (result.extend.pageInfo.pageNum == item) {
        numLi.addClass("active");
      }
      //添加条目单击事件
      numLi.click(function () {
        isSearch(item);
      });
      ul.append(numLi);
    })

    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"))
    if (result.extend.pageInfo.hasNextPage == false) {
      nextPageLi.addClass("disabled");
      lastPageLi.addClass("disabled");
    } else {
      //为元素添加翻页事件
      nextPageLi.click(function () {
        isSearch(result.extend.pageInfo.pageNum + 1);
      });
      lastPageLi.click(function () {
        isSearch(result.extend.pageInfo.pages);
      });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_info_nav");
  }

  //查询按钮
  function search_btn(pn) {
    searchState = 1
    to_search(1)
  };

  function back_btn(pn) {
    searchState = 0
    $("#s_eid").val("")
    $("#s_itime").val("")
    $("#s_otime").val("")
    $("#s_holiday").val("")
    to_page(1)
  };

  //处理form提交的数据
  function doFormData(data) {
    if ($("#s_eid").val() == "") {
      data = data.split("eid=").join('')
    }
    if ($("#s_itime").val() == "") {
      data = data.split("&itime=").join('')
    }
    if ($("#s_otime").val() == "") {
      data = data.split("&otime=").join('')
    }
    if ($("#s_holiday").val() == "") {
      data = data.split("&holiday=").join('')
    }
    //去掉开头的&号
    if (data.charAt(0) == "&") {
      data = data.slice(1)
    }
    return data
  }

  //查询事件
  function to_search(pn) {
    // console.log($("#search_div form").serialize())
    var data = doFormData($("#search_div form").serialize());

    postRequest("/checkWork/search/" + pn, data).then(
      result => {
        build_ck_table(result.data);
        build_ck_info(result.data);
        build_ck_nav(result.data);
      }
    )
  }

  //按钮事件,弹出新增模态框
  //新增按钮
  function ck_add_btn() {
    $('#addModal').modal({
      backdrop: 'static'
    });
  };
  //编辑按钮
  var updateId ;
  $(document).on("click", ".ck_edit_btn", function () {
    //先查出对应cid的考勤信息
    updateId = $(this).attr("edit-id");
    getCkByCid($(this).attr("edit-id"));
    //2、把员工的id传递给模态框的更新按钮
    $("#ck_edit_btn").attr("edit-id", $(this).attr("edit-id"));
    $('#editModal').modal({
      backdrop: 'static'
    });
  });

  //添加操作保存按钮
  function ck_save_btn() {
    // console.log($("#addModal form").serialize())
    // $.ajax({
    //   url: "${path}/addCk",
    //   type: "POST",
    //   data: $("#addModal form").serialize(),
    //   success: function (result) {
    //     //数据保存成功，关闭模态框
    //     $('#addModal').modal('hide');
    //     //到最后一页，显示刚才保存的数据
    //     //发送ajax请求显示最后一页数据即可
    //     to_page(totalRecord);
    //   }
    // });
    postRequest("/checkWork/addCk", $("#addModal form").serialize()).then(
      res => {
        $('#addModal').modal('hide');
        //到最后一页，显示刚才保存的数据
        //发送ajax请求显示最后一页数据即可
        to_page(totalRecord);
      }
    )
  };

  //更新操作保存按钮
  function ck_edit_btn() {
    // $.ajax({
    //   url: "${path}/editCk/" + $(this).attr("edit-id"),
    //   type: "POST",
    //   data: $("#editModal form").serialize(),
    //   success: function (result) {
    //     //模态框关闭
    //     $('#editModal').modal('hide');
    //     //来到本页，显示刚才保存的数据
    //     //发送ajax请求显示本页数据即可
    //     to_page(currentPage);
    //   }
    // });
    postRequest("/checkWork/editCk/" + updateId, $("#editModal form").serialize()).then(
      res => {
        $('#editModal').modal('hide');
        //来到本页，显示刚才保存的数据
        //发送ajax请求显示本页数据即可
        to_page(currentPage);
      }
    )
  };

  //修改时候获取原有的信息
  function getCkByCid(cid) {
    // $.ajax({
    //   url:"${path}/ck/" + cid,
    //   type:"GET",
    //   success:function(result){
    //     // console.log(result);
    //     var ck = result.extend.checkwork;
    //     $("#edit_cid").text(ck.cid);
    //     $("#edit_eid").text(ck.eid);
    //     $("#edit_itime").val(ck.itime);
    //     $("#edit_otime").val(ck.otime);
    //     $("#editModal input[name = holiday]").val([ck.holiday]);
    //   },
    //   failed:function (err) {
    //     console.log(err)
    //   }
    // });
    getRequest("/checkWork/ck/" + cid).then(
      result => {
        var ck = result.data.extend.checkwork;
        $("#edit_cid").text(ck.cid);
        $("#edit_eid").text(ck.eid);
        $("#edit_itime").val(ck.itime);
        $("#edit_otime").val(ck.otime);
        $("#editModal input[name = holiday]").val([ck.holiday]);
      }
    )
  }

  //删除单条记录
  $(document).on("click", ".delete_btn", function () {
    //弹出是否确认删除对话框
    // alert($(this).parents("tr").find("td:eq(1)").text());
    var eid = $(this).parents("tr").find("td:eq(2)").text();
    var cid = $(this).attr("del-id");
    if (confirm("确认删除工号 " + eid + " 吗？")) {
      //确认，发送ajax请求删除即可
      // $.ajax({
      //   url: "${path}/delCk/" + cid,
      //   type: "DELETE",
      //   success: function (result) {
      //     // alert(result.msg);
      //     //回到本页
      //     to_page(currentPage);
      //   }
      // });
      deleteRequest("/checkWork/delCk/" + cid).then(
        res => {
          to_page(currentPage);
        }
      )
    }
  });

  //完成全选/全部不选功能
  function check_all() {
    //attr获取checked是undefined;
    //我们这些dom原生的属性；attr获取自定义属性的值；
    //prop修改和读取dom原生属性的值
    //全选与全部不选
    $(".check_item").prop("checked", $(this).prop("checked"));
  };
  //check_item当表中的item全选了，表头的全选按钮也选中
  $(document).on("click", ".check_item", function () {
    //判断是否全选
    // alert($(".check_item:checked").length)
    var flag = $(".check_item:checked").length == $(".check_item").length;
    $("#check_all").prop("checked", flag);
  });

  //点击全部删除
  function ck_del_btn() {
    var eids = "";
    var del_idstr = "";
    $.each($(".check_item:checked"), function () {
      // alert( $(this).parents("tr").find("td:eq(2)").text());
      eids += $(this).parents("tr").find("td:eq(2)").text() + ",";
      del_idstr += $(this).parents("tr").find("td:eq(1)").text() + ",";
    });
    eids = eids.substring(0, eids.length - 1);
    del_idstr = del_idstr.substring(0, del_idstr.length - 1);
    //alert(del_idstr);
    if (confirm("确认删除【" + eids + "】吗？")) {
      //发送ajax请求删除
      // $.ajax({
      //   url: "${path}/delCk/" + del_idstr,
      //   type: "DELETE",
      //   success: function (result) {
      //     // alert(result.msg);
      //     //回到当前页面
      //     to_page(currentPage);
      //   }
      // });
      deleteRequest("/checkWork/delCk/" + del_idstr).then(
        res => {
          to_page(currentPage);

        }
      )
    }
  };

</script>

<style scoped>
  .my-form {
    display: inline;
    padding-left: 20px;
    padding-bottom: 20px;
  }
</style>
