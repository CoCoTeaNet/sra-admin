/**
 * 提交登录信息
 * @param formEl FormInstance
 */
export function submitForm(formEl: FormInstance | undefined) {
    if (!formEl) return;
    formEl.validate((valid) => {
        if (valid) {
            loading.value = true;
            console.log('submit!');
        } else {
            console.log('error submit!');
            return false;
        }
    });
}