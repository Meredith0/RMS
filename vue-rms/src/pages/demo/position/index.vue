<template>
  <d2-container >
    <template slot="header">
      <el-row >
        <el-col :span="6" :offset="4">
          <el-button type="primary" @click="dialogVisible = true">新增职位</el-button>
        </el-col>
        <el-col :span="2" :offset="5">
          <el-input v-model="position4search" placeholder="职位名称"></el-input>
        </el-col>
        <el-col :span="2">
          <el-button type="primary" icon="el-icon-search" @click="search()">搜索</el-button>
        </el-col>
      </el-row>

    </template>
    <!--打表-->
    <el-col :span="16" :offset="4">
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
      title="新增职位"
      :visible.sync="dialogVisible"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="职位名称">
          <el-input placeholder="职位名称" v-model="insertData.pname"></el-input>
        </el-form-item>
        <el-form-item label="基础工资">
          <el-input placeholder="基础工资" v-model="insertData.basemoney"></el-input>
        </el-form-item>
        <el-form-item label="职位人数">
          <el-input placeholder="职位人数" v-model="insertData.count"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addPosition">确 定</el-button>
  </span>
    </el-dialog>

    <!--    修改用户-->
    <el-dialog
      title="修改用户信息"
      :visible.sync="dialogVisible4update"
      width="65%">
      <el-form :inline="true" class="demo-form-inline">

        <el-form-item label="职位名">
          <el-input placeholder="新职位名" v-model="updateData.pname"></el-input>
        </el-form-item>
        <el-form-item label="基础工资">
          <el-input placeholder="新基础工资" v-model="updateData.basemoney"></el-input>
        </el-form-item>
        <el-form-item label="职位人数">
          <el-input placeholder="新职位人数" v-model="updateData.count"></el-input>
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
  import {postRequest} from "../../../utils/postRequest";
  import * as qs from "qs";
  import {getRequest} from "../../../utils/getRequest";
  import {putRequest} from "../../../utils/putRequest";
  import {deleteRequest} from "../../../utils/deleteRequset";

  export default {
    name: 'page3',
    created(){
      this.show();
    },
    methods: {

      show() {
        getRequest("/position/position").then(res => {
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

      addPosition() {
        postRequest("/position/position", qs.stringify(this.insertData)).then(
          res => {
            if (res.status === 204) {
              this.$message({
                showClose: true,
                message: '修改成功',
                type: 'success'
              });
            }

          }).catch(
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

      updateEvent({row}) {
        this.dialogVisible4update = true;
        this.updateData.pid = row.pid;
        this.updateData.pname = row.pname;
        this.updateData.basemoney = row.basemoney;
        this.updateData.count = row.count;

      },
      //修改用户
      updateUser() {
        putRequest("/position/position", qs.stringify(this.updateData)).then(
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
        deleteRequest("/position/position?id=" + row.pid).then(
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
        getRequest("position/find?name=" + this.position4search).then(
          res => {
            if (res.status === 200) {
              this.data = Array.from(res.data);
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
      ,
    },

    data() {
      return {
        columns: [
          {
            title: '职位名称',
            key: 'pname'
          },
          {
            title: '基础工资',
            key: 'basemoney'
          },
          {
            title: '职位人数',
            key: 'count'
          },
        ],
        insertData: [
          {
            pname: '',
            basemoney: '',
            count: ''
          }
        ],
        data: [],

        updateData: {
          pid: '',
          pname: '',
          basemoney: '',
          count: ''
        }
        ,

        //按用职位名模糊搜索
        position4search:'',
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
