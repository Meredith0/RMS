<template>
  <el-table
    :data="logReverse"
    border
    size="mini"
    stripe
    style="width: 100%">

    <el-table-column type="expand">
      <div class="d2-error-log-list__expand-group" slot-scope="props">
        <expand-item
          :type="props.row.type"
          :value="props.row.type === 'log' ? '日志' : '异常'"
          title="类型"/>
        <expand-item
          :type="props.row.type"
          :value="props.row.info"
          title="内容"/>
        <expand-item
          :value="get(props.row.vm, '$vnode.tag', '')"
          title="报错组件"
          type="error"
          v-if="props.row.type === 'error'"/>
        <expand-item
          :value="get(props.row.err, 'name', '')"
          title="错误名称"
          type="error"
          v-if="props.row.type === 'error'"/>
        <expand-item
          :value="get(props.row.err, 'message', '')"
          title="错误信息"
          type="error"
          v-if="props.row.type === 'error'"/>
        <expand-item
          title="错误堆栈"
          type="error"
          v-if="props.row.type === 'error'"
          value="见下">
          <div style="overflow: auto;">
            <pre>{{stackBeautify(props.row.err)}}</pre>
          </div>
        </expand-item>
        <expand-item
          :type="props.row.type"
          :value="get(props.row.user, 'name', '')"
          title="用户名"/>
        <expand-item
          :type="props.row.type"
          :value="props.row.uuid"
          title="uuid"/>
        <expand-item
          :type="props.row.type"
          :value="props.row.token"
          title="token"/>
        <expand-item
          :type="props.row.type"
          :value="props.row.url"
          title="页面地址"/>
        <expand-item
          :type="props.row.type"
          :value="props.row.time"
          title="时间"/>
      </div>
    </el-table-column>

    <el-table-column
      :filter-method="filterType"
      :filter-multiple="false"
      :filters="[
        { text: '日志', value: 'log' },
        { text: '异常', value: 'error' }
      ]"
      align="center"
      filter-placement="bottom"
      label="类型"
      prop="type"
      width="80px">
      <template slot-scope="scope">
        <el-tag
          size="mini"
          type="danger"
          v-if="scope.row.type === 'error'">
          <d2-icon name="bug"/>
          Bug
        </el-tag>
        <el-tag
          size="mini"
          type="info"
          v-else>
          <d2-icon name="dot-circle-o"/>
          Log
        </el-tag>
      </template>
    </el-table-column>

    <el-table-column
      :show-overflow-tooltip="true"
      label="地址"
      prop="url"
      width="140px">
    </el-table-column>

    <el-table-column
      :show-overflow-tooltip="true"
      label="内容"
      prop="info">
    </el-table-column>

    <el-table-column
      :show-overflow-tooltip="true"
      label="错误类型"
      width="140px">
      <template
        slot-scope="scope">
        {{get(scope.row.err, 'name', '')}}
      </template>
    </el-table-column>

    <el-table-column
      label="错误信息"
      width="300px">
      <template
        slot-scope="scope">
        {{get(scope.row.err, 'message', '')}}
      </template>
    </el-table-column>

  </el-table>
</template>

<script>
  import {mapState} from 'vuex'
  import {get} from 'lodash'
  import ExpandItem from './components/ExpandItem'

  export default {
    name: 'd2-error-log-list',
    components: {
      ExpandItem
    },
    computed: {
      ...mapState('d2admin', {
        logList: state => state.log.list
      }),
      logReverse() {
        // 直接 reverse 的话有点问题
        const res = [];
        const loglength = this.logList.length;
        this.logList.forEach((log, index) => {
          res.push(this.logList[loglength - 1 - index])
        });
        return res
      }
    },
    methods: {
      get,
      filterType(value, row) {
        return row.type === value
      },
      stackBeautify(err) {
        if (!err) {
          return ''
        }
        return err.stack
      }
    }
  }
</script>

<style lang="scss">
  .d2-error-log-list__expand-group {
    .d2-error-log-list__expand {
      padding-left: 20px;
      margin-bottom: 10px;

      &:last-child {
        margin-bottom: 0px;
      }

      .d2-error-log-list__expand-title {
        font-size: 16px;
        font-weight: bold;
        margin-top: 0px;
        margin-bottom: 10px;
      }

      .d2-error-log-list__expand-value {
        font-size: 12px;
        margin-top: 0px;
        margin-bottom: 0px;
      }
    }

    .d2-error-log-list__expand--log {
      border-left: 4px solid $color-info;
    }

    .d2-error-log-list__expand--error {
      border-left: 4px solid $color-danger;
    }
  }
</style>
