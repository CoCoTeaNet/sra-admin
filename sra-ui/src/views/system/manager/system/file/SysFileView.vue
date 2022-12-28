<template>
    <table-manage>
        <!-- 表格操作 -->
        <template #search>
                        <el-form-item label="文件名称">
                <el-input placeholder="文件名称" v-model:model-value="pageParam.searchObject.fileName"/>
            </el-form-item>
            <el-form-item label="文件后缀">
                <el-input placeholder="文件后缀" v-model:model-value="pageParam.searchObject.fileSuffix"/>
            </el-form-item>
            <el-form-item label="文件真实路径">
                <el-input placeholder="文件真实路径" v-model:model-value="pageParam.searchObject.realPath"/>
            </el-form-item>
            <el-form-item label="浏览路径">
                <el-input placeholder="浏览路径" v-model:model-value="pageParam.searchObject.browsePath"/>
            </el-form-item>
            <el-form-item label="文件访问地址">
                <el-input placeholder="文件访问地址" v-model:model-value="pageParam.searchObject.fullPath"/>
            </el-form-item>
            <el-form-item label="文件大小（单位：字节）">
                <el-input placeholder="文件大小（单位：字节）" v-model:model-value="pageParam.searchObject.fileSize"/>
            </el-form-item>
            <el-form-item label="创建人">
                <el-input placeholder="创建人" v-model:model-value="pageParam.searchObject.createBy"/>
            </el-form-item>
            <el-form-item label="创建时间">
                <el-input placeholder="创建时间" v-model:model-value="pageParam.searchObject.createTime"/>
            </el-form-item>
            <el-form-item label="更新人">
                <el-input placeholder="更新人" v-model:model-value="pageParam.searchObject.updateBy"/>
            </el-form-item>
            <el-form-item label="更新时间">
                <el-input placeholder="更新时间" v-model:model-value="pageParam.searchObject.updateTime"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="loadTableData">搜索</el-button>
                <el-button @click="resetSearchForm">重置</el-button>
            </el-form-item>
        </template>

        <template #operate>
            <el-button type="primary" @click="onAdd">添加系统文件表</el-button>
        </template>

        <!-- 表格视图 -->
        <template #default>
            <el-table stripe row-key="id" :data="pageVo.records">
                <el-table-column prop="fileName" label="文件名称" />
                <el-table-column prop="fileSuffix" label="文件后缀" />
                <el-table-column prop="realPath" label="文件真实路径" />
                <el-table-column prop="browsePath" label="浏览路径" />
                <el-table-column prop="fullPath" label="文件访问地址" />
                <el-table-column prop="fileSize" label="文件大小（单位：字节）" />
                <el-table-column prop="createBy" label="创建人" />
                <el-table-column prop="createTime" label="创建时间" />
                <el-table-column prop="updateBy" label="更新人" />
                <el-table-column prop="updateTime" label="更新时间" />
                <!-- 单行操作 -->
                <el-table-column fixed="right" width="150" label="操作">
                    <template #default="scope">
                        <el-button size="small" @click="onEdit(scope.row)">编辑</el-button>
                        <el-button size="small" plain type="danger" @click="onRemove(scope.row)">删除</el-button>
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
                    <el-form-item prop="fileName" label="文件名称">
                        <el-input v-model="editForm.fileName"></el-input>
                    </el-form-item>
                    <el-form-item prop="fileSuffix" label="文件后缀">
                        <el-input v-model="editForm.fileSuffix"></el-input>
                    </el-form-item>
                    <el-form-item prop="realPath" label="文件真实路径">
                        <el-input v-model="editForm.realPath"></el-input>
                    </el-form-item>
                    <el-form-item prop="browsePath" label="浏览路径">
                        <el-input v-model="editForm.browsePath"></el-input>
                    </el-form-item>
                    <el-form-item prop="fullPath" label="文件访问地址">
                        <el-input v-model="editForm.fullPath"></el-input>
                    </el-form-item>
                    <el-form-item prop="fileSize" label="文件大小（单位：字节）">
                        <el-input v-model="editForm.fileSize"></el-input>
                    </el-form-item>
                    <el-form-item prop="createBy" label="创建人">
                        <el-input v-model="editForm.createBy"></el-input>
                    </el-form-item>
                    <el-form-item prop="createTime" label="创建时间">
                        <el-input v-model="editForm.createTime"></el-input>
                    </el-form-item>
                    <el-form-item prop="updateBy" label="更新人">
                        <el-input v-model="editForm.updateBy"></el-input>
                    </el-form-item>
                    <el-form-item prop="updateTime" label="更新时间">
                        <el-input v-model="editForm.updateTime"></el-input>
                    </el-form-item>
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
    import {add, deleteBatch, update, listByPage} from "@/api/system/sysFile-api";
    import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
    import TableManage from "@/components/container/TableManage.vue";
    import {ElForm} from "element-plus/es";
    import {ElMessageBox} from "element-plus";

    type FormInstance = InstanceType<typeof ElForm>
    const sttFormRef = ref<FormInstance>();

    const pageParam = ref<PageParam>({pageNo: 1, pageSize: 10, searchObject: {}});
    // 表单参数
    const editForm = ref<SysFileModel>({});
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

    const onEdit = (row: SysFileModel): void => {
        editForm.value = row;
        dialogFormVisible.value = true;
    }

    const onAdd = () => {
        dialogFormVisible.value = true;
        editForm.value = {};
    }

    const onRemove = (row: SysFileModel): void => {
        ElMessageBox.confirm('确认删除改行数据?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }
        ).then(() => {
            reqSuccessFeedback(deleteBatch([row.ID]), '删除成功', () => {
                loadTableData();
            });
        });
    }

    const loadTableData = (): void => {
        if (!loading.value) loading.value = true;
        let param = {
            pageNo: pageParam.value.pageNo,
            pageSize: pageParam.value.pageSize,
            sysFile: pageParam.value.searchObject
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