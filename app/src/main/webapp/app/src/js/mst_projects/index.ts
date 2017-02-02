import * as Vue from './../../../node_modules/@types/vue/node_modules/vue/types/index';

namespace MstProjects {

    class IndexApp extends Vue {

        constructor() {
            super(false);
            this._init({
                el: '#v-mst-projects',
                data: {
                    projects: []
                },
                methods: {
                    searchProjects: this.searchProjects;
                }
            });
        }

        public searchProjects() {
            $.ajax()
        }
    }

    export var indexApp = new IndexApp();

}
