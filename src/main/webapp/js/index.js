var headTitle = new Vue({
    el: '#headTitle',
    data: {
        headText: 'Hello, My friend!'
    }
})

var poDataDiv = new Vue({
    el: '#poDataDiv',
    data:{
        classNameText: '请输入类名',
        variablesNameText: '请输入属性名:',
        variablesTypeText: '请输入属性类型:',
        addVariablesNameTypesRowText: '添加一行',
        className: 'className Here',
        variablesNameTypes: [{name:"name", type:"type"}]
    },
    methods: {
        addVariablesNameTypesRow: function(event) {
            poDataDiv.variablesNameTypes.push({name:"name", type:"type"})
        }
    }
})

var result = new Vue({
    el: '#result',
    data: {
        resultText: ''
    }
})

var submitButton = new Vue({
    el: '#submitButton',
    data: {
        submitText: 'submit'
    },
    methods: {
        submit: function (event) {
            axios.post('/generate/po', {
                poDto:{
                    className: poDataDiv.className,
                    variablesNameTypes: poDataDiv.variablesNameTypes
                }
            }).then(function(response) {
                result.resultText = response.data
                console.log(response)
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})
