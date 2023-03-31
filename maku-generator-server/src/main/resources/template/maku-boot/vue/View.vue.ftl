<template>
    <table-manage>
        <!-- 表格操作 -->
        <template #search>
            <#list fieldList as field>
                <#if field.primaryPk && field.attrName != 'deleteStatus'>
            <el-form-item label="${field.fieldComment}">
                <el-input placeholder="${field.fieldComment}" v-model:model-value="pageParam.searchObject.${field.attrName}"/>
            </el-form-item>
                </#if>
            </#list>
            <el-form-item>
                <el-button :icon="Search" type="primary" @click="loadTableData">搜索</el-button>
                <el-button :icon="RefreshRight" @click="resetSearchForm">重置</el-button>
            </el-form-item>
        </template>

        <template #operate>
            <el-button type="primary" :icon="Plus" @click="onAdd">添加${tableComment}</el-button>
        </template>

        <!-- 表格视图 -->
        <template #default>
            <el-table stripe row-key="id" :data="pageVo.records" v-loading="loading">
                <#list fieldList as field>
                <el-table-column prop="${field.attrName}" label="${field.fieldComment}" />
                </#list>
                <!-- 单行操作 -->
                <el-table-column fixed="right" width="150" label="操作">
                    <template #default="scope">
                        <el-button size="small" :icon="Edit" @click="onEdit(scope.row)">编辑</el-button>
                        <el-button size="small" plain type="danger" :icon="DeleteFilled" @click="onRemove(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </template>

        <template #page>
            <el-pagination background layout="total, sizes, prev, pager, next, jumper"
                           :total="pageVo.total" :page-size="pageVo.pageSize" :page-sizes=[5,10,15]
                           @current-change="onPageChange" @size-change="onSizeChange"/>
        </template>

        <!-- 编辑对话框 -->
        <template #form>
            <el-dialog v-model="dialogFormVisible" :title="editForm.id? '编辑' : '添加'">
                <el-form ref="sttFormRef" label-width="120px" :model="editForm" :rules="rules">
                    <#list fieldList as field>
                        <#if !field.primaryPk>
                    <el-form-item prop="${field.attrName}" label="${field.fieldComment}">
                        <el-input v-model="editForm.${field.attrName}"></el-input>
                    </el-form-item>
                        </#if>
                    </#list>
                </el-form>
                <template #footer>
                    <span class="dialog-footer">
                      <el-button @click="dialogFormVisible = false">取消</el-button>
                      <el-button type="primary" @click="doUpdate(sttFormRef)">确认</el-button>
                    </span>
                </template>
            </el-dialog>
        </template>
    </table-manage>
</template>

<script setup lang="ts">
    import {onMounted, ref, reactive, nextTick} from "vue";
    import {add, deleteBatch, update, listByPage} from "@/api/${moduleName}/${className}-api";
    import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
    import TableManage from "@/components/container/TableManage.vue";
    import {ElForm} from "element-plus/es";
    import {ElMessageBox} from "element-plus";
    import {DeleteFilled, Edit, Plus, Search, RefreshRight} from "@element-plus/icons-vue";

    type FormInstance = InstanceType<typeof ElForm>
    const sttFormRef = ref<FormInstance>();

    const pageParam = ref<PageParam>({pageNo: 1, pageSize: 10, searchObject: {}});
    // 表单参数
    const editForm = ref<${ClassName}Model>({});
    // 加载进度
    const loading = ref<boolean>(true);
    // 表单校验规则
    const rules = reactive({
        updateNo: [{required: true, min: 2, max: 30, message: '长度限制2~20', trigger: 'blur'}],
    });
    const dialogFormVisible = ref<boolean>(false);
    const pageVo = ref<PageVO>({pageNo: 1, pageSize: 10, total: 0, records: []});

    // 初始化数据
    onMounted(() => {
        loadTableData();
    });

    const onEdit = (row: ${ClassName}Model): void => {
        editForm.value = row;
        dialogFormVisible.value = true;
    }

    const onAdd = () => {
        dialogFormVisible.value = true;
        editForm.value = {};
    }

    const onRemove = (row: ${ClassName}Model): void => {
        ElMessageBox.confirm('确认删除改行数据?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }
        ).then(() => {
            reqSuccessFeedback(deleteBatch([row.id]), '删除成功', () => {
                loadTableData();
            });
        });
    }

    const loadTableData = (): void => {
        if (!loading.value) loading.value = true;
        let param = {
            pageNo: pageParam.value.pageNo,
            pageSize: pageParam.value.pageSize,
            ${className}: pageParam.value.searchObject
        };
        reqCommonFeedback(listByPage(param), (data: any) => {
            pageVo.value.records = data.rows;
            pageVo.value.total = data.recordCount;
            pageVo.value.pageSize = data.pageSize;
            loading.value = false;
        });
    }

    const onPageChange = (currentPage: number) => {
        pageParam.value.pageNo = currentPage;
        nextTick(() => loadTableData());
    }

    const onSizeChange = (size: number) => {
        pageParam.value.pageSize = size;
        nextTick(() => loadTableData());
    }

    const doUpdate = (formEl: any): void => {
        formEl.validate((valid: any) => {
            if (valid) {
                if (!editForm.value.ID) {
                    reqSuccessFeedback(add(editForm.value), '新增成功', () => {
                        loadTableData();
                        dialogFormVisible.value = false;
                    });
                } else {
                    reqSuccessFeedback(update(editForm.value), '修改成功', () => {
                        loadTableData();
                        dialogFormVisible.value = false;
                    });
                }
            }
        });
    }

    const resetSearchForm = () => {
        pageParam.value.searchObject = {};
    }
</script>

<style scoped></style>