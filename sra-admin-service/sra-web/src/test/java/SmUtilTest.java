import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.junit.Test;

public class SmUtilTest {

    @Test
    public void sm2() {
        String text = "我是一段测试aaaa";

        // 生成公钥（加密）和私钥（解密）
        SM2 sm2 = SmUtil.sm2();
        String privateKey = sm2.getPrivateKeyBase64();
        String publicKey = HexUtil.encodeHexStr(((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(false));

        // 公钥加密
        SM2 encSm2 = SmUtil.sm2(null, publicKey);
        byte[] encrypt = encSm2.encrypt(text, KeyType.PublicKey);
        String encodedHexStr = HexUtil.encodeHexStr(encrypt);
        System.out.println("公钥加密字符串：" + encodedHexStr);

        // 私钥解密
        SM2 deSm2 = SmUtil.sm2(privateKey, publicKey);
        String deText = StrUtil.utf8Str(deSm2.decrypt(encodedHexStr, KeyType.PrivateKey));
        System.out.println("私钥解密字符串：" + deText);
    }

}
