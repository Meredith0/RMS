<template>
  <d2-container>
    <template slot="header">员工报表</template>

    <el-row>
      <el-col :span="10">
        <p class="el-icon-s-data">&nbsp;部门员工年龄分布报表</p>
        <ve-histogram :data="chartData" :settings="chartSettings"

        ></ve-histogram>
      </el-col>

      <el-col :offset="2" :span="10">
        <p class="el-icon-s-data">&nbsp;考勤报表</p>
        <ve-pie :data="chartData1"></ve-pie>
      </el-col>
    </el-row>
  </d2-container>
</template>

<script>

  import {getRequest} from "../../../utils/getRequest";

  export default {
    name: "reportDiagram",

    created() {
      this.ageReport();
      this.workReport();
      this.chartSettings = {
        dimension: ['年龄'],
        yAxisName: ['人数']
      }
    },
    methods: {
      ageReport() {
        getRequest("/report/ageReport").then(
          res => {
            this.data = Array.from(res.data);
            this.chartData.rows = [
              {'年龄': '18-21岁', '人数': res.data[0]},
              {'年龄': '22-25岁', '人数': res.data[1]},
              {'年龄': '26-29岁', '人数': res.data[2]},
              {'年龄': '30-33岁', '人数': res.data[3]},
              {'年龄': '34-37岁', '人数': res.data[4]},
              {'年龄': '38-41岁', '人数': res.data[5]},
              {'年龄': '42岁以上', '人数': res.data[6]}
            ];
          }
        )
      },
      workReport() {
        getRequest("/report/workReport").then(
          res => {
            this.data = Array.from(res.data);
            this.chartData1.rows = [
              {'出勤情况': '出勤', '出勤人次': res.data[0]},
              {'出勤情况': '迟到', '出勤人次': res.data[1]},
              {'出勤情况': '早退', '出勤人次': res.data[2]},
              {'出勤情况': '旷工', '出勤人次': res.data[3]}
            ];
          }
        )
      }

    },

    data() {
      return {
        data: [],
        chartData: {
          columns: ['年龄', '人数'],
          rows: [
            {'年龄': '18-21岁', '人数': 1},
            {'年龄': '22-25岁', '人数': 1},
            {'年龄': '26-29岁', '人数': 1},
            {'年龄': '30-33岁', '人数': 1},
            {'年龄': '34-37岁', '人数': 1},
            {'年龄': '38-41岁', '人数': 1},
            {'年龄': '42岁以上', '人数': 1}
          ]
        },
        dataRow: [],

        chartData1: {
          columns: ['出勤情况', '出勤人次'],
          rows: [
            {'出勤情况': '全勤', '出勤人次': 0},
            {'出勤情况': '迟到', '出勤人次': 0},
            {'出勤情况': '早退', '出勤人次': 0},
            {'出勤情况': '旷工', '出勤人次': 0},
          ]
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .inner {
    position: absolute;
    top: 20px;
    right: 20px;
    bottom: 20px;
    left: 20px;
  }
</style>
