import * as echarts from "echarts";
import {defineComponent} from "vue";
import {index} from "@/api/system/test-api";
import {useStore, setStore} from "@/store";

export default defineComponent({
    data() {
        return {
            store: useStore(),
        }
    },
    mounted() {
        index().then((res: any) => {
            console.log(res.data)
        })

        let self = this;
        this.$nextTick(() => {
            self.init();
        })
    },
    methods: {
        sum() {
            setStore();
        },
        init() {
            let chartDom = document.getElementById('demo');
            if (!chartDom) {
                return;
            }
            let myChart = echarts.init(chartDom);
            let option = {
                title: {
                    text: 'Referer of a Website',
                    subtext: 'Fake Data',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            {value: 1048, name: 'Search Engine'},
                            {value: 735, name: 'Direct'},
                            {value: 580, name: 'Email'},
                            {value: 484, name: 'Union Ads'},
                            {value: 300, name: 'Video Ads'}
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            option && myChart.setOption(option);
        }
    }
});