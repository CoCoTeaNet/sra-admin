/**
 * 字典模型
 */
interface DictionaryModel {
    id: string,
    parentId?: string,
    dictionaryName: string,
    remark?: string,
    enableStatus?: string,
    sort?: number,
    children?: DictionaryModel[]
}