package com.wh.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class UuIDUtils {
    /**
     * 获得随即32位uuid
     *
     * @return
     */
    public static String uuId() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 通过文件名字获得随即uuid
     *
     * @param fileName
     * @return
     */
    public static String fileUuId(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        int c = fileName.indexOf(".");
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid + fileName.substring(c);
    }
}
