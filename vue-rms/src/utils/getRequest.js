import axios from 'axios'

export const getRequest = (url, params) => {
  return axios({
    method: 'get',
    url: url,
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
};
