<template>
  <d2-container>
    <div aria-labelledby="myModalLabel" class="modal fade" id="deptAddModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title" id="myModalLabel">添加部门</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="addDeptform">
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_add_DeptNo">部门名称：</label>
                <div class="col-sm-9">
                  <input class="form-control" id="input_add_DeptNo" name="dname" placeholder="部门名称"
                         type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_add_DeptName">部门主管：</label>
                <div class="col-sm-9">
                  <input class="form-control" id="input_add_DeptName" name="dmanager"
                         placeholder="部门主管"
                         type="text">
                </div>
              </div>

            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button @click="saveDept" class="btn btn-primary" id="dept_save_btn" type="button">保存
            </button>
          </div>
        </div>
      </div>
    </div>
    <!--<%&#45;&#45;//单击编辑按钮弹出的模态框&#45;&#45;%>-->
    <div aria-labelledby="myModalLabel" class="modal fade" id="deptUpdateModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <h4 align="center" class="modal-title">修改部门</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="upateDeptform" method="post">
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_DeptNo">部门编号：</label>
                <div class="col-sm-9">
                  <p class="form-control-static" id="input_update_DeptNo"></p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_DeptName">部门名称：</label>
                <div class="col-sm-9">
                  <input class="form-control" id="input_update_DeptName" name="dname"
                         placeholder="部门名称"
                         type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_DeptName">部门主管：</label>
                <div class="col-sm-9">
                  <input class="form-control" id="input_update_DeptManager" name="dmanager"
                         placeholder="部门名称"
                         type="text">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button @click="updateDept" class="btn btn-primary" id="dept_update_btn" type="button">
              更新
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="container">

      <div class="row">
        <div class="col-lg-1 ">
          <button @click="addDept()" class="btn btn-primary" id="add_dept">新增部门</button>
        </div>
        <div class="col-lg-3 col-lg-offset-5">
          <div class="input-group">
            <div class="input-group-btn">
              <button aria-haspopup="true" class="btn btn-default dropdown-toggle"
                      data-toggle="dropdown"
                      id="selButton" type="button">查找条件<span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                <li><a href="#" id="deid"
                       onclick="document.getElementById('selButton').innerText='部门编号'">部门编号</a></li>
                <li><a href="#" id="dename"
                       onclick="document.getElementById('selButton').innerText='部门名称'">部门名称</a></li>
                <li><a href="#" id="demg"
                       onclick="document.getElementById('selButton').innerText='部门主管'">部门主管</a></li>
              </ul>
            </div><!-- /btn-group -->
            <input class="form-control" id="text_search" placeholder="搜索" type="text">

          </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
        <div class="col-lg-1">
          <button @click="search_id()" class="btn btn-primary search_btn" id="search_btn"
                  type="submit"><span class="glyphicon glyphicon-search"></span>搜索
          </button>
        </div>
      </div>
      <div><p></p></div>
      <div><p></p></div>
      <div><p></p></div>
      <div><p></p></div>
      <div class="row">

        <div class="col-lg-10">
          <table class="table table-hover" id="emps_table">
            <thead>
            <tr>
              <td class="col-lg-2">部门编号</td>
              <td class="col-lg-2">部门名称</td>
              <td class="col-lg-2">部门主管</td>
              <td class="col-lg-2">操作</td>
            </tr>
            </thead>
            <tbody id="add"></tbody>
            <tfoot></tfoot>
          </table>
        </div>
      </div>
      <!--显示分页信息-->
      <div class="row">
        <!--    <%&#45;&#45;  分页文字信息&#45;&#45;%>-->
        <div class="col-md-4 " id="page_info_area"></div>
        <!--    <%&#45;&#45;  分页条信息&#45;&#45;%>-->
        <div class="col-md-5 col-lg-offset-3" id="page_nav_area"></div>
      </div>
    </div>
  </d2-container>

