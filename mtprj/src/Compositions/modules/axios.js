import axios from "axios";
import { useStore } from "vuex";

const BASE_URL = "http://localhost:8080/api";
function axiosGet(URL, onSucess = null, onFailed = null) {
  const store = useStore();
  const final_URL = BASE_URL + URL;
  axios.get(final_URL).then((resp) => {
    if (resp.status == 200) {
      if (onSucess) {
        onSucess(resp.data);
      } else {
        if (onFailed) {
          onFailed(resp.data);
        }
      }
    }
  });
}

function axiosPostOrderProcess(URL, data) {
  const final_URL = BASE_URL + URL;
  console.log(data);
  axios
    .post(final_URL, {
      pc_id: data.pcid,
      p_id: data.p_id,
      idx: data.idx,
    })
    .then((resp) => {
      if (resp.status == 200) {
        console.log(resp);
      } else {
        console.log(resp);
      }
    })
    .catch((err) => {
      console.log(err);
    });
}

function axiosPostMachine(URL, data) {
  const final_URL = BASE_URL + URL;
  console.log(data);
  axios
    .post(final_URL, {
      mname: data.mname,
      pc_id: data.pc_id,
      o_id: data.o_id,
    })
    .then((resp) => {
      if (resp.status == 200) {
        console.log(resp);
      } else {
        console.log(resp);
      }
    })
    .catch((err) => {
      console.log(err);
    });
}

function axiosDelete(URL) {
  const final_URL = BASE_URL + URL;
  axios
    .delete(final_URL)
    .then((resp) => {
      if (resp.status == 200) {
        console.log(resp);
      } else {
        console.log(resp);
      }
    })
    .catch((err) => {
      console.log(err);
    });
}

export { axiosGet, axiosPostOrderProcess, axiosDelete, axiosPostMachine };
