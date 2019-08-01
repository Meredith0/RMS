import axios from 'axios'

export const putRequest = (url, params) => {
  return axios({
    method: 'put',
    url: url,
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    }
  });
};
