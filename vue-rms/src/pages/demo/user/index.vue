<template>
  <d2-container>
    <template slot="header">
      <el-row >
        <el-col :span="6" :offset="3" >
        <el-button type="primary" @click="dialogVisible = true">新增用户</el-button>
        </el-col>
        <el-col :span="2" :offset="8">
          <el-input v-model="username4search"  placeholder="用户名" ></el-input>
        </el-col>
        <el-col :span="2">
          <el-button type="primary" icon="el-icon-search" @click="search()">搜索</el-button>
        </el-col>
      </el-row>

    </template>
    <!--打表-->
    <el-col  :span="18" :offset="3">
    <d2-crud
      :columns="columns"
      :data="data"
      :rowHandle="rowHandle"
      @custom-emit-1="updateEvent"
      @custom-emit-2="deleteEvent">
    </d2-crud>
    </el-col>
    <!--增加用户-->
    <el-dialog
      title="新增用户"
      :visible.sync="dialogVisible"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="用户名">
          <el-input placeholder="用户名" v-model="insertData.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="密码" v-model="insertData.password"></el-input>
        </el-form-item>
        <!--        下拉选择-->
        <el-form-item label="角色">
          <el-select v-model="insertData.role" placeholder="请选择角色" value="bindingData.role">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addUser">确 定</el-button>
  </span>
    </el-dialog>

    <!--    修改用户-->
    <el-dialog
      title="修改用户信息"
      :visible.sync="dialogVisible4update"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">

        <el-form-item label="用户名">
          <el-input placeholder="新用户名" v-model="updateData.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="新密码" v-model="updateData.password"></el-input>
        </el-form-item>

        <!--        下拉选择-->
        <el-form-item label="角色">
          <el-select v-model="updateData.role" placeholder="请选择新角色" value="updateData.role">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible4update = false">取 消</el-button>
    <el-button type="primary" @click="updateUser">确 定</el-button>
  </span>
    </el-dialog>

  </d2-container>

</template>

<script>
  import axios from "axios";
  import {postRequest} from "../../../utils/postRequest";
  import qs from 'qs';
  import {putRequest} from "../../../utils/putRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";
  import {getRequest} from "../../../utils/getRequest";

  export default {
    name: 'page2',

    created() {
      this.show()
    },
    methods: {

      show() {
        axios.get("/user/show").then(res => {
          if (res.status === 200) {
            this.data = Array.from(res.data);
          } else {
            this.$message({
              showClose: true,
              message: '获取数据失败',
              type: 'error'
            });
          }
        })
      },

      //增加用户
      addUser() {
        postRequest("/user/user", qs.stringify(this.insertData)).then(
          res => {
            if (res.status === 204) {
              this.show();
              this.$message({
                showClose: true,
                message: '插入成功',
                type: 'success'
              });
            }
          }
        ).catch(
          err => {

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

      //触发更新面板
      updateEvent({row}) {
        this.dialogVisible4update = true;
        this.updateData.id = row.userId;
        this.updateData.username = row.username;
        this.updateData.password = row.password;

      },
      //修改用户
      updateUser() {
        putRequest("/user/user", qs.stringify(this.updateData)).then(
          res => {
            this.show();
            if (res.status === 204) {
              this.$message({
                showClose: true,
                message: '修改成功',
                type: 'success'
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
          this.dialogVisible4update = false
        )
      },

      //删除用户
      deleteEvent({row}) {
        deleteRequest("/user/user?id=" + row.userId).then(
          res => {
            this.show();

            this.$message({
              showClose: true,
              message: '删除成功',
              type: 'success'
            });

          }
        ).catch()
      },

      //搜索
      search() {
        getRequest("user/search?username=" + this.username4search).then(
          res=>{
            if (res.status === 200) {
              this.data = Array.from(res.data);
            }else {
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
        filename: __filename,
        //显示的列
        columns: [
          {
            title: '用户名',
            key: 'username'
          },
          {
            title: '用户角色',
            key: 'role'
          },
        ],

        //后端数据
        data: [],

        //下拉选择
        options: [{
          value: '2',
          label: '员工'
        }, {
          value: '3',
          label: '部门经理'
        }, {
          value: '1',
          label: '管理员'
        }],
        value: ''
        ,

        insertData: [
          {
            id: '',
            username: '',
            password: '',
            role: ''
          }
        ],
        updateData: {
          id: '',
          username: '',
          password: '',
          role: ''
        }
        ,
        //按用户名模糊搜索
        username4search:'',
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
