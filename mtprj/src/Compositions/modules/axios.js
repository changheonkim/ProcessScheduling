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

export { axiosGet };
