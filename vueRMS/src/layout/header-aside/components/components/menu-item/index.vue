<template>
  <el-menu-item :index = "menu.path || uniqueId">
    <i
      :class = "`fa fa-${menu.icon}`"
      v-if = "menu.icon"></i>
    <i
      class = "fa fa-file-o"
      v-if = "menu.icon === undefined & !menu.iconSvg"></i>
    <d2-icon-svg
      :name = "menu.iconSvg"
      v-if = "menu.iconSvg"/>
    <span slot = "title">{{menu.title || '未命名菜单'}}</span>
  </el-menu-item>
</template>

<script>
  import {uniqueId} from 'lodash'

  export default {
    name: 'd2-layout-header-aside-menu-item',
    props: {
      menu: {
        type: Object,
        required: false,
        default: () => {
        }
      }
    },
    data() {
      return {
        uniqueId: uniqueId('d2-menu-empty-')
      }
    }
  }
</script>
