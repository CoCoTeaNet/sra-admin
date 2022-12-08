<template>
  <table-manage>
    <template #search>
      <n-form-item label="用户账号">
        <n-input placeholder="账号" v-model:value="pageParam.searchObject.username" />
      </n-form-item>
      <n-form-item label="用户昵称">
        <n-input placeholder="昵称" v-model:value="pageParam.searchObject.nickname" />
      </n-form-item>
      <n-form-item label="账号邮箱">
        <n-input placeholder="邮箱" v-model:value="pageParam.searchObject.email" />
      </n-form-item>
      <n-form-item label="用户性别">
        <n-select
          style="width: 200px"
          placeholder="选择性别"
          v-model:value="pageParam.searchObject.sex"
          :options="sexList"
        />
      </n-form-item>
      <n-form-item label="账号状态">
        <n-select
          style="width: 200px"
          placeholder="选择状态"
          v-model:value="pageParam.searchObject.accountStatus"
          :options="accountStatusList"
        />
      </n-form-item>
      <n-form-item>
        <n-space>
          <n-button type="primary" @click="loadTableData">搜索</n-button>
          <n-button @click="onResetSearchForm">重置</n-button>
        </n-space>
      </n-form-item>
    </template>

    <template #operate>
      <n-space>
        <n-button type="primary" @click="onCreate" :render-icon="renderIcon(Add)">
          添加用户
        </n-button>
        <n-button type="error" @click="onDeleteBatch" :render-icon="renderIcon(Remove)">
          批量删除
        </n-button>
      </n-space>
    </template>

    <template #default>
      <n-data-table
        :data="pageVo.records"
        :columns="columns"
        :loading="loading"
        :scroll-x="1800"
        :on-update-checked-row-keys="handleCheckKeys"
      />
    </template>

    <template #page>
      <n-pagination
        v-model:page="pageParam.pageNo"
        v-model:page-size="pageParam.pageSize"
        v-model:item-count="pageVo.total"
        :page-sizes="[15, 25, 35]"
        :on-update:page="onPageChange"
        :on-update:page-size="onSizeChange"
        show-quick-jumper
        show-size-picker
      />
    </template>

    <template #form>
      <n-modal v-model:show="formShow" preset="card" style="width: 50%">
        <template #header>
          <div style="font-weight: 600"> {{ editForm.id ? '编辑' : '新增' }}用户 </div>
        </template>

        <n-form
          label-placement="left"
          ref="sttFormRef"
          :label-width="100"
          :model="editForm"
          :rules="rules"
        >
          <n-form-item path="username" label="账号名称">
            <n-input v-model:value="editForm.username" />
          </n-form-item>
          <n-form-item path="nickname" label="用户昵称">
            <n-input v-model:value="editForm.nickname" />
          </n-form-item>
          <n-form-item path="password" label="用户密码">
            <n-input :prefix-icon="Lock" v-model:value="editForm.password" type="password" />
          </n-form-item>
          <n-form-item path="email" label="邮箱">
            <n-input v-model:value="editForm.email" />
          </n-form-item>
          <n-form-item path="roleName" label="用户角色">
            <n-select
              v-model:value="editForm.roleId"
              placeholder="选择角色"
              :options="roleOptions"
            />
          </n-form-item>
          <n-form-item path="sort" label="性别">
            <n-radio-group v-model:value="editForm.sex">
              <n-space>
                <n-radio v-for="item in sexList" :key="item.value" :value="item.value">
                  {{ item.label }}
                </n-radio>
              </n-space>
            </n-radio-group>
          </n-form-item>
          <n-form-item path="sort" label="账号状态">
            <n-radio-group v-model:value="editForm.accountStatus">
              <n-space>
                <n-radio v-for="item in accountStatusList" :key="item.value" :value="item.value">
                  {{ item.label }}
                </n-radio>
              </n-space>
            </n-radio-group>
          </n-form-item>
        </n-form>

        <template #action>
          <n-space justify="end">
            <n-button @click="formShow = false">取 消</n-button>
            <n-button type="primary" @click="onConfirm">确 认</n-button>
          </n-space>
        </template>
      </n-modal>
    </template>
  </table-manage>
</template>

