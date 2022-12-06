<template>
  <table-manage>
    <!-- 表格操作 -->
    <template #search>
      <n-form-item label="版本名称">
        <n-input placeholder="版本名称" v-model:value="pageParam.searchObject.updateNo" />
      </n-form-item>
      <n-form-item label="平台名称">
        <n-input placeholder="平台名称" v-model:value="pageParam.searchObject.platformName" />
      </n-form-item>

      <n-form-item>
        <n-space>
          <n-button type="primary" @click="loadTableData">搜索</n-button>
          <n-button @click="resetSearchForm">重置</n-button>
        </n-space>
      </n-form-item>
    </template>

    <template #operate>
      <n-button :render-icon="renderIcon(Add)" type="primary" @click="onAdd">添加版本</n-button>
    </template>

    <!-- 表格视图 -->
    <template #default>
      <n-data-table
        :data="pageVo.records"
        :columns="columns"
        :loading="loading"
        :scroll-x="1800"
      />
    </template>

    <!-- 分页 -->
    <template #page>
      <n-pagination v-model:page="pageParam.pageNo"
                    v-model:page-size="pageParam.pageSize"
                    v-model:item-count="pageVo.total"
                    :on-update:page="onPageChange"
                    :on-update:page-size="onSizeChange"
                    :page-sizes="[10, 20, 30]"
                    show-quick-jumper
                    show-size-picker
      />
    </template>

    <!-- 编辑对话框 -->
    <template #form>
      <n-modal v-model:show="showModel" preset="card" style="width: 50%">
        <template #header>
          <div style="font-weight: 600"> {{ editForm.id ? '编辑' : '新增' }}版本号 </div>
        </template>
        <n-form
          label-placement="left"
          ref="sttFormRef"
          :label-width="100"
          :model="editForm"
          :rules="rules"
        >
          <n-form-item path="updateNo" label="版本号">
            <n-input v-model:value="editForm.updateNo" />
          </n-form-item>
          <n-form-item path="updateDesc" label="更新描述">
            <n-input v-model:value="editForm.updateDesc" type="textarea" rows="8" />
          </n-form-item>
          <n-form-item path="platformName" label="平台名称">
            <n-input v-model:value="editForm.platformName" />
          </n-form-item>
          <n-form-item path="downloadUrl" label="下载地址">
            <n-input v-model:value="editForm.downloadUrl" />
          </n-form-item>
        </n-form>
        <template #action>
          <n-space justify="end">
            <n-button @click="showModel = false">取消</n-button>
            <n-button type="primary" @click="doUpdate">确认</n-button>
          </n-space>
        </template>
      </n-modal>
    </template>
  </table-manage>
</template>

<script setup lang="ts">
  import { onMounted, ref, reactive, nextTick, h } from 'vue';
  import { add, deleteBatch, update, listByPage } from '@/api/system/version-api';
  import {
    useMessage,
    useDialog,
    FormInst,
    DataTableColumns,
    NButton,
    PaginationProps,
    FormRules,
  } from 'naive-ui';
  import { Add } from '@vicons/ionicons5';
  import { renderIcon } from '@/utils';

  const message = useMessage();
  const dialog = useDialog();

  const sttFormRef = ref<FormInst | null>();
  const showModel = ref<boolean>(false);
  const pageParam = ref<PageParam>({ pageNo: 1, pageSize: 10, searchObject: {} });
  // 表单参数
  const editForm = ref<VersionModel>({});
  // 加载进度
  const loading = ref<boolean>(true);
  // 表单校验规则
  const rules: FormRules = {
    updateNo: { required: true, min: 2, max: 20, message: '字数必须2~20个', trigger: 'blur' },
  };
  const pageVo = ref<PageVO>({
    total: 0,
    records: [],
  });

  const createColumns = ({
    edit,
    remove,
  }: {
    edit: (row: VersionModel) => void;
    remove: (row: VersionModel) => void;
  }): DataTableColumns<VersionModel> => {
    return [
      {
        title: '版本号',
        key: 'updateNo',
        width: 150,
      },
      {
        title: '平台名称',
        key: 'platformName',
        width: 150,
      },
      {
        title: '更新描述',
        key: 'updateDesc',
        width: 300,
      },
      {
        title: '下载地址',
        key: 'downloadUrl',
        width: 250,
      },
      {
        title: '创建人',
        key: 'createBy',
        width: 150,
      },
      {
        title: '创建时间',
        key: 'createTime',
        width: 200,
      },
      {
        title: '更新人',
        key: 'updateBy',
        width: 150,
      },
      {
        title: '更新时间',
        key: 'updateTime',
        width: 200,
      },
      {
        title: '操作',
        key: 'actions',
        width: 200,
        fixed: 'right',
        render(row) {
          return [
            h(
              NButton,
              {
                size: 'small',
                style: {
                  marginRight: '6px',
                },
                onClick: () => onEdit(row),
              },
              { default: () => '编辑' }
            ),
            h(
              NButton,
              {
                size: 'small',
                type: 'error',
                onClick: () => onRemove(row),
              },
              { default: () => '删除' }
            ),
          ];
        },
      },
    ];
  };
  const columns = createColumns({
    edit: (row: VersionModel) => onEdit(row),
    remove: (row: VersionModel) => onRemove(row),
  });

  // 初始化数据
  onMounted(() => {
    loadTableData();
  });

  const onEdit = (row: VersionModel): void => {
    editForm.value = row;
    console.log(editForm.value)
    showModel.value = true;
  };

  const onAdd = () => {
    editForm.value = {};
    showModel.value = true;
  };

  const onRemove = (row: VersionModel): void => {
    dialog.warning({
      title: '警告',
      content: '确认删除这行数据？',
      positiveText: '确认',
      negativeText: '取消',
      onPositiveClick: () => {
        deleteBatch([row.id]).then(() => {
          loadTableData();
        });
      },
    });
  };

  const loadTableData = (): void => {
    if (!loading.value) loading.value = true;
    let param = {
      pageNo: pageParam.value.pageNo,
      pageSize: pageParam.value.pageSize,
      version: pageParam.value.searchObject,
    };
    listByPage(param).then((data) => {
      pageVo.value.records = data.rows;
      pageVo.value.total = data.recordCount;
      loading.value = false;
    });
  };

  const onPageChange = (currentPage: number) => {
    pageParam.value.pageNo = currentPage;
    nextTick(() => loadTableData());
  };

  const onSizeChange = (size: number) => {
    pageParam.value.pageSize = size;
    nextTick(() => loadTableData());
  };

  const doUpdate = (): void => {
    console.log(editForm.value);
    sttFormRef.value?.validate((errors) => {
      if (!errors) {
        if (!editForm.value.id) {
          add(editForm.value).then(() => {
            loadTableData();
            showModel.value = false;
            message.success('保存成功');
          });
        } else {
          update(editForm.value).then(() => {
            loadTableData();
            showModel.value = false;
            message.success('更新成功');
          });
        }
      }
    });
  };

  const resetSearchForm = () => {
    pageParam.value.searchObject = {
      updateNo: '',
      platformName: '',
    };
  };
</script>

<style scoped></style>
