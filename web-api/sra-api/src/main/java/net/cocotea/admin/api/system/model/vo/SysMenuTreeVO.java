package net.cocotea.admin.api.system.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@Data
@Accessors(chain = true)
public class SysMenuTreeVO {

    private BigInteger id;
    private BigInteger parentId;
    private String menuName;
    private String routerPath;
    private Integer isExternalLink;
    private Integer menuType;
    private Integer sort;
    private String iconPath;
    private Integer menuStatus;

    private List<SysMenuTreeVO> children;
}