<script setup lang="ts">
  import { h, nextTick, onMounted, ref } from 'vue';
  import { listByPage, deleteBatch, add, update } from '@/api/system/user-api';
  import TableManage from '@/components/TableManage/TableManage.vue';
  import {
    accountStatusList,
    sexList,
    getAccountStatus,
    getSex,
  } from '@/views/system/manager/user/user-status';
  import { NButton, NTag, useDialog, DataTableRowKey, FormInst, FormRules } from 'naive-ui';
  import { renderIcon } from '@/utils';
  import { Add, Remove } from '@vicons/ionicons5';
  import { roleApi } from '@/api/system/role-api';

  const dialog = useDialog();
  const rules: FormRules = {
    username: { required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur' },
    nickname: { required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur' },
    password: { required: true, min: 6, max: 32, message: '长度限制6~32', trigger: 'blur' },
    roleId: { required: true, message: '请选择角色', trigger: 'blur' },
  };

  const roleOptions = ref<any[]>([]);
  const sttFormRef = ref<FormInst | null>();
  const editForm = ref<UserModel>({});
  const formShow = ref<boolean>(false);
  const checkRowKeysRef = ref<DataTableRowKey[]>([]);
  // 分页参数
  const pageParam = ref<PageParam>({ pageNo: 1, pageSize: 15, searchObject: {} });
  // api返回的分页数据
  const pageVo = ref<PageVO>({ total: 0, records: [] });
  // 加载进度
  const loading = ref<boolean>(true);
  const columns = [
    { type: 'selection' },
    {
      title: '用户名称',
      key: 'username',
      width: 200,
    },
    {
      title: '昵称',
      key: 'nickname',
      width: 200,
    },
    {
      title: '邮箱',
      key: 'email',
      width: 200,
    },
    {
      title: '账号角色',
      key: 'roleName',
      width: 150,
    },
    {
      title: '性别',
      key: 'sex',
      width: 100,
      render(row) {
        return h(NTag, { type: getSex(row.sex, 0) }, getSex(row.sex, 1));
      },
    },
    {
      title: '账号状态',
      key: 'accountStatus',
      width: 100,
      render(row) {
        return h(
          NTag,
          { type: getAccountStatus(row.accountStatus, 0) },
          getAccountStatus(row.accountStatus, 1)
        );
      },
    },
    {
      title: '最后登录IP',
      key: 'lastLoginIp',
      width: 200,
    },
    {
      title: '最后登录时间',
      key: 'lastLoginTime',
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
              onClick: () => onDelete(row),
            },
            { default: () => '删除' }
          ),
        ];
      },
    },
  ];

  // 初始化数据
  onMounted(() => {
    loadTableData();
    loadRoles();
  });

  const onEdit = (row: UserModel): void => {
    editForm.value = row;
    formShow.value = true;
  };

  const loadTableData = () => {
    if (!loading.value) loading.value = true;
    let param = {
      pageNo: pageParam.value.pageNo,
      pageSize: pageParam.value.pageSize,
      userVO: pageParam.value.searchObject,
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

  const onResetSearchForm = () => {
    pageParam.value.searchObject = {
      username: '',
      nickname: '',
      sex: 0,
      accountStatus: 1,
      email: '',
    };
  };

  const onCreate = () => {
    formShow.value = true;
  };

  const onDelete = (id: string) => {
    dialog.warning({
      title: '警告',
      content: '确认删除这行数据？',
      positiveText: '确认',
      negativeText: '取消',
      onPositiveClick: () => {
        deleteBatch([id]).then(() => {
          loadTableData();
        });
      },
    });
  };

  const onDeleteBatch = () => {
    dialog.warning({
      title: '警告',
      content: '确认删除这行数据？',
      positiveText: '确认',
      negativeText: '取消',
      onPositiveClick: () => {
        deleteBatch(checkRowKeysRef.value).then(() => {
          loadTableData();
        });
      },
    });
  };

  const handleCheckKeys = (rowKeys: DataTableRowKey[]) => {
    checkRowKeysRef.value = rowKeys;
  };

  const loadRoles = () => {
    let param: any = { pageNo: 1, pageSize: 1000, roleVO: { roleName: '' } };
    roleApi.listByPage(param).then((data) => {
      let options: any = [];
      data.rows.map((item) => {
        options.push({ label: item.roleName, value: item.id });
      });
      roleOptions.value = options;
    });
  };

  const onConfirm = () => {
    sttFormRef.value?.validate((errors) => {
      if (!errors) {
        if (!editForm.value.id) {
          add(editForm.value).then(() => {
            loadTableData();
          });
        } else {
          update(editForm.value).then(() => {
            loadTableData();
          });
        }
      }
    });
  };
</script>

<style scoped></style>
