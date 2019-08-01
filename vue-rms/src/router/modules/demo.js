import layoutHeaderAside from '@/layout/header-aside'

const meta = { auth: true }

export default {
  path: '/demo',
  name: 'demo',
  meta,
  redirect: { name: 'demo-page1' },
  component: layoutHeaderAside,
  children: (pre => [
    { path: 'page1', name: `${pre}page1`, component: () => import('@/pages/demo/page1'), meta: { ...meta, title: '页面 1' } },
    { path: 'user', name: `${pre}user`, component: () => import('@/pages/demo/user'), meta: { ...meta, title: '用户管理' } },
    { path: 'position', name: `${pre}position`, component: () => import('@/pages/demo/position'), meta: { ...meta, title: '职位管理' } },
    { path: 'reportDiagram', name: `${pre}reportDiagram`, component: () => import('@/pages/demo/reportDiagram'), meta: { ...meta, title: '报表' }},

    { path: 'dept', name: `${pre}dept`, component: () => import('@/pages/demo/dept'), meta: { ...meta, title: '部门管理' }},

    { path: 'affiche', name: `${pre}affiche`, component: () => import('@/pages/demo/affiche'), meta: { ...meta, title: '公告管理' }},

    { path: 'checkState', name: `${pre}checkState`, component: () => import('@/pages/demo/checkState'), meta: { ...meta, title: '考勤状况管理' }},

    { path: 'checkWork', name: `${pre}checkWork`, component: () => import('@/pages/demo/checkWork'), meta: { ...meta, title: '考勤信息管理' }},

    { path: 'emp', name: `${pre}emp`, component: () => import('@/pages/demo/emp'), meta: { ...meta, title: '员工管理' }},

    { path: 'salary', name: `${pre}salary`, component: () => import('@/pages/demo/salary'), meta: { ...meta, title: '工资管理' }}

  ])('demo-')
}
