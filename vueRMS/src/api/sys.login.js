import request from '@/plugin/axios'

export function AccountLogin (data) {
  return request({
    url: '/signin',
    method: 'post',
    data
  })
}
