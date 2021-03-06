/*
 * Copyright (C) 2015-2016 QuickAF
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ieclipse.af.util;

import java.security.MessageDigest;

/**
 * Description
 *
 * @author Jamling
 */
public final class EncodeUtils {
    public static final char[] HEX_CHAR = "0123456789abcdef".toCharArray();

    private EncodeUtils() {

    }

    public final static String getMd5(byte[] buffer) {
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_CHAR[byte0 >>> 4 & 0xf];
                str[k++] = HEX_CHAR[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public final static String getMd5(String source) {
        if (source == null) {
            return null;
        }
        return getMd5(source.getBytes());
    }
}
