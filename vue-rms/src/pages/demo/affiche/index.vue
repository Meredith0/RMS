<template>
  <d2-container>
    <div class="container">
      <!-- 标题-->
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <h3>公告表</h3>
        </div>
      </div>
      <!--查询-->
      <div class="row" id="search_div">
        <div style="display:inline;float:left">
          <form class="">
            <div style="display:inline;padding-left: 20px">
              <label for="s_amsg">公告内容：</label>
              <input id="s_amsg" name="amessage" placeholder="公告内容" type="text">
            </div>
            <div style="display:inline;padding-left: 20px">
              <label for="s_adate">日期：</label>
              <input id="s_adate" name="adate" type="date">
            </div>
          </form>
        </div>
        <div style="display:inline;float:right">
          <button @click="search_btn()" class="btn btn-success" id="search_btn" type="button">查询
          </button>
          <button @click="back_btn" class="btn btn-default" id="back_btn" type="button">退出查询
          </button>
          <button @click="aff_add_btn" class="btn btn-primary" id="aff_add_btn" type="button">新增
          </button>
          <button @click="aff_del_btn" class="btn btn-danger" id="aff_del_btn" type="button">删除
          </button>
          <button @click="selectAll_btn" class="btn btn-info" id="selectAll_btn" type="button">
            全选
          </button>
        </div>
      </div>
      <!--公告内容-->
      <div class="row">
        <div class="col-md-12">
          <ul class="my-ul" id="aff_ul">
          </ul>
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
    <!-- 模态框 -->
    <div aria-labelledby="myModalLabel" class="modal fade" id="affModal" role="dialog"
         tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
              aria-hidden="true">&times;</span>
            </button>
            <center><h4 class="modal-title" id="hTitle"></h4></center>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group" style="display: none">
                <label class="col-sm-3 control-label" for="lbl_aid">aid：</label>
                <div class="col-sm-6">
                  <p class="form-control-static" id="lbl_aid" name="aid"></p>
                </div>
              </div>
              <div class="form-group">
                <div class="form-content">
                  <label class="control-label">公告内容：</label>
                  <textarea class="form-control" id="edit_content" name="amessage"
                            rows="5"></textarea>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
            <button @click="save_btn" class="btn btn-primary" id="save_btn" type="button">保存
            </button>
          </div>
        </div>
      </div>
    </div>

  </d2-container>
</template>

