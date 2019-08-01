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
            <center><h4 class="modal-title">添加考勤状况信息</h4></center>

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
                <label class="col-sm-3 control-label" for="add_cyear">签到年份：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="add_cyear" max="9999" min="1945" name="cyear"
                         placeholder="签到年份"
                         type="number">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="add_cmonth">签到月份：</label>
                <div class="col-sm-6">
                  <select class="form-control" id="add_cmonth" name="cmonth">
                    <option selected="selected" value="">空</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                  </select>

                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">出勤：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="atwork" type="radio" value="1">
                      请假
                    </label>
                    <label>
                      <input checked name="atwork" type="radio" value="0">
                      正常
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">迟到：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="late" type="radio" value="1">
                      是
                    </label>
                    <label>
                      <input checked name="late" type="radio" value="0">
                      否
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">早退：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="early" type="radio" value="1">
                      是
                    </label>
                    <label>
                      <input checked name="early" type="radio" value="0">
                      否
                    </label>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button @click="cs_save_btn" class="btn btn-primary" id="cs_save_btn" type="button">保存
            </button>
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
            <center><h4 class="modal-title">更改考勤状态信息</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group" style="display: none">
                <label class="col-sm-3 control-label" for="edit_id">id：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="edit_id"></p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_eid">工号：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="edit_eid"></p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_cyear">签到年份：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="edit_cyear" max="9999" min="1945" name="cyear"
                         placeholder="签到年份"
                         type="number">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="edit_cmonth">签到月份：</label>
                <div class="col-sm-6">
                  <select class="form-control" id="edit_cmonth" name="cmonth">
                    <option selected="selected" value="">空</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                  </select>

                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">出勤：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="atwork" type="radio" value="1">
                      请假
                    </label>
                    <label>
                      <input checked name="atwork" type="radio" value="0">
                      正常
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">迟到：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="late" type="radio" value="1">
                      是
                    </label>
                    <label>
                      <input checked name="late" type="radio" value="0">
                      否
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">早退：</label>
                <div class="col-sm-6">
                  <div class="radio">
                    <label>
                      <input name="early" type="radio" value="1">
                      是
                    </label>
                    <label>
                      <input checked name="early" type="radio" value="0">
                      否
                    </label>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button @click="cs_edit_btn" class="btn btn-primary" id="cs_edit_btn" type="button">保存
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <!-- 标题-->
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <h3>考勤状况表</h3>
          <hr>
        </div>
      </div>
      <!--查询-->
      <div class="row" id="search_div">
        <div style="display: inline;float: left;padding-bottom: 20px">
          <form class="my-form">
            <div class="my-form">
              <label for="s_eid">工号：</label>
              <input id="s_eid" name="eid" placeholder="工号" type="text">
            </div>
            <div class="my-form">
              <label for="s_cyear">年份：</label>
              <input id="s_cyear" max="9999" min="1945" name="cyear" placeholder="年份" type="number">
            </div>
            <div class="my-form">
              <label for="s_cmonth">月份：</label>
              <select class="" id="s_cmonth" name="cmonth">
                <option selected="selected" value="">空</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
            </div>
            <div class="my-form">
              <label for="s_atwork">出勤：</label>
              <select class="" id="s_atwork" name="atwork">
                <option selected="selected" value="-1">空</option>
                <option value="1">请假</option>
                <option value="0">正常</option>
              </select>
            </div>
            <div class="my-form">
              <label for="s_late">迟到：</label>
              <select class="" id="s_late" name="late">
                <option selected="selected" value="-1">空</option>
                <option value="1">是</option>
                <option value="0">否</option>
              </select>
            </div>
            <div class="my-form">
              <label for="s_early">早退：</label>
              <select class="" id="s_early" name="early">
                <option selected="selected" value="-1">空</option>
                <option value="1">是</option>
                <option value="0">否</option>
              </select>
            </div>
          </form>
        </div>
        <div style="float:right;padding-left: 20px">
          <button @click="search_btn" class="btn btn-success" id="search_btn" type="button">查询
          </button>
          <button @click="back_btn" class="btn btn-default" id="back_btn" type="button">退出查询
          </button>
          <button @click="cs_add_btn" class="btn btn-primary" id="cs_add_btn" type="button">新增
          </button>
          <button @click="cs_del_btn" class="btn btn-danger" id="cs_del_btn" type="button">删除
          </button>
        </div>
      </div>

      <!--     表格-->
      <div class="row">
        <div class="col-md-12">
          <table class="table table-hover" id="cs_table">
            <thead>
            <tr>
              <th>
                <input @click="check_all" id="check_all" type="checkbox"/>
              </th>
              <th style="display: none">id</th>
              <th>工号</th>
              <th>签到年份</th>
              <th>签到月份</th>
              <th>出勤</th>
              <th>迟到</th>
              <th>早退</th>
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
      to_page(1);
    },
    methods: {
      search_btn() {
        search_btn();
      },
      back_btn() {
        back_btn();
      },
      cs_add_btn() {
        cs_add_btn();
      },
      cs_del_btn() {
        cs_del_btn();
      },
      check_all() {
        check_all();
      },
      cs_save_btn() {
        cs_save_btn();
      },
      cs_edit_btn() {
        cs_edit_btn();
      }
    }
  }

  var totalRecord, currentPage, searchState = 0;

  function to_page(pn) {
    getRequest("/checkState/css?pn=" + pn).then(
      result => {
        build_cs_table(result.data);
        //2、解析并显示分页信息
        build_cs_info(result.data);
        //3、解析并显示分页条信息
        build_cs_nav(result.data);
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

  function build_cs_table(result) {
    $("#cs_table tbody").empty();
    var css = result.extend.pageInfo.list;
    $.each(css, function (index, item) {
      //alert(item.empName);
      var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
      var idTd = $("<td style='display:none'></td>").append(item.id);
      var eidTd = $("<td></td>").append(item.eid);
      var cyearTd = $("<td></td>").append(item.cyear);
      var cmonthTd = $("<td></td>").append(item.cmonth);
      var atworkTd = $("<td></td>").append(item.atwork == '1' ? "请假" : "正常");
      var lateTd = $("<td></td>").append(item.late == '1' ? "是" : "否");
      var earlyTd = $("<td></td>").append(item.early == '1' ? "是" : "否");
      var edtBtn = $("<button></button>").addClass("btn btn-warning btn-sm cs_edit_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" ").append("编辑");
      //为编辑按钮添加一个自定义的属性，来表示当前员工id
      edtBtn.attr("edit-id", item.id);
      var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-trash")).append(" ").append("删除");
      //为删除按钮添加一个自定义的属性来表示当前删除的员工id
      delBtn.attr("del-id", item.id);
      var btnTd = $("<td></td>").append(edtBtn).append(" ").append(delBtn);
      $("<tr></tr>").append(checkBoxTd)
      .append(idTd)
      .append(eidTd)
      .append(cyearTd)
      .append(cmonthTd)
      .append(atworkTd)
      .append(lateTd)
      .append(earlyTd)
      .append(btnTd)
      .appendTo("#cs_table tbody");
    });
  }

  function build_cs_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前为第" + result.extend.pageInfo.pageNum + "页，总共有" +
      result.extend.pageInfo.pages + "页，总共有" +
      result.extend.pageInfo.total + "条记录");
    totalRecord = result.extend.pageInfo.total;
    currentPage = result.extend.pageInfo.pageNum;
  }

  function build_cs_nav(result) {
    $("#page_info_nav").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    //构建li元素
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
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
    });

    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
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
    searchState = 1;
    to_search(1)
  }
  function back_btn(pn) {
    searchState = 0;
    $("#s_eid").val("");
    $("#s_cyear").val("");
    $("#s_cmonth").val("");
    $("#s_atwork").val("");
    $("#s_late").val("");
    $("#s_early").val("");
    to_page(1)
  }
  //处理form提交的数据
  function doFormData(data) {
    if ($("#s_eid").val() == "") {
      data = data.split("eid=").join('')
    }
    if ($("#s_cyear").val() == "") {
      data = data.split("&cyear=").join('')
    }
    if ($("#s_cmonth").val() == "") {
      data = data.split("&cmonth=").join('')
    }
    //去掉开头的&号
    if (data.charAt(0) == "&") {
      data = data.slice(1)
    }
    return data
  }

  //查询事件
  function to_search(pn) {
    var data = doFormData($("#search_div form").serialize());
    // console.log(data)

    postRequest("/checkState/searchCs/" + pn, data).then(
      res => {
        // console.log(result.extend.pageInfo)
        build_cs_table(res.data);
        build_cs_info(res.data);
        build_cs_nav(res.data);
      }
    )
  }

  //按钮事件,弹出新增模态框
  //新增按钮
  function cs_add_btn() {
    $('#addModal').modal({
      backdrop: 'static'
    });
  }
  //编辑按钮
  var updateID;
  $(document).on("click", ".cs_edit_btn", function () {
    //先查出对应cid的考勤信息
    updateID = $(this).attr("edit-id");
    getCsById($(this).attr("edit-id"));
    //2、把员工的id传递给模态框的更新按钮
    $("#cs_edit_btn").attr("edit-id", $(this).attr("edit-id"));
    $('#editModal').modal({
      backdrop: 'static'
    });
  });

  //添加操作保存按钮
  function cs_save_btn() {
    postRequest("/checkState/addCs?" + $("#addModal form").serialize()).then(
      res => {
        $('#addModal').modal('hide');
        //到最后一页，显示刚才保存的数据
        //发送ajax请求显示最后一页数据即可
        to_page(totalRecord);
      }
    )
  }
  //更新操作保存按钮
  function cs_edit_btn() {


    postRequest("/checkState/editCs/" + updateID,
      $("#editModal form").serialize()).then(
      res => {
        $('#editModal').modal('hide');
        //来到本页，显示刚才保存的数据
        //发送ajax请求显示本页数据即可
        to_page(currentPage);
      }
    )
  }
  //修改时候获取原有的信息
  function getCsById(id) {

    getRequest("/checkState/cs/" + id).then(
      res => {
        var cs = res.data.extend.checkstate;
        $("#edit_id").text(cs.id);
        $("#edit_eid").text(cs.eid);
        $("#edit_eid").val(cs.eid);
        $("#edit_cyear").val(cs.cyear);
        $("#edit_cmonth").val(cs.cmonth);
        $("#editModal input[name = atwork]").val([cs.atwork]);
        $("#editModal input[name = late]").val([cs.late]);
        $("#editModal input[name = early]").val([cs.early]);
      })
  }

  //删除单条记录
  $(document).on("click", ".delete_btn", function () {
    //弹出是否确认删除对话框
    // alert($(this).parents("tr").find("td:eq(1)").text());
    var eid = $(this).parents("tr").find("td:eq(2)").text();
    var id = $(this).attr("del-id");
    if (confirm("确认删除工号 " + eid + " 吗？")) {
      //确认，发送ajax请求删除即可
      deleteRequest("/checkState/delCs/" + id).then(
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
  }
  //check_item当表中的item全选了，表头的全选按钮也选中
  $(document).on("click", ".check_item", function () {
    //判断是否全选
    // alert($(".check_item:checked").length)
    var flag = $(".check_item:checked").length == $(".check_item").length;
    $("#check_all").prop("checked", flag);
  });

  //点击全部删除
  function cs_del_btn() {
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

      deleteRequest("/checkState/delCs" + del_idstr).then(
        res => {
          to_page(currentPage);
        }
      )
    }
  }

</script>

<style scoped>
  .my-form {
    display: inline;
    padding-left: 20px;
    margin-bottom: 20px;
  }
</style>
