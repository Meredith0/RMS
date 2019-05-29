import axios from 'axios'

export const postRequest = (url, params) => {
  return axios({
    method: 'post',
    url: url,
    data: params,
    // transformRequest: [function (data) {
    //   let ret = '';
    //   for (let it in data) {
    //     ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    //   }
    //   return ret
    // }],
    headers: {
      'Content-Type': 'application/json'
    }
  });
};
