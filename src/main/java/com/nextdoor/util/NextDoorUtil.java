/*
 * Copyright (c) 2024 Nika Beridze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nextdoor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class NextDoorUtil {
    public static void ensureStringNotNull(Object str, String name) {
        ensureStringNotNull(String.valueOf(str), name);
    }

    public static void ensureStringNotNull(String str, String name) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " can not be null or empty.");
        }
    }

    public static void ensureObjectNotNull(Object object, String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " can not be null.");
        }
    }

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
