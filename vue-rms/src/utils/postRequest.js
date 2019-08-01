import axios from 'axios'

export const postRequest = (url, params) => {

  return axios({
    method: 'post',
    url: url,
    data: params,
     headers: {
       //'Content-Type': 'application/json',
       'Content-Type': 'application/x-www-form-urlencoded'
     }
  });
};
