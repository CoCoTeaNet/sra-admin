const getAccountStatus: any = (status: number, type: number) => {
  let obj = { color: '', text: '' };
  switch (status) {
    case 0:
      obj = { color: 'warning', text: '停用' };
      break;
    case 1:
      obj = { color: 'success', text: '正常' };
      break;
    case 2:
      obj = { color: 'info', text: '冻结' };
      break;
    case 3:
      obj = { color: 'danger', text: '封禁' };
      break;
  }
  return type === 0 ? obj.color : obj.text;
};

const getSex: any = (status: number, type: number) => {
  let obj = { color: '', text: '' };
  switch (status) {
    case 0:
      obj = { color: 'info', text: '不公开' };
      break;
    case 1:
      obj = { color: 'primary', text: '男' };
      break;
    case 2:
      obj = { color: 'success', text: '女' };
      break;
  }
  return type === 0 ? obj.color : obj.text;
};

const accountStatusList: object[] = [
  { label: '停用', value: 0 },
  { label: '正常', value: 1 },
  { label: '冻结', value: 2 },
  { label: '封禁', value: 3 },
];

const sexList: object[] = [
  { label: '不公开', value: 0 },
  { label: '男', value: 1 },
  { label: '女', value: 2 },
];

export { getAccountStatus, getSex, sexList, accountStatusList };
