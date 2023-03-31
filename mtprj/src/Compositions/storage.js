// 컴포지션 api 이용하기에 해당 폴더의 이름을 컴포지션으로 명명함.
import { reactive, toRefs } from "vue";

export const useStorage = () => {
    const KEY  = 'my-to-do-list' // localStorage에서 데이터를 저장할 KEY
    // localStorage는 UTF-16 DOMString 형식으로 저장하기에 JSON을 parse나 stringify를 해주어야 합니다.
    
// 여기서 반응성이란 : Vue Virtual DOM이 데이터 변화를 감지해준다.
    const storage_obj = reactive({storage_id: 0}) // 일정 리스트를 가질 todos 속성과 신규 id를 책정할 수 있는 storage_id 속성을 가진 객체
// reactive : 객체에 반응성을 더해주는 함수
// val_obj에 반응성을 추가합니다.
// reactive는 object, array 이외에는 사용할 수 없습니다.
// property 값을 변경할 때 변수.property에 변경할 값을 넣어줍니다.

// 그럼 reactive는 필요 없는 것 아닌가요..?라고 생각할 수도 있지만 공식 문서상에 ref의 값으로

// 객체가 전달될 경우 reactive 메소드를 통해 깊은(Deep) 감지를 수행한다고 합니다.
    const loadTodos = (initTodos) => { // localStorage로부터 데이터를 불러오는 함수
        let temp_todos = JSON.parse(localStorage.getItem(KEY) || '[]')
        temp_todos.forEach((todo, idx) => {
            todo.id = idx
        })
        storage_obj.storage_id = temp_todos.length
        initTodos(temp_todos)
    }

    const saveTodos = (todos) => { // localStorage로부터 데이터를 저장하는 함수
        localStorage.setItem(KEY, JSON.stringify(todos.value))
    }

    return {
        ...toRefs(storage_obj),
// toRefs : 객체의 내부 속성들 모두에 반응성을 더해주는 함수
        loadTodos,
        saveTodos,
    }
}

// Vue3에서는 프록시를 이용하여 반응성을 관리하며 어떤 변수가 반응성을 가지게 하기 위해서는 프록시로의 변환이, 해제하기 위해서는 프록시에서 일반 변수로의 변환이 필요하다.