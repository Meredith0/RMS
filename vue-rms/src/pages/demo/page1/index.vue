<template>
  <d2-container>
    <template slot="header">
      <el-button type="primary" @click="dialogVisible = true">新增</el-button>
    </template>
    <d2-crud
      :columns="columns"
      :data="data"
      :rowHandle="rowHandle"
      @custom-emit-1="updateEvent"
      @custom-emit-2="deleteEvent"
    >
    </d2-crud>
    <el-pagination
      ref="pagination"
      background
      layout="prev, pager, next"
      :total="totalCount"
      :current-page="pageNum"
      @current-change="paging"
    >
    </el-pagination>
    <el-dialog
      title="新增员工"
      :visible.sync="dialogVisible"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-date-picker
            title="日期"
            value-format="yyyy-MM-dd"
            v-model="postData.empDate"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input placeholder="员工姓名" v-model="postData.empName"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input placeholder="员工地址" v-model="postData.empAddress"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="add">确 定</el-button>
  </span>
    </el-dialog>

    <el-dialog
      title="修改员工信息"
      :visible.sync="dialogVisible4update"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-date-picker
            text="日期"
            value-format="yyyy-MM-dd"
            v-model="updateData.empDate"
            type="date"
            placeholder="选择日期"
            :default-value="updateData.empDate"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input placeholder="员工姓名" v-model="updateData.empName"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input placeholder="员工地址" v-model="updateData.empAddress"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible4update = false">取 消</el-button>
    <el-button type="primary" @click="update">确 定</el-button>
  </span>
    </el-dialog>
  </d2-container>

</template>

<script>

  import {putRequest} from "../../../utils/putRequest";
  import {postRequest} from "../../../utils/postRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";

  export default {

    created() {
      this.getMaxPage();
      this.getData(this.pageNum);
    },

    methods: {
      //分页获取员工
      getData(page) {
        this.$axios.get("/user/show").then(
          res => {
            if (res.status === 200) {
              this.data = Array.from(res.data);
            } else {
              this.$message({
                showClose: true,
                message: '获取数据失败',
                type: 'error'
              });
            }
          }
        )
      },
      paging(currentPage) {
        this.pageNum = currentPage;
        this.getData(this.pageNum)
      },
      //增加员工
      add() {
        postRequest("/emp", this.postData).then(
          res => {
            if (res.status === 204) {
              this.getData();
              this.$message({
                showClose: true,
                message: '插入成功',
                type: 'success'
              });
            }
          }
        ).catch(
          err => {
            console.log('err: ', err);
            this.$message({
              showClose: true,
              message: '插入失败',
              type: 'error'
            });
          }
        ).finally(
          this.dialogVisible = false
        )
      },

      //更新
      update() {
        putRequest("/put", this.updateData).then(
          res => {
            if (res.data.status === 204) {
              this.getData();
              this.$message({
                showClose: true,
                message: '修改成功',
                type: 'success'
              });
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: 'error'
              });
            }
          }
        ).catch(
          err => {
            console.log('err: ', err);
            this.$message({
              showClose: true,
              message: '修改失败',
              type: 'error'
            });
          }
        ).finally(
          this.getData(),
          this.dialogVisible4update = false
        )
      },

      //触发更新面板
      updateEvent({row}) {
        this.dialogVisible4update = true;
        this.updateData.id = row.id;
        this.updateData.empName = row.name;
        this.updateData.empAddress = row.address;
        this.updateData.empDate = row.date;
      },

      //删除
      deleteEvent({row}) {
        deleteRequest("/user/user", {'userId': row.id}).then(
          res => {
            if (res.data.status === 204) {
              this.getData();
              this.$message({
                showClose: true,
                message: '删除成功',
                type: 'success'
              });
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: 'error'
              });
            }
          }
        ).catch(
          err => {
            console.log('err: ', err);
            this.$message({
              showClose: true,
              message: err,
              type: 'error'
            });
          }
        )
      },
      getMaxPage() {

        this.$axios.get("/total").then(
          res=>{
            this.data.totalCount = Math.floor(res.data/20);
          }
        );

      }
    },

    data() {
      return {
        dialogVisible: false,
        dialogVisible4update: false,
        columns: [
          {
            title: '日期',
            key: 'date'
          },
          {
            title: '姓名',
            key: 'name'
          },
          {
            title: '地址',
            key: 'address'
          }
        ],
        data: [],

        pageNum: 1,//分页
        totalCount:10000,//总页数
        postData: {
          id: '',
          empDate: '',
          empName: '',
          empAddress: '',
        },

        updateData: {
          id: '',
          empDate: '',
          empName: '',
          empAddress: '',
        },

        rowHandle: {
          custom: [
            {
              text: '修改',
              type: 'warning',
              size: 'small',
              emit: 'custom-emit-1'
            },
            {
              text: '删除',
              type: 'danger',
              size: 'small',
              emit: 'custom-emit-2'
            }
          ]
        }
      }
    },


  }
</script>
