<template>
  <el-submenu :index = "menu.path || uniqueId">
    <template slot = "title">
      <i
        :class = "`fa fa-${menu.icon}`"
        v-if = "menu.icon"></i>
      <i
        class = "fa fa-folder-o"
        v-if = "menu.icon === undefined & !menu.iconSvg"></i>
      <d2-icon-svg
        :name = "menu.iconSvg"
        v-if = "menu.iconSvg"/>
      <span slot = "title">{{menu.title}}</span>
    </template>
    <template v-for = "(child, childIndex) in menu.children">
      <d2-layout-header-aside-menu-item
        :key = "childIndex"
        :menu = "child"
        v-if = "child.children === undefined"/>
      <d2-layout-header-aside-menu-sub
        :key = "childIndex"
        :menu = "child"
        v-else/>
    </template>
  </el-submenu>
</template>

<script>
  import {uniqueId} from 'lodash'
  // 组件
  import d2LayoutMainMenuItem from '../menu-item'

  export default {
    name: 'd2-layout-header-aside-menu-sub',
    components: {
      'd2-layout-header-aside-menu-item': d2LayoutMainMenuItem
    },
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