</template>
<script>

  import $ from 'jquery';
  import {getRequest} from "../../../utils/getRequest";
  import {postRequest} from "../../../utils/postRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";
  import qs from "qs";
  import {putRequest} from "../../../utils/putRequest";

  export default {
    name: 'root',
    created() {
      to_page(1);
    },
    data() {
      return {}
    },
    methods: {
      addDept() {
        addDept();
      },
      search_id() {
        search_id();
      },

      saveDept() {
        saveDept();
      },

      updateDept() {
        updateDept();
      }
    }
  }
  var totalRecord, currentPage;

  function to_page(pn) {
    getRequest("/dept/dept?pn=" + pn).then(
      result => {
        //1、解析并显示员工信息
        build_emps_table(result.data);
        //2、解析并显示分页信息
        build_emps_info(result.data);
        //3、解析显示分页条
        // build_dept_nav(result.data);
      }
    )
  }

  //显示所有部门信息并进行分页处理
  function build_emps_table(result) {
    $("#emps_table tbody").empty();
    var emps = result.extend.PageInfo.list;
    $.each(emps, function (index, item) {
      // alert(item.dname);
      // var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
      var deid = $("<td></td>").append(item.did);
      var dename = $("<td></td>").append(item.dname);
      var demanager = $("<td></td>").append(item.dmanager);
      var edtBtn = $("<button></button>").addClass("btn btn-warning btn-sm edit_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" ").append("编辑");
      //为编辑按钮添加一个自定义的属性，来表示当前员工id
      edtBtn.attr("edit-id", item.did);
      var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-trash")).append(" ").append("删除");
      //为删除按钮添加一个自定义的属性来表示当前删除的员工id
      delBtn.attr("del-id", item.did);
      var btnTd = $("<td></td>").append(edtBtn).append(" ").append(delBtn);
      $("<tr></tr>").append()
      .append(deid)
      .append(dename)
      .append(demanager)
      .append(btnTd)
      .appendTo("#emps_table tbody");
    });
  }

  function build_emps_info(result) {
    // $("#page_info_area").empty();
    // $("#page_info_area").append("当前为第" + result.extend.PageInfo.pageNum + "页，总共有" +
    //   result.extend.PageInfo.pages + "页，总共有" +
    //   result.extend.PageInfo.total + "条记录");
    totalRecord = result.extend.PageInfo.total;
    currentPage = result.extend.PageInfo.pageNum;
  }

  function build_dept_nav(result) {
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    //构建li元素  firstPageLi:首页  prePageLi：往前
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    //如果没有下一页，则这两个按钮不能点
    if (result.extend.PageInfo.hasPreviousPage == false) {
      // alert(result.extend.PageInfo.hasPreviousPage);
      firstPageLi.addClass("disabled");
      prePageLi.addClass("disabled");
    } else {
      //为元素添加翻页事件
      firstPageLi.click(function () {
        to_page(1);
      });
      prePageLi.click(function () {
        to_page((result.extend.PageInfo.pageNum) - 1);
      });
    }

    //添加首页和前一页的提示
    ul.append(firstPageLi).append(prePageLi);

    //遍历navigatepageNums页码提示
    $.each(result.extend.PageInfo.navigatepageNums, function (index, item) {
      var numLi = $("<li></li>").append($("<a></a>").append(item));
      if (result.extend.PageInfo.pageNum == item) {
        numLi.addClass("active");
      }
      //添加条目单击事件
      numLi.click(function () {
        to_page(item);
      });
      ul.append(numLi);
    });
    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
    if (result.extend.PageInfo.hasNextPage == false) {
      nextPageLi.addClass("disabled");
      lastPageLi.addClass("disabled");
    } else {
      //为元素添加翻页事件
      nextPageLi.click(function () {
        to_page(result.extend.PageInfo.pageNum + 1);
      });
      lastPageLi.click(function () {
        to_page(result.extend.PageInfo.pages);
      });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    // navEle.appendTo("#page_info_nav");
    $("#page_nav_area").append(navEle);
  }

  //点击删除按键
  $(document).on("click", ".delete_btn", function () {
    //1、弹出确认删除对话框
    var deptName = $(this).parents("tr").find("td:eq(1)").text();
    var deptId = $(this).attr("del-id");
    // alert(deptId);
    if (confirm("确认删除(" + deptName + ")吗？")) {
      deleteRequest("/dept/delD/" + deptId).then(
        res => {
          alert(res.data.msg);
          //回到本页
          to_page(currentPage);
        }
      )
    }
  });

  //根据不同条件进行查询
  function search_id() {
    var value = document.getElementById("selButton").innerText;
    if(value==""){
      to_page(1);
    }
    if (value == "部门编号") {
      var deptId = $("#text_search").val();

      getRequest("/dept/deptId/" + deptId).then(
        res => {
          rebuliderid(res.data);
        }
      )
    } else if (value == "部门名称") {
      var deptName = $("#text_search").val();
      // alert(deptName);
      getRequest("/dept/deptName/" + deptName).then(
        res => {
          rebulider(res.data);
        }
      )
    } else if (value == "部门主管") {
      var deptMag = $("#text_search").val();
      // alert(deptMag);
      getRequest("/dept/deptMag/" + deptMag).then(
        res => {
          rebulider(res.data);
        }
      )
    }
  }

  //根据不同条件查找重建数据表格
  function rebulider(result) {
    $("#emps_table tbody").empty();
    $("#page_info_area").empty();
    $("#page_nav_area").empty();
    var dep = result.extend.dept;
    $.each(dep, function (index, depts) {
      var tb1 = $("<td></td>").append(depts.did);
      var tb2 = $("<td></td>").append(depts.dname);
      var tb3 = $("<td></td>").append(depts.dmanager);
      var tb4 = $("<td></td>").append("无");
      $("<tr></tr>").append(tb1).append(tb2).append(tb3).append(tb4).appendTo("#emps_table tbody")
    });
  }

  function rebuliderid(result) {
    $("#emps_table tbody").empty();
    $("#page_info_area").empty();
    $("#page_nav_area").empty();
    var depid = result.extend.dept;
    var tb1 = $("<td></td>").append(depid.did);
    var tb2 = $("<td></td>").append(depid.dname);
    var tb3 = $("<td></td>").append(depid.dmanager);
    var tb4 = $("<td></td>").append("无");
    $("<tr></tr>").append(tb1).append(tb2).append(tb3).append(tb4).appendTo("#emps_table tbody")
  }

  var updateDeptId;
  //编辑按键
  $(document).on("click", ".edit_btn", function () {
    //查出部门信息，显示部门信息
    updateDeptId = ($(this).attr("edit-id"));
    //把部门的id传递给模态框的更新按钮;
    $("#dept_update_btn").attr("edit-id", $(this).attr("edit-id"));
    getDeptByNo(updateDeptId);
    $('#deptUpdateModal').modal({
      backdrop: 'static'
    });
  });

  //根据部门编号查询部门信息
  function getDeptByNo(deptId) {
    getRequest("/dept/deptId/" + deptId).then(
      res => {
        var deptData = res.data.extend.dept;
        $("#input_update_DeptNo").text(deptData.did);
        $("#input_update_DeptName").val(deptData.dname);
        $("#input_update_DeptManager").val(deptData.dmanager);
      }
    )
  }

  //todo 更新部门数据
  function updateDept() {
   // var deptId = $(this).attr("del-id");
    putRequest("/dept/updept/" + updateDeptId+"?"+($("#deptUpdateModal form").serialize())).then(
      res => {
        alert(res.data.msg);
        //1、模态框关闭
        $('#deptUpdateModal').modal('hide');
        //2、来到本页，显示刚才保存的数据
        //发送ajax请求显示本页数据即可
        to_page(currentPage);
      }
    )
  }

  /*
* 添加部门
* */
  //添加按钮事件,弹出新增模态框
  function addDept() {
    $('#deptAddModal').modal({
      backdrop: 'static'
    });
  }

  //添加部门保存按钮事件
  function saveDept() {
    // 发送ajax请求
    // alert($("#deptAddModal form").serialize());
    //进行表单验证
    postRequest("/dept/addD?" + $("#deptAddModal form").serialize()).then(
      res => {
        {
          alert(res.data.msg);
          //数据保存成功
          //1、模态框关闭
          $('#deptAddModal').modal('hide');
          //2、来到最后一页，显示刚才保存的数据
          //发送ajax请求显示最后一页数据即可
          to_page(totalRecord);
        }
      }
    )
  }
</script>

<style scoped>

</style>
