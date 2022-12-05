<template>
  <table-manage>
    <!-- 表格操作 -->
    <template #search>
      <n-form-item label="版本名称">
        <n-input placeholder="版本名称" v-model:modn-value="pageParam.searchObject.updateNo" />
      </n-form-item>
      <n-form-item label="平台名称">
        <n-input placeholder="平台名称" v-model:modn-value="pageParam.searchObject.platformName" />
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
      <n-data-table :data="pageVo.records" :columns="columns" :pagination="paginationReactive" />
    </template>

    <!-- 编辑对话框 -->
    <template #form>
      <!--<n-dialog v-model="dialogFormVisible" :title="`${editForm.id ? '编辑' : '添加'}`">-->
      <!--  <n-form ref="sttFormRef" labn-width="120px" :model="editForm" :rules="rules">-->
      <!--    <n-form-item prop="updateNo" label="版本号">-->
      <!--      <n-input v-model="editForm.updateNo" />-->
      <!--    </n-form-item>-->
      <!--    <n-form-item prop="updateDesc" label="更新描述">-->
      <!--      <n-input v-model="editForm.updateDesc" type="textarea" rows="8" />-->
      <!--    </n-form-item>-->
      <!--    <n-form-item prop="platformName" label="平台名称">-->
      <!--      <n-input v-model="editForm.platformName" />-->
      <!--    </n-form-item>-->
      <!--    <n-form-item prop="downloadUrl" label="下载地址">-->
      <!--      <n-input v-model="editForm.downloadUrl" />-->
      <!--    </n-form-item>-->
      <!--  </n-form>-->
      <!--  <template #footer>-->
      <!--    <span class="dialog-footer">-->
      <!--      <n-button @click="dialogFormVisible = false">取消</n-button>-->
      <!--      <n-button type="primary" @click="doUpdate(sttFormRef)">确认</n-button>-->
      <!--    </span>-->
      <!--  </template>-->
      <!--</n-dialog>-->
      <basic-modal @register="modalRegister" ref="modalRef" class="basicModal" @on-ok="okModal">
        <template #default>
          <div>123</div>
        </template>
      </basic-modal>
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
  } from 'naive-ui';
  import { useModal } from '@/components/Modal';
  import { Add } from '@vicons/ionicons5';
  import { renderIcon } from "@/utils";

  const [modalRegister, { openModal, closeModal }] = useModal({
    title: '新增预约',
  });

  async function okModal() {
    closeModal();
  }

  function showModal() {
    openModal();
  }

  const message = useMessage();
  const dialog = useDialog();

  const sttFormRef = ref<FormInst | null>();

  const pageParam = ref<PageParam>({ pageNo: 1, pageSize: 10, searchObject: {} });
  // 表单参数
  const editForm = ref<VersionModel>({});
  // 加载进度
  const loading = ref<boolean>(true);
  // 表单校验规则
  const rules = reactive({
    updateNo: [{ required: true, min: 2, max: 30, message: '长度限制2~20', trigger: 'blur' }],
  });
  const dialogFormVisible = ref<boolean>(false);
  const pageVo = ref<PageVO>({ pageNo: 1, pageSize: 10, total: 0, records: [] });

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
        fixed: 'right',
        render(row) {
          return [
            h(
              NButton,
              {
                strong: true,
                tertiary: true,
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
                strong: true,
                tertiary: true,
                size: 'small',
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
  const paginationReactive = reactive<PaginationProps>({
    page: pageVo.value.pageNo,
    pageSize: pageVo.value.pageSize,
    onUpdatePage: (page) => onPageChange(page),
    onUpdatePageSize: (pageSize) => onSizeChange(pageSize),
    showQuickJumper: true,
    showSizePicker: true,
  });

  // 初始化数据
  onMounted(() => {
    loadTableData();
  });

  const onEdit = (row: DictionaryModel): void => {
    editForm.value = row;
    dialogFormVisible.value = true;
  };

  const onAdd = () => {
    // dialogFormVisible.value = true;
    // editForm.value = {};
    showModal();
  };

  const onRemove = (row: DictionaryModel): void => {
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
      pageVo.value.pageSize = data.pageSize;
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

  const doUpdate = (formEl: any): void => {
    formEl.validate((valid: any) => {
      if (valid) {
        if (!editForm.value.id) {
          add(editForm.value).then(() => {
            loadTableData();
            dialogFormVisible.value = false;
            message.success('保存成功');
          });
        } else {
          update(editForm.value).then(() => {
            loadTableData();
            dialogFormVisible.value = false;
            message.success('更新成功');
          });
        }
      }
    });
  };

  const resetSearchForm = () => {
    pageParam.value.searchObject = {};
  };
</script>

<style scoped></style>
