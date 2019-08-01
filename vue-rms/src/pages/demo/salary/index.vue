<template>
  <d2-container>
    <div aria-labelledby="myModalLabel" class="modal fade" id="salaryAddModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title" id="addModalLabel">添加工资</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="addSalaryform">
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_sid">工资号：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_update_sid" name="sid" placeholder="工资号"
                         type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">员工编号：</label>
                <div class="col-sm-6">
                  <!-- 提交部门Id即可-->
                  <select class="form-control" name="eid">
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_add_base">基本工资：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_add_base" name="base" placeholder="基本工资"
                         type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_add_date">日期：</label>
                <div class="col-sm-6">
                <input class="form-control" id="input_add_date" name="date" placeholder="日期"
                       type="date">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_add_bonds">奖金：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_add_bonds" name="bonus" placeholder="奖金"
                         type="text">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button" >关闭</button>
            <button class="btn btn-primary" id="salary_save_btn" type="button" @click="salary_save_btn">保存</button>
          </div>
        </div>
      </div>
    </div>

    <!-- 修改模态框 -->
    <div aria-labelledby="myModalLabel" class="modal fade" id="salaryUpdateModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title" id="updateModalLabel">修改工资</h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="UpdateSalaryform">
              <div class="form-group">
                <label class="col-sm-3 control-label" for="sid_update_static">工资号：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="sid_update_static" name="sid"></p>
                </div>

              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_mmp">员工名：</label>
                <div class="col-sm-6">
                  <select class="form-control" id="input_update_mmp" name="eid">

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_base">基本工资：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_update_base" name="base" placeholder="基本工资"
                         type="text">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_date">日期：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_update_date" name="date" placeholder="日期"
                         type="date">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label" for="input_update_bonus">奖金：</label>
                <div class="col-sm-6">
                  <input class="form-control" id="input_update_bonus" name="bonus" placeholder="奖金"
                         type="text">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button class="btn btn-primary" id="salary_update_btn" type="button" @click="salary_update_btn">更新</button>
          </div>
        </div>
      </div>
    </div>

    <!--显示界面--->
    <div class="container">
      <!-- 标题-->
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <h3>工资信息表</h3>
          <hr>
        </div>
      </div>
      <div id="search_div">
        <div style="display:inline;float:left">
          <form class="form-horizontal">
            <div class="form-group">
              <label for="edit_text">输入查询的工资号：</label>
              <input id="edit_text" name="sid" placeholder="工资号" style="width: 100px" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
              <label for="edit_text1">输入查询的基本工资：</label>
              <input id="edit_text1" name="base" placeholder="基本工资" style="width: 100px"
                     type="text">&nbsp;&nbsp;&nbsp;&nbsp;
              <label for="edit_text2">选择查询的员工名：</label>
              <select id="edit_text2" name="eid">
              </select>
            </div>
          </form>
        </div>
      </div>
      <!--按钮-->
      <div class="row">
        <div class="col-md-6 col-md-offset-10">
          <button class="btn btn-success" id="search_btn" type="button" @click="search_btn">查询</button>
          <button class="btn btn-primary" id="salary_add_modal_btn" type="button" @click="salary_add_modal_btn">新增</button>
          <button class="btn btn-danger" id="salary_delete_all_btn" type="button" @click="salary_delete_all_btn">删除</button>
          <button class="btn btn-default" id="back_btn" type="button" @click="back_btn">返回</button>
        </div>
      </div>
      <!--表格-->
      <div class="row">
        <div class="col-md-12">
          <table class="table table-hover" id="salaries_table">
            <thead>
            <tr>
              <th>选择</th>
              <th>工资号</th>
              <th>员工号</th>
              <th>员工名</th>
              <th>基本工资</th>
              <th>时间</th>
              <th>奖金</th>
              <th>工资</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
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

  import {postRequest} from "../../../utils/postRequest";
  import {getRequest} from "../../../utils/getRequest";
  import {putRequest} from "../../../utils/putRequest";
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
      salary_add_modal_btn() {
        salary_add_modal_btn();
      },
      salary_delete_all_btn() {
        salary_add_modal_btn();
      },
      back_btn() {
        back_btn();
      },
      salary_save_btn() {
        salary_save_btn();
      },
      salary_update_btn() {
        salary_update_btn();
      },

    }
  }

  var totalRecord, currentPage, searchState = 0;

  function to_page(pn) {
    getEmps("#edit_text2");

    postRequest("/salary/salaries?pn=" + pn).then(
      result => {
        build_salaries_table(result.data);
        //2、解析并显示分页信息
        build_salaries_info(result.data);
        //3、解析并显示分页条信息
        build_salaries_nav(result.data);
      }
    )
  }

  //判断是否处于查询状态
  function isSearch(pn) {
    if (searchState == 0) {
      to_page(pn)
    } else {
      to_search(pn)
    }
  }

  //查询按钮
  function search_btn(pn) {
    searchState = 1;
    to_search(1)
  }

  function back_btn(pn) {
    searchState = 0;
    $("#edit_text").val("");
    $("#edit_text1").val("");
    $("#edit_text2").val("");
    to_page(1)
  }

  function build_salaries_table(result) {
    $("#salaries_table tbody").empty();
    var salaries = result.extend.pageInfo.list;
    $.each(salaries, function (index, item) {
      //alert(item.empName);
      var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
      var salaryNoTd = $("<td></td>").append(item.sid);
      var salaryEId = $("<td></td>").append(item.eid);
      var salaryNameTd = $("<td></td>").append(item.ename);
      var salaryBase = $("<td></td>").append(item.base);
      var salaryDate = $("<td></td>").append(item.date);
      var salaryBonus = $("<td></td>").append(item.bonus);
      var salarySum = $("<td></td>").append(item.base * 1 + item.bonus * 1);
      var edtBtn = $("<button></button>").addClass("btn btn-warning btn-sm edit_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" ").append("编辑");
      //为编辑按钮添加一个自定义的属性，来表示当前员工id
      edtBtn.attr("edit-id", item.sid);
      var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append(
        $("<span></span>").addClass("glyphicon glyphicon-trash")).append(" ").append("删除");
      //为删除按钮添加一个自定义的属性来表示当前删除的员工id
      delBtn.attr("del-id", item.sid);
      var btnTd = $("<td></td>").append(edtBtn).append(" ").append(delBtn);
      $("<tr></tr>")
      .append(checkBoxTd)
      .append(salaryNoTd)
      .append(salaryEId)
      .append(salaryNameTd)
      .append(salaryBase)
      .append(salaryDate)
      .append(salaryBonus)
      .append(salarySum)
      .append(btnTd)
      .appendTo("#salaries_table tbody");
    });
  }

  function build_salaries_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前为第" + result.extend.pageInfo.pageNum + "页，总共有" +
      result.extend.pageInfo.pages + "页，总共有" +
      result.extend.pageInfo.total + "条记录");
    totalRecord = result.extend.pageInfo.total;
    currentPage = result.extend.pageInfo.pageNum;
  }

  function build_salaries_nav(result) {
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

  //添加按钮事件,弹出新增模态框
  function salary_add_modal_btn() {
    //发送Ajax请，获得部门信息，并在下拉列表显示
    getEmps("#salaryAddModal select");
    //弹出模态框salaryAddModal
    $('#salaryAddModal').modal({
      backdrop: 'static'
    });
  }

  //查出所有的部门信息，并显示在下拉列表中
  //定义参数
  function getEmps(ele) {
    //清空下拉列表
    $(ele).empty();
    var optionEle = $("<option></option>").append("下拉").attr("value", "");
    optionEle.appendTo(ele);

    getRequest("/emp/listEmps").then(
      result => {
        $.each(result.data.extend.emps, function () {
          var optionEle = $("<option></option>").append(this.ename).attr("value", this.eid);
          //optionEle.appendTo("#salaryAddModal select");
          optionEle.appendTo(ele);
        });
      }
    )
  }

  //添加员工信息
  function salary_save_btn() {

    console.log("salary_save_btn"+ $("#salaryAddModal form").serialize());
    postRequest("/salary/salary", $("#salaryAddModal form").serialize()).then(
      res => {
        $("#salaryAddModal").modal("hide");
        //alert(result.msgEs);
        //2、来到最后一页，显示刚才保存的数据
        //发送ajax请求显示最后一页数据即可
        to_page(totalRecord);
      }
    )
  }

  //更新数据
  var updateId;
  //1、我们是按钮创建之前就绑定了click，所以绑定不上。
  //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
  //jquery新版没有live，使用on进行替代
  $(document).on("click", ".edit_btn", function () {
    //0、查出部门信息，显示部门信息
    getEmps("#input_update_mmp");
    //1、查出员工信息，显示员工信息salaryUpdateModal
    updateId = $(this).attr("edit-id");
    getSalary($(this).attr("edit-id"));
    //2、把员工的id传递给模态框的更新按钮
    $("#salary_update_btn").attr("edit-id", $(this).attr("edit-id"));
    $('#salaryUpdateModal').modal({
      backdrop: 'static'
    });
  });

  //根据员工查出员工信息
  function getSalary(sid) {

    getRequest("/salary/salary/" + sid).then(
      result => {
        console.log(result);
        var salaryData = result.data.extend.salary;
        $("#sid_update_static").text(salaryData.sid);
        //$("#eid_update_static").text(salaryData.eid);
        //$("#ename_update_static").text(salaryData.ename);
        $("#input_update_mmp").val([salaryData.eid]);
        $("#input_update_base").text(salaryData.base);
        $("#input_update_date").val(salaryData.date);
        $("#input_update_bonus").text(salaryData.bonus);
      }
    )
  }

  //点击更新按钮，更新工资信息
  function salary_update_btn() {
    putRequest("/salary/salary/" + updateId, $("#salaryUpdateModal form").serialize()).then(
      res => {
        $('#salaryUpdateModal').modal('hide');
        //2、来到本页，显示刚才保存的数据
        //发送ajax请求显示本页数据即可
        to_page(currentPage);
      }
    )
  }

  //删除单条记录
  $(document).on("click", ".delete_btn", function () {
    //弹出是否确认删除框
    //1、弹出是否确认删除对话框
    // alert($(this).parents("tr").find("td:eq(1)").text());
    var eid = $(this).parents("tr").find("td:eq(3)").text();
    var sid = $(this).attr("del-id");
    if (confirm("确认删除【" + eid + "】吗？")) {
      //确认，发送ajax请求删除即可
      deleteRequest("/salary/salary/" + sid).then(
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
    //判断当前选择中的元素是否5个
    // alert($(".check_item:checked").length)
    var flag = $(".check_item:checked").length == $(".check_item").length;
    $("#check_all").prop("checked", flag);
  });

  //点击全部删除，就批量删除
  function salary_delete_all_btn() {
    //
    var salaryNames = "";
    var del_idstr = "";
    $.each($(".check_item:checked"), function () {
      // alert( $(this).parents("tr").find("td:eq(2)").text());
      //this
      salaryNames += $(this).parents("tr").find("td:eq(1)").text() + ",";
      //组装员工编号字符串
      del_idstr += $(this).parents("tr").find("td:eq(1)").text() + ",";
    });
    //去除empNames多余的,
    salaryNames = salaryNames.substring(0, salaryNames.length - 1);
    //去除删除的id多余的,
    del_idstr = del_idstr.substring(0, del_idstr.length - 1);
    //alert(del_idstr);
    if (confirm("确认删除【" + salaryNames + "】吗？")) {
      deleteRequest("/salary/salary/" + del_idstr).then(
        res => {
          to_page(currentPage);
        }
      )
    }
  }

  //查询事件
  function to_search(pn) {
    postRequest("/salary/search/" + pn, $("#search_div form").serialize()).then(
      result => {
        build_salaries_table(result.data);
        build_salaries_info(result.data);
        build_salaries_nav(result.data);
      }
    )
  }

</script>

<style scoped>


</style>
