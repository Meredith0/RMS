<template>
  <d2-container>
    <template slot="header">
      <el-row>
        <el-col :span="6">
          <el-button @click="dialogVisible = true" type="primary">新增员工</el-button>
        </el-col>
        <el-col :offset="14" :span="4">
          <el-input @change="search()" placeholder="根据员工姓名搜索" v-model="emp4search"></el-input>
        </el-col>
      </el-row>
    </template>
    <!--打表-->
    <el-col>
    <d2-crud
      :columns="columns"
      :data="data"
      :rowHandle="rowHandle"
      @custom-emit-1="updateEvent"
      @custom-emit-2="deleteConfirm">
    </d2-crud>
    </el-col>
    <el-col :offset="8">
      <el-pagination
        :page-size="pageSize"
        :page-count="total"
        :current-page.sync="currentPage"
        @current-change="show(currentPage)"
        background
        layout="prev, pager, next">
      </el-pagination>
    </el-col>
    <!--增加用户-->
    <el-dialog
      :visible.sync="dialogVisible"
      title="新增员工"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="员工姓名">
          <el-input placeholder="员工姓名" v-model="insertData.ename"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio label="1" v-model="insertData.sex">男</el-radio>
          <el-radio label="2" v-model="insertData.sex">女</el-radio>
        </el-form-item>
        <el-form-item label="入职日期">
          <el-date-picker placeholder="选择日期"
                          type="date"
                          v-model="insertData.workdate"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="部门编号">
          <el-input placeholder="部门编号" v-model="insertData.did"></el-input>
        </el-form-item>
        <el-form-item label="职位编号">
          <el-input placeholder="职位编号" v-model="insertData.pid"></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input placeholder="身份证" v-model="insertData.identity"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
          <el-input placeholder="手机号码" v-model="insertData.phone"></el-input>
        </el-form-item>
        <el-form-item label="住址">
          <el-input placeholder="住址" v-model="insertData.address"></el-input>
        </el-form-item>
        <el-form-item label="入职日期">
          <el-date-picker placeholder="选择日期"
                          type="date"
                          v-model="insertData.birthday"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button @click="addEmp" type="primary">确 定</el-button>
  </span>
    </el-dialog>

    <!--    修改员工-->
    <el-dialog
      :visible.sync="dialogVisible4update"
      title="修改员工信息"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="员工姓名">
          <el-input placeholder="员工姓名" v-model="updateData.ename"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio label="1" v-model="updateData.sex">男</el-radio>
          <el-radio label="2" v-model="updateData.sex">女</el-radio>
        </el-form-item>
        <el-form-item label="入职日期">
          <el-date-picker placeholder="选择日期"
                          type="date"
                          v-model="updateData.workdate"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="部门编号">
          <el-input placeholder="部门编号" v-model="updateData.did"></el-input>
        </el-form-item>
        <el-form-item label="职位编号">
          <el-input placeholder="职位编号" v-model="updateData.pid"></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input placeholder="身份证" v-model="updateData.identity"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
          <el-input placeholder="手机号码" v-model="updateData.phone"></el-input>
        </el-form-item>
        <el-form-item label="住址">
          <el-input placeholder="住址" v-model="updateData.address"></el-input>
        </el-form-item>
        <el-form-item label="入职日期">
          <el-date-picker placeholder="选择日期"
                          type="date"
                          v-model="updateData.birthday"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <span class="dialog-footer" slot="footer">
    <el-button @click="dialogVisible4update = false">取 消</el-button>
    <el-button @click="updateUser" type="primary">确 定</el-button>
  </span>
    </el-dialog>

  </d2-container>
</template>

