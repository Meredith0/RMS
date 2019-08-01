<template>
  <d2-container class="page">

    <el-row><br><br><br><br></el-row>
    <el-col :offset="8" :span="12">
      <h1>欢迎使用人事信息管理系统</h1>
    </el-col>
    <el-row> <br><br> <br> <br><br> <br><br><br>
       </el-row>
<!--    <el-row >-->
<!--      <div class="page-login" style="width: 100%">-->
<!--        <br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br>-->
<!--        <br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br>-->
<!--        <div class="page-login&#45;&#45;layer page-login&#45;&#45;layer-area">-->
<!--          <ul class="circles">-->
<!--            <li v-for="n in 10" :key="n"></li>-->
<!--          </ul>-->
<!--        </div>-->
<!--        <div-->
<!--          class="page-login&#45;&#45;layer page-login&#45;&#45;layer-time"-->
<!--          flex="main:center cross:center">-->
<!--          {{time}}-->
<!--        </div>-->
<!--      </div>-->
<!--    </el-row>-->
  </d2-container>
</template>

<script>
  import D2HelpBtn from './components/d2-help-btn'
  import D2Badge from './components/d2-badge'
  import {getRequest} from "../../utils/getRequest";
  import dayjs from "dayjs";

  export default {
    components: {
      D2HelpBtn,
      D2Badge
    },
    mounted() {
      this.timeInterval = setInterval(() => {
        this.refreshTime()
      }, 1000)
    },
    methods: {
      loadUser() {
        getRequest("/emp?eid=")
      },
      refreshTime() {
        this.time = dayjs().format('HH:mm:ss')
      },
    },
    data() {
      return {
        filename: __filename,
        timeInterval: null,
        time: dayjs().format('HH:mm:ss'),
      }
    }
  }
</script>

<style lang="scss" scoped>
  .page {
    .page__logo {
      width: 120px;
    }

    .page__btn-group {
      color: $color-text-placehoder;
      font-size: 12px;
      margin-top: 0px;
      margin-bottom: 20px;

      span {
        color: $color-text-sub;

        &:hover {
          color: $color-text-main;
        }
      }
    }
  }

  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 480px;
  }

  .page-login {
    @extend %unable-select;
    $backgroundColor: #F0F2F5;
    // ---
   // background-color: $backgroundColor;
    height: 100%;
    position: relative;
    // 层
    .page-login--layer {
      @extend %full;
      overflow: auto;
    }

    .page-login--layer-area {
      overflow: hidden;
    }

    // 时间
    .page-login--layer-time {
      font-size: 24em;
      font-weight: bold;
      color: rgba(0, 0, 0, 0.1);
      overflow: hidden;
    }

    // main
    .page-login--logo {
      width: 240px;
      margin-bottom: 2em;
      margin-top: -2em;
    }

    // 登录表单
    .page-login--form {
      width: 350px;
      height: 600px;
      // 卡片
      .el-card {
        margin-bottom: 15px;
      }

      // 登录按钮
      .button-login {
        width: 100%;
      }

      // 输入框左边的图表区域缩窄
      .el-input-group__prepend {
        padding: 0px 14px;
      }

      .login-code {
        height: 40px - 2px;
        display: block;
        margin: 0px -20px;
        border-top-right-radius: 2px;
        border-bottom-right-radius: 2px;
      }

      // 登陆选项
      .page-login--options {
        margin: 0px;
        padding: 0px;
        font-size: 14px;
        color: $color-primary;
        margin-bottom: 15px;
        font-weight: bold;
      }

      .page-login--quick {
        width: 100%;
      }
    }

  }
  // 背景
  .circles {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;

    li {
      position: absolute;
      display: block;
      list-style: none;
      width: 20px;
      height: 20px;
      background: #FFF;
      animation: animate 25s linear infinite;
      bottom: -200px;
      @keyframes animate {
        0% {
          transform: translateY(0) rotate(0deg);
          opacity: 1;
          border-radius: 0;
        }
        100% {
          transform: translateY(-1000px) rotate(720deg);
          opacity: 0;
          border-radius: 50%;
        }
      }

      &:nth-child(1) {
        left: 15%;
        width: 80px;
        height: 80px;
        animation-delay: 0s;
      }

      &:nth-child(2) {
        left: 5%;
        width: 20px;
        height: 20px;
        animation-delay: 2s;
        animation-duration: 12s;
      }

      &:nth-child(3) {
        left: 70%;
        width: 20px;
        height: 20px;
        animation-delay: 4s;
      }

      &:nth-child(4) {
        left: 40%;
        width: 60px;
        height: 60px;
        animation-delay: 0s;
        animation-duration: 18s;
      }

      &:nth-child(5) {
        left: 65%;
        width: 20px;
        height: 20px;
        animation-delay: 0s;
      }

      &:nth-child(6) {
        left: 75%;
        width: 150px;
        height: 150px;
        animation-delay: 3s;
      }

      &:nth-child(7) {
        left: 35%;
        width: 200px;
        height: 200px;
        animation-delay: 7s;
      }

      &:nth-child(8) {
        left: 50%;
        width: 25px;
        height: 25px;
        animation-delay: 15s;
        animation-duration: 45s;
      }

      &:nth-child(9) {
        left: 20%;
        width: 15px;
        height: 15px;
        animation-delay: 2s;
        animation-duration: 35s;
      }

      &:nth-child(10) {
        left: 85%;
        width: 150px;
        height: 150px;
        animation-delay: 0s;
        animation-duration: 11s;
      }
    }
  }

</style>