<script>
  import {postRequest} from "../../../utils/postRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";
  import {getRequest} from "../../../utils/getRequest";

  export default {
    name: "index",

    created() {
      to_page(1)
    },

    data() {
      return{
        selectState:''
    }
    },
    methods: {
      search_btn() {
        search_btn();
      },
      back_btn() {
        back_btn();
      },
      aff_add_btn() {
        aff_add_btn();
      },
      aff_del_btn() {
        aff_del_btn();
      },
      selectAll_btn() {
        selectAll_btn();
      },
      save_btn() {
        save_btn();
      },

    }
  }

  //定义全局变量
  var totalRecord, currentPage, searchState = 0;

  function to_page(pn) {
    postRequest("/affiche/affiches?pn=" + pn).then(
      result => {

        //1、解析并显示员工数据
        build_affiche_table(result.data);
        //2、解析并显示分页信息
        build_affiche_info(result.data);
        //3、解析并显示分页条信息
        build_affiche_nav(result.data);
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

  function build_affiche_table(result) {
    $("#aff_ul").empty();
    var affs = result.extend.pageInfo.list;
    $.each(affs, function (index, item) {
      var checkBox = $("<input type='checkbox' class='check_item'/>");
      $(checkBox).attr("_aid", item.aid);
      var adateSpan = $("<span></span>").addClass("date-title").append(item.adate);
      var delSpan = $("<span></span>").addClass("glyphicon glyphicon-trash my-trash del_span");
      var adateDiv = $("<div class='panel-heading'></div>").append(checkBox).append(
        adateSpan).append(delSpan);
      var editSpan = $("<span></span>").addClass("glyphicon glyphicon-pencil my-pencil edit_span");
      var amsgDiv = $("<div class='panel-body'></div>").append(item.amessage).append("<br>").append(
        editSpan);
      var defaultDiv = $("<div class='panel panel-default'></div>").append(adateDiv).append(
        amsgDiv);
      //为编辑按钮添加一个自定义的属性，来表示当前id
      $(editSpan).attr("_aid", item.aid);
      //为删除按钮添加一个自定义的属性来表示当前删除的id
      $(delSpan).attr("_aid", item.aid);
      $("<li class='my-li'></li>")
      .append(defaultDiv)
      .appendTo("#aff_ul");
    });
  }

  function build_affiche_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前为第" + result.extend.pageInfo.pageNum + "页，总共有" +
      result.extend.pageInfo.pages + "页，总共有" +
      result.extend.pageInfo.total + "条记录");
    totalRecord = result.extend.pageInfo.total;
    currentPage = result.extend.pageInfo.pageNum;
  }

  function build_affiche_nav(result) {
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
    $("#s_amsg").val("");
    $("#s_adate").val("");
    to_page(1)
  }

  //处理form提交的数据
  function doFormData(data) {
    if ($("#s_msg").val() == "") {
      data = data.split("amessage=").join('')
    }
    if ($("#s_adate").val() == "") {
      data = data.split("&adate=").join('')
    }
    //去掉开头的&号
    if (data.charAt(0) == "&") {
      data = data.slice(1)
    }
    return data
  }

  //查询事件
  function to_search(pn) {
    console.log($("#search_div form").serialize());
    var data = doFormData($("#search_div form").serialize());
    console.log(data);
    // $.ajax({
    //   url: "${path}/searchAff/" + pn,
    //   type: "post",
    //   data: data,
    //   success: function (result) {
    //     console.log(result.extend.pageInfo);
    //     build_affiche_table(result);
    //     build_affiche_info(result);
    //     build_affiche_nav(result);
    //   },
    // });

    postRequest("/affiche/searchAff/" + pn, data).then(
      result => {
        console.log(result.data.extend.pageInfo);
        build_affiche_table(result.data);
        build_affiche_info(result.data);
        build_affiche_nav(result.data);
      }
    )
  }

  //新增按钮
  function aff_add_btn() {
    //更改模态框标题
    $("#hTitle").text("新增公告");
    $("#edit_content").val("");
    $('#affModal').modal({
      backdrop: 'static'
    });
  }

  //编辑按钮
  $(document).on("click", ".edit_span", function () {
    //更改模态框标题
    $("#hTitle").text("编辑公告");
    //先查出对应cid的考勤信息
    getAffByAid($(this).attr("_aid"));
    //2、把aid传递给模态框的保存按钮
    $("#save_btn").attr("_aid", $(this).attr("_aid"));
    $('#affModal').modal({
      backdrop: 'static'
    });
  });

  //保存按钮
  function save_btn() {
    // console.log($("#affModal form").serialize())
    var type = "";
    var _aid = "";
    // console.log($("#hTitle").text())
    if ($("#hTitle").text() == "编辑公告") {
      type = "editAff/";
      _aid = $(this).attr("_aid")
    } else if ($("#hTitle").text() == "新增公告") {
      type = "addAff"
    }
    postRequest("/affiche/" + type + _aid, $("#affModal form").serialize()).then(
      result => {
        //模态框关闭
        $('#affModal').modal('hide');
        //来到本页，显示刚才保存的数据
        //发送ajax请求显示本页数据即可
        to_page(currentPage);
      }
    )
  }

  //修改时候获取原有的信息
  function getAffByAid(aid) {
    getRequest("/affiche/aff/" + aid).then(
      result=>{
        var aff = result.data.extend.affiche;
        $("#edit_aid").text(aff.aid);
        $("#edit_content").val(aff.amessage);
      }
    )
  }

  //删除单条记录
  $(document).on("click", ".del_span", function () {
    var aid = $(this).attr("_aid");
    if (confirm("确认删除公告？")) {

      deleteRequest("/affiche/delAff/" + aid).then(
        result => {
          alert(result.data.msg);
          //回到本页
          to_page(currentPage);
        }
      )
    }
  });

  //完成全选/全部不选功能
  function selectAll_btn() {
    //attr获取checked是undefined;
    //我们这些dom原生的属性；attr获取自定义属性的值；
    //prop修改和读取dom原生属性的值
    //全选与全部不选
    var checkValue = "";
    console.log($(this));
    if ($(this).text() == "selectAll") {
      checkValue = true;
      $(this).text("全不选")
    } else if ($(this).text() == "全不选") {
      checkValue = false;
      $(this).text("全选")
    }
    $(".check_item").prop("checked", checkValue);
  }

  //点击全部删除
  function aff_del_btn() {
    var del_idstr = "";
    $.each($(".check_item:checked"), function () {
      del_idstr += $(this).attr("_aid") + ",";
    });
    del_idstr = del_idstr.substring(0, del_idstr.length - 1);
    console.log(del_idstr);
    if (confirm("确认删除？")) {
      //发送ajax请求删除

      deleteRequest("/affiche/delAff/" + del_idstr).then(
        result=>{
          to_page(currentPage);
        }
      )
    }
  }
</script>

<style scoped>

  @import "../../../static/css/affiche.css";

</style>