<script>
  import qs from "qs";
  import {getRequest} from "../../../utils/getRequest";
  import {postRequest} from "../../../utils/postRequest";
  import {putRequest} from "../../../utils/putRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";

  export default {
    name: "index",

    created() {
      this.show(1);
    },

    methods: {

      show(pageNo) {
        getRequest("/emp/show?pageNo=" + pageNo).then(res => {
          if (res.status === 200) {
              this.total = res.data.total;
            this.data = Array.from(res.data.emp);
          } else {
            this.$message({
              showClose: true,
              message: '获取数据失败',
              type: 'error'
            });
          }
        })
      },

      addEmp() {
        postRequest("/emp/emp", qs.stringify(this.insertData)).then(
          res => {
            this.show(1);
            if (res.status === 204) {
              this.$message({
                showClose: true,
                message: '添加成功',
                type: 'success'
              });
            } else {
              this.$message({
                showClose: true,
                message: '添加失败, 部门编号或职位编号不存在',
                type: 'error'
              });
            }

          }).catch(
          err => {
            console.log('err: ', err);
            this.$message({
              showClose: true,
              message: 'oops, server down',
              type: 'error'
            });
          }
        ).finally(
          this.dialogVisible = false
        )
      },

      updateEvent({row}) {
        this.dialogVisible4update = true;
        this.updateData.pid = row.pid;
        this.updateData.ename = row.ename;
        this.updateData.phone = row.phone;
        this.updateData.birthday = row.birthday;
        this.updateData.address = row.address;
        if (row.sex === '男') {
          this.updateData.sex = '1';
        } else if (row.sex === '女') {
          this.updateData.sex = '2';
        }
        this.updateData.did = row.did;
        this.updateData.workdate = row.workdate;
        this.updateData.eid = row.eid;
        this.updateData.identity = row.identity;

      },
      //修改用户
      updateUser() {
        putRequest("/emp/emp", qs.stringify(this.updateData)).then(
          res => {
            this.show(1);
            if (res.status === 204) {
              this.$message({
                showClose: true,
                message: '修改成功',
                type: 'success'
              });
            } else {
              this.$message({
                showClose: true,
                message: '修改失败, 部门编号或职位编号不存在',
                type: 'error'
              });
            }
          }
        ).catch(
          err => {
            console.log('err: ', err);
            this.$message({
              showClose: true,
              message: 'oops, server down',
              type: 'error'
            });
          }
        ).finally(
          this.dialogVisible4update = false
        )
      },

      //确认删除
      deleteConfirm({row}) {
        this.$confirm('此操作删除该员工, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteEvent({row});
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      //删除用户
      deleteEvent({row}) {
        deleteRequest("/emp/emp?eid=" + row.eid).then(
          res => {
            this.show(1);
            if (res.status === 204) {
              this.$message({
                showClose: true,
                message: '删除成功',
                type: 'success'
              });
            } else {
              this.$message({
                showClose: true,
                message: '删除失败',
                type: 'error'
              });
            }
          }
        ).catch(
          err => {
            this.$message({
              showClose: true,
              message: 'oops, server down',
              type: 'error'
            });
          }
        )
      },
      //搜索
      search() {
        getRequest("emp/find?name=" + this.emp4search).then(
          res => {
            if (res.status === 200) {
              this.data = Array.from(res.data.emp);
              this.total = res.data.total;
            } else {
              this.$message({
                showClose: true,
                message: '搜索失败',
                type: 'error'
              });
            }
          }
        )
      }
    },

    data() {
      return {
        total: 1,
        pageNo: '',
        pageSize: 5,
        pageCount: 1,
        currentPage: 1,
        radio: '1',
        workDate: '',
        columns: [
          {
            title: '员工姓名',
            key: 'ename'
          },
          {
            title: '性别',
            key: 'sex'
          },
          {
            title: '部门编号',
            key: 'did'
          },
          {
            title: '职位编号',
            key: 'pid'
          },
          {
            title: '入职日期',
            key: 'workdate'
          },
          {
            title: '身份证',
            key: 'identity'
          },
          {
            title: '住址',
            key: 'address'
          },
          {
            title: '生日',
            key: 'birthday'
          },

        ],
        insertData: [
          {
            ename: '',
            identity: '',
            phone: '',
            birthday: '',
            address: '',
            sex: '',
            pid: '',
            did: '',
            workdate: '',

          }
        ],
        data: [],

        updateData: {
          ename: '',
          identity: '',
          phone: '',
          birthday: '',
          address: '',
          sex: '',
          pid: '',
          did: '',
          workdate: '',
          eid: ''
        }
        ,

        //按用职位名模糊搜索
        emp4search: '',
        //每列的修改删除按钮
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
        },
        dialogVisible: false,
        dialogVisible4update: false,
      }
    }
  }
</script>

<style scoped>

</style>
